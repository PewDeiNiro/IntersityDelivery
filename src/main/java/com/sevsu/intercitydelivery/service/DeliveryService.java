package com.sevsu.intercitydelivery.service;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.enums.DeliveryStatus;
import com.sevsu.intercitydelivery.exception.*;
import com.sevsu.intercitydelivery.mapper.DeliveryMapper;
import com.sevsu.intercitydelivery.model.Coordinate;
import com.sevsu.intercitydelivery.repository.DeliveryRepository;
import com.sevsu.intercitydelivery.repository.UserRepository;
import com.sevsu.intercitydelivery.request.CancelDeliveryRequest;
import com.sevsu.intercitydelivery.request.DeliveryRequest;
import com.sevsu.intercitydelivery.request.UpdateDeliveryStatusRequest;
import com.sevsu.intercitydelivery.response.DeliveryResponse;
import com.sevsu.intercitydelivery.token.Token;
import com.sevsu.intercitydelivery.utils.CostCalculator;
import com.sevsu.intercitydelivery.utils.DistanceCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DeliveryMapper deliveryMapper;

    public DeliveryResponse executeDelivery(DeliveryRequest deliveryRequest) {
        User client = userRepository.findById(deliveryRequest.getUserId())
                .orElseThrow(() -> new UserDoesNotExistException("Пользователя с заданным userId не существует"));
        if (!Token.checkAuthentication(deliveryRequest.getUserId(), deliveryRequest.getToken())) {
            throw new InvalidTokenException("Невалидный токен пользователя");
        }
        if (deliveryRequest.getWeight() > 100){
            throw new TooMuchWeightException("Слишком большой вес посылки, он не должен превышать 100 кг");
        }
        double distance = DistanceCalculator.calculateDistance(deliveryRequest.getDeparture(), deliveryRequest.getDestination()),
                cost = CostCalculator.calculateDeliveryCost(deliveryRequest.getDeparture(), deliveryRequest.getDestination(), deliveryRequest.getWeight());
        if (distance > 100 * 1000){
            throw new TooFarDistanceException("Слишком большое расстояние перевозки, оно не должно превышать 100 км");
        }
        if (client.getAmount() < cost){
            throw new UserDoesNotHaveEnoughMoneyException("У пользователя недостаточно денег, чтобы заказать доставку");
        }
        Delivery delivery = deliveryMapper.mapDeliveryRequestToDeliveryEntity(deliveryRequest);
        client.setAmount(client.getAmount() - cost);
        delivery.setClient(client);
        delivery.setDeliveryStatus(DeliveryStatus.PENDING);
        userRepository.saveAndFlush(client);
        deliveryRepository.saveAndFlush(delivery);
        DeliveryResponse response = deliveryMapper.mapDeliveryEntityToDeliveryResponse(delivery);
        response.setCost(cost);
        return response;
    }

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public Delivery getDeliveryById(int id){
        return deliveryRepository.findById(id).orElseThrow(() -> new DeliveryDoesNotExistException("Доставки с таким уникальным идентификатором не существует"));
    }

    public Delivery updateDeliveryStatus(UpdateDeliveryStatusRequest request){
        Delivery delivery = deliveryRepository.findById(request.getId())
                .orElseThrow(() -> new DeliveryDoesNotExistException("Доставки с таким уникальным идентификатором не существует"));
        delivery.setDeliveryStatus(request.getStatus());
        deliveryRepository.saveAndFlush(delivery);
        return delivery;
    }

    public String cancelDelivery(CancelDeliveryRequest request){
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserDoesNotExistException("Пользователя с таким уникальным идентификатором не существует"));
        String token = request.getToken();
        if (!Token.checkAuthentication(user.getId(), token)){
            throw new InvalidTokenException("Невалидный токен пользователя");
        }
        Delivery delivery = deliveryRepository.findById(request.getDeliveryId())
                .orElseThrow(() -> new DeliveryDoesNotExistException("Доставки с таким уникальным идентификатором не существует"));
        if (delivery.getClient().getId() != user.getId()){
            throw new DeliveryDoesNotBelongException("Доставка не принадлежит данному пользователю");
        }
        double cost = CostCalculator.calculateDeliveryCost(new Coordinate(delivery.getDepartureLatitude(), delivery.getDepartureLongitude()),
                new Coordinate(delivery.getDestinationLatitude(), delivery.getDestinationLongitude()), delivery.getWeight());
        user.setAmount(user.getAmount() + cost);
        delivery.setDeliveryStatus(DeliveryStatus.CANCELED);
        userRepository.saveAndFlush(user);
        deliveryRepository.saveAndFlush(delivery);
        return "Доставка успешно отменена пользователем";
    }

}

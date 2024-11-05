package com.sevsu.intercitydelivery.service;

import com.sevsu.intercitydelivery.entity.Delivery;
import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.exception.AmountCanNotBeLessZeroException;
import com.sevsu.intercitydelivery.exception.InvalidTokenException;
import com.sevsu.intercitydelivery.exception.UserDoesNotExistException;
import com.sevsu.intercitydelivery.feign.PaymentClient;
import com.sevsu.intercitydelivery.repository.UserRepository;
import com.sevsu.intercitydelivery.request.CreatePaymentRequest;
import com.sevsu.intercitydelivery.response.CreatePaymentResponse;
import com.sevsu.intercitydelivery.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentClient paymentClient;

    public List<Delivery> getAllUserDeliveries(int id){
        User user = userRepository.findById(id)
                .orElseThrow(UserDoesNotExistException::new);
        return user.getDeliveries();
    }

    public CreatePaymentResponse createUserPayment(CreatePaymentRequest request) {
        if (request.getAmount() <= 0){
            throw new AmountCanNotBeLessZeroException();
        }
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(UserDoesNotExistException::new);
        String token = request.getToken();
        if (!Token.checkAuthentication(user.getId(), token)) {
            throw new InvalidTokenException();
        }
        return paymentClient.createInvoice(request);
    }


}

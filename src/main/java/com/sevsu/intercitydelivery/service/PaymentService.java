package com.sevsu.intercitydelivery.service;

import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.enums.PaymentStatus;
import com.sevsu.intercitydelivery.exception.PaymentDoesNotSucceededException;
import com.sevsu.intercitydelivery.exception.UserDoesNotExistException;
import com.sevsu.intercitydelivery.mapper.PaymentMapper;
import com.sevsu.intercitydelivery.repository.UserRepository;
import com.sevsu.intercitydelivery.request.UpdateBalanceRequest;
import com.sevsu.intercitydelivery.response.UpdateBalanceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    public UpdateBalanceResponse updateBalance(UpdateBalanceRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(UserDoesNotExistException::new);
        if (request.getStatus() != PaymentStatus.SUCCEEDED){
            throw new PaymentDoesNotSucceededException();
        }
        user.setAmount(user.getAmount() + request.getAmount());
        userRepository.saveAndFlush(user);
        return paymentMapper.mapUpdateRequestToResponse(request);
    }

}

package com.sevsu.intercitydelivery.service;

import com.sevsu.intercitydelivery.entity.User;
import com.sevsu.intercitydelivery.exception.*;
import com.sevsu.intercitydelivery.mapper.SignRequestUserMapper;
import com.sevsu.intercitydelivery.repository.UserRepository;
import com.sevsu.intercitydelivery.request.SignRequest;
import com.sevsu.intercitydelivery.response.SignResponse;
import com.sevsu.intercitydelivery.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SignRequestUserMapper signRequestUserMapper;

    public SignResponse signUp(SignRequest signRequest) {
        if (signRequest.getUsername().equals("root")){
            throw new RootUserIsNotAllowed();
        }
        if (userRepository.existsByUsername(signRequest.getUsername())){
            throw new UsernameAlreadyTakenException();
        }
        User user = signRequestUserMapper.mapSignRequestToUser(signRequest);
        userRepository.saveAndFlush(user);
        return new SignResponse(user.getId(), Token.generateToken(user.getId(), user.getPassword()));
    }

    public SignResponse signIn(SignRequest signRequest) {
        if (!userRepository.existsByUsername(signRequest.getUsername())){
            throw new UserDoesNotExistException();
        }
        User user = userRepository.findByUsername(signRequest.getUsername()).orElse(null);
        if (user == null){
            throw new UserNotFoundException();
        }
        if (!user.getPassword().equals(signRequest.getPassword())){
            throw new InvalidPasswordException();
        }
        return new SignResponse(user.getId(), Token.generateToken(user.getId(), user.getPassword()));
    }

}

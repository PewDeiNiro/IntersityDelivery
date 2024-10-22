package com.sevsu.intercitydelivery.token;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

@Data
public class Token {

    private static Map<Integer, Token> tokens = new HashMap<>();

    @JsonValue
    private String token;

    private Token(String password){
        token = new BCryptPasswordEncoder().encode(password);
    }

    public static Token generateToken(int userId, String password){
        Token token = new Token(password);
        tokens.put(userId, token);
        return token;
    }

    public static boolean checkAuthentication(int userId, Token token){
        return tokens.containsKey(userId) && tokens.get(userId).toString().equals(token.getToken());
    }

    @Override
    public String toString() {
        return token;
    }

}

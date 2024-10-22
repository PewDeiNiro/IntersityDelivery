package com.sevsu.intercitydelivery.response;

import com.sevsu.intercitydelivery.token.Token;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignResponse {

    private int userId;

    private Token token;

}

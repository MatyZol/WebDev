
package hu.unideb.dto;

import lombok.Data;

@Data
public class TokenResponse {

    public String token;

    public TokenResponse(String token) {
        this.token = token;
    }


    public TokenResponse() {
    }


}
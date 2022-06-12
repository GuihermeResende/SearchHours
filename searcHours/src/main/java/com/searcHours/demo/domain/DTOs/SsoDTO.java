package com.searcHours.demo.domain.DTOs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class SsoDTO {

    private UserDetailsDTO user;
    private String jwtToken;

    public String toJson() throws JsonProcessingException {
        ObjectMapper m = new ObjectMapper();
        return m.writeValueAsString(this);
    }

    public SsoDTO(UserDetailsDTO user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

}

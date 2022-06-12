package com.searcHours.demo.domain.DTOs;

import com.searcHours.demo.domain.models.User;
import lombok.Data;

@Data
public class UserDetailsDTO {

    private Long id;
    private String nome;

    public static UserDetailsDTO toDTO(User user){
        UserDetailsDTO userDTO = new UserDetailsDTO();
        userDTO.id = user.getId();
        userDTO.nome = user.getNome();

        return userDTO;
    }
}

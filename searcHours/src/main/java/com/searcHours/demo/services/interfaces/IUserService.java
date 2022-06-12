package com.searcHours.demo.services.interfaces;

import com.searcHours.demo.domain.DTOs.SignUpDTO;

public interface IUserService {
    Boolean SignUp(SignUpDTO signUpDTO);
    Boolean deleteUser(Long userId);
}

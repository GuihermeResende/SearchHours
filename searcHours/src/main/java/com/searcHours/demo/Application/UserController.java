package com.searcHours.demo.Application;

import com.searcHours.demo.domain.DTOs.SignUpDTO;
import com.searcHours.demo.services.servicesImpl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody SignUpDTO signUpDTO) {
        boolean ret = userService.SignUp(signUpDTO);

        return ResponseEntity.ok(ret);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

}

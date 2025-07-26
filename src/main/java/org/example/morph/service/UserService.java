package org.example.morph.service;

import org.example.morph.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto.SignupResDto signup(UserDto.SignupReqDto signupReqDto);
}

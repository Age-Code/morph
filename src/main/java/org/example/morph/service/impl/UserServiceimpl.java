package org.example.morph.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.morph.domain.User;
import org.example.morph.dto.UserDto;
import org.example.morph.repository.UserRepository;
import org.example.morph.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceimpl implements UserService {

    final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    // Signup
    @Override
    public UserDto.SignupResDto signup(UserDto.SignupReqDto signupReqDto){

        User user = userRepository.findByUsername(signupReqDto.getUsername()).orElse(null);
        if(user != null) {
            throw new RuntimeException("Already exist");
        }

        signupReqDto.setPassword(bCryptPasswordEncoder.encode(signupReqDto.getPassword()));
        user = userRepository.save(signupReqDto.toEntity());

        return user.toSignupResDto();
    }

}

package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.UserRepository;
import com.gmail.zagurskaya.repository.model.User;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.converter.UserConverter;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserConverter userConverter,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userConverter = userConverter;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> dtos = users.stream()
                .map(userConverter::toDTO)
                .collect(Collectors.toList());
        return dtos;
    }

    @Override
    @Transactional
    public void add(UserDTO userDTO) {
        userDTO.setRegDate(LocalDateTime.now());
        userDTO.setRoleId(1L);
        User user = userConverter.toEntity(userDTO);
        String password = passwordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDTO loadUserByUsername(String name) {
        User loaded = userRepository.findByUsername(name).orElseThrow(() -> new EntityNotFoundException("User not found with name " + name));
        UserDTO userDTO = userConverter.toDTO(loaded);
        return userDTO;
    }

}

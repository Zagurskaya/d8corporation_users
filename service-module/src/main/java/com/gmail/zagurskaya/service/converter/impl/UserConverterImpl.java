package com.gmail.zagurskaya.service.converter.impl;

import com.gmail.zagurskaya.repository.RoleRepository;
import com.gmail.zagurskaya.repository.UserRepository;
import com.gmail.zagurskaya.repository.model.User;
import com.gmail.zagurskaya.service.converter.RoleConverter;
import com.gmail.zagurskaya.service.converter.UserConverter;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserConverterImpl implements UserConverter {

    private final RoleConverter roleConverter;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserConverterImpl(RoleConverter roleConverter,
                             RoleRepository roleRepository,
                             UserRepository userRepository) {
        this.roleConverter = roleConverter;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setFullName(user.getFullName());
        userDTO.setAge(user.getAge());
        userDTO.setRegDate(user.getRegDate());
        userDTO.setRole(roleConverter.toDTO(user.getRole()));
        userDTO.setRoleId(user.getRole().getId());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());
        user.setAge(userDTO.getAge());
        user.setRegDate(userDTO.getRegDate());
        user.setRole(roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id " + userDTO.getRoleId())));
        return user;
    }
}

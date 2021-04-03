package com.gmail.zagurskaya.service.impl;

import com.gmail.zagurskaya.repository.RoleRepository;
import com.gmail.zagurskaya.repository.model.Role;
import com.gmail.zagurskaya.service.RoleService;
import com.gmail.zagurskaya.service.converter.RoleConverter;
import com.gmail.zagurskaya.service.model.RoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RoleServiceImpl implements RoleService {

    private final RoleConverter roleConverter;
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleConverter roleConverter, RoleRepository roleRepository) {
        this.roleConverter = roleConverter;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> getRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDTO> rolesDTO = roles.stream()
                .map(roleConverter::toDTO)
                .collect(Collectors.toList());
        return rolesDTO;
    }
}

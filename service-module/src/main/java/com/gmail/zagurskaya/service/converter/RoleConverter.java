package com.gmail.zagurskaya.service.converter;

import com.gmail.zagurskaya.repository.model.Role;
import com.gmail.zagurskaya.service.model.RoleDTO;

public interface RoleConverter {

    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);
}

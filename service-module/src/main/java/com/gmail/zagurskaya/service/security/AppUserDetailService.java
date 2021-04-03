package com.gmail.zagurskaya.service.security;


import com.gmail.zagurskaya.service.RoleService;
import com.gmail.zagurskaya.service.UserService;
import com.gmail.zagurskaya.service.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@SpringBootApplication(exclude = UserDetailsServiceAutoConfiguration.class)
@Service
public class AppUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String name) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        UserDTO userDTO = userService.loadUserByUsername(name);
        return new AppUserPrincipal(userDTO, userDTO.getRole());
    }
}

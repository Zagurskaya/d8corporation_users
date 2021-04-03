package com.gmail.zagurskaya.service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserDTO {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private Long age;

    private LocalDateTime regDate;

    private RoleDTO role;
    private Long roleId;
}

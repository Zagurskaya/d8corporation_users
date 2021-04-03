package com.gmail.zagurskaya.service.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class RoleDTO {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;
}

package com.sabora.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String type;
    private String dni;
    private String name;
    private String apellidos;
    private String email;
    private String password;
    private long telefono;
    private String username;
    private HashMap<String, Object> specificProperties;
}

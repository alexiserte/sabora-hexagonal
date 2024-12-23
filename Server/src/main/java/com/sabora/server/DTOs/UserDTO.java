package com.sabora.server.DTOs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sabora.server.Models.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public User toUser() {
        switch (type) {
            case "GlassesUser":
                return new GlassesUser(dni, name, apellidos, email, password, String.valueOf(telefono), username, (int) specificProperties.get("age"), (String) specificProperties.get("gender"));
            case "FoodSpecialist":
                return new FoodSpecialist(dni, name, apellidos, email, password, String.valueOf(telefono), username, (String) specificProperties.get("organization"));
            case "Cliente":
                return new Cliente(dni, name, apellidos, email, password, String.valueOf(telefono), username, (String) specificProperties.get("business"), (String) specificProperties.get("bankAccount"));
            case "DataAnalyst":
                return new DataAnalyst(dni, name, apellidos, email, password, String.valueOf(telefono), username);
            default:
                return null;
        }
    }

    public UserDTO(User user) {
        this.type = user.getClass().getSimpleName();
        this.dni = user.getDni();
        this.name = user.getName();
        this.apellidos = user.getApellidos();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.telefono = Long.parseLong(user.getTelefono());
        this.username = user.getUsername();
        switch (type) {
            case "GlassesUser":
                GlassesUser glassesUser = (GlassesUser) user;
                this.specificProperties = new HashMap<>();
                specificProperties.put("age", glassesUser.getAge());
                specificProperties.put("gender", glassesUser.getGender());
                break;
            case "FoodSpecialist":
                FoodSpecialist foodSpecialist = (FoodSpecialist) user;
                this.specificProperties = new HashMap<>();
                specificProperties.put("organization", foodSpecialist.getOrganization());
                break;
            case "Cliente":
                Cliente cliente = (Cliente) user;
                this.specificProperties = new HashMap<>();
                specificProperties.put("business", cliente.getBusiness());
                specificProperties.put("bankAccount", cliente.getBankAccount());
                break;
            case "DataAnalyst":
                break;
            default:
                throw new IllegalArgumentException("Invalid user type: " + type);

        }
    }
}
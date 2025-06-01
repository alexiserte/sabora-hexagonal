package com.sabora.api.mappers;

import com.sabora.application.domain.*;
import com.sabora.application.exception.User.IllegalUserType;
import org.mapstruct.Mapper;
import org.openapitools.model.UserDTO;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

        default User toUser(UserDTO dto) {
        String dni = dto.getDni();
        String name = dto.getName();
        String apellidos = dto.getApellidos();
        String email = dto.getEmail();
        String password = dto.getPassword();
        String telefono = String.valueOf(dto.getTelefono());
        String username = dto.getUsername();
        Map<String, Object> props = dto.getSpecificProperties();

        switch (dto.getType()) {
            case "GlassesUser":
                return GlassesUser.builder().dni(dni)
                        .name(name)
                        .apellidos(apellidos)
                        .email(email)
                        .password(password)
                        .telefono(telefono)
                        .username(username)
                        .age((int) props.get("age"))
                        .gender((String) props.get("gender"))
                        .build();

            case "FoodSpecialist":
                return FoodSpecialist.builder()
                        .dni(dni)
                        .name(name)
                        .apellidos(apellidos)
                        .email(email)
                        .password(password)
                        .telefono(telefono)
                        .username(username)
                        .organization((String) props.get("organization"))
                        .build();

            case "Cliente":
                return Cliente.builder()
                        .dni(dni)
                        .name(name)
                        .apellidos(apellidos)
                        .email(email)
                        .password(password)
                        .telefono(telefono)
                        .username(username)
                        .business((String) props.get("business"))
                        .bankAccount((String) props.get("bankAccount"))
                        .build();
            case "DataAnalyst":
                return DataAnalyst.builder()
                        .dni(dni)
                        .name(name)
                        .apellidos(apellidos)
                        .email(email)
                        .password(password)
                        .telefono(telefono)
                        .username(username)
                        .build();
            default:
                throw new IllegalUserType("Tipo de usuario inválido: " + dto.getType());
        }
    }

    default UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();

        dto.setType(user.getClass().getSimpleName());
        dto.setDni(user.getDni());
        dto.setName(user.getName());
        dto.setApellidos(user.getApellidos());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setTelefono(Long.parseLong(user.getTelefono()));
        dto.setUsername(user.getUsername());

        HashMap<String, Object> props = getProps(user);
        dto.setSpecificProperties(props);

        return dto;
    }

    private static HashMap<String, Object> getProps(User user) {
        HashMap<String, Object> props = new HashMap<>();

        if (user instanceof GlassesUser) {
            GlassesUser gu = (GlassesUser) user;
            props.put("age", gu.getAge());
            props.put("gender", gu.getGender());
        } else if (user instanceof FoodSpecialist) {
            FoodSpecialist fs = (FoodSpecialist) user;
            props.put("organization", fs.getOrganization());
        } else if (user instanceof Cliente) {
            Cliente c = (Cliente) user;
            props.put("business", c.getBusiness());
            props.put("bankAccount", c.getBankAccount());
        }
        return props;
    }
}

package com.sabora.database.repositories;

import com.sabora.application.domain.User;
import com.sabora.database.entities.UserMO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserMO toEntity(User user);
    User toDomain(UserMO userMO);
}

package com.sabora.database.mappers;

import com.sabora.application.domain.GlassesUser;
import com.sabora.database.entities.GlassesUserMO;

public interface GlassesUserEntityMapper {
    GlassesUserMO toEntity(GlassesUser glassesUser);
    GlassesUser toDomain(GlassesUserMO glassesUserMO);
}

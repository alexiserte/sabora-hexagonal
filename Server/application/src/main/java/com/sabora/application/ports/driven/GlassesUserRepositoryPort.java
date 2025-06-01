package com.sabora.application.ports.driven;

import com.sabora.application.domain.GlassesUser;

import java.util.List;

public interface GlassesUserRepositoryPort {
    GlassesUser save(GlassesUser cliente);

    List<GlassesUser> findAll();
}

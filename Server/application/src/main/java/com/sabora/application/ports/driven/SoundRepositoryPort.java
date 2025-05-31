package com.sabora.application.ports.driven;

import com.sabora.application.domain.Sound;

public interface SoundRepositoryPort {
    Sound findByName(String name);
}

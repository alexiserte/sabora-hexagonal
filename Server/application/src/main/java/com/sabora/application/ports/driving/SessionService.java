package com.sabora.application.ports.driving;

import com.sabora.application.domain.User;

public interface SessionService {
    void register(User user);

    User getUser(String username, String password);
}

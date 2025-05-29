package com.sabora.application.ports.driving;

import com.sabora.server.DTOs.UserDTO;

public interface SessionService {
        void register(UserDTO user);
        UserDTO getUser(String username,String password);
}

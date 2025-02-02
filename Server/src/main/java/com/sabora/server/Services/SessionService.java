package com.sabora.server.Services;

import com.sabora.server.DTOs.UserDTO;

public interface SessionService {
        void register(UserDTO user);
        UserDTO getUser(String username,String password);
}

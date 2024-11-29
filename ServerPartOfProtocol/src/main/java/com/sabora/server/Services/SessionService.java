package com.sabora.server.Services;

import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Models.User;

public interface SessionService {
        void register(UserDTO user);
        UserDTO getUser(String username);
}

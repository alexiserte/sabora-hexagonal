package com.sabora.application.services;

import com.sabora.application.Encryption.DataEncryption;
import com.sabora.application.Encryption.PasswordEncrypter;
import com.sabora.application.config.EncryptionConfig;
import com.sabora.application.domain.Cliente;
import com.sabora.application.domain.User;
import com.sabora.application.exception.User.AlreadyExistingUserException;
import com.sabora.application.exception.User.UserNotFoundException;
import com.sabora.application.ports.driven.UserRepositoryPort;
import com.sabora.application.ports.driving.SessionService;
import com.sabora.application.ports.driving.UserService;
import com.sabora.application.validation.UserValidation;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class SessionServiceImplementation implements SessionService {

    private final GlassesUserService glassesUserService;
    private final FoodSpecialistService foodSpecialistService;
    private final ClienteService clienteService;
    private final DataAnalystService dataAnalystService;

    private final UserRepositoryPort userRepository;
    private final EncryptionConfig encryptionConfig;

    private Map<String, UserService<? extends User>> userServices;
    private final PasswordEncrypter passwordEncrypter = new PasswordEncrypter();


    @PostConstruct
    public void initUserServices() {
        userServices = Map.of(
                "GlassesUser", glassesUserService,
                "FoodSpecialist", foodSpecialistService,
                "Cliente", clienteService,
                "DataAnalyst", dataAnalystService
        );
    }

    public void register(User user) {
        UserValidation.validateUser(user);

        user.setPassword(passwordEncrypter.encryptPassword(user.getPassword()));

        UserService<User> userService = (UserService<User>) userServices.get(user.getClass().getSimpleName());
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new AlreadyExistingUserException(user.getUsername());
        } else {
            String base64Key = encryptionConfig.getSecretKey();
            try {
                user.setDni(DataEncryption.encrypt(user.getDni(), base64Key));
                user.setEmail(DataEncryption.encrypt(user.getEmail(), base64Key));
                user.setTelefono(DataEncryption.encrypt(String.valueOf(user.getTelefono()), base64Key));

                if (user instanceof Cliente) {
                    Cliente cliente = (Cliente) user;
                    cliente.setBankAccount(DataEncryption.encrypt(cliente.getBankAccount(), base64Key));
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            userService.registerUser(user);
        }
    }

    @Override
    public User getUser(String username, String password) {
        for (UserService<? extends User> userService : userServices.values()) {
            User user = userService.getUser(username);
            if (user != null) {
                try {
                    user.setDni(DataEncryption.decrypt(user.getDni(), encryptionConfig.getSecretKey()));
                    user.setEmail(DataEncryption.decrypt(user.getEmail(), encryptionConfig.getSecretKey()));
                    user.setTelefono(DataEncryption.decrypt(user.getTelefono(), encryptionConfig.getSecretKey()));
                    if (passwordEncrypter.checkPassword(password, user.getPassword())) {
                        return user;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new UserNotFoundException(username);
    }

}

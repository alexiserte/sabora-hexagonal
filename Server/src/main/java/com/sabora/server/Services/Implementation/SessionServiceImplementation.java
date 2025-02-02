package com.sabora.server.Services.Implementation;

import com.sabora.server.Configuration.EncryptionConfig;
import com.sabora.server.DTOs.UserDTO;
import com.sabora.server.Exceptions.User.AlreadyExistingUserException;
import com.sabora.server.Exceptions.User.IllegalUserType;
import com.sabora.server.Exceptions.User.UserNotFoundException;
import com.sabora.server.Exceptions.User.UserValidationException;
import com.sabora.server.Models.Cliente;
import com.sabora.server.Models.User;
import com.sabora.server.Repositories.UserRepository;
import com.sabora.server.Services.SessionService;
import com.sabora.server.Services.UserService;
import com.sabora.server.Utils.Encryption.DataEncryption;
import com.sabora.server.Utils.Encryption.PasswordEncrypter;
import com.sabora.server.Utils.Validation.UserValidation;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SessionServiceImplementation implements SessionService {

    private final Map<String, UserService<? extends User>> userServices;
    private final UserRepository userRepository;
    private final PasswordEncrypter passwordEncrypter = new PasswordEncrypter();
    private final EncryptionConfig encryptionConfig;

    public SessionServiceImplementation(
            GlassesUserService glassesUserService,
            FoodSpecialistService foodSpecialistService,
            ClienteService clienteService,
            DataAnalystService dataAnalystService, UserRepository userRepository, EncryptionConfig encryptionConfig
    ) {
        this.userRepository = userRepository;
        this.encryptionConfig = encryptionConfig;
        userServices = Map.of(
                "GlassesUser", glassesUserService,
                "FoodSpecialist", foodSpecialistService,
                "Cliente", clienteService,
                "DataAnalyst", dataAnalystService
        );
    }

    public void register(UserDTO userDTO) {
        UserValidation.validateUser(userDTO);
        System.out.println(userDTO);
        User user = userDTO.toUser();
        user.setPassword(passwordEncrypter.encryptPassword(user.getPassword()));
        if (user == null || !userServices.containsKey(userDTO.getType())) {
            throw new IllegalUserType(userDTO.getType());
        }
        UserService<User> userService = (UserService<User>) userServices.get(userDTO.getType());
        if(userRepository.existsByUsername(user.getUsername())){
                throw new AlreadyExistingUserException(user.getUsername());
        }else{
                String base64Key = encryptionConfig.getSecretKey();
            try {
                user.setDni(DataEncryption.encrypt(user.getDni(), base64Key));
                user.setEmail(DataEncryption.encrypt(user.getEmail(), base64Key));
                user.setTelefono(DataEncryption.encrypt(String.valueOf(user.getTelefono()), base64Key));

                if(user instanceof Cliente){
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
    public UserDTO getUser(String username, String password) {
        for (UserService<? extends User> userService : userServices.values()) {
            User user = userService.getUser(username);
            if (user != null) {
                try {
                    user.setDni(DataEncryption.decrypt(user.getDni(), encryptionConfig.getSecretKey()));
                    user.setEmail(DataEncryption.decrypt(user.getEmail(), encryptionConfig.getSecretKey()));
                    user.setTelefono(DataEncryption.decrypt(user.getTelefono(), encryptionConfig.getSecretKey()));
                    if (passwordEncrypter.checkPassword(password, user.getPassword())) {
                        return new UserDTO(user);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new UserNotFoundException(username);
    }

}

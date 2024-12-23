package com.sabora.server.Utils.Encryption;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class SecureKeyGenerator {

        public static void main(String[] args) throws Exception {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256); // 256 bits para máxima seguridad
            SecretKey secretKey = keyGen.generateKey();
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
            System.out.println("Clave AES generada (codificada en Base64): " + encodedKey);
        }


}

package net.internalerror.appyserver.rest.service;

import org.springframework.stereotype.Service;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

@Service
public class PasswordService {

  public byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

  public byte[] hashPassword(String password, byte[] salt) {
    KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);

    try {
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      return factory.generateSecret(spec).getEncoded();
    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
      throw new RuntimeException(e);
    }
  }
}

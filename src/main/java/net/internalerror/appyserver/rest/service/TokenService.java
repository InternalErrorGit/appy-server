package net.internalerror.appyserver.rest.service;

import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.entity.AuthTokenEntity;
import net.internalerror.appyserver.data.entity.UserEntity;
import net.internalerror.appyserver.data.repository.AuthTokenRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TokenService {

  private final AuthTokenRepository authTokenRepository;

  public AuthTokenEntity createNewAuthToken(UserEntity user) {

    if (authTokenRepository.existsByUserEntity(user)) {
      return authTokenRepository.findByUserEntity(user);
    }


    String token;
    do {
      token = UUID.randomUUID().toString();
    } while (authTokenRepository.existsByToken(token));

    AuthTokenEntity authToken = new AuthTokenEntity();
    authToken.setCreateDate(LocalDateTime.now());
    authToken.setUserEntity(user);
    authToken.setToken(token);
    return authTokenRepository.save(authToken);
  }

}

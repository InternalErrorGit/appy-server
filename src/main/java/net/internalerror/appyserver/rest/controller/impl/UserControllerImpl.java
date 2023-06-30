package net.internalerror.appyserver.rest.controller.impl;

import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.entity.UserEntity;
import net.internalerror.appyserver.data.repository.UserRepository;
import net.internalerror.appyserver.rest.NetworkResponseObject;
import net.internalerror.appyserver.rest.controller.impl.base.UserControllerBase;
import net.internalerror.appyserver.rest.model.LoginModel;
import net.internalerror.appyserver.rest.model.RegisterModel;
import net.internalerror.appyserver.rest.service.PasswordService;
import net.internalerror.appyserver.rest.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserControllerImpl implements UserControllerBase {

  private final PasswordService passwordService;
  private final UserRepository userRepository;
  private final TokenService tokenService;

  @Override
  public NetworkResponseObject registerUser(RegisterModel registerModel) {

    UserEntity entity = new UserEntity();
    entity.setUsername(registerModel.getUsername());
    entity.setFirstname(registerModel.getFirstname());
    entity.setLastname(registerModel.getLastname());
    entity.setEmail(registerModel.getEmail());
    entity.setSalt(passwordService.generateSalt());
    entity.setPassword(passwordService.hashPassword(registerModel.getPassword(), entity.getSalt()));

    entity = userRepository.save(entity);

    return NetworkResponseObject.builder().message(null).status(HttpStatus.OK).object(entity).build();
  }

  @Override
  public NetworkResponseObject loginUser(LoginModel loginModel) {

    String username = loginModel.getUsername();

    UserEntity user = userRepository.findByUsername(username);

    if (user != null) {
      byte[] encodedPassword = passwordService.hashPassword(loginModel.getPassword(), user.getSalt());

      if (Arrays.equals(encodedPassword, user.getPassword())) {
        return NetworkResponseObject.builder().status(HttpStatus.OK).message(null).object(tokenService.createNewAuthToken(user)).build();
      }
      return NetworkResponseObject.builder().status(HttpStatus.UNAUTHORIZED).message("Login Failed").object(List.of("MSG1008")).build();

    }
    throw new RuntimeException("Something went wrong");
  }
}

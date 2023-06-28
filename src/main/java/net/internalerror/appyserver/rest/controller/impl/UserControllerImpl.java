package net.internalerror.appyserver.rest.controller.impl;

import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.entity.UserEntity;
import net.internalerror.appyserver.data.repository.UserRepository;
import net.internalerror.appyserver.rest.controller.impl.base.UserControllerBase;
import net.internalerror.appyserver.rest.model.RegisterModel;
import net.internalerror.appyserver.rest.service.PasswordService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserControllerImpl implements UserControllerBase {

  private final PasswordService passwordService;
  private final UserRepository userRepository;

  @Override
  public UserEntity registerUser(RegisterModel registerModel) {

    UserEntity entity = new UserEntity();
    entity.setUsername(registerModel.getUsername());
    entity.setFirstname(registerModel.getFirstname());
    entity.setLastname(registerModel.getLastname());
    entity.setEmail(registerModel.getEmail());
    entity.setSalt(passwordService.generateSalt());
    entity.setPassword(passwordService.hashPassword(registerModel.getPassword(), entity.getSalt()));

    return userRepository.save(entity);
  }
}

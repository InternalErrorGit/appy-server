package net.internalerror.appyserver.rest.controller;

import lombok.AllArgsConstructor;
import net.internalerror.appyserver.rest.NetworkResponseObject;
import net.internalerror.appyserver.rest.controller.impl.UserControllerImpl;
import net.internalerror.appyserver.rest.controller.impl.base.UserControllerBase;
import net.internalerror.appyserver.rest.model.LoginModel;
import net.internalerror.appyserver.rest.model.RegisterModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController implements UserControllerBase {

  private final UserControllerImpl impl;

  @Override
  @PostMapping("/api/user/register")
  public NetworkResponseObject registerUser(RegisterModel registerModel) {
    return impl.registerUser(registerModel);
  }

  @Override
  @PostMapping("/api/user/login")
  public NetworkResponseObject loginUser(LoginModel loginModel) {
    return impl.loginUser(loginModel);
  }
}

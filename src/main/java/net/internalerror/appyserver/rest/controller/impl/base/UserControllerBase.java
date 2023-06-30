package net.internalerror.appyserver.rest.controller.impl.base;

import jakarta.validation.Valid;
import net.internalerror.appyserver.rest.NetworkResponseObject;
import net.internalerror.appyserver.rest.model.LoginModel;
import net.internalerror.appyserver.rest.model.RegisterModel;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

public interface UserControllerBase {

  NetworkResponseObject registerUser(@Valid @RequestBody RegisterModel registerModel);

  NetworkResponseObject loginUser(@Valid @RequestBody LoginModel loginModel);
}

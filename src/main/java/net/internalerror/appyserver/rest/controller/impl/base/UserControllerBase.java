package net.internalerror.appyserver.rest.controller.impl.base;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.entity.UserEntity;
import net.internalerror.appyserver.rest.model.RegisterModel;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserControllerBase {

  UserEntity registerUser(@Valid @RequestBody RegisterModel registerModel);
}

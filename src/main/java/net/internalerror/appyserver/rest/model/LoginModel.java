package net.internalerror.appyserver.rest.model;

import lombok.Getter;
import lombok.Setter;
import net.internalerror.appyserver.rest.model.validation.UsernameExists;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class LoginModel {

  @UsernameExists(message = "MSG1007")
  @Length(min = 5, max = 25, message = "MSG1002")
  private String username;

  private String password;

}

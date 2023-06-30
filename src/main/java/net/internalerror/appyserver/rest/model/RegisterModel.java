package net.internalerror.appyserver.rest.model;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import net.internalerror.appyserver.rest.model.validation.UniqueEmail;
import net.internalerror.appyserver.rest.model.validation.UsernameExists;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class RegisterModel {

  @UsernameExists(message = "MSG1001")
  @Length(min = 5, max = 25, message = "MSG1002")
  private String username;

  private String password;

  @Email(message = "MSG1003")
  @UniqueEmail(message = "MSG1004")
  private String email;

  @Length(min = 2, max = 25, message = "MSG1005")
  private String firstname;

  @Length(min = 2, max = 25, message = "MSG1006")
  private String lastname;

}

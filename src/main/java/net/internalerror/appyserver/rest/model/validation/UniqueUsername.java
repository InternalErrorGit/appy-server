package net.internalerror.appyserver.rest.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;
import lombok.AllArgsConstructor;
import net.internalerror.appyserver.data.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueUsername.UniqueUsernameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueUsername {
  String message() default "Username is not unique";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @AllArgsConstructor
  @Service
  class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
      return !userRepository.existsByUsername(username);
    }
  }


}

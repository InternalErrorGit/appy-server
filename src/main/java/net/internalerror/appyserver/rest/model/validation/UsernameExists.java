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
@Constraint(validatedBy = UsernameExists.UsernameExistsValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UsernameExists {
  String message() default "Username does not exist";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @AllArgsConstructor
  @Service
  class UsernameExistsValidator implements ConstraintValidator<UsernameExists, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
      return userRepository.existsByUsername(username);
    }
  }


}

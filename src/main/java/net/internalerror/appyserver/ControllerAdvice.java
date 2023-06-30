package net.internalerror.appyserver;

import net.internalerror.appyserver.rest.NetworkResponseObject;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public NetworkResponseObject handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

    return NetworkResponseObject.builder()
        .status(HttpStatus.BAD_REQUEST)
        .message("Validation failed")
        .object(e.getBindingResult().getAllErrors().stream()
            .map(DefaultMessageSourceResolvable::getDefaultMessage)
            .collect(Collectors.toList())
        )
        .build();

  }
}

package net.internalerror.appyserver.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Builder
public class NetworkResponseObject {
  private HttpStatus status;
  private String message;
  private Object object;
}

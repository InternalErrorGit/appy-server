package net.internalerror.appyserver.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.internalerror.appyserver.data.base.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "auth_token_entity")
public class AuthTokenEntity extends BaseEntity {
  @Column(name = "create_date", nullable = false)
  private LocalDateTime createDate;

  @Column(name = "token", nullable = false, unique = true)
  private String token;

  @OneToOne(optional = false)
  @JsonIgnore
  @JoinColumn(name = "user_entity_id", nullable = false, unique = true)
  private UserEntity userEntity;

}
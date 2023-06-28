package net.internalerror.appyserver.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import net.internalerror.appyserver.data.base.BaseEntity;

@Getter
@Setter
@Entity
@Table(name = "user_entity")
public class UserEntity extends BaseEntity {
  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Lob
  @JsonIgnore
  @Column(name = "password", nullable = false)
  private byte[] password;

  @Lob
  @JsonIgnore
  @Column(name = "salt", nullable = false)
  private byte[] salt;

  @Column(name = "firstname", nullable = false)
  private String firstname;

  @Column(name = "lastname", nullable = false)
  private String lastname;

}
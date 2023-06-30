package net.internalerror.appyserver.data.repository;

import net.internalerror.appyserver.data.entity.AuthTokenEntity;
import net.internalerror.appyserver.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthTokenRepository extends JpaRepository<AuthTokenEntity, Long> {
  AuthTokenEntity findByUserEntity(UserEntity userEntity);
  boolean existsByUserEntity(UserEntity userEntity);
  boolean existsByToken(String token);
}
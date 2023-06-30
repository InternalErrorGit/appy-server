package net.internalerror.appyserver.data.repository;

import net.internalerror.appyserver.data.base.BaseRepository;
import net.internalerror.appyserver.data.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
  UserEntity findByUsername(String username);
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
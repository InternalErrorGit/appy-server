package net.internalerror.appyserver.data.repository;

import net.internalerror.appyserver.data.base.BaseRepository;
import net.internalerror.appyserver.data.entity.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<UserEntity> {
  boolean existsByUsername(String username);
  boolean existsByEmail(String email);
}
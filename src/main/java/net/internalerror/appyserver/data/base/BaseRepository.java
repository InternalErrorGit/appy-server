package net.internalerror.appyserver.data.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
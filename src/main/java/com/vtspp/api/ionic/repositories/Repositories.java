package com.vtspp.api.ionic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface Repositories<T, K> extends JpaRepository <T, K> {
}

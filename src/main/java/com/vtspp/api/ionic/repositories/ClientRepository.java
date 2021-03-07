package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends Repositories<Client, Integer> {
}
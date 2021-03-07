package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.Telephone;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneRepository extends Repositories<Telephone, Integer> {
}
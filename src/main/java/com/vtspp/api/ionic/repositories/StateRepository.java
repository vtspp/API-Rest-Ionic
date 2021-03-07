package com.vtspp.api.ionic.repositories;

import com.vtspp.api.ionic.domain.State;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends Repositories<State, Integer> {
}
package com.vtspp.api.ionic.resource;

import com.vtspp.api.ionic.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface Resources <T>{

    ResponseEntity<Void> save (T obj);
    ResponseEntity<Void> remove (Integer id);
    ResponseEntity<List<T>> findAll();
    ResponseEntity<Void> update (T obj);
    ResponseEntity<CategoryDTO> findOne (Integer id);
}

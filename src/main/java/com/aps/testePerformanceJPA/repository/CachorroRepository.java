package com.aps.testePerformanceJPA.repository;

import com.aps.testePerformanceJPA.Cachorro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroRepository extends CrudRepository<Cachorro, Long> {
}

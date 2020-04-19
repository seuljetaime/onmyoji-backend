package com.ez.onmyoji.repository;

import com.ez.onmyoji.bean.ShiShen;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 式神Repo
 */
@Repository
public interface ShiShenRepository extends ReactiveCrudRepository<ShiShen, Integer> {
}

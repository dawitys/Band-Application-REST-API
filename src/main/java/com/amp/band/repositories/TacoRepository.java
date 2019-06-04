package com.amp.band.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.amp.band.domains.Taco;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long>{
}
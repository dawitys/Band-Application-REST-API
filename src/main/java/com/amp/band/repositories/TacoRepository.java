package com.amp.band.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.amp.band.domains.Band;

public interface TacoRepository extends PagingAndSortingRepository<Band, Long>{
}
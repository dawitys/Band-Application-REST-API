package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amp.band.domains.Taco;
import com.amp.band.repositories.TacoRepository;

@Service
public class TacoServiceImpl implements TacoService {
	
	TacoRepository tacoRepository;

	@Autowired
	public TacoServiceImpl(TacoRepository tacoRepository) {
		this.tacoRepository = tacoRepository;
	}

	@Override
	public Taco save(Taco ingredient) {
		return tacoRepository.save(ingredient);
	}

	@Override
	public Iterable<Taco> saveAll(Iterable<Taco> tacos) {
		return tacoRepository.saveAll(tacos);
	}

	@Override
	public Optional<Taco> findById(Long id) {
		return tacoRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return tacoRepository.existsById(id);
	}

	@Override
	public Iterable<Taco> findAll() {
		return tacoRepository.findAll();
	}

	@Override
	public Iterable<Taco> findAllById(Iterable<Long> ids) {
		return tacoRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return tacoRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		tacoRepository.deleteById(id);
	}

	@Override
	public void delete(Taco taco) {
		tacoRepository.delete(taco);
	}

	@Override
	public void deleteAll(Iterable<Taco> tacos) {
		tacoRepository.deleteAll(tacos);
	}

	@Override
	public void deleteAll() {
		tacoRepository.deleteAll();
	}

	@Override
	public Iterable<Taco> findAll(Sort sort) {
		return tacoRepository.findAll(sort);
	}

	@Override
	public Page<Taco> findAll(Pageable pageable) {
		return tacoRepository.findAll(pageable);
	}

}

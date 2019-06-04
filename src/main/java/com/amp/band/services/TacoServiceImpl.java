package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amp.band.domains.Band;
import com.amp.band.repositories.TacoRepository;

@Service
public class TacoServiceImpl implements TacoService {
	
	TacoRepository tacoRepository;

	@Autowired
	public TacoServiceImpl(TacoRepository tacoRepository) {
		this.tacoRepository = tacoRepository;
	}

	@Override
	public Band save(Band ingredient) {
		return tacoRepository.save(ingredient);
	}

	@Override
	public Iterable<Band> saveAll(Iterable<Band> tacos) {
		return tacoRepository.saveAll(tacos);
	}

	@Override
	public Optional<Band> findById(Long id) {
		return tacoRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return tacoRepository.existsById(id);
	}

	@Override
	public Iterable<Band> findAll() {
		return tacoRepository.findAll();
	}

	@Override
	public Iterable<Band> findAllById(Iterable<Long> ids) {
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
	public void delete(Band taco) {
		tacoRepository.delete(taco);
	}

	@Override
	public void deleteAll(Iterable<Band> tacos) {
		tacoRepository.deleteAll(tacos);
	}

	@Override
	public void deleteAll() {
		tacoRepository.deleteAll();
	}

	@Override
	public Iterable<Band> findAll(Sort sort) {
		return tacoRepository.findAll(sort);
	}

	@Override
	public Page<Band> findAll(Pageable pageable) {
		return tacoRepository.findAll(pageable);
	}

}

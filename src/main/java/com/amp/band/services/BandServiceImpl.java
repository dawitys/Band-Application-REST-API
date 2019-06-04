package com.amp.band.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.amp.band.domains.Band;
import com.amp.band.repositories.BandRepository;

@Service
public class BandServiceImpl implements BandService {
	
	BandRepository bandRepository;

	@Autowired
	public BandServiceImpl(BandRepository BandRepository) {
		this.bandRepository = BandRepository;
	}

	@Override
	public Band save(Band ingredient) {
		return bandRepository.save(ingredient);
	}

	@Override
	public Iterable<Band> saveAll(Iterable<Band> Bands) {
		return bandRepository.saveAll(Bands);
	}

	@Override
	public Optional<Band> findById(Long id) {
		return bandRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return bandRepository.existsById(id);
	}

	@Override
	public Iterable<Band> findAll() {
		return bandRepository.findAll();
	}

	@Override
	public Iterable<Band> findAllById(Iterable<Long> ids) {
		return bandRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return bandRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		bandRepository.deleteById(id);
	}

	@Override
	public void delete(Band Band) {
		bandRepository.delete(Band);
	}

	@Override
	public void deleteAll(Iterable<Band> Bands) {
		bandRepository.deleteAll(Bands);
	}

	@Override
	public void deleteAll() {
		bandRepository.deleteAll();
	}

	@Override
	public Iterable<Band> findAll(Sort sort) {
		return null;
		//return bandRepository.findAll(sort);
	}

	@Override
	public Page<Band> findAll(Pageable pageable) {
		return null;
		//return bandRepository.findAll(pageable);
	}

}

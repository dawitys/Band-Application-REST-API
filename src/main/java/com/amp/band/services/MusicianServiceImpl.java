package com.amp.band.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amp.band.domains.Musician;
import com.amp.band.repositories.MusicianRepository;

@Service
public class MusicianServiceImpl implements MusicianService {

	MusicianRepository musicianRepository;
	
	@Autowired
	public MusicianServiceImpl(MusicianRepository musicianRepository) {
		this.musicianRepository = musicianRepository;
	}
	
	@Override
	public Musician save(Musician musician) {
		return musicianRepository.save(musician);
	}

	@Override
	public Iterable<Musician> saveAll(Iterable<Musician> musicians) {
		return musicianRepository.saveAll(musicians);		
	}

	@Override
	public Optional<Musician> findById(Long id) {
		return musicianRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return musicianRepository.existsById(id);
	}

	@Override
	public Iterable<Musician> findAll() {
		return musicianRepository.findAll();
	}

	@Override
	public Iterable<Musician> findAllById(Iterable<Long> ids) {
		return musicianRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return musicianRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		musicianRepository.deleteById(id);
	}

	@Override
	public void delete(Musician musician) {		
		musicianRepository.delete(musician);
	}

	@Override
	public void deleteAll(Iterable<Musician> musicians) {
		musicianRepository.deleteAll(musicians);
	}

	@Override
	public void deleteAll() {
		musicianRepository.deleteAll();
	}

}

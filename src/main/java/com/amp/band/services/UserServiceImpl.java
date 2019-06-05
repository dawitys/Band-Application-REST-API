package com.amp.band.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amp.band.domains.User;
import com.amp.band.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository UserRepository) {
		this.userRepository = UserRepository;
	}

	@Override
	public User save(User ingredient) {
		return userRepository.save(ingredient);
	}

	@Override
	public Iterable<User> saveAll(Iterable<User> Users) {
		return userRepository.saveAll(Users);
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return userRepository.existsById(id);
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Iterable<User> findAllById(Iterable<Long> ids) {
		return userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User User) {
		userRepository.delete(User);
	}

	@Override
	public void deleteAll(Iterable<User> Users) {
		userRepository.deleteAll(Users);
	}

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}
}

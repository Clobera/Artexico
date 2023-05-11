package com.personalprojects.artexico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalprojects.artexico.entities.Borough;
import com.personalprojects.artexico.repositories.BoroughRepository;

@Service
public class BoroughServiceImpl implements BoroughService {
	@Autowired
	private BoroughRepository boroRepo;

	@Override
	public List<Borough> index() {
		return boroRepo.findAll();
	}

}

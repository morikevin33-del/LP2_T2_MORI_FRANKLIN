package com.examenT2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenT2.entity.ProveedorMoriFranklin;
import com.examenT2.repository.ProveedorMoriFranklinRepository;
import com.examenT2.service.ProveedorMoriFranklinService;

@Service
public class ProveedorMoriFranklinServiceImpl implements ProveedorMoriFranklinService {

	@Autowired
	private ProveedorMoriFranklinRepository proveedorRepository;

	@Override
	public List<ProveedorMoriFranklin> listar() {
		return proveedorRepository.findAll();
	}

	@Override
	public ProveedorMoriFranklin buscarPorId(Integer id) {
		return proveedorRepository.findById(id).orElse(null);
	}
}

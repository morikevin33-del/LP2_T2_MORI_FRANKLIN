package com.examenT2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examenT2.entity.OrdenCompraMoriFranklin;
import com.examenT2.repository.OrdenCompraMoriFranklinRepository;
import com.examenT2.service.OrdenCompraMoriFranklinService;

@Service
public class OrdenCompraMoriFranklinServiceImpl implements OrdenCompraMoriFranklinService {

	@Autowired
	private OrdenCompraMoriFranklinRepository ordenRepository;

	@Override
	public List<OrdenCompraMoriFranklin> listarDescendente() {
		return ordenRepository.findAllByOrderByNroOrdenDesc();
	}

	@Override
	public OrdenCompraMoriFranklin buscarPorId(Integer nroOrden) {
		return ordenRepository.findById(nroOrden).orElse(null);
	}

	@Override
	public OrdenCompraMoriFranklin guardar(OrdenCompraMoriFranklin orden) {
		return ordenRepository.save(orden);
	}
}

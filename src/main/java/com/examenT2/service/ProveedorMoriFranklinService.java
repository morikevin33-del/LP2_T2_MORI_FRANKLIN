package com.examenT2.service;

import java.util.List;

import com.examenT2.entity.ProveedorMoriFranklin;

public interface ProveedorMoriFranklinService {

	List<ProveedorMoriFranklin> listar();

	ProveedorMoriFranklin buscarPorId(Integer id);
}

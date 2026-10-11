package com.examenT2.service;

import java.util.List;

import com.examenT2.entity.OrdenCompraMoriFranklin;

public interface OrdenCompraMoriFranklinService {

	List<OrdenCompraMoriFranklin> listarDescendente();

	OrdenCompraMoriFranklin buscarPorId(Integer nroOrden);

	OrdenCompraMoriFranklin guardar(OrdenCompraMoriFranklin orden);
}

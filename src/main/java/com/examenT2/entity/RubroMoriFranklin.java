package com.examenT2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_rubro")
public class RubroMoriFranklin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rubro")
	private Integer idRubro;

	@Column(name = "denominacion", nullable = false, length = 50)
	private String denominacion;

	public RubroMoriFranklin() {
	}

	public Integer getIdRubro() {
		return idRubro;
	}

	public void setIdRubro(Integer idRubro) {
		this.idRubro = idRubro;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
}

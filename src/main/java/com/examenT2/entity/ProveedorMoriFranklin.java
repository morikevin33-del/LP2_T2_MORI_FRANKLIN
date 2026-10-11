package com.examenT2.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_proveedor")
public class ProveedorMoriFranklin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "ruc", nullable = false, length = 11)
	private String ruc;

	@Column(name = "razon_social", nullable = false, length = 50)
	private String razonSocial;

	@Column(name = "fecha_registro", nullable = false)
	private LocalDateTime fechaRegistro;

	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;

	@Column(name = "pagina_web", length = 100)
	private String paginaWeb;

	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private RubroMoriFranklin rubro;

	public ProveedorMoriFranklin() {
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPaginaWeb() {
		return paginaWeb;
	}

	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}

	public RubroMoriFranklin getRubro() {
		return rubro;
	}

	public void setRubro(RubroMoriFranklin rubro) {
		this.rubro = rubro;
	}
}

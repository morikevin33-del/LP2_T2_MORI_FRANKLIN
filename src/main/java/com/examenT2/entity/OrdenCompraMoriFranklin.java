package com.examenT2.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tbl_orden_compra")
public class OrdenCompraMoriFranklin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false)
	private ProveedorMoriFranklin proveedor;

	@Column(name = "monto", nullable = false, precision = 10, scale = 2)
	private BigDecimal monto;

	@Column(name = "direccion_entrega", nullable = false, length = 255)
	private String direccionEntrega;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fecha_entrega", nullable = false)
	private LocalDate fechaEntrega;

	@Column(name = "estado", length = 1)
	private String estado = "P";

	public OrdenCompraMoriFranklin() {
	}

	@PrePersist
	void valorPorDefecto() {
		if (estado == null || estado.isBlank()) {
			estado = "P";
		}
	}

	@Transient
	public String getEstadoDescripcion() {
		if ("C".equals(estado)) {
			return "Completado";
		} else if ("A".equals(estado)) {
			return "Anulado";
		}
		return "Pendiente";
	}

	public Integer getNroOrden() {
		return nroOrden;
	}

	public void setNroOrden(Integer nroOrden) {
		this.nroOrden = nroOrden;
	}

	public ProveedorMoriFranklin getProveedor() {
		return proveedor;
	}

	public void setProveedor(ProveedorMoriFranklin proveedor) {
		this.proveedor = proveedor;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public LocalDate getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(LocalDate fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}

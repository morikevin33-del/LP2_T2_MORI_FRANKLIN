package com.examenT2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.entity.OrdenCompraMoriFranklin;
import com.examenT2.entity.ProveedorMoriFranklin;
import com.examenT2.service.OrdenCompraMoriFranklinService;
import com.examenT2.service.ProveedorMoriFranklinService;

@Controller
public class OrdenCompraMoriFranklinController {

	@Autowired
	private OrdenCompraMoriFranklinService ordenService;

	@Autowired
	private ProveedorMoriFranklinService proveedorService;

	@GetMapping({ "/", "/ordenes" })
	public String listado(Model model) {
		model.addAttribute("ordenes", ordenService.listarDescendente());
		return "listadoMoriFranklin";
	}

	@GetMapping("/ordenes/nuevo")
	public String nuevo(Model model) {
		OrdenCompraMoriFranklin orden = new OrdenCompraMoriFranklin();
		orden.setProveedor(new ProveedorMoriFranklin());
		model.addAttribute("orden", orden);
		model.addAttribute("proveedores", proveedorService.listar());
		return "nuevoMoriFranklin";
	}

	@PostMapping("/ordenes/nuevo")
	public String registrar(@ModelAttribute("orden") OrdenCompraMoriFranklin orden, RedirectAttributes redirect) {
		orden.setNroOrden(null);
		orden.setEstado("P");
		orden.setProveedor(proveedorService.buscarPorId(orden.getProveedor().getIdProveedor()));
		OrdenCompraMoriFranklin guardada = ordenService.guardar(orden);
		redirect.addFlashAttribute("mensaje", "Orden de compra Nro. " + guardada.getNroOrden() + " registrada.");
		return "redirect:/ordenes";
	}

	@GetMapping("/ordenes/editar/{nroOrden}")
	public String editar(@PathVariable Integer nroOrden, Model model) {
		OrdenCompraMoriFranklin orden = ordenService.buscarPorId(nroOrden);
		if (orden == null) {
			return "redirect:/ordenes";
		}
		model.addAttribute("orden", orden);
		model.addAttribute("proveedores", proveedorService.listar());
		return "edicionMoriFranklin";
	}

	@PostMapping("/ordenes/editar/{nroOrden}")
	public String actualizar(@PathVariable Integer nroOrden, @ModelAttribute("orden") OrdenCompraMoriFranklin orden,
			RedirectAttributes redirect) {
		orden.setNroOrden(nroOrden);
		orden.setProveedor(proveedorService.buscarPorId(orden.getProveedor().getIdProveedor()));
		OrdenCompraMoriFranklin guardada = ordenService.guardar(orden);
		redirect.addFlashAttribute("mensaje", "Orden de compra Nro. " + guardada.getNroOrden() + " actualizada.");
		return "redirect:/ordenes";
	}
}

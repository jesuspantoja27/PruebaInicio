package com.pruebaback.demo.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pruebaback.demo.interfaceService.IProductoService;
import com.pruebaback.demo.modelo.Producto;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos",productos);
		return "listado";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("producto",new Producto());
		return"AgregarProducto";
		
	}
	@PostMapping("/save")
	public String save(@Validated Producto P, Model model) {
		service.save(P);
		return"redirect:/listar";

	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Producto>producto=service.listarId(id);
		model.addAttribute("producto", producto);
		return"AgregarProducto";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return"redirect:/listar";
		
	}
	
	
}



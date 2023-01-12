package com.pruebaback.demo.interfaceService;

import java.util.Optional;
import java.util.List;


import com.pruebaback.demo.modelo.Producto;

public interface IProductoService {
	
	public List<Producto>listar();
	public Optional<Producto>listarId(int id);
	public int save(Producto P);
	public void  delete(int id);
	
}

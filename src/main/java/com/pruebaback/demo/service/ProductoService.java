package com.pruebaback.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaback.demo.interfaceService.IProductoService;
import com.pruebaback.demo.interfaces.IProducto;

import com.pruebaback.demo.modelo.Producto;

@Service

public class ProductoService implements IProductoService {

	@Autowired
	private IProducto data;  
	
	@Override
	public List<Producto>listar() {
		// TODO Auto-generated method stub
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Producto P) {
		int res=0;
		Producto producto=data.save(P);
		if(producto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}

}

package pe.com.cibertec.service;

import java.util.List;

import pe.com.cibertec.mode.entity.CategoriaProductoEntity;

public interface CategoriaProductoService {
	List<CategoriaProductoEntity> buscarCategoriaProductos();

	void crearCategoriaProducto(CategoriaProductoEntity categoriaProducto);

	CategoriaProductoEntity buscarCategoriaProductoPorId(Integer id);

	void actualizarCategoriaProducto(Integer id, CategoriaProductoEntity categoriaProductoEntity);

	void eliminarCategoriaProducto(Integer id);
}

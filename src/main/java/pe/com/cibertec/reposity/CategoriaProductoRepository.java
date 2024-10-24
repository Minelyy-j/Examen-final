package pe.com.cibertec.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.cibertec.mode.entity.CategoriaProductoEntity;

@Repository
public interface CategoriaProductoRepository extends JpaRepository<CategoriaProductoEntity, Integer> {

}

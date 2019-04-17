package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}

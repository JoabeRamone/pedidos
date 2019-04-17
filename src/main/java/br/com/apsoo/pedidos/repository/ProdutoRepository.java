package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}

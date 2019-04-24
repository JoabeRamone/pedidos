package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}

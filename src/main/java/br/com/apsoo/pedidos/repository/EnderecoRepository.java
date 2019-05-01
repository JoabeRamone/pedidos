package br.com.apsoo.pedidos.repository;

import br.com.apsoo.pedidos.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}

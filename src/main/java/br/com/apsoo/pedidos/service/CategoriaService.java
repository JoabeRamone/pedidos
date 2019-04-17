package br.com.apsoo.pedidos.service;


import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.repository.CategoriaRepository;
import br.com.apsoo.pedidos.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;


    public Categoria buscarPorId(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("O Objeto com o Id: "
                + id + " da classe "
                + Categoria.class.getName()
                + " não foi econtrado."));
    }
}

package br.com.apsoo.pedidos.resource;


import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//cama de controle

@RestController
@RequestMapping(value = "/categorias") //mapeando
public class CategoriaResource {

    @Autowired //qunaod ele for subir a aplicação ele gerencia as dependencias. Como instancia
    private CategoriaService categoriaService;


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")//{qual quer valor}
    public ResponseEntity<?> buscarCategoriaPorId(@PathVariable("id") Integer id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        return ResponseEntity.ok().body(categoria);
    }

}

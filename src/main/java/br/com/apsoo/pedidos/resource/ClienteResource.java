package br.com.apsoo.pedidos.resource;


import br.com.apsoo.pedidos.domain.Cliente;
import br.com.apsoo.pedidos.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


//cama de controle

@RestController
@RequestMapping(value = "/clientes") //mapeando
public class ClienteResource {

    @Autowired //qunaod ele for subir a aplicação ele gerencia as dependencias. Como instancia
    private ClienteService clienteService;


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")//{qual quer valor}
    public ResponseEntity<?> buscarClientePorId(@PathVariable("id") Integer id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok().body(cliente);
    }

}

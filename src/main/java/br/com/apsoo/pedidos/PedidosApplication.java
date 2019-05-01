package br.com.apsoo.pedidos;



import br.com.apsoo.pedidos.domain.Categoria;
import br.com.apsoo.pedidos.domain.Cidade;
import br.com.apsoo.pedidos.domain.Cliente;
import br.com.apsoo.pedidos.domain.Endereco;
import br.com.apsoo.pedidos.domain.Estado;
import br.com.apsoo.pedidos.domain.Produto;
import br.com.apsoo.pedidos.domain.enumerations.TipoCliente;
import br.com.apsoo.pedidos.repository.CategoriaRepository;
import br.com.apsoo.pedidos.repository.CidadeRepository;
import br.com.apsoo.pedidos.repository.ClienteRepository;
import br.com.apsoo.pedidos.repository.EnderecoRepository;
import br.com.apsoo.pedidos.repository.EstadoRepository;
import br.com.apsoo.pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class PedidosApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public static void main(String[] args) {
        SpringApplication.run(PedidosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Categoria cat1 = new Categoria(null, "Informática");
        Categoria cat2 = new Categoria(null, "Escritório");

        Produto p1 = new Produto(null, "Computador", 2000);
        Produto p2 = new Produto(null, "Impresora", 800);
        Produto p3 = new Produto(null, "Mouse", 80);

        cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));

        cat2.getProdutos().add(p2);

        p1.getCategorias().add(cat1);
        p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
        p3.getCategorias().add(cat1);


        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "São Paulo");

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "São Paulo", est2);
        Cidade c3 = new Cidade(null, "Campinas", est2);

        est1.getCidades().add(c1);
        est2.getCidades().addAll(Arrays.asList(c2, c3));

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

        Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "15485454854145", TipoCliente.PESSOAFISICA);

        cli1.getTelefones().addAll(Arrays.asList("54185415545","65652415852"));

        Endereco e1 = new Endereco(null,"Rua Flores","300","Apto 21","Jardim","48426584",c1,cli1);
        Endereco e2 = new Endereco(null,"Rua Avenida Matos","105","Sala 800","Centro","48426635",c2,cli1);

        cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

        clienteRepository.save(cli1);
        enderecoRepository.saveAll(Arrays.asList(e1,e2));


    }
}

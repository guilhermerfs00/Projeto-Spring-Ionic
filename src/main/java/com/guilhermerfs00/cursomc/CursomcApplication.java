package com.guilhermerfs00.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.guilhermerfs00.cursomc.domain.Categoria;
import com.guilhermerfs00.cursomc.domain.Cidades;
import com.guilhermerfs00.cursomc.domain.Cliente;
import com.guilhermerfs00.cursomc.domain.Endereco;
import com.guilhermerfs00.cursomc.domain.Estado;
import com.guilhermerfs00.cursomc.domain.Produto;
import com.guilhermerfs00.cursomc.domain.enums.TipoCliente;
import com.guilhermerfs00.cursomc.repositories.CategoriaRepository;
import com.guilhermerfs00.cursomc.repositories.CidadeRepository;
import com.guilhermerfs00.cursomc.repositories.ClienteRepository;
import com.guilhermerfs00.cursomc.repositories.EnderecoRepository;
import com.guilhermerfs00.cursomc.repositories.EstadoRepository;
import com.guilhermerfs00.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidades c1 = new Cidades(null, "Uberlandia", est1);
		Cidades c2 = new Cidades(null, "São Paulo", est2);
		Cidades c3 = new Cidades(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "9323493512", TipoCliente.PESSOAFISICA);

		cli1.getTelefones().addAll(Arrays.asList("34778783", "983485924"));

		Endereco e1 = new Endereco(null, "Rua flores", "300", "Apto303", "Jardim", "39285483", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "142342312", cli1, c2);
		
		cli1.getEndereco().addAll(Arrays.asList(e1,e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	}

}

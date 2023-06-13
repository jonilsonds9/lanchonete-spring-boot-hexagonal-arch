package br.com.fiap.lanchonete.infraestrutura.adaptadores.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.lanchonete.dominio.Produto;
import br.com.fiap.lanchonete.dominio.portas.repositories.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.infraestrutura.adaptadores.entidades.ProdutoEntity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

	@Autowired
	private SpringProdutoRepository springProdutoRepository;

	@Override
	public List<Produto> findAll() {
		List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findAll();
		return produtoEntities.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList());
	}

	@Override
	public Produto incluir(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity(
				produto.getNome(), 
				produto.getDescricao(), 
				produto.getPreco(),
				produto.getDataCadastro(), 
				produto.getStatus(), 
				produto.getCategorias());
		
		return new Produto(this.springProdutoRepository.save(produtoEntity));
	}

	@Override
	public Produto alterar(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity(
				produto.getId(),
				produto.getNome(), 
				produto.getDescricao(), 
				produto.getPreco(),
				produto.getDataCadastro(), 
				produto.getStatus(), 
				produto.getCategorias());
		
		return new Produto(this.springProdutoRepository.save(produtoEntity));
	}

	@Override
	public void excluir(Long id) {
		ProdutoEntity produtoEntity = this.springProdutoRepository.findById(id).get();
		this.springProdutoRepository.delete(produtoEntity);	
	}

	@Override
	public List<Produto> buscarPorCategoria(String categoria) {
		List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findByCategoriasNome(categoria);		
		return Produto.toProdutos(produtoEntities);
	}
}

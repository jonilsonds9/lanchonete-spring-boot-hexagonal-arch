package br.com.fiap.lanchonete.infrastracture.persistence.repositories;

import br.com.fiap.lanchonete.domain.Categoria;
import br.com.fiap.lanchonete.domain.Produto;
import br.com.fiap.lanchonete.domain.ports.repositories.ProdutoRepositoryPort;
import br.com.fiap.lanchonete.infrastracture.persistence.entidades.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoRepository implements ProdutoRepositoryPort {

	private final SpringProdutoRepository springProdutoRepository;

	public ProdutoRepository(SpringProdutoRepository springProdutoRepository) {
		this.springProdutoRepository = springProdutoRepository;
	}

	@Override
	public List<Produto> buscarTodos() {
		List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findAll();
		return produtoEntities.stream().map(ProdutoEntity::toProduto).toList();
	}

	@Override
	public Optional<Produto> buscarPorId(Long id) {
		Optional<ProdutoEntity> optionalProdutoEntity = this.springProdutoRepository.findById(id);
		return optionalProdutoEntity.map(ProdutoEntity::toProduto);
	}

	@Override
	public List<Produto> buscarPorCategoria(Categoria categoria) {
		List<ProdutoEntity> produtoEntities = this.springProdutoRepository.findByCategoria(categoria);
		return produtoEntities.stream().map(ProdutoEntity::toProduto).toList();
	}

	@Override
	public Produto salvar(Produto produto) {
		ProdutoEntity produtoEntity = this.springProdutoRepository.save(new ProdutoEntity(produto));
		return produtoEntity.toProduto();
	}

	@Override
	public void excluir(Long id) {
		this.springProdutoRepository.deleteById(id);
	}
}

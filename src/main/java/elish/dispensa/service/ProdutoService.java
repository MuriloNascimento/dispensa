package elish.dispensa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import elish.dispensa.dao.ProdutoDAO;
import elish.dispensa.entidades.Produto;
import elish.dispensa.exceptions.DaoException;
import elish.dispensa.exceptions.ServiceExeption;

@Service
public class ProdutoService {

	@Inject
	private ProdutoDAO pdao;

	public void salvar(Produto produto) throws ServiceExeption {

		if (produto.getNome() == null) {
			throw new ServiceExeption("O produto está sem nome");
		}

		try {
			pdao.salvar(produto);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel salvar", e);
		}

	}

	public void excluir(Produto produto) throws ServiceExeption {
		Produto ptmp = pdao.buscarPorId(produto.getId());
		pdao.excluir(ptmp);
	}

	public List<Produto> buscarTodos() {
		return pdao.buscartodos();
	}

	public Produto buscarPorId(int id) {
		return pdao.buscarPorId(id);
	}

}

package elish.dispensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import elish.dispensa.dao.ProdutoDAO;
import elish.dispensa.entidades.Produto;
import elish.dispensa.exceptions.ServiceExeption;
import elish.dispensa.exceptions.DaoException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoDAO pdao; 
	
	public void salvar(Produto produto) throws ServiceExeption{
		
		if(produto.getNome()==null){
			throw new ServiceExeption("O usuario está sem nome");
		}
		
		try {
			pdao.salvar(produto);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel salvar",e);
		}
		
	}
	
}

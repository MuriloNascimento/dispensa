package elish.dispensa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import elish.dispensa.dao.SetorDAO;
import elish.dispensa.entidades.Setor;
import elish.dispensa.exceptions.DaoException;
import elish.dispensa.exceptions.ServiceExeption;

@Service
public class SetoreService {
	
	@Inject
	private SetorDAO sdao;
	
	public List<Setor> buscarTodos() {
		return sdao.buscartodos();
	}
	
	public Setor buscarPorId(int id){
		return sdao.buscarPorId(id);
	}
	
	public void salvar(Setor setor) throws ServiceExeption {

		if (setor.getNome() == null) {
			throw new ServiceExeption("O setor está sem nome");
		}

		try {
			sdao.salvar(setor);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel salvar", e);
		}

	}

	public void excluir(Setor setor) throws ServiceExeption {
		try {
			Setor stmp = sdao.buscarPorId(setor.getId());
			sdao.excluir(stmp);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel excluir", e);
		}
		
	}

}

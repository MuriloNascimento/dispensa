package elish.dispensa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import elish.dispensa.dao.SetorDAO;
import elish.dispensa.entidades.Setor;

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
	
	

}

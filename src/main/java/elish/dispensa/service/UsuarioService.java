package elish.dispensa.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import elish.dispensa.dao.UsuarioDAO;
import elish.dispensa.entidades.Usuario;
import elish.dispensa.exceptions.DaoException;
import elish.dispensa.exceptions.ServiceExeption;

@Service
public class UsuarioService {

	@Inject
	private UsuarioDAO udao;

	public void salvar(Usuario usuario) throws ServiceExeption {

		try {
			
			if (usuario.getSenha() == null || usuario.getSenha() == "") {
				throw new ServiceExeption("O usuario está sem senha");
			}

			udao.salvar(usuario);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel salvar", e);
		}

	}
	
	public void excluir(Usuario usuario) throws ServiceExeption {

		try {
			Usuario usuarioTmp = udao.buscarPorId(usuario.getId());
			udao.excluir(usuarioTmp);
		} catch (DaoException e) {
			throw new ServiceExeption("Não foi possivel salvar", e);
		}

	}
	
	public List<Usuario> buscarTodos(){
		return udao.buscartodos();
	}
	
	public Usuario buscarPorId(int id){
		return udao.buscarPorId(id);
	}

}

package elish.dispensa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import elish.dispensa.entidades.Usuario;
import elish.dispensa.exceptions.DaoException;

@Repository
@SuppressWarnings("unchecked")
public class UsuarioDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Usuario usuario) throws DaoException{
		try {
			em.merge(usuario);
		} catch (Exception e) {
			throw new DaoException("Não foi possivel salvar",e);
		}
	}
	
	@Transactional
	public void excluir(Usuario usuario) throws DaoException{
		try {
			em.remove(usuario);
		} catch (Exception e) {
			throw new DaoException("Não foi possivel excluir",e);
		}
	}
	
	
	public List<Usuario> buscartodos(){
		
		Query consulta = em.createQuery("select u from Usuario u");
		return consulta.getResultList();
	}
	
	public Usuario buscarPorId(int id){
		return em.find(Usuario.class, id);
	}
	
	public List<Usuario> buscarPorLoginSenha(Usuario usuario){
		Query consulta = em.createQuery("Select u from Usuario u where u.login=:login and u.Senha=:senha");
		consulta.setParameter("login",usuario.getLogin());
		consulta.setParameter("senha",usuario.getSenha());
		return consulta.getResultList();
	}

}

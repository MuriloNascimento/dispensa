package elish.dispensa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import elish.dispensa.entidades.Setor;
import elish.dispensa.exceptions.DaoException;

@Repository
public class SetorDAO {

	@PersistenceContext
	EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Setor> buscartodos(){
		Query consulta = em.createQuery("select s from Setor s");
		return consulta.getResultList();
	}
	
	public Setor buscarPorId(int id){
		return em.find(Setor.class, id);
	}
	
	@Transactional
	public void salvar(Setor setor) throws DaoException{
		try {
			em.merge(setor);
		} catch (Exception e) {
			throw new DaoException("Não foi possivel salvar",e);
		} finally {
			em.close();
		}
		
	}
	
	@Transactional
	public void excluir(Setor setor) throws DaoException{
		try {
			em.remove(setor);
		} catch (Exception e) {
			throw new DaoException("Não foi possivel excluir",e);
		} finally {
			em.close();
		}
	}
}

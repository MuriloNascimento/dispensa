package elish.dispensa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import elish.dispensa.entidades.Setor;

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
}

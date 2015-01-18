package elish.dispensa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import elish.dispensa.entidades.Produto;
import elish.dispensa.exceptions.DaoException;

@Repository
public class ProdutoDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public void salvar(Produto produto) throws DaoException{
		try {
			em.merge(produto);
		} catch (Exception e) {
			throw new DaoException("Não foi possivel salvar",e);
		} finally {
			em.close();
		}
		
	}
	
	@Transactional
	public void excluir(Produto produto){
		em.remove(produto);
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscartodos(){
		
		Query consulta = em.createQuery("select p from Produto p");
		return consulta.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> buscarTodosOrdenadosPor(String ordem){
		Query consulta = em.createQuery("select p from Produto p order by p.nome "+ordem);
		return consulta.getResultList();
	}
	
	public Produto buscarPorId(int id){
		return em.find(Produto.class, id);
	}

}

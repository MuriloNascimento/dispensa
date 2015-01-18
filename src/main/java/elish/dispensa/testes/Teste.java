package elish.dispensa.testes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import elish.dispensa.dao.ProdutoDAO;
import elish.dispensa.entidades.Produto;
import elish.dispensa.exceptions.DaoException;


public class Teste {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws DaoException {
		// TODO Auto-generated method stub
		
		ApplicationContext contexto = new ClassPathXmlApplicationContext("applicationContext.xml");
		ProdutoDAO pdao = contexto.getBean(ProdutoDAO.class);
		
		Produto produto = new Produto();
		
		produto.setNome("Queijo");
		produto.setSetor("Geladeira");
		
		pdao.salvar(produto);
	}

}

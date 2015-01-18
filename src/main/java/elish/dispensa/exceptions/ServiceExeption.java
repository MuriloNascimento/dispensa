package elish.dispensa.exceptions;

@SuppressWarnings("serial")
public class ServiceExeption extends Exception {

	public ServiceExeption(String mensagem) {
		super(mensagem);
	}

	public ServiceExeption(String mensagem, DaoException e) {
		super(mensagem, e);
	}
	
}

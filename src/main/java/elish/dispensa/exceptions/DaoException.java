package elish.dispensa.exceptions;

@SuppressWarnings("serial")
public class DaoException extends Exception {

	public DaoException(String mensagem, Exception e) {
		super(mensagem, e);
	}

}

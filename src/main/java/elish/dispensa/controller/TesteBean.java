package elish.dispensa.controller;

import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

import org.springframework.stereotype.Controller;

@Controller
@ViewScoped
public class TesteBean {
	
	private String cor;

	public void alteraCor(ValueChangeEvent e){
		this.cor = e.getNewValue().toString();
	}
	
	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	

}

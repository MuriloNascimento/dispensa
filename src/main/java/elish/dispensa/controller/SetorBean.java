package elish.dispensa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import elish.dispensa.entidades.Setor;
import elish.dispensa.service.SetoreService;

@Controller
@ViewScoped
public class SetorBean {
	
	private Setor setor = new Setor();
	private List<Setor> setores;

	@Inject
	private SetoreService ss;
	
	@PostConstruct
	public void init(){
		setores = ss.buscarTodos();
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public SetoreService getSs() {
		return ss;
	}

	public void setSs(SetoreService ss) {
		this.ss = ss;
	}

}

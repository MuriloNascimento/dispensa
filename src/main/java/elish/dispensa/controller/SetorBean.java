package elish.dispensa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import elish.dispensa.entidades.Setor;
import elish.dispensa.exceptions.ServiceExeption;
import elish.dispensa.service.SetoreService;

@Controller
@ViewScoped
public class SetorBean {
	
	private Setor setor = new Setor();
	private List<Setor> setores;
	private String titulo;

	@Inject
	private SetoreService ss;
	
	@PostConstruct
	public void init(){
		setores = ss.buscarTodos();
		titulo = "Cadastro de setor";
	}
	
	public void salvar(){
		try {
			ss.salvar(setor);
			setor = new Setor();
			setores = ss.buscarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso",null));
		} catch (ServiceExeption e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel salvar " + e.getMessage(),null));
		}
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}

package elish.dispensa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import elish.dispensa.entidades.Usuario;
import elish.dispensa.exceptions.ServiceExeption;
import elish.dispensa.service.UsuarioService;

@Controller
@ViewScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private List<Usuario> usuarios;

	@Inject
	private UsuarioService us;
	
	@PostConstruct
	public void init(){
		usuarios = us.buscarTodos();
	}
	
	public void salvar(){
		try {
			us.salvar(usuario);
			usuario = new Usuario();
			usuarios = us.buscarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso",null));
		} catch (ServiceExeption e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel salvar " + e.getMessage(),null));
		}
	}
	
	public void excluir(){
		try {
			us.excluir(usuario);
			usuarios = us.buscarTodos();
			usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluido com sucesso",null));
		} catch (ServiceExeption e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel salvar " + e.getMessage(),null));
		}
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public UsuarioService getUs() {
		return us;
	}

	public void setUs(UsuarioService us) {
		this.us = us;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}

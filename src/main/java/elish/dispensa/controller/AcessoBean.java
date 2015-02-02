package elish.dispensa.controller;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import elish.dispensa.entidades.Usuario;
import elish.dispensa.service.UsuarioService;


@Controller
@ViewScoped
public class AcessoBean {
	
	private Usuario usuarioLogado = new Usuario();
	
	
	@Inject
	private UsuarioService us;
	
	public String logar(){
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(us.autenticar(usuarioLogado).size() > 0){
			HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
			session.setAttribute("usuarioLogado", usuarioLogado);
			return "frmusuario.xhtml?faces-redirect=true";
		} else {
			usuarioLogado = new Usuario();
			return "login.xhtml?faces-redirect=true";
		}
	}

	public String logout(){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
		session.invalidate();
		usuarioLogado = new Usuario();
		return "login.xhtml?faces-redirect=true";
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public UsuarioService getUs() {
		return us;
	}

	public void setUs(UsuarioService us) {
		this.us = us;
	}

}

package elish.dispensa.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;

import elish.dispensa.entidades.Produto;
import elish.dispensa.exceptions.ServiceExeption;
import elish.dispensa.service.ProdutoService;

@Controller
@ViewScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	
	private List<Produto> produtos;
	
	@Inject
	private ProdutoService ps;
	
	
	@PostConstruct
	public void init(){
		produtos = ps.buscarTodos();
	}
	
	public void salvar(){
		try {
			ps.salvar(produto);
			produto = new Produto();
			produtos = ps.buscarTodos();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Salvo com sucesso",null));
		} catch (ServiceExeption e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel salvar " + e.getMessage(),null));
		}
	}
	
	public void excluir(){
		try {
			ps.excluir(produto);
			produtos = ps.buscarTodos();
			produto = new Produto();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Excluido com sucesso",null));
		} catch (ServiceExeption e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possivel salvar " + e.getMessage(),null));
		}
	}


	public Produto getProduto() {
		return produto;
	}


	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public ProdutoService getPs() {
		return ps;
	}


	public void setPs(ProdutoService ps) {
		this.ps = ps;
	}
	
	

}

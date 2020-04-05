package controle;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import util.JpaUtil;

/**
 * 
 * @author Tiago Batista
 *
 *         LoginBean, classe responsavel pela logica de logar no sistema
 *
 */

@ManagedBean(name = "LoginBean")
@RequestScoped
public class LoginBean {

	private String usuarioTXT;
	private String senhaTXT;
	UsuarioDao usuarioDao;
	private String mensagem;

	private static final String PESQUISAR = "pesquisarUsuario.xhtml";

	public LoginBean() {
		this.usuarioDao = new UsuarioDaoImpl(JpaUtil.getEntityManager());

	}

	public void entrar() throws IOException {

		if (this.usuarioTXT.equals("admin") && this.senhaTXT.equals("admin")) {
			FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
		} else {
			if (this.usuarioDao.pesquisar(this.usuarioTXT) != null) {
				if (this.usuarioDao.pesquisar(this.usuarioTXT).getSenha().equals(this.senhaTXT)) {
					FacesContext.getCurrentInstance().getExternalContext().redirect(PESQUISAR);
				} else {
					this.mensagem = " Senha inválida";
				}
			} else {

				this.mensagem = " Usuario inválido";
			}

		}
	}

	public String getUsuarioTXT() {
		return usuarioTXT;
	}

	public void setUsuarioTXT(String usuarioTXT) {
		this.usuarioTXT = usuarioTXT;
	}

	public String getSenhaTXT() {
		return senhaTXT;
	}

	public void setSenhaTXT(String senhaTXT) {
		this.senhaTXT = senhaTXT;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

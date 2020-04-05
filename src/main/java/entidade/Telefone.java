package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tiago Batista
 * 
 * Classe telefone utilizada como referencia o usuário, onde faz um para muitos.
 * Nesta classe tem uma coisa em particular, ela tem um ID, onde o mesmo é autoincrmentado
 * pelo proprio JPA com a estratégia "GenerationType.AUTO"
 *
 */
@Entity
@Table(name = "TELEFONE")
public class Telefone {
	
	@Id
	@Column(name = "id_telefone")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "ddd")
	private int ddd;
	@Column(name = "numero")
	private String numero;
	@Column(name = "tipo")
	private String tipo;
	/**
	 * @ManyToOne essa referencia faz com que, ao recuperar um usuario o mesmo, traz todos os
	 * telefones do usuário, pegando a chave de referencia. email de usuario com email_usuario 
	 * do telefone
	 */
	@ManyToOne
	@JoinColumn(name = "email_usuario", referencedColumnName  = "email",nullable = false)
	private Usuario usuario;

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "(" + ddd + ")"  + numero ;
	}


}

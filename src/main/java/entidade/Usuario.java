package entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tiago Batista
 *	
 * Usuario é a classe principal desse projeto onde tem a tela de pesquisa e a tela de manter
 * Usuario tem uma lista de telefones e tem como chave primaria o email, levando em consideração
 * que a maioria dos sistema tem como login o email.
 *
 */

@Entity
@Table(name="USUARIO")
public class Usuario {

	@Id
	@Column(name="email")
	private String email;
	@Column(name="nome")
	private String nome;
	@Column(name="senha")
	private String senha;
	
	/**
	 * A lista de telefones é carregado de forma automatica pelo proprio jpa, para isso acontecer
	 * tem que realizar o mapeamento com o telefone, lá em telefone tb há a configuração de mapeamento
	 */
	@OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Telefone> telefones;
	
	public Usuario() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	@Override
	public String toString() {
		return nome;
	}

}

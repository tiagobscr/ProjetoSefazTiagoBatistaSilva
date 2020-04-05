import java.util.List;

import org.junit.Test;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import entidade.Usuario;
import util.JpaUtil;

public class FactoryTest {
	
	 UsuarioDao usuarioDao;
	 List<Usuario> usuarios;
	
	@Test
	public void Test() {
		
		usuarioDao = new UsuarioDaoImpl(JpaUtil.getEntityManager());
		usuarios = usuarioDao.listarNome("");
		System.out.println(usuarios);
		
		
		
	}

}

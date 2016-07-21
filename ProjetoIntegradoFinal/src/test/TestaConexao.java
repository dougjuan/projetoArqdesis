package test;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import ConnectionFactory.FabricaConexao;;
public class TestaConexao {

	@Test
	public void testgetConexao() throws ClassNotFoundException {
		try {
			assertNotNull("testa se a conexao nao e nula", FabricaConexao.getConexao());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}

}

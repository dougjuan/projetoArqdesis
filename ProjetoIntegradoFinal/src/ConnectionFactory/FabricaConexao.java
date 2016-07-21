package ConnectionFactory;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;


	public class FabricaConexao {
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		// Obtém conexão com o banco de dados
		public static Connection getConexao() throws SQLException {
			return DriverManager
					.getConnection("jdbc:mysql://localhost/projetoIntegrado?user=alunos&password=alunos");
		}

	}







package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBanco {

	private static Connection con = null;
	private static PreparedStatement preparador;
	private static ResultSet resultado;

	public static Connection getConnection() {		
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "DBOPTN", "oportunidade");
				System.out.println("Conectado com sucesso");
			} catch (SQLException e) {
				System.out.println("Erro ao conectar: " + e.getMessage());
			}
		}
		return con;
	}

	public static void fecharConexao(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("Conexão Fechada");
			} catch (SQLException e) {
				System.err.println("Erro: " + e);
			}
		}
	}

	public static void fecharConexao(Connection con, PreparedStatement preparador) {
		if (preparador != null) {
			try {
				preparador.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			} finally {
				fecharConexao(con);
			}
		}
	}

	public static void fecharConexao(Connection con, PreparedStatement preparador, ResultSet resultado) {
		if (resultado != null) {
			try {
				resultado.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			} finally {
				fecharConexao(con, preparador);
			}
		}
	}
}

package br.com.trabalhoIntegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.trabalhoIntegrado.TO.DispenserTO;
import br.com.trabalhoIntegrado.model.Dispenser;


public class DispenserDAO {

	private Connection connection;
	private PreparedStatement stm;

	public DispenserDAO() throws SQLException {
		connection = new  Conexao().connection();
	}

	public boolean resetarDispencher() {
		try {
			PreparedStatement stmt = connection.prepareStatement("UPDATE Dispenser SET QuantidadeDeNotas = 1000 WHERE nota = 10 or Nota = 20");
			stmt.execute();
			stmt = connection.prepareStatement("UPDATE Dispenser SET QuantidadeDeNotas = 500 WHERE Nota = 50");
			stmt.execute();

			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
		}
	}

	public PreparedStatement recuperarNotas() {
		Connection conn;
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement("SELECT * FROM Dispenser");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return stm;
	}

	public boolean retirarNota(List<Dispenser> listaNota){
		try {

			for (Dispenser dispenser: listaNota) {
					PreparedStatement stmt = connection.prepareStatement("UPDATE dispenser SET QuantidadeDeNotas = ? WHERE Nota = ?");
					stmt.setInt(2, dispenser.getNota());
					stmt.setInt(1, dispenser.getQuantidade());
					stmt.execute();
			}

			connection.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
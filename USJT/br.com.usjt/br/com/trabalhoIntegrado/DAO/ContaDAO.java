package br.com.trabalhoIntegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.trabalhoIntegrado.TO.ContaTO;

public class ContaDAO {
	private PreparedStatement stm;

	public ContaDAO() {
		try {
			stm = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement  selec(int numConta) throws ClassNotFoundException, SQLException {
		Connection conn = new Conexao().connection();	
		try {
			stm = conn.prepareStatement("SELECT * FROM Conta WHERE conta.conta = ?");
			stm.setInt(1, numConta);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stm;
	}


	public String  innerJoin(int numConta) throws ClassNotFoundException, SQLException {
		Connection conn;
		String nome = "";
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement("SELECT nomeCliente from Cliente inner join Conta on Conta.codigoCliente = Cliente.codigoCliente where conta = ?");
			stm.setInt(1, numConta);

			ResultSet rs = stm.executeQuery();
			while (rs.next()){
				nome = rs.getString(1);
			}	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nome;
	}


	public int  selectCodigoCliente(int numConta) throws ClassNotFoundException, SQLException {
		Connection conn;
		int codigoCliente = 0;
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement("SELECT codigoCliente FROM Conta WHERE conta.conta = ?");
			stm.setInt(1, numConta);

			ResultSet rs = stm.executeQuery();
			while (rs.next()){
				codigoCliente = rs.getInt(1);
			}	
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigoCliente;
	}

	public PreparedStatement selectSaldo(int numConta){
		Connection conn;
		try {
			conn = new Conexao().connection();	
			stm = conn.prepareStatement("SELECT saldo FROM Conta WHERE conta.conta = ?");
			stm.setInt(1, numConta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stm;
	}

	public PreparedStatement update(ContaTO to){
		String sqlUpdate = "UPDATE contaTO  SET numConta=? SET saldo=?";
		
		try (Connection conn = new Conexao().connection();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDouble(1, to.getNumConta());
			stm.setInt(2, to.getSaldo());
			stm.execute();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}
}
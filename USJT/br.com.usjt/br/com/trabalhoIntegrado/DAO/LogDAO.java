package br.com.trabalhoIntegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class LogDAO {

	private PreparedStatement stm;

	public LogDAO() {
		try {
			stm = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement selec() throws ClassNotFoundException, SQLException {
		Connection conn;
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement("SELECT * FROM Log"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stm ;
	}

	public PreparedStatement insert(String tipoOperacao, double valor, int conta, int agencia, Date DataOperacao, int codigoMovimento, int codigoCliente) throws ClassNotFoundException, SQLException {
		Connection conn = new Conexao().connection();


		stm = conn.prepareStatement("INSERT INTO Log (codigoDoMovimento, tipoOperacao, valor, Conta, agencia, codigoDoCliente,  dataOperacao) VALUES (?,?,?,?,?,?,?)");
		
		java.sql.Date dataMov = new java.sql.Date(DataOperacao.getTime());

		stm.setInt(1, codigoMovimento);    
		stm.setString(2, tipoOperacao);  
		stm.setDouble(3, valor);
		stm.setInt(4, conta);    
		stm.setInt(5, agencia);    
		stm.setInt(6, codigoCliente);
		stm.setDate(7, dataMov);
		
		return stm ;
	}
}
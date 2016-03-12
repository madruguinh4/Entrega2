package br.com.trabalhoIntegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class DebitoAutomaticoDAO {
	private PreparedStatement stm;

	public DebitoAutomaticoDAO() {
		try {
			// instância a classe ConnectionFactory para poder fazer a conexão com o banco de dados
			stm = null;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PreparedStatement selec(int conta){
		
		Connection conn;
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement( "select * from dedbitoAutomatico WHERE conta = ?");
			stm.setInt(1, conta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return stm;
	}

	public PreparedStatement insert(String tipoDebito, String operadora, int codigoConsumidor, Date dataDebito, Double valorDebito, int numConta) throws ClassNotFoundException, SQLException {
		Connection conn = new Conexao().connection();

		stm = conn.prepareStatement("INSERT INTO dedbitoAutomatico(tipoDebito,operadora,codigoConsumidor,dataDebitol,valorDebito,conta) VALUES(?,?,?,?,?,?)");

		java.sql.Date dataBanco = new java.sql.Date(dataDebito.getTime());

		stm.setString(1, tipoDebito);    
		stm.setString(2, operadora);  
		stm.setInt(3, codigoConsumidor);
		stm.setDate(4, dataBanco);    
		stm.setDouble(5, valorDebito);    
		stm.setInt(6, numConta);
		
		return stm ;
	}
}
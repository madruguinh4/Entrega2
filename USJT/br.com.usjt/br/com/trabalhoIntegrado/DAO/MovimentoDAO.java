package br.com.trabalhoIntegrado.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.trabalhoIntegrado.TO.MovimentoTO;

public class MovimentoDAO {
	
	private PreparedStatement stm;

	public MovimentoDAO() {
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
			stm = conn.prepareStatement( "select * from Movimento WHERE numConta = ?");
			stm.setInt(1, conta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}
	
	public int selecCodigo(int conta){
		int cond = 0;
		String SqlSelect = "select codigoMovimento from Movimento WHERE numConta = ?";
		try (Connection conn = new Conexao().connection();	
				
				PreparedStatement stm = conn.prepareStatement(SqlSelect);) {
			stm.setInt(1, conta);
			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()){
					cond = rs.getInt(1);
				}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e0) {
			System.out.print(e0.getStackTrace());
		}
		return cond;
	}
	
	public PreparedStatement selecBetween(Date DataInicial, Date dataFinal){
		Connection conn;
		try {
			conn = new Conexao().connection();
			stm = conn.prepareStatement( "SELECT * FROM Movimento WHERE dataOperacao BETWEEN ? AND ?");
			stm.setDate(1, new java.sql.Date(DataInicial.getTime()));
			stm.setDate(2, new java.sql.Date(dataFinal.getTime()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stm;
	}

	public PreparedStatement insert(int conta, Date dataMovimento, double valor, int agenciaDestino, int contaDestino, String tipo) throws ClassNotFoundException, SQLException {
		Connection conn = new Conexao().connection();

		stm = conn.prepareStatement("INSERT INTO Movimento(numConta,dataOperacao,valorOperacao,agenciaDestino,contaDestino,tipoMovimento) VALUES(?,?,?,?,?,?)");
		
		java.sql.Date dateMovimento = new java.sql.Date(dataMovimento.getTime());

		
		stm.setInt(1, conta);    
		stm.setDate(2, dateMovimento);  
		stm.setDouble(3, valor);
		stm.setInt(4, agenciaDestino);
		stm.setInt(5, contaDestino);
		stm.setString(6, tipo);
		return stm ;
	}
}

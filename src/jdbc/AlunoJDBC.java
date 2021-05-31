package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;

public class AlunoJDBC {
	
	Connection con;
	String sql;
	PreparedStatement pst;
	
	
	public void salvar(Aluno a) throws IOException {
		
		try {
			Connection con = db.getConexao();
			System.out.println("Conexão realizada com sucesso !");
			
			sql = "INSERT INTO aluno (matricula,nome, sexo, dt_nasc) VALUES ( ?, ?,  ?, ?)";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, a.getId());
			pst.setString(2, a.getNome());
			pst.setString(3, a.getSexo());
			
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(4, dataSql);
			
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno realizado com sucesso!");
			
			db.fechaConexao();
			System.out.println("Conexão fechada com sucesso !");
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
	
	public List<Aluno> listar() throws IOException {
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			
			Connection con = db.getConexao();
			System.out.println("Conexão realizada com sucesso !");
			
			sql = "SELECT * FROM aluno";
			
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
		
			while (rs.next()) {
				Aluno a = new Aluno();
				a.setId(rs.getInt("matricula"));
				a.setNome(rs.getString("nome"));
				a.setSexo(rs.getString("sexo"));
				a.setDt_nasc(rs.getDate("dt_nasc"));
				alunos.add(a);
				System.out.println(a.getId() +" " + a.getNome() +" " +  a.getSexo() +" " +  a.getDt_nasc());
			}
			rs.close();
			pst.close();
			
			db.fechaConexao();
			System.out.println("Conexão fechada com sucesso !");
		}catch(SQLException e){
			System.out.println(e);
		}
		return alunos;
	}
	
	public void apagar(int id) throws IOException{
		try {
			Connection con = db.getConexao();
			System.out.println("Conexão realizada com sucesso !");
			
			sql = "DELETE FROM aluno where matricula = ?";
			
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno excluido com sucesso!");
			
			db.fechaConexao();
			System.out.println("Conexão fechada com sucesso !");
		
	}catch (SQLException e) {
		
		System.out.println(e);
	}
}
	public void alterar(Aluno a) throws IOException {
		
		try {
			Connection con = db.getConexao();
			System.out.println("Conexão realizada com sucesso !");
			
			sql = "UPDATE aluno SET nome= ?, sexo= ?, dt_nasc= ? where matricula = ?";
			
			pst = con.prepareStatement(sql);
			pst.setString(1, a.getNome());
			pst.setString(2, a.getSexo());
			Date dataSql = new Date(a.getDt_nasc().getTime());
			pst.setDate(3, dataSql);
			pst.setInt(4, a.getId());
			
			pst.executeUpdate();
			System.out.println("\nCadastro do aluno alterado com sucesso!");
			
			db.fechaConexao();
			System.out.println("Conexão fechada com sucesso !");
		}
		catch (SQLException e) {
			
			System.out.println(e);
		}
		
	}
}


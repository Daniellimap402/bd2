package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectPg.ConnectDataBase;
import entities.Funcionario;

public class FuncionarioDAO {

	private Connection con;

	public FuncionarioDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario VALUES(?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, funcionario.getId());
			preparator.setString(2, funcionario.getNome());
			preparator.setString(3, funcionario.getCpf());

			preparator.execute();
			preparator.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void deleteFuncionario(Funcionario funcionario) {
		String sql = "DELETE FROM funcionario WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, funcionario.getId());

			preparator.execute();
			preparator.close();
			System.out.println(funcionario.getNome() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateFuncionario(Funcionario funcionario, String collumn) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			if (collumn.toLowerCase().equals("nome")) {
				sql = "UPDATE funcionario SET nome = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setString(1, funcionario.getNome());
			}
			preparator.setInt(2, funcionario.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Funcionario> selectById(Integer id) {
		String sql = "SELECT * FROM funcionario where id = ?";
		List<Funcionario> list = new ArrayList<Funcionario>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, id);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Funcionario eachFuncionario = new Funcionario();
				eachFuncionario.setId(results.getInt("id"));
				eachFuncionario.setNome(results.getString("nome"));
				eachFuncionario.setCpf(results.getString("cpf"));

				list.add(eachFuncionario);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectPg.ConnectDataBase;
import entities.Venda;

public class VendaDAO {

	private Connection con;

	public VendaDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addVenda(Venda venda) {
		String sql = "INSERT INTO venda VALUES(?,?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, venda.getId());
			preparator.setInt(2, venda.getIdFuncionario());
			preparator.setInt(3, venda.getIdCarro());
			preparator.setInt(4, venda.getQuantidade());

			preparator.execute();
			preparator.close();
			System.out.println("Inserção realizada!");

		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void deleteVenda(Venda venda) {
		String sql = "DELETE FROM venda WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, venda.getId());

			preparator.execute();
			preparator.close();
			System.out.println("Venda number: " + venda.getId() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateVenda(Venda venda, String collumn) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			if (collumn.toLowerCase().equals("idfuncionario")) {
				sql = "UPDATE venda SET id_funcionario = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, venda.getIdFuncionario());
			}
			else if (collumn.toLowerCase().equals("idcarro")) {
				sql = "UPDATE venda SET id_carro = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, venda.getIdCarro());
			}
			else if(collumn.toLowerCase().equals("quantidade")) {
				sql = "UPDATE venda SET quantidade = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, venda.getQuantidade());
			}
			preparator.setInt(2, venda.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Venda> selectById(Integer id) {
		String sql = "SELECT * FROM venda where id = ?";
		List<Venda> list = new ArrayList<Venda>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, id);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Venda eachVenda = new Venda();
				eachVenda.setId(results.getInt("id"));
				eachVenda.setIdFuncionario(results.getInt("id_funcionario"));
				eachVenda.setIdCarro(results.getInt("id_carro"));
				eachVenda.setQuantidade(results.getInt("quantidade"));

				list.add(eachVenda);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connectPg.ConnectDataBase;
import entities.Carro;

public class CarroDAO {

	private Connection con;

	public CarroDAO() throws SQLException, ClassNotFoundException {

		con = ConnectDataBase.makeConnection();

	}

	public void addCarro(Carro carro) {
		String sql = "INSERT INTO carro VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, carro.getId());
			preparator.setString(2, carro.getModelo());
			preparator.setString(3, carro.getMarca());
			preparator.setInt(4, carro.getAno());
			preparator.setDouble(5, carro.getPreco());
			preparator.setInt(6, carro.getEstoque());

			preparator.execute();
			preparator.close();
			System.out.println(carro.getModelo() + " was successfully added");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateCarro(Carro carro, String column) {
		String sql = null;

		try {
			PreparedStatement preparator = null;
			if (column.toLowerCase().equals("ano")) {
				sql = "UPDATE carro SET ano = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setInt(1, carro.getAno());
			}
			else if (column.toLowerCase().equals("modelo")) {
				sql = "UPDATE carro SET modelo = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setString(1, carro.getModelo());
			}
			else if (column.toLowerCase().equals("preco")) {
				sql = "UPDATE carro SET preco = ? WHERE id = ?";
				preparator = con.prepareStatement(sql);
				preparator.setDouble(1, carro.getPreco());
			}
			preparator.setInt(2, carro.getId());

			preparator.execute();
			preparator.close();

			System.out.println("Update was successfully");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void deleteCarro(Carro carro) {
		String sql = "DELETE FROM carro WHERE id = ?";
		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, carro.getId());

			preparator.execute();
			preparator.close();
			System.out.println(carro.getModelo() + " was successfully deleted from data base");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public List<Carro> selectById(Integer id) {
		String sql = "SELECT * FROM carro where id = ?";
		List<Carro> list = new ArrayList<Carro>();

		try {
			PreparedStatement preparator = con.prepareStatement(sql);
			preparator.setInt(1, id);
			ResultSet results = preparator.executeQuery();

			while (results.next()) {
				Carro eachCarro = new Carro();
				eachCarro.setId(results.getInt("id"));
				eachCarro.setAno(results.getInt("ano"));
				eachCarro.setEstoque(results.getInt("estoque"));
				eachCarro.setMarca(results.getString("marca"));
				eachCarro.setModelo(results.getString("modelo"));
				eachCarro.setPreco(results.getDouble("preco"));

				list.add(eachCarro);
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}

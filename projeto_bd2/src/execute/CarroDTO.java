package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.CarroDAO;
import entities.Carro;

public class CarroDTO {

	Carro carroTest = new Carro();
	CarroDAO carroDAO = null;
	
	public CarroDTO(Integer id, String modelo, String marca, Integer ano, Double preco, Integer estoque) {
		carroTest.setId(id);
		carroTest.setModelo(modelo);
		carroTest.setMarca(marca);
		carroTest.setAno(ano);
		carroTest.setPreco(preco);
		carroTest.setEstoque(estoque);
	}

	public void addCarro() {

		createCarroDAO();

		carroDAO.addCarro(carroTest);
	}

	private void createCarroDAO() {
		try {
			carroDAO = new CarroDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteCarro() {

		createCarroDAO();

		carroDAO.deleteCarro(carroTest);
	}

	public void listaCarros() {

		createCarroDAO();

		List<Carro> list = carroDAO.selectById(carroTest.getId());
		for (Carro carro : list) {
			System.out.println(carro);
		}
	}
	
	public void updateCarro(String colum) {
		
		createCarroDAO();
		carroDAO.updateCarro(carroTest, colum);
	}

}

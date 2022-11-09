package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.VendaDAO;
import entities.Venda;

public class VendaDTO {

	Venda vendaTest = new Venda();
	VendaDAO vendaDAO = null;

	public VendaDTO(int id, int idFuncionario, int idCarro, int quantidade) {
		vendaTest.setId(id);
		vendaTest.setIdFuncionario(idFuncionario);
		vendaTest.setIdCarro(idCarro);
		vendaTest.setQuantidade(quantidade);
	}

	public void addVenda() {

		createVendaDAO();

		vendaDAO.addVenda(vendaTest);
	}

	public void deleteVenda() {

		createVendaDAO();

		vendaDAO.deleteVenda(vendaTest);
	}

	public void listaVendas() {

		createVendaDAO();

		List<Venda> list = vendaDAO.selectById(vendaTest.getId());
		for (Venda venda : list) {
			System.out.println(venda);
		}
	}

	private void createVendaDAO() {
		try {
			vendaDAO = new VendaDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateVenda(String colum) {
		
		createVendaDAO();
		vendaDAO.updateVenda(vendaTest, colum);
		
	}

}

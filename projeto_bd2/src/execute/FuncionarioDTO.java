package execute;

import java.sql.SQLException;
import java.util.List;

import DAO.FuncionarioDAO;
import entities.Funcionario;

public class FuncionarioDTO {

	Funcionario funcionarioTest = new Funcionario();
	FuncionarioDAO funcionarioDao = null;

	public FuncionarioDTO(int id, String nome, String cpf) {
		funcionarioTest.setId(id);
		funcionarioTest.setNome(nome);
		funcionarioTest.setCpf(cpf);
	}

	public void addFuncionario() {

		criarFuncionarioDao();

		funcionarioDao.addFuncionario(funcionarioTest);
	}

	private void criarFuncionarioDao() {
		try {
			funcionarioDao = new FuncionarioDAO();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void deleteFuncionario() {

		criarFuncionarioDao();

		funcionarioDao.deleteFuncionario(funcionarioTest);
	}

	public void listarFuncionarios() {

		criarFuncionarioDao();

		List<Funcionario> list = funcionarioDao.selectById(funcionarioTest.getId());
		for (Funcionario corretora : list) {
			System.out.println(corretora);
		}
	}
	
	public void updateFuncionario(String collumn) {
		
		criarFuncionarioDao();
		funcionarioDao.updateFuncionario(funcionarioTest, collumn);
		
	}

}

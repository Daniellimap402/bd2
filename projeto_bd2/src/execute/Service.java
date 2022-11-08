package execute;

import java.util.Scanner;

import entities.Funcionario;
import entities.Venda;

public class Service {
	
	private Boolean mostrarFuncionalidades = true;
	
	public void mostrarFuncionalidades() {
		
		while(mostrarFuncionalidades) {
			Scanner s = new Scanner(System.in);
			System.out.println();
			System.out.println("Digite: ");
			System.out.println("1 para adicionar");
			System.out.println("2 para atualizar ");
			System.out.println("3 para deletar ");
			System.out.println("4 para listar ");
			System.out.println("5 para sair ");
			Integer funcao = Integer.parseInt(s.next());
			s = new Scanner(System.in);
			verificarFuncao(funcao);
		}
	}
	
	private void verificarFuncao(Integer funcao) {
		switch (funcao) {
		case 1:
			adicionarElemento();
			break;
		case 2:
			atualizarElemento();
			break;
		case 3:
			deletarElemento();
			break;
		case 4:
			listarElementos();
			break;
			
		default:
			mostrarFuncionalidades = false;
			break;
		}
	}

	private void listarElementos() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para listar Carro");
		System.out.println("2 para listar Funcionario ");
		System.out.println("3 para listar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		listarElemento(elemento);
		
	}

	private void listarElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			listarCarro();
			break;
		case 2:
			listarFuncionario();
			break;
		case 3:
			listarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void listarVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda ");
		Integer id = Integer.parseInt(s.next());
		VendaDTO vendaDTO = new VendaDTO(id, 0, 0);
		vendaDTO.listaVendas();		
	}

	private void listarFuncionario() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do funcionario ");
		Integer id = Integer.parseInt(s.next());
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO(id, null, null);
		funcionarioDTO.listarFuncionarios();
	}

	private void listarCarro() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do carro ");
		Integer id = Integer.parseInt(s.next());
		CarroDTO carroDTO = new CarroDTO(id, null, null, id, null, id);
		carroDTO.listaCarros();
	}

	private void deletarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para deletar Carro");
		System.out.println("2 para deletar Funcionario ");
		System.out.println("3 para deletar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarRemocaoElemento(elemento);
		
	}

	private void verificarRemocaoElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			removerCarro();
			break;
		case 2:
			removerFuncionario();
			break;
		case 3:
			removerVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void removerVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda ");
		Integer id = Integer.parseInt(s.next());
		Venda venda = new Venda();
		venda.setId(id);
		VendaDTO vendaDTO = new VendaDTO(id, 0, 0);
		vendaDTO.deleteVenda();
	}

	private void removerFuncionario() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do funcionario ");
		Integer id = Integer.parseInt(s.next());
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO(id, null, null);
		funcionarioDTO.deleteFuncionario();
	}

	private void removerCarro() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do carro ");
		Integer id = Integer.parseInt(s.next());
		CarroDTO carroDTO = new CarroDTO(id, null, null, null, null, null);
		carroDTO.deleteCarro();
	}

	private void atualizarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para atualizar Carro");
		System.out.println("2 para atualizar Funcionario ");
		System.out.println("3 para atualizar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarEdicaoElemento(elemento);
		
	}

	private void verificarEdicaoElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			atualizarCarro();
			break;
		case 2:
			atualizarFuncionario();
			break;
		case 3:
			atualizarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
		
	}

	private void atualizarVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda: ");
		Integer idVenda = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o id do funcionario: ");
		System.out.println("Digite 2 para editar o id do carro: ");
		Integer edicao = Integer.valueOf(s.next());
		Integer idFuncionario = 0;
		Integer idCarro = 0;
		String coluna = null;	
		switch (edicao) {
		case 1:
			System.out.println("Digite o id do funcionario: ");
			idFuncionario = Integer.parseInt(s.next());
			coluna = "idfuncionario";
			break;
		case 2:
			System.out.println("Digite o id do carro: ");
			idCarro = Integer.parseInt(s.next());
			coluna = "idcarro";
			break;
		default:
			break;
		}
		VendaDTO vendaDTO = new VendaDTO(idVenda, idFuncionario, idCarro);
		vendaDTO.updateVenda(coluna);
	}

	private void atualizarFuncionario() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do funcionario: ");
		Integer id = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o nome do funcionario: ");
		Integer edicao = Integer.valueOf(s.next());
		String nome = null;
		String coluna = null;
		switch (edicao) {
		case 1:
			System.out.println("Digite o nome do funcionario: ");
			nome = s.next();
			coluna = "nome";
			break;
		default:
			break;
		}
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO(id, nome, null);
		funcionarioDTO.updateFuncionario(coluna);
	}

	private void atualizarCarro() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do carro: ");
		Integer id = Integer.parseInt(s.next());
		System.out.println("Digite 1 para editar o modelo do carro: ");
		System.out.println("Digite 2 para editar o ano do carro: ");
		System.out.println("Digite 3 para editar o preco do carro: ");
		Integer edicao = Integer.valueOf(s.next());
		String modelo = null;
		Integer ano = 0;
		Double preco = 0D;
		String coluna = null;	
		switch (edicao) {
		case 1:
			System.out.println("Digite o modelo do carro: ");
			 modelo = s.next();
			coluna = "modelo";
			break;
		case 2:
			System.out.println("Digite o ano do carro: ");
			ano = Integer.parseInt(s.next());
			coluna = "ano";
			break;
		case 3:
			System.out.println("Digite o preco do carro: ");
			preco = Double.parseDouble(s.next());
			coluna = "preco";
			break;
		default:
			break;
		}
		CarroDTO carroDto = new CarroDTO(id, modelo, null, ano, preco, null);
		carroDto.updateCarro(coluna);
	}

	private void adicionarElemento() {
		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Digite: ");
		System.out.println("1 para adicionar Carro ");
		System.out.println("2 para adicionar Funcionario ");
		System.out.println("3 para adicionar Venda ");
		System.out.println("4 para voltar ");
		Integer elemento = Integer.parseInt(s.next());
		verificarElemento(elemento);
	}

	private void verificarElemento(Integer elemento) {
		switch (elemento) {
		case 1:
			adicionarCarro();
			break;
		case 2:
			adicionarFuncionario();
			break;
		case 3:
			adicionarVenda();
			break;			
		default:
			mostrarFuncionalidades();
			break;
		}
	}

	private void adicionarVenda() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id da venda: ");
		Integer id = Integer.parseInt(s.next());
		System.out.println("Digite o id do funcionario: ");
		Integer idFuncionario = Integer.parseInt(s.next());
		System.out.println("Digite o id do carro: ");
		Integer idCarro = Integer.parseInt(s.next());
		VendaDTO vendaDto = new VendaDTO(id, idFuncionario, idCarro);
		vendaDto.addVenda();
	}

	private void adicionarFuncionario() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do funcionario: ");
		Integer id = Integer.parseInt(s.next());
		System.out.println("Digite o nome do funcionario: ");
		String nome = s.next();
		System.out.println("Digite o cpf do funcionario: ");
		String cpf = s.next();
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO(id, nome, cpf);
		funcionarioDTO.addFuncionario();
	}

	private void adicionarCarro() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite o id do carro: ");
		Integer id = Integer.parseInt(s.next());
		System.out.println("Digite o modelo do carro: ");
		String modelo = s.next();
		System.out.println("Digite a marca do carro: ");
		String marca = s.next();
		System.out.println("Digite o ano do carro: ");
		Integer ano = Integer.parseInt(s.next());
		System.out.println("Digite o preco: ");
		Double preco = Double.parseDouble(s.next());
		System.out.println("Digite a quantidade: ");
		Integer estoque = Integer.parseInt(s.next());
		CarroDTO carroDTO = new CarroDTO(id, modelo, marca, ano, preco, estoque);
		carroDTO.addCarro();
	}
}

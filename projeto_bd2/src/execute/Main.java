package execute;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import DAO.CarroDAO;
import DAO.VendaDAO;
import entities.Carro;

public class Main {

	public static void main(String[] args) {
		
		Service service = new Service();		
		service.mostrarFuncionalidades();
	}
	
	

}

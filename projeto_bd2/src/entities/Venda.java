package entities;

public class Venda {

	private int id;
	private int idFuncionario;
	private int idCarro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdFuncionario() {
		return idFuncionario;
	}
	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	public int getIdCarro() {
		return idCarro;
	}
	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	@Override
	public String toString() {
		return "Venda [id=" + id + ", idFuncionario=" + idFuncionario + ", idCarro=" + idCarro + "]";
	}

	

}

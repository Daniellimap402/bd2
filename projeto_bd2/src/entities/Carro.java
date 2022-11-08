package entities;

public class Carro {

	private Integer id;
	private String modelo;
	private String marca;
	private Integer ano;
	private Double preco;
	private Integer estoque;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
	
	@Override
	public String toString() {
		return "Carro [id=" + id + ", modelo=" + modelo + ", marca=" + marca + ", ano=" + ano + ", preco=" + preco
				+ ", estoque=" + estoque + "]";
	}
	
}

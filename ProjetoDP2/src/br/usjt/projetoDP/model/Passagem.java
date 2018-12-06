package br.usjt.projetoDP.model;

public class Passagem {
	
	private long id;
	int fileiras;
	char poltrona;
	String formaPagamento;
	int parcelasPagamento;
	Voo voo;
	Cliente cliente;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getFileiras() {
		return fileiras;
	}
	
	public void setFileiras(int fileiras) {
		this.fileiras = fileiras;
	}
	
	public char getPoltrona() {
		return poltrona;
	}
	
	public void setPoltrona(char poltrona) {
		this.poltrona = poltrona;
	}
	
	public String getFormaPagamento() {
		return formaPagamento;
	}
	
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	public int getParcelasPagamento() {
		return parcelasPagamento;
	}
	
	public void setParcelasPagamento(int parcelasPagamento) {
		this.parcelasPagamento = parcelasPagamento;
	}
	
	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}	
}

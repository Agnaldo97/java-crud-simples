package br.usjt.projetoDP.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class Voo {
	
	private long id;
	int numero;
	int fileiras;
	int poltronasPorFileira;
	double precoTrecho;
	String origem;
	String destino;
	Date dataPartida;
	Time horaPartida;
	Date dataChegadaPrevista;
	Time horaChegadaPrevista;
	ArrayList<Passagem> passagem;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getFileiras() {
		return fileiras;
	}
	
	public void setFileiras(int fileiras) {
		this.fileiras = fileiras;
	}
	
	public int getPoltronasPorFileira() {
		return poltronasPorFileira;
	}
	
	public void setPoltronasPorFileira(int poltronasPorFileira) {
		this.poltronasPorFileira = poltronasPorFileira;
	}
	
	public double getPrecoTrecho() {
		return precoTrecho;
	}
	
	public void setPrecoTrecho(double precoTrecho) {
		this.precoTrecho = precoTrecho;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public Date getDataPartida() {
		return dataPartida;
	}
	
	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}
	
	public Time getHoraPartida() {
		return horaPartida;
	}
	
	public void setHoraPartida(Time horaPartida) {
		this.horaPartida = horaPartida;
	}
	
	public Date getDataChegadaPrevista() {
		return dataChegadaPrevista;
	}
	
	public void setDataChegadaPrevista(Date dataChegadaPrevista) {
		this.dataChegadaPrevista = dataChegadaPrevista;
	}
	
	public Time getHoraChegadaPrevista() {
		return horaChegadaPrevista;
	}
	
	public void setHoraChegadaPrevista(Time horaChegadaPrevista) {
		this.horaChegadaPrevista = horaChegadaPrevista;
	}
	
	public ArrayList<Passagem> getPassagem() {
		return passagem;
	}
	
	public void setPassagem(ArrayList<Passagem> passagem) {
		this.passagem = passagem;
	}
}

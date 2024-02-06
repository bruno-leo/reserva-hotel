package dominio;

public class Hotel {

	private String nome;
	private int estrelas;
	private double tarifaSemanaNormal;
	private double tarifaFDSNormal;
	private double tarifaSemanaVip;
	private double tarifaFDSVip;
	
	public Hotel() {}
	
	public Hotel(String nome, int estrelas, double semanaNormal, double semanaVip, double fdsNormal, double fdsVip) {
		this.nome = nome;
		this.estrelas = estrelas;
		this.tarifaSemanaNormal = semanaNormal;
		this.tarifaFDSNormal = fdsNormal;
		this.tarifaSemanaVip = semanaNormal;
		this.tarifaFDSVip = fdsVip;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEstrelas() {
		return estrelas;
	}
	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}
	public double getTarifaSemanaNormal() {
		return tarifaSemanaNormal;
	}
	public void setTarifaSemanaNormal(double tarifaSemanaNormal) {
		this.tarifaSemanaNormal = tarifaSemanaNormal;
	}
	public double getTarifaFDSNormal() {
		return tarifaFDSNormal;
	}
	public void setTarifaFDSNormal(double tarifaFDSNormal) {
		this.tarifaFDSNormal = tarifaFDSNormal;
	}
	public double getTarifaSemanaVip() {
		return tarifaSemanaVip;
	}
	public void setTarifaSemanaVip(double tarifaSemanaVip) {
		this.tarifaSemanaVip = tarifaSemanaVip;
	}
	public double getTarifaFDSVip() {
		return tarifaFDSVip;
	}
	public void setTarifaFDSVip(double tarifaFDSVip) {
		this.tarifaFDSVip = tarifaFDSVip;
	}
	
}

package utils;

public enum TipoCliente {

	REGULAR("REGULAR"), VIP("VIP");
	
	private String tipo;
	
	TipoCliente(String tipo) {
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
}

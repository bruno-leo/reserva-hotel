package repositorio;

import dominio.Hotel;

public class HotelRepositorio {

	private static int tamanhoCache = 10;
	private Hotel[] hoteis = new Hotel[tamanhoCache];
	private int index;
	
	public HotelRepositorio() {}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void setHoteis(int indice, Hotel hotel) {
		this.hoteis[indice] = hotel;
	}
	
	public void inserir(Hotel hotel) {
		int indice = getIndex();
		
		setHoteis(indice, hotel);
		
		indice++;
		
		setIndex(indice);
	}
	
	public void procurarHotelMaisBarato(String tipoUsuario, int diaSemana, int fds) {
		String hotelMaisBarato = null;
		double valorHotel = 1000.0;
		double soma;
		int estrelaHotel = 0;
		int estrela;
		int count = 0;
		
		do {
			if (hoteis[count] != null) {
				if (tipoUsuario.toLowerCase().equals("regular")) {
					double valorSemana = hoteis[count].getTarifaSemanaNormal() * diaSemana;
					double valorFds = hoteis[count].getTarifaFDSNormal() * fds;
					
					soma = valorSemana + valorFds;
					estrela = hoteis[count].getEstrelas();
					
				}
				else if (tipoUsuario.toLowerCase().equals("vip")) {
					double valorSemana = hoteis[count].getTarifaSemanaVip() * diaSemana;
					double valorFds = hoteis[count].getTarifaFDSVip() * fds;
					
					soma = valorSemana + valorFds;
					estrela = hoteis[count].getEstrelas();	
				}
				else {
					System.out.println("Tipo de Usuário desconhecido!");
					break;
				}
				
				if ((soma < valorHotel) && (estrela > estrelaHotel)) {
					valorHotel = soma;
					estrelaHotel = estrela;
					hotelMaisBarato = hoteis[count].getNome();
				}
				
			}
			
			count++;
			
		} while (hoteis[count] != null);
		
		System.out.println(hotelMaisBarato);
		System.out.println(valorHotel);
		System.out.println(estrelaHotel);
	}
	
	
}

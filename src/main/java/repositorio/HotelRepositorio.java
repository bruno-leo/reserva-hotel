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
	
	public int procurarIndex(String nome) {
		int position = 0;
		
		for (Hotel hotel : hoteis) {
			try {
				if (hotel.getNome().toLowerCase().contains(nome.toLowerCase())) {
					break;
				}
				
				position++;
			} catch (Exception e) {
				position = -1;
				break;
			}
		}
		
		return position;
	}
	
	public void procurar(String nome) {
		int position = procurarIndex(nome);
		
		if (position != -1) {
			Hotel hotel = hoteis[position];
			System.out.println(hotel.getNome());
			System.out.println(hotel.getEstrelas() + " estrelas");
		}
		else {
			System.out.println("Hotel não encontrado");
		}
	}
	
	
}

import java.util.Scanner;
import dominio.Hotel;
import repositorio.HotelRepositorio;
import utils.TipoCliente;
import utils.Utilitarios;

public class Principal {

	public static void main(String[] args) {
		System.out.println("Desafio técnico hotel");
//		System.out.print("Nome do cliente: ");
//		Scanner scnr = new Scanner(System.in);
//		String nomeCliente;
//		nomeCliente = scnr.nextLine();
//		scnr.close();

		calcularMelhorHotel();
	}

	public static void calcularMelhorHotel() {
		Hotel palm = new Hotel("Palm Plaza Resor", 3, 110.0, 90.0, 80.0, 80.0);
		Hotel elegance = new Hotel("Elegance Haven Hotel", 4, 160.0, 60.0, 110.0, 50.0);
		Hotel azure = new Hotel("Azure Horizon Retreat", 5, 220.0, 150.0, 100.0, 40.0);
		
		HotelRepositorio hr = new HotelRepositorio();
		hr.inserir(palm);
		hr.inserir(elegance);
		hr.inserir(azure);

		System.out.print("Datas de entrada: ");
		Scanner scnr = new Scanner(System.in);
		String arrayDatas = scnr.nextLine();
		scnr.close();

		String tipoCliente = Utilitarios.tipoUsuario(arrayDatas);
		System.out.println(tipoCliente);

		String[] datas = Utilitarios.datasReservas(arrayDatas);
		int qtdDiasUteis = 0;
		int qtdDiasNaoUteis = 0;

		for (String dt : datas) {
			String dtFormat = Utilitarios.formatarData(dt);
			if (Utilitarios.isFds(dtFormat)) {
				qtdDiasNaoUteis++;
			} else {
				qtdDiasUteis++;
			}
		}
		
		double tarifaPalm = calcularTarifa(tipoCliente, qtdDiasUteis, qtdDiasNaoUteis, palm);
		double tarifaElegance = calcularTarifa(tipoCliente, qtdDiasUteis, qtdDiasNaoUteis, elegance);
		double tarifaAzure = calcularTarifa(tipoCliente, qtdDiasUteis, qtdDiasNaoUteis, azure);
		
		double menorTarifa = Math.min(tarifaPalm, tarifaElegance);
		menorTarifa = Math.min(menorTarifa, tarifaAzure);
		
		System.out.println(menorTarifa);
	}
	
	public static double calcularTarifa(String tipo, int diasSemana, int diasFimDeSemana, Hotel hotel) {
		double total = 0;
		
		if (TipoCliente.REGULAR.getTipo().equals(tipo.toUpperCase())) {
			total = (diasSemana * hotel.getTarifaSemanaNormal()) + (diasFimDeSemana * hotel.getTarifaFDSNormal());
		}
		else if (TipoCliente.VIP.getTipo().equals(tipo.toUpperCase())) {
			total = (diasSemana * hotel.getTarifaSemanaVip()) + (diasFimDeSemana * hotel.getTarifaFDSVip());
		}
		
		return total;
	}

}


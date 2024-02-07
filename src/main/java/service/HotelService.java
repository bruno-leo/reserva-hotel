package service;

import java.util.Scanner;

import dominio.Hotel;
import repositorio.HotelRepositorio;
import utils.Utilitarios;

public class HotelService {

	public static void calcularMelhorHotel() {
		Hotel palm = new Hotel("Palm Plaza Resor", 3, 110.0, 80.0, 90.0, 80.0);
		Hotel elegance = new Hotel("Elegance Haven Hotel", 4, 160.0, 110.0, 60.0, 50.0);
		Hotel azure = new Hotel("Azure Horizon Retreat", 5, 220.0, 100.0, 150.0, 40.0);
		
		HotelRepositorio hr = new HotelRepositorio();
		hr.inserir(palm);
		hr.inserir(elegance);
		hr.inserir(azure);

		System.out.print("Datas de entrada: ");
		Scanner scnr = new Scanner(System.in);
		String arrayDatas = scnr.nextLine();
		scnr.close();

		String tipoCliente = Utilitarios.tipoUsuario(arrayDatas);

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
		
		hr.procurarHotelMaisBarato(tipoCliente, qtdDiasUteis, qtdDiasNaoUteis);
	}
}

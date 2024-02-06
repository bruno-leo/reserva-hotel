package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Utilitarios {

	public static String tipoUsuario(String data) {
		int index = data.indexOf(":");
		
		String tipoUsuario = data.substring(0, (index));
		
		return tipoUsuario;
	}
	
	public static String[] datasReservas(String data) {
		String[] input = data.split(":");
		
		String[] datas = input[1].split(",");
		
		return datas;
	}
	
	public static String formatarData(String data) {
		int index = data.indexOf("(");
		
		String datas = data.substring(0, (index)).trim();
		
		String dataFormatada = datas.substring(0,2) + "-" + datas.substring(2, 5) + "-" + datas.substring(5, 9);
		
		return dataFormatada;
	}
	
	public static boolean isFds(String dataFormatada) {
		boolean isFds = true;
		
		try {
			Calendar data = Calendar.getInstance();
			
			SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
			
			data.setTime(formato.parse(dataFormatada));
			
			if((data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) 
					|| (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				isFds = true;
			}
			else {
				isFds = false;
			}
		}
		catch(ParseException e ) {
			System.out.println(e);
		}
		
		return isFds;
	}
	
	
}

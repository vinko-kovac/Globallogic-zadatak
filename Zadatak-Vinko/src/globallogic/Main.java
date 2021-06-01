package globallogic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		
		Set<Character> logic = new HashSet<>();
		logic.add('l');
		logic.add('o');
		logic.add('g');
		logic.add('i');
		logic.add('c');
		
		int ukupnoSlova = 0;
		double ukupnoOdabranihSlova = 0;
		
		List<Rijec> listaRijeci = new ArrayList<>();
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter your sentence: ");
			String line = sc.nextLine();
			String recenica = line.trim();
			recenica = recenica.toLowerCase();
			String[] rijeci = recenica.split(" ");
			
			for (String r: rijeci) {
				
				int brojacOdabranih = 0;
				int brojacUkupno = 0;
				List<Character> listaSlova = new ArrayList<>();
				
				for (int i = 0; i < r.length(); i++) {
					Character znak = r.charAt(i);
					if (znak >= 'a' && znak <= 'z') {
						ukupnoSlova++;
						brojacUkupno++;
						if (logic.contains(znak)) {
							ukupnoOdabranihSlova++;
							brojacOdabranih++;
							if (!listaSlova.contains(znak)) {
								listaSlova.add(znak);
							}
						}
					}
				}
				
				if (brojacOdabranih != 0) {
					Rijec rijec = new Rijec(brojacUkupno, brojacOdabranih, listaSlova);
					listaRijeci.add(rijec);
				}
				
				
			}
			
			listaRijeci.sort(new Comparator<Rijec>() {
				
				@Override
				public int compare(Rijec r1, Rijec r2) {
					return Integer.compare(r1.getOdabranaSlova(), r2.getOdabranaSlova());
				}
				
			});
			
			double ukupnaFrekvencija = ukupnoOdabranihSlova/ukupnoSlova;
			
			for (Rijec rij: listaRijeci) {
				double frekvencija = rij.getOdabranaSlova()/ukupnoOdabranihSlova;
				System.out.print("{" + rij.getLista() + "," + rij.getSlova() + "} = ");
				System.out.printf("%.2f (%d/%.0f)\n", frekvencija, rij.getOdabranaSlova(), ukupnoOdabranihSlova);
			}
			
			System.out.printf("TOTAL Frequency: %.2f (%.0f/%d) \n", ukupnaFrekvencija, ukupnoOdabranihSlova, ukupnoSlova);
		}

	}

}

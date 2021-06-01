package globallogic;

import java.util.List;

public class Rijec {
	
	private int slova;
	private int odabranaSlova;
	private List<Character> lista;
	
	public Rijec (int slova, int odabranaSlova, List<Character> lista) {
		this.slova = slova;
		this.odabranaSlova = odabranaSlova;
		this.lista = lista;
	}
	
	public int getOdabranaSlova() {
		return this.odabranaSlova;
	}
	
	public int getSlova() {
		return this.slova;
	}
	
	public List<Character> getLista() {
		return this.lista;
	}

}

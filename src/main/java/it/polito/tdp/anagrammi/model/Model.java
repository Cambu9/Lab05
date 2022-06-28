package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	private List<String> lista;
	private AnagrammaDAO anagrammaDao;
	
	public AnagrammaDAO getAnagrammaDao() {
		return anagrammaDao;
	}

	public void setAnagrammaDao(AnagrammaDAO anagrammaDao) {
		this.anagrammaDao = anagrammaDao;
	}

	public List<String> getLista() {
		return lista;
	}

	public void setLista(List<String> lista) {
		this.lista = lista;
	}

	public List<String> anagramma(String s) {
		this.lista = new ArrayList<String>();
		anagramma_ricorsiva("",0,s);
		return lista;
	}
	
	private void anagramma_ricorsiva(String parziale, int l, String rimanenti) {

		if(rimanenti.length() == 0) {
			System.out.println(parziale);
			this.lista.add(parziale);
		} else { //caso normale
			for (int pos=0; pos < rimanenti.length(); pos++) {
				String nuova_parziale = parziale + rimanenti.charAt(pos);
				String nuova_rimanenti = rimanenti.substring(0, pos) + rimanenti.substring(pos + 1);
				anagramma_ricorsiva(nuova_parziale, l+1, nuova_rimanenti);
				
			}
		}
		
		
	}
	
	public boolean getTutteLeParole(String parola) {
		return anagrammaDao.getTutteParole(parola);
	}
}

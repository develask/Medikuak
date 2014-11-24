package KONTROLADOREA;

import java.util.ArrayList;
import java.util.Date;

import MODEL.Medikua;
import MODEL.Zita;

public class MedikuLista {
	private ArrayList<Medikua> lista;
	
	public MedikuLista(){
		this.lista=new ArrayList<Medikua>();
	}
	public void addMedikua(Medikua m){
		this.lista.add(m);
	}

	public Medikua medikuaBilatu(int id) {
		for (Medikua medikua : lista) if (medikua.getId() == id) return medikua;
		return null;
	}

	public Zita getZita(Medikua m, Date d) {
		return m.getZita(d);
	}

	public Medikua zitaLibreaDuenMedikuaBilatu(Date noiz) {
		for (Medikua medikua : lista) {
			if (medikua.zitaLibreaDu(noiz)) return medikua;
		}
		return null;
	}

	public void zitaEsleitu(Medikua m2, Zita z) {
		m2.zitaEsleitu(z);
	}

	public void zitaKendu(Medikua m, Zita z) {
		m.zitaKendu(z);
	}
}

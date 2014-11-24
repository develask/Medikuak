package KONTROLADOREA;

import java.util.Date;

import MODEL.Medikua;
import MODEL.Zita;


public class Kontroladorea {
	private static Kontroladorea nireInstantzia;
	private MedikuLista medikuLista;
	
	@SuppressWarnings("deprecation")
	private Kontroladorea() {
		medikuLista = new MedikuLista();
		Medikua m = new Medikua(0);
		m.zitaEsleitu(new Zita(new Date(2014, 11, 22)));
		m.zitaEsleitu(new Zita(new Date(2014, 11, 27)));
		m.zitaEsleitu(new Zita(new Date(2014, 12, 12)));
		this.medikuLista.addMedikua(m);
		m = new Medikua(1);
		m.zitaEsleitu(new Zita(new Date(2014, 11, 22)));
		m.zitaEsleitu(new Zita(new Date(2014, 11, 26)));
		m.zitaEsleitu(new Zita(new Date(2014, 12, 12)));
		this.medikuLista.addMedikua(m);
		m = new Medikua(2);
		m.zitaEsleitu(new Zita(new Date(2014, 11, 22)));
		m.zitaEsleitu(new Zita(new Date(2014, 11, 26)));
		m.zitaEsleitu(new Zita(new Date(2014, 12, 11)));
		this.medikuLista.addMedikua(m);
	}
	
	public static Kontroladorea getInstantzia(){
		if (Kontroladorea.nireInstantzia == null) Kontroladorea.nireInstantzia = new Kontroladorea();
		return Kontroladorea.nireInstantzia;
	}
	/**
	 * Mediku baten id-a eta medikuak dituen ziten arteko egun bat jarriz, mediku hori zita kendu eta beste bati esleitzen zaiatuko da.
	 * @param id Medikuaren ID-a
	 * @param noiz zita noiz den
	 * @return Esleitutako medikuaren id
	 * @throws Exception Lortzen ez badu
	 */
	public int medikuarenZitakEzeztatu(int id, Date noiz) throws Exception {
		Medikua m = medikuLista.medikuaBilatu(id);
		Zita z = medikuLista.getZita(m, noiz);
		if (z==null) throw new Exception();
		Medikua m2 = medikuLista.zitaLibreaDuenMedikuaBilatu(noiz);
		medikuLista.zitaEsleitu(m2, z);
		medikuLista.zitaKendu(m,z);
		return m2.getId();
	}
	
}

package MODEL;

import java.util.ArrayList;
import java.util.Date;

public class Medikua {
	private int id;
	private ArrayList<Zita> zitak;
	
	public Medikua(int id){
		this.id = id;
		this.zitak = new ArrayList<Zita>();
	}

	public int getId() {
		return id;
	}

	public Zita getZita(Date d) {
		for (Zita zita : zitak) if (zita.getData().equals(d)) return zita;
		return null;
	}

	public boolean zitaLibreaDu(Date noiz) {
		for (Zita zita : zitak) if (zita.getData().equals(noiz)) return false;
		return true;
	}

	public void zitaEsleitu(Zita z) {
		zitak.add(z);
	}

	public void zitaKendu(Zita z) {
		this.zitak.remove(z);
	}
}

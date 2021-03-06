package menjacnica;

import java.util.LinkedList;

public class Menjacnica {
	LinkedList<Kurs> kursevi;

	public Menjacnica(LinkedList<Kurs> kursevi) {
			this.kursevi = kursevi;
	}
	
	public Menjacnica(){
		kursevi = new LinkedList<>();
	}
	
	public void dodajKurs(Kurs kurs) {
		kursevi.add(kurs);
	}

	public void izbrisiKurs(Kurs kurs) {
		kursevi.remove(kurs);
	}
	
	public LinkedList<Kurs> vratiKurseve() {
		return (LinkedList<Kurs>) kursevi;
	}
}

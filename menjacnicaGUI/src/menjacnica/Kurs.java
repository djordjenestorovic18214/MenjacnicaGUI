package menjacnica;

public class Kurs {
	private int sifra;
	private String skraceniNaziv;
	private double prodajniKurs;
	private double srednjiKurs;
	private double kupovniiKurs;
	private String naziv;
	
	public Kurs(int sifra, String skraceniNaziv, double prodajniKurs, double srednjiKurs, double kupovniiKurs,
			String naziv) {
		super();
		this.sifra = sifra;
		this.skraceniNaziv = skraceniNaziv;
		this.prodajniKurs = prodajniKurs;
		this.srednjiKurs = srednjiKurs;
		this.kupovniiKurs = kupovniiKurs;
		this.naziv = naziv;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}

	public void setSkraceniNaziv(String skraceniNaziv) {
		if(skraceniNaziv == null || skraceniNaziv.isEmpty())
			throw new RuntimeException("Unesite skraceni naziv kursa.");
		this.skraceniNaziv = skraceniNaziv;
	}

	public double getProdajniKurs() {
		return prodajniKurs;
	}

	public void setProdajniKurs(double prodajniKurs) {
		if(prodajniKurs <= 0)
			throw new RuntimeException("Prodajni kurs mora biti veci od 0.");
		this.prodajniKurs = prodajniKurs;
	}

	public double getSrednjiKurs() {
		return srednjiKurs;
	}

	public void setSrednjiKurs(double srednjiKurs) {
		if(srednjiKurs <= 0)
			throw new RuntimeException("Srednji kurs mora biti veci od 0.");
		this.srednjiKurs = srednjiKurs;
	}

	public double getKupovniiKurs() {
		return kupovniiKurs;
	}

	public void setKupovniiKurs(double kupovniiKurs) {
		if(kupovniiKurs <= 0)
			throw new RuntimeException("Kupovni kurs mora biti veci od 0.");
		this.kupovniiKurs = kupovniiKurs;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if(naziv == null || naziv.isEmpty())
			throw new RuntimeException("Unesite naziv kursa.");
		this.naziv = naziv;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (Double.doubleToLongBits(kupovniiKurs) != Double.doubleToLongBits(other.kupovniiKurs))
			return false;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		if (Double.doubleToLongBits(prodajniKurs) != Double.doubleToLongBits(other.prodajniKurs))
			return false;
		if (sifra != other.sifra)
			return false;
		if (skraceniNaziv == null) {
			if (other.skraceniNaziv != null)
				return false;
		} else if (!skraceniNaziv.equals(other.skraceniNaziv))
			return false;
		if (Double.doubleToLongBits(srednjiKurs) != Double.doubleToLongBits(other.srednjiKurs))
			return false;
		return true;
	}
	
	
	
}

package be.vdab.entities;
import java.math.BigDecimal;

public class Pizza {

	private long id;
	private String naam;
	private BigDecimal prijs;
	private boolean pikant;
	
	public long getId() {
		return id;
	}
	public String getNaam() {
		return naam;
	}
	public BigDecimal getPrijs() {
		return prijs;
	}
	public boolean isPikant() {
		return pikant;
	}
	
	public Pizza (String naam, BigDecimal prijs, boolean pikant) {
		setNaam(naam);
		setPrijs(prijs);
		setPikant(pikant);
	}
	
	public Pizza (long id, String naam, BigDecimal prijs, boolean pikant) {
		this(naam, prijs, pikant);
		setId(id);
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setPikant (boolean pikant) {
		this.pikant = pikant;
	}
	
	public void setNaam (String naam) {
		if (!isNaamValid(naam)) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}
	
	public static boolean isNaamValid(String naam) {
		// TODO Naam v/e pizza mag niet null zijn, en geen lege string
		return naam != null && !naam.isEmpty();
	}
	
	public void setPrijs (BigDecimal prijs) {
		if (!isPrijsValid(prijs)) {
			throw new IllegalArgumentException();
		}
		this.prijs = prijs;
	}
	
	public static boolean isPrijsValid (BigDecimal prijs) {
		// BigDecimal prijs mag niet null zijn, en moet >= 0 zijn
		return prijs != null && prijs.compareTo(BigDecimal.ZERO) >= 0;
	}
	
}

package be.vdab.entities;
import java.util.Calendar;

public class Begroeting {
	@Override
	public String toString() {
		int uur = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return uur >= 6 && uur < 12 ? "Goede morgen" : 
			uur >= 12 && uur < 14 ? "Goede voormiddag" : 
				uur >= 14 && uur < 18 ? "Goede namiddag" : "Goede avond";
	}

}

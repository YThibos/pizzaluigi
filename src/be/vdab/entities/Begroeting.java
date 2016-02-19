package be.vdab.entities;
import java.time.LocalTime;


public class Begroeting {
	@Override
	public String toString() {
		
		int uur = LocalTime.now().getHour();
		return uur >= 6 && uur < 12 ? "Goede morgen" : 
			uur >= 12 && uur < 14 ? "Goede voormiddag" : 
				uur >= 14 && uur < 18 ? "Goede namiddag" : "Goede avond";
				
		
	}

}

import java.util.Date;

public class ClickSpeedMeter {
	private int numOfClicks;
	private Date dateOfFirstClick;
	private Date dateOfLastClick;
	
	public ClickSpeedMeter() {
		numOfClicks = 0;
	}
	
	public int getNumOfClicks() {
		return numOfClicks;
	}
	
	public void countClick() {
		if (numOfClicks == 0) {
			dateOfFirstClick = new Date();
		}
		
		numOfClicks++;
		
		dateOfLastClick = new Date();
	}
	
	// returns zero if no click was counted so far
	public double calculateNumOfClicksPerSecond() {
		if (dateOfFirstClick == null || numOfClicks < 2) {
			return 0.0;
		}
		
		long millis_bygone = dateOfLastClick.getTime() - dateOfFirstClick.getTime();
		double clickPerMilli = numOfClicks / (double) (millis_bygone);
		return clickPerMilli * 1000;
	}
	
	public double calculateSecondsBygone() {
		if (dateOfFirstClick == null || dateOfLastClick == null) {
			return 0;
		}
		return (dateOfLastClick.getTime() - dateOfFirstClick.getTime()) / 1000.0;
	}
}
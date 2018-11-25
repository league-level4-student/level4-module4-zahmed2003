package _04_hospital;

public class Patient {
	
	boolean care = false;

	public void checkPulse() {
		care = true;
		
	}

	public boolean feelsCaredFor() {
		return care;
	}
	
	

}

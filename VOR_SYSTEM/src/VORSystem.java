
public class VORSystem {

	private int currentRadial, destinationRadial, deflection;
	private boolean toward;
	String signal;
	
	public VORSystem(OBS plane, int intercept) {
		destinationRadial = plane.getHeading();
		toward = plane.getDirection();
		currentRadial = intercept;
	}
	public void deflectionCalc(){
		deflection = currentRadial - destinationRadial;
		if(Math.abs(deflection)==90){
			signal="BAD";
		}
		else{
			signal = "GOOD";
		}
	}
	
}

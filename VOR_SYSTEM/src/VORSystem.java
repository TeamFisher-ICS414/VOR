
public class VORSystem {

	private int currentRadial, destinationRadial, difference, deflection;
	private boolean toward;
	String direction, turn;
	
	public VORSystem(OBS plane, int intercept) {
		destinationRadial = plane.getHeading();
		toward = plane.getDirection();
		currentRadial = intercept;
	}
	public boolean signalValidate(){
		boolean signal;
		if(currentRadial<0){
			signal =  false;
		}else{
			signal = true;
		}
		return signal;
	}
	public boolean deflectionCalc(){
		boolean signal;

		difference = currentRadial - destinationRadial;
		
		if(difference > 180){
			deflection = difference - 360;
		}else if (difference<-181){
			deflection = 360 + difference;
		}else{
			deflection = difference;
		}
		
		if(deflection < 0){
			turn = "LEFT";
		}else{
			turn = "RIGHT";
		}
		
		if(Math.abs(deflection)<=91 && Math.abs(deflection)>=89){
			signal = false;
		}else{
			signal = true;
		}
		
		return signal;
	}
	public void planeDirection(){
		if(toward == true){
			direction = "TO";
		}else{
			direction = "FROM";
		}
	}
	public void output(){
		if(deflectionCalc() == true && signalValidate()==true){
			planeDirection();
			System.out.println("Signals is: GOOD"+"\nTurn "+Math.abs(deflection)+" degrees "+turn
					+"\nHeading "+direction+" the station");
		}else{
			System.out.println("Signal is: BAD");
		}
	}
}


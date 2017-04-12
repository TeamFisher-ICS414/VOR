public class VORSystem {

	private int currentRadial, destinationRadial, difference, deflection;
	private boolean toward, goodSignal;
	String direction, turn, dots;
	
	public VORSystem(int destination, int incomingSignal) {
		destinationRadial = destination;	
		currentRadial = incomingSignal;
		/*
		 * Testing conditionals in a constructor is difficult!
		 * 
		 * if (incomingSignal > 0) {
			goodSignal = true;
			currentRadial = incomingSignal;
		} else {
			goodSignal = false;
			currentRadial = (-1)*incomingSignal;
		}
		if (currentRadial == 360) {
			
			currentRadial = 0;
		}*/
	}
	
	public boolean signalValidate(){
		boolean signalTest;
		if(currentRadial<0){
			signalTest =  false;
		}else{
			signalTest = true;
		}
		return signalTest;
	}
	public void zero360(){
		if(currentRadial == 360){
			currentRadial = 0;
		}
	}
	
	
	public void deflectionCalc() {
		if(signalValidate()){
			zero360();
			goodSignal = true;
			difference = currentRadial - destinationRadial;
			
			//Bill to Lambert - really love this chunk of code!
			if(difference > 180){
				deflection = difference - 360;
			}else if (difference<-181){
				deflection = 360 + difference;
			}else{
				deflection = difference;
			}
			
			if(deflection < 0){
				turn = "LEFT";
			}else if (deflection == 0){
				turn = "CENTERED";
			}else if (Math.abs(deflection) == 180){
				turn = "CENTERED";
				toward=true;
			}else {
				turn = "RIGHT";
			}
			
			if(Math.abs(deflection)<=91 && Math.abs(deflection)>=89){
				goodSignal = false;
			}
			
			if(Math.abs(deflection)>=91 || toward) {
				direction = "TO";
			}else {
				direction = "FROM";
			}
			
			if(Math.abs(deflection)>=10) {
				dots = "FULL";
			}else if (Math.abs(deflection)>=8) {
				dots = "4 dots";
			}else if (Math.abs(deflection)>=6) {
				dots = "3 dots";
			}else if (Math.abs(deflection)>=4) {
				dots = "2 dots";
			}else if (Math.abs(deflection)>=2) {
				dots = "1 dot";
			}else {
				dots = "0 dots";
			}
		}else{
			goodSignal = false;
		}
		
	}
	
	public void output(){
		deflectionCalc();
		if(goodSignal == true){
			System.out.println("Signals is: GOOD"+"\nNeedle "+turn+" "+dots
					+"\n"+direction+" indicator lit");
		}else{
			System.out.println("Signal is: BAD");
		}
	}
}


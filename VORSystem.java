public class VORSystem {

	public int currentRadial, destinationRadial, difference, deflection;
	public boolean toward, goodSignal;
	public String direction, turn, dots;
	
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
			//zero360();
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
			if(Math.abs(deflection)<=91 && Math.abs(deflection)>=89){
				goodSignal = false;
			}
		}else{
			goodSignal = false;
		}
		
	}
	
	public void direction(){
		if (deflection == 0){
			turn = "CENTERED";
		}else if (Math.abs(deflection) == 180){
			turn = "CENTERED";
			toward=true;
		}else if(deflection < 0){
			turn = "LEFT";
		}else {
			turn = "RIGHT";
		}
	}
	
	public void toFrom(){
		if(Math.abs(deflection)>=91 || toward) {
			direction = "TO";
		}else {
			direction = "FROM";
		}
	}
	
	public void dotCalc(){
		int dotHelper;
		if(Math.abs(deflection)<=90) {
			dotHelper = Math.abs(deflection);
		}else{
			dotHelper = 180 - Math.abs(deflection);
		}
		
		if(dotHelper>=10) {
			dots = "FULL";
		}else if (dotHelper>=8) {
			dots = "4 dots";
		}else if (dotHelper>=6) {
			dots = "3 dots";
		}else if (dotHelper>=4) {
			dots = "2 dots";
		}else if (dotHelper>=2) {
			dots = "1 dot";
		}else {
			dots = "0 dots";
		}
	}
	
	public void output(){
		deflectionCalc();
		direction();
		toFrom();
		dotCalc();
		if(goodSignal == true){
			System.out.println("Signals is: GOOD"+"\nNeedle "+turn+" "+dots
					+"\n"+direction+" indicator lit");
		}else{
			System.out.println("Signal is: BAD");
		}
	}
}


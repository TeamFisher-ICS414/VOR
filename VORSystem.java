public class VORSystem {

	/*
	 * Bill edit added goodSignal
	 */
	private int currentRadial, destinationRadial, difference, deflection;
	private boolean toward, goodSignal;
	String direction, turn, dots;
	/*
	 * Bill edit - I changed constructor parameters to match the driver
	 */
	public VORSystem(int OBS, int signal) {
		destinationRadial = OBS;		
		if (signal > 0) {
			goodSignal = true;
			currentRadial = signal;
		} else {
			goodSignal = false;
			currentRadial = (-1)*signal;
		}
		if (currentRadial == 360) {
			currentRadial = 0;
		}
	}
	/*
	 * Now included in constructor
	 * 
	public boolean signalValidate(){
		boolean signalTest;
		if(currentRadial<0){
			signalTest =  false;
		}else{
			signalTest = true;
		}
		return signalTest;
	}
	*/
	
	public void deflectionCalc() {
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
		}else if (deflection == 0) {
			turn = "CENTERED";
		}else {
			turn = "RIGHT";
		}
		
		/*
		 * Have not received final answer to forum question on "abeam"
		 * We are going with this statement, from original instructions, and assuming any later apparent contradiction is due to miscommunication
		 * "Assume	that	the	plane	is	abeam	the	VOR	station	
if	the	intercepted	radial	is	within	one	degree	of	90	degrees	from	the	intended	radial."
		 */
		
		if(Math.abs(deflection)<=91 && Math.abs(deflection)>=89){
			goodSignal = false;
		}
		
		if(Math.abs(deflection)>=91) {
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
	}
	
	/*
	 * Bill - changed calc of to-from, now included in deflection calc	
	 *
	public void toFrom(){
		if(toward == true){
			direction = "TO";
		}else{
			direction = "FROM";
		}
	}
	*/
	
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


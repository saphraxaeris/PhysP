
public class PhysPObject {
	private double initVel = Double.NaN;
	private double finalVel = Double.NaN;
	private double avgVel = Double.NaN; // Add?
	private double initPos = Double.NaN;
	private double finalPos = Double.NaN;
	private double displacement = Double.NaN; // (x - x0)
	private double initTime = Double.NaN; //Add ->need to make adjustments to code
	private double finalTime = Double.NaN; //Add ->need to make adjustments to code
	private double timeMoved = Double.NaN;
	private double accel = Double.NaN;

	/***
	 * Creates a new PhysPObject object with attributes set to "Not a Number"
	 */
	public PhysPObject() {
	}

	/***
	 * Sets a value to a specific attribute
	 * @param d = value
	 * @param name of attribute
	 */
	public void setVariable(double d, String name) {
		switch (name) {
		case "initial velocity":
			initVel = d;
			break;
		case "final velocity":
			finalVel = d;
			break;
		case "initial position":
			initPos = d;
			break;
		case "final position":
			finalPos = d;
			break;
		case "displacement":
			displacement = d;
			break;
		case "time moved":
			timeMoved = d;
			break;
		case "initial time":
			initTime = d;
			break;
		case "final time":
			finalTime = d;
			break;
		case "acceleration":
			accel = d;
			break;
		case "average velocity":
			avgVel = d;
			break;
		}
	}

	/***
	 * Calculates and gets the value of a specific attribute
	 * @param name of attribute
	 * @return Value of attribute
	 */
	public double getVariable(String name) {
		switch (name) {
		case "initial velocity":
			calcInitVel();
			return initVel;
		case "final velocity":
			calcFinalVel();
			return finalVel;
		case "initial position":
			calcInitPos();
			return initPos;
		case "final position":
			calcFinalPos();
			return finalPos;
		case "displacement":
			calcDisplacement();
			return displacement;
		case "time moved":
			calcTimeMoved();
			return timeMoved;
		case "initial time":
			calcInitTime();
			return initTime;
		case "final time":
			calcFinalTime();
			return finalTime;
		case "acceleration":
			calcAccel();
			return accel;
		case "average velocity":
			calcAvgVel();
			return avgVel;
		default:
			return 0;
		}
	}

	/***************************************/
	/* Private Functions */
	/***************************************/

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added

	private boolean calcInitVel() {
		if (!Double.isNaN(finalPos) && !Double.isNaN(accel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			initVel = finalVel - (accel*timeMoved);
			return true;//1
		}
		else if (((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement)) && !Double.isNaN(accel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			if(Double.isNaN(displacement))
				displacement = finalPos - initPos;
			initVel = (displacement - (0.5)*accel*(Math.pow(timeMoved, 2)))/timeMoved;
			return true;//2
		}
		else if (!Double.isNaN(finalVel) && !Double.isNaN(accel) && ((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement))) {
			if (Double.isNaN(displacement))
				displacement = finalPos - initPos;
			initVel = Math.sqrt(Math.pow(finalVel, 2) - 2*accel*displacement);
			return true;//3
		}
		else if (!Double.isNaN(avgVel) && !Double.isNaN(finalVel)){
			initVel = (2*avgVel) - finalVel;
			return true;//4
		}
		else if (!Double.isNaN(initVel)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added

	private boolean calcFinalVel() {
		if (!Double.isNaN(initVel) && !Double.isNaN(accel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			finalVel = initVel + accel*timeMoved;
			return true;//1
		}
		else if (!Double.isNaN(initVel) && !Double.isNaN(accel) && ((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement))) {
			if(Double.isNaN(displacement))
				displacement = finalPos - initPos;
			finalVel = Math.sqrt(Math.pow(initVel, 2) + (2*accel*displacement));
			return true;//3
		}
		else if (!Double.isNaN(initVel) && !Double.isNaN(avgVel)) {
			initVel = 2*avgVel - initVel;
			return true;//4
		}
		else if (!Double.isNaN(finalVel)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added

	private boolean calcInitPos() {
		if (!Double.isNaN(displacement) && !Double.isNaN(finalPos)) {
			initPos = finalPos - displacement;
			return true;//0
		}
		else if (!Double.isNaN(finalPos)  && !Double.isNaN(accel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			initPos = finalPos - (initVel*timeMoved) - ((0.5)*accel*Math.pow(timeMoved, 2));
			return true;//2
		}
		else if (!Double.isNaN(finalVel) && !Double.isNaN(initVel) && !Double.isNaN(accel) && !Double.isNaN(finalPos)) {
			initPos = (Math.pow(initVel, 2) + (2*accel*finalPos) - Math.pow(finalVel, 2))/(2*accel);
			return true;//3
		}
		else if (!Double.isNaN(initPos)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added

	private boolean calcFinalPos() {
		if (!Double.isNaN(displacement) && !Double.isNaN(initPos)) {
			finalPos = initPos + displacement;
			return true;//0
		}
		else if (!Double.isNaN(initPos)  && !Double.isNaN(accel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			finalPos = initPos + (initVel*timeMoved) + ((0.5)*accel*Math.pow(timeMoved, 2));
			return true;//2
		}
		else if (!Double.isNaN(finalVel) && !Double.isNaN(initVel) && !Double.isNaN(accel) && !Double.isNaN(initPos)) {
			finalPos = (Math.pow(finalVel, 2 + (2*accel*finalPos)) - Math.pow(initVel, 2))/(2*accel);
			return true;//3
		}
		else if (!Double.isNaN(finalPos)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added

	private boolean calcDisplacement() {
		if (!Double.isNaN(initPos) && !Double.isNaN(finalPos)) {
			displacement = finalPos - initPos;
			return true;//0				
		}
		else if (!Double.isNaN(initVel) && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime))) && !Double.isNaN(accel)) {
			displacement = initVel*timeMoved + (0.5)*accel*Math.pow(timeMoved, 2);
			return true;//2
		}
		else if (!Double.isNaN(finalVel) && !Double.isNaN(initVel) && !Double.isNaN(accel)) {
			displacement = (Math.pow(finalVel, 2) - Math.pow(initVel, 2))/(2*accel);
			return true;
		}
		else if (!Double.isNaN(displacement)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}
	private boolean calcInitTime() {
		boolean valid = calcTimeMoved();
		if(valid){
			if(!Double.isNaN(finalTime))
				initTime = finalTime - timeMoved;
			else
				initTime = timeMoved;
		}
		if(!Double.isNaN(initTime)) {
			return true;
		}
		return valid;			
	}
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	private boolean calcFinalTime() {
		boolean valid = calcTimeMoved();
		if(valid){
			if(!Double.isNaN(initTime))
				finalTime = timeMoved + initTime;
			else
				finalTime = timeMoved;
		}
		if(!Double.isNaN(finalTime)) {
			return true;
		}
		return valid;			
	}
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	private boolean calcAccel() {
		if (!Double.isNaN(initVel) && !Double.isNaN(finalVel) &&  (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime)))) {
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			accel = (finalVel-initVel)/timeMoved;
			return true;//0
		}
		else if(!Double.isNaN(initVel) && ((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement))  && (!Double.isNaN(timeMoved) || (!Double.isNaN(initTime) && !Double.isNaN(finalTime))) ){
			if(Double.isNaN(displacement))
				displacement = finalPos - initPos;
			if(Double.isNaN(timeMoved))
				timeMoved = finalTime - initTime;
			accel = (2*(displacement-(timeMoved*initVel)))/Math.pow(timeMoved, 2);
			return true;//2
		}
		else if(!Double.isNaN(initVel) && ((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement))  && !Double.isNaN(finalVel)){
			if(Double.isNaN(displacement))
				displacement = finalPos - initPos;
			accel = ((finalVel*finalVel)-(initVel*initVel))/(2*(displacement));
			return true;//3
		}
		else if (!Double.isNaN(accel)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 
	private boolean calcTimeMoved() {
		if(!Double.isNaN(initTime) && !Double.isNaN(finalTime)){
			timeMoved = finalTime - initTime;
			return true;
		}
		else if (!Double.isNaN(initVel) && !Double.isNaN(accel) && !Double.isNaN(finalVel)) {
			timeMoved = (finalVel-initVel)/accel;
			return true;//1
		}
		else if (!Double.isNaN(initVel) && !Double.isNaN(accel) && ((!Double.isNaN(finalPos) && !Double.isNaN(initPos)) || !Double.isNaN(displacement))) {
			if(Double.isNaN(displacement))
				displacement = finalPos - initPos;
			timeMoved = ((Math.sqrt(Math.pow(initVel,2) + 2*accel*(displacement))-initVel)/accel);
			return true;//2 
		}
		else if(!Double.isNaN(timeMoved)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}

	private boolean calcAvgVel() {
		boolean tmp1 = calcInitVel();
		boolean tmp2 = calcFinalVel();

		if(tmp1 && tmp2) {
			avgVel = (initVel + finalVel) / 2;
			return true;
		}
		else if(!Double.isNaN(avgVel)) {
			return true;
		}
		else { //Could not be computed. Print needed information implement more thoroughly later
			System.out.println("Too few argument");
			return false;
		}
	}
}


public class PhysPObject {
	private double mass = Double.NaN;
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
		case "mass":
			mass = d;
			break;
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
		}
	}

	/***
	 * Calculates and gets the value of a specific attribute
	 * @param name of attribute
	 * @return Value of attribute
	 */
	public double getVariable(String name) {
		switch (name) {
		case "mass":
			calcMass();
			return mass;
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
		default:
			return 0;
		}
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	
	/***************************************/
	/* Private Functions */
	/***************************************/
	private boolean calcMass() {
		if (mass == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}
	
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	
	private boolean calcInitVel() {
		if (initVel == Double.NaN) {
			if (finalPos != Double.NaN && accel != Double.NaN && (timeMoved != Double.NaN || (initTime != Double.NaN && finalTime != Double.NaN))) {
				if(timeMoved == Double.NaN)
					timeMoved = finalTime - initTime;
				initVel = finalVel - (accel*timeMoved);
				return true;//1
			}
			else if (((finalPos != Double.NaN && initPos != Double.NaN) || displacement != Double.NaN) && accel != Double.NaN && (timeMoved != Double.NaN || (initTime != Double.NaN && finalTime != Double.NaN))) {
				if(timeMoved == Double.NaN)
					timeMoved = finalTime - initTime;
				if(displacement == Double.NaN)
					displacement = finalPos - initPos;
				initVel = (displacement - (0.5)*accel*(Math.pow(timeMoved, 2)))/timeMoved;
				return true;//2
			}
			else if (finalVel != Double.NaN && accel != Double.NaN && ((finalPos != Double.NaN && initPos != Double.NaN) || displacement != Double.NaN)) {
				if (displacement == Double.NaN)
					displacement = finalPos - initPos;
				initVel = Math.sqrt(Math.pow(finalVel, 2) - 2*accel*displacement);
				return true;//3
			}
			else if (avgVel != Double.NaN && finalVel != Double.NaN){
				initVel = (2*avgVel) - finalVel;
				return true;//4
			}
			else { //Could not be computed. Print needed information implement more thoroughly later
				System.out.println("Too few argument");
				return false;
			}
		}
		return true;
	}
	
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	
	private boolean calcFinalVel() {
		if (finalVel == Double.NaN) {
			if (initVel != Double.NaN && accel != Double.NaN && (timeMoved != Double.NaN || (initTime != Double.NaN && finalTime != Double.NaN))) {
				if(timeMoved == Double.NaN)
					timeMoved = finalTime - initTime;
				finalVel = initVel + accel*timeMoved;
				return true;//1
			}
			else if (initVel != Double.NaN && accel != Double.NaN && ((finalPos != Double.NaN && initPos != Double.NaN) || displacement != Double.NaN)) {
				if(displacement == Double.NaN)
					displacement = finalPos - initPos;
				finalVel = Math.sqrt(Math.pow(initVel, 2) + (2*accel*displacement));
				return true;//3
			}
			else if (initVel != Double.NaN && avgVel != Double.NaN) {
				initVel = 2*avgVel - initVel;
				return true;//4
			}
			else { //Could not be computed. Print needed information implement more thoroughly later
				System.out.println("Too few argument");
				return false;
			}
		}
		return true;
	}

	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	
	private boolean calcInitPos() {
		if (initPos == Double.NaN) {
			if (displacement != Double.NaN && finalPos != Double.NaN) {
				initPos = finalPos - displacement;
				return true;//0
			}
			else if (finalPos != Double.NaN  && accel != Double.NaN && timeMoved != Double.NaN) {
				if(timeMoved == Double.NaN)
					timeMoved = finalTime - initTime;
				if(displacement == Double.NaN)
					displacement = finalPos - initPos;
					
				initPos = finalPos - (initVel*timeMoved) - ((0.5)*accel*Math.pow(timeMoved, 2));
				return true;//2
			}
			else if (finalVel != Double.NaN && initVel != Double.NaN && accel != Double.NaN && finalPos != Double.NaN) {
				initPos = (Math.pow(initVel, 2) - Math.pow(finalVel, 2) + (2*accel*finalPos))/(2*accel);
				return true;//3
			}
			else { //Could not be computed. Print needed information implement more thoroughly later
				System.out.println("Too few argument");
				return false;
			}
		}
		return true;
	}
	
	// Kinematic Formulas (a = constant)
	//0.) displacement = x - x0
	//1.) v = v0 + a*t
	//2.) x = x0 + v0*t + (1/2)*a*t^2
	//3.) v^2 = v0^2 + 2*a*(x - x0)
	//4.) avgV = (v + v0) / 2 			Added
	
	private boolean calcFinalPos() {
		if (finalPos == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}

	private boolean calcDisplacement() {
		if (displacement == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}
	private boolean calcInitTime() {
		if (initTime == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}
	
	private boolean calcFinalTime() {
		if (finalTime == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}
	
	private boolean calcAccel() {
		if (accel == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}

	private boolean calcTimeMoved() {
		if (timeMoved == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}
}

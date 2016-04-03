
public class PhysPObject {
	private double mass = Double.NaN;
	private double initVel = Double.NaN;
	private double finalVel = Double.NaN;
	private double initPos = Double.NaN;
	private double finalPos = Double.NaN;
	private double displacement = Double.NaN;
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
		case "initVel":
			initVel = d;
			break;
		case "finalVel":
			finalVel = d;
			break;
		case "initPos":
			initPos = d;
			break;
		case "finalPos":
			finalPos = d;
			break;
		case "displacement":
			displacement = d;
			break;
		case "timeMoved":
			timeMoved = d;
			break;
		case "accel":
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
		case "initVel":
			calcInitVel();
			return initVel;
		case "finalVel":
			calcFinalVel();
			return finalVel;
		case "initPos":
			calcInitPos();
			return initPos;
		case "finalPos":
			calcFinalPos();
			return finalPos;
		case "displacement":
			calcDisplacement();
			return displacement;
		case "timeMoved":
			calcTimeMoved();
			return timeMoved;
		case "accel":
			calcAccel();
			return accel;
		default:
			return 0;
		}
	}

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

	private boolean calcInitVel() {
		if (initVel == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}

	private boolean calcFinalVel() {
		if (finalVel == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}

	private boolean calcInitPos() {
		if (initPos == Double.NaN) {
			System.out.println("Calculation of this attribute is not yet implemented.");
			return false;
		}
		return true;
	}

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

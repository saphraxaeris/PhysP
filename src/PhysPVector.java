
public class PhysPVector {
	private double xComponent = Double.NaN;
	private double yComponent = Double.NaN;
	private double magnitude = Double.NaN;
	private double angle = Double.NaN;

	/***
	 * Creates a new PhysPVector object with attributes set to "Not a Number"
	 */
	public PhysPVector() {
	}

	/***
	 * Sets a value to a specific attribute
	 * @param d = value
	 * @param name of attribute
	 */
	public void setVariable(double d, String name) {
		switch (name) {
		case "xComponent":
			xComponent = d;
			break;
		case "yComponent":
			yComponent = d;
			break;
		case "magnitude":
			magnitude = d;
			break;
		case "angle":
			angle = d;
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
		case "xComponent":
			calcXComponent();
			return xComponent;
		case "yComponent":
			calcYComponent();
			return yComponent;
		case "magnitude":
			calcMagnitude();
			return magnitude;
		case "angle":
			calcAngle();
			return angle;
		default:
			return 0;
		}
	}

	/***************************************/
	/* Private Functions */
	/***************************************/
	private boolean calcXComponent() {
		if (xComponent == Double.NaN) {
			if (magnitude != Double.NaN && angle != Double.NaN) {
				xComponent = magnitude*Math.cos(angle);
				return true;
			} else if (magnitude != Double.NaN && yComponent != Double.NaN) {
				xComponent = Math.sqrt(Math.pow(magnitude, 2) - Math.pow(yComponent, 2));
				return true;
			} else {
				if (magnitude != Double.NaN) {
					System.out.println("Too few arguments: Y Component or Angle is needed.");
				} else {
					System.out.println("Too few arguments: Magnitude is needed.");
				}
				return false;
			}
		}
		return true;
	}

	private boolean calcYComponent() {
		if (yComponent == Double.NaN) {
			if (magnitude != Double.NaN && angle != Double.NaN) {
				yComponent = magnitude*Math.sin(angle);
				return true;
			} else if (magnitude != Double.NaN && xComponent != Double.NaN) {
				yComponent = Math.sqrt(Math.pow(magnitude, 2) - Math.pow(xComponent, 2));
				return true;
			} else {
				if (magnitude != Double.NaN) {
					System.out.println("Too few arguments: X Component or Angle is needed.");
				} else {
					System.out.println("Too few arguments: Magnitude is needed.");
				}
				return false;
			}
		}
		return true;
	}

	private boolean calcMagnitude() {
		if (magnitude == Double.NaN) {
			if(xComponent != Double.NaN && yComponent != Double.NaN) {
				magnitude = Math.sqrt(Math.pow(xComponent, 2) + Math.pow(yComponent, 2));
				return true;
			}
			else if(xComponent != Double.NaN && angle != Double.NaN) {
				magnitude = xComponent/Math.cos(angle);
				return true;
			}
			else if(yComponent != Double.NaN && angle != Double.NaN) {
				magnitude = yComponent/Math.sin(angle);
				return true;
			}
			else {
				if(angle == Double.NaN) {
					System.out.println("Too few arguments: Angle is needed.");
				}
				else {
					System.out.println("Too few arguments: X or Y component is needed.");
				}
				return false;
			}
		}
		return true;
	}

	private boolean calcAngle() {
		if (angle == Double.NaN) {
			if(xComponent != Double.NaN && yComponent != Double.NaN) {
				angle = Math.atan(yComponent/xComponent);
				return true;
			}
			else if(xComponent != Double.NaN && magnitude != Double.NaN) {
			
				angle = Math.atan(yComponent/xComponent);
				return true;
			}
			else if(yComponent != Double.NaN && magnitude != Double.NaN) {
				
				angle = Math.atan(yComponent/xComponent);
				return true;
			}
			else {
				if(magnitude != Double.NaN) {
					System.out.println("Too few arguments: X or Y component is needed.");
				}
				else {
					System.out.println("Too few arguments: Magnitude is needed.");
				}
				return false;
			}
		}
		return true;
	}
}

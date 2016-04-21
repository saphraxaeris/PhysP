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
		case "x component":
			xComponent = d;
			break;
		case "y component":
			yComponent = d;
			break;
		case "magnitude":
			magnitude = d;
			break;
		case "angle":
			angle = d*(Math.PI/180.0);// Change to radians
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
		case "x component":
			calcXComponent();
			return xComponent;
		case "y component":
			calcYComponent();
			return yComponent;
		case "magnitude":
			calcMagnitude();
			return magnitude;
		case "angle":
			calcAngle();
			return angle*(180.0/Math.PI); // Change back to degrees
		default:
			return 0;
		}
	}

	/***************************************/
	/* Private Functions */
	/***************************************/
	//Formulas
	// 1.) magnitude = (x^2 + y^2)^(1/2)
	// 2.) sin(angle) = y/magnitude
	// 3.) cos(angle) = x/magnitude
	// 4.) tan(angle) = y/x
	private boolean calcXComponent() {
			if (!Double.isNaN(magnitude) && !Double.isNaN(angle)) {
				xComponent = magnitude*Math.cos(angle);
				System.out.println(ColorCodes.GREEN + "Used: cos(angle) = x/magnitude" + ColorCodes.RESET);
				return true;//3
			} else if (!Double.isNaN(magnitude) && !Double.isNaN(yComponent)) {
				xComponent = Math.sqrt(Math.pow(magnitude, 2) - Math.pow(yComponent, 2));
				System.out.println(ColorCodes.GREEN + "Used: magnitude = (x^2 + y^2)^(1/2)" + ColorCodes.RESET);
				return true;//1
			} else {
				if(!Double.isNaN(xComponent)) {
					return true;
				}
				if (!Double.isNaN(magnitude)) {
					System.out.println(ColorCodes.RED + "Too few arguments: Y Component or Angle is needed." + ColorCodes.RESET);
				} else {
					System.out.println(ColorCodes.RED + "Too few arguments: Magnitude is needed." + ColorCodes.RESET);
				}
				return false;
			}
	}

	private boolean calcYComponent() {
			if (!Double.isNaN(magnitude)&& !Double.isNaN(angle)) {
				yComponent = magnitude*Math.sin(angle);
				System.out.println(ColorCodes.GREEN + "Used: sin(angle) = y/magnitude" + ColorCodes.RESET);
				return true;//2
			} else if (!Double.isNaN(magnitude) && !Double.isNaN(xComponent)) {
				yComponent = Math.sqrt(Math.pow(magnitude, 2) - Math.pow(xComponent, 2));
				System.out.println(ColorCodes.GREEN + "Used: magnitude = (x^2 + y^2)^(1/2)" + ColorCodes.RESET);
				return true;//1
			} else {
				if(!Double.isNaN(yComponent)) {
					return true;
				}
				if (!Double.isNaN(magnitude)) {
					System.out.println(ColorCodes.RED + "Too few arguments: X Component or Angle is needed." + ColorCodes.RESET);
				} else {
					System.out.println(ColorCodes.RED + "Too few arguments: Magnitude is needed." + ColorCodes.RESET);
				}
				return false;
			}
	}

	private boolean calcMagnitude() {
			if(!Double.isNaN(xComponent) && !Double.isNaN(yComponent)) {
				magnitude = Math.sqrt(Math.pow(xComponent, 2) + Math.pow(yComponent, 2));
				System.out.println(ColorCodes.GREEN + "Used: magnitude = (x^2 + y^2)^(1/2)" + ColorCodes.RESET);
				return true;//1
			}
			else if(!Double.isNaN(xComponent) && !Double.isNaN(angle)) {
				magnitude = xComponent/Math.cos(angle);
				System.out.println(ColorCodes.GREEN + "Used: sin(angle) = y/magnitude" + ColorCodes.RESET);
				return true;//2
			}
			else if(!Double.isNaN(yComponent) && !Double.isNaN(angle)) {
				magnitude = yComponent/Math.sin(angle);
				System.out.println(ColorCodes.GREEN + "Used: cos(angle) = x/magnitude" + ColorCodes.RESET);
				return true;//3
			}
			else {
				if(!Double.isNaN(magnitude)) {
					return true;
				}
				if(Double.isNaN(angle)) {
					System.out.println(ColorCodes.RED + "Too few arguments: Angle is needed." + ColorCodes.RESET);
				}
				else {
					System.out.println(ColorCodes.RED + "Too few arguments: X or Y component is needed." + ColorCodes.RESET);
				}
				return false;
			}
	}

	private boolean calcAngle() {
			if(!Double.isNaN(xComponent) && !Double.isNaN(yComponent)) {
				angle = Math.atan(yComponent/xComponent);
				System.out.println(ColorCodes.GREEN + "Used: tan(angle) = y/x" + ColorCodes.RESET);
				return true;//4
			}
			else if(!Double.isNaN(xComponent) && !Double.isNaN(magnitude)) {
				angle = Math.acos(xComponent/magnitude);
				System.out.println(ColorCodes.GREEN + "Used: cos(angle) = x/magnitude" + ColorCodes.RESET);
				return true;//3
			}
			else if(!Double.isNaN(yComponent) && !Double.isNaN(magnitude)) {
				angle = Math.asin(yComponent/magnitude);
				System.out.println(ColorCodes.GREEN + "Used: sin(angle) = y/magnitude" + ColorCodes.RESET);
				return true;//2
			}
			else {
				if(!Double.isNaN(angle)) {
					return true;
				}
				if(!Double.isNaN(magnitude)) {
					System.out.println(ColorCodes.RED + "Too few arguments: X or Y component is needed." + ColorCodes.RESET);
				}
				else {
					System.out.println(ColorCodes.RED + "Too few arguments: Magnitude is needed." + ColorCodes.RESET);
				}
				return false;
			}
	}
}

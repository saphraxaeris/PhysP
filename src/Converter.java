
public class Converter {
	public static double Distance(String from, String to, double value) {
		
		return Double.NaN;
	}
	
	public static double Force(String from, String to, double value) {
		
		return Double.NaN;
	}
	
	public static double Velocity(String from, String to, double value) {
		
		return Double.NaN;
	}
	
	public static double Acceleration(String from, String to, double value) {
		
		return Double.NaN;
	}
	
	public static double Time(String from, String to, double value) {
		
		return Double.NaN;
	}
	
	public static double Angle(String from, String to, double value) {
		if(from.equals(to)) {
			return value;
		}
		else if (from.equals("degrees")) {
			if(to.equals("radians")) {
				//Convert
			}
		}
		else if(from.equals("radians")) {
			if(to.equals("degress")) {
				///Convert
			}
		}
		return Double.NaN;
	}
}

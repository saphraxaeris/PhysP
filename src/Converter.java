
public class Converter {
	/*
	 * Converter Tool:
	 * https://www.unitjuggler.com/convert-acceleration-from-ms2-to-fts2.html
	 */
	
    public static double Distance(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if (from.equals("m")) {
            switch(to) {
            case "cm":
                return value * 100;
            case "km":
                return value / 1000;
            case "mi":
                return value * 0.000621371192;
            case "in":
                return value * 39.370;
            case "ft":
                return value * 3.2808;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m")) {
            switch(from) {
            case "cm":
                return value / 100;
            case "km":
                return value * 1000;
            case "mi":
                return value * 1609.344;
            case "in":
                return value / 39.370;
            case "ft":
                return value / 3.2808;
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }

    public static double Force(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if(from.equals("N")) {
            switch(to) {
            case "pounds":
                return value * 0.224809;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("N")) {
            switch(from) {
            case "pounds":
                return value * 4.44822;
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
    
    public static double Velocity(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if(from.equals("m/s")) {
            switch(to) {
            case "cm/s":
                return value * 100;
            case "ft/s":
                return value * 3.2808;
            case "ft/min":
                return (value * 3.2808) / 60;
            case "mi/h":
                return (value * 0.000621371192) / 3600;
            case "km/h":
                return (value * 1000) / 3600;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m/s")) {
            switch(from) {
            case "cm/s":
                return value / 100;
            case "ft/s":
                return value / 3.2808;
            case "ft/min":
                return (value / 3.2808) / 60;
            case "mi/h":
                return (value * 1609.344) / 3600;
            case "km/h":
                return (value * 1000) / 3600;
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
    
    public static double Acceleration(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if(from.equals("m/s^2")) {
            switch(to) {
            case "cm/s^2":
                return value * 0.01;
            case "ft/s^2":
                return value * 3.2808398950131;
            case "ft/min^2":
                return value * 11811.023622047;
            case "mi/h^2":
                return value * 8052.9706513958;
            case "km/h^2":
                return value * 12960;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m/s^2")) {
            switch(from) {
            case "cm/s^2":
                return value * 100;
            case "ft/s^2":
                return value * 0.3048;
            case "ft/min^2":
                return value * 0.00008466666666667;
            case "mi/h^2":
                return value * 0.00012417777777778;
            case "km/h^2":
                return value * 0.0000716049382716;
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
    
    public static double Time(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if(from.equals("s")) {
            switch(to) {
            case "min":
                return value / 60;
            case "h":
                return value / 3600;
            default:
                return Double.NaN;
            }
        }   
        else if(to.equals("s")) {
            switch(from) {
            case "min":
                return value * 60;
            case "h":
                return value * 3600;
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
    
    public static double Angle(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if(from.equals("degrees")) {
            switch(to) {
            case "radians":
                return value * (Math.PI / 180.0);
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("degrees")) {
            switch(from) {
            case "radians":
                return value * (180.0 / Math.PI);
            default:
                return Double.NaN;
            }
        }
        return Double.NaN;
    }
}

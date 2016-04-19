
public class Converter {
    public static double Distance(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if (from.equals("m")) {
            switch(to) {
            case "cm":
                return value * 1000;
            case "km":
                return value / 1000;
            case "mile":
                return value * 0.000621371192;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m")) {
            switch(from) {
            case "cm":
                return value / 1000;
            case "km":
                return value * 1000;
            case "mile":
                return value * 1609.344;
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
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("N")) {
            switch(from) {
            case "pounds":
                return Double.NaN;
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
                return Double.NaN;
            case "ft/s":
                return Double.NaN;
            case "ft/min":
                return Double.NaN;
            case "mile/hr":
                return Double.NaN;
            case "km/hr":
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m/s")) {
            switch(to) {
            case "cm/s":
                return Double.NaN;
            case "ft/s":
                return Double.NaN;
            case "ft/min":
                return Double.NaN;
            case "mile/hr":
                return Double.NaN;
            case "km/hr":
                return Double.NaN;
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
                return Double.NaN;
            case "ft/s^2":
                return Double.NaN;
            case "ft/min^2":
                return Double.NaN;
            case "mile/hr^2":
                return Double.NaN;
            case "km/hr^2":
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("m/s^2")) {
            switch(from) {
            case "cm/s^2":
                return Double.NaN;
            case "ft/s^2":
                return Double.NaN;
            case "ft/min^2":
                return Double.NaN;
            case "mile/hr^2":
                return Double.NaN;
            case "km/hr^2":
                return Double.NaN;
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
                return Double.NaN;
            case "hr":
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }   
        else if(to.equals("s")) {
            switch(from) {
            case "min":
                return Double.NaN;
            case "hr":
                return Double.NaN;
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
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }
        else if(to.equals("degrees")) {
            switch(from) {
            case "radians":
                return Double.NaN;
            default:
                return Double.NaN;
            }
        }
        if(from.equals(to)) {
            return value;
        }
        return Double.NaN;
    }
}

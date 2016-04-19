
public class Converter {
    public static double Distance(String from, String to, double value) {
        if(from.equals(to))
            return value;
        else if (from.equals("m")) {
            switch(to) {
            case "cm":
                return value * 100;
            case "km":
                return value / 1000;
            case "mile":
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
            case "mile":
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
    //there's a lot of unambiguity here...
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
                return value * 100;
            case "ft/s":
                return value * 3.2808;
            case "ft/min":
                return (value * 3.2808) / 60;
            case "mile/hr":
                return (value * 0.000621371192) / 3600;
            case "km/hr":
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
            case "mile/hr":
                return (value * 1609.344) / 3600;
            case "km/hr":
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
                return value / 60;
            case "hr":
                return value / 3600;
            default:
                return Double.NaN;
            }
        }   
        else if(to.equals("s")) {
            switch(from) {
            case "min":
                return value * 60;
            case "hr":
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

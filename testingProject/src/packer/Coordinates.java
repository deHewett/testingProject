package packer;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author I.M.Bad
 */
public class Coordinates {
    
    private final double x;
    private final double y;
    
    public Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public double euclideanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.pow((xDiff * xDiff + yDiff * yDiff),0.5);
        return dist;
    }
    
    public double manhattanDistanceTo(Coordinates other) {
        double xDiff = other.getX() - this.getX();
        double yDiff = other.getY() - this.getY();
        double dist = Math.abs(xDiff) + Math.abs(yDiff);
        return dist;
    }
    
    public double companyDistanceTo(Coordinates other) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        double xDiff1 = Double.parseDouble(df.format(other.getX() - this.getX()));
        double yDiff1 = Double.parseDouble(df.format(other.getY() - this.getY()));
        double dist1 = Math.pow((xDiff1 * xDiff1 + yDiff1 * yDiff1),0.5);
        double xDiff2 = Double.parseDouble(df.format(other.getX() - this.getX()));
        double yDiff2 = Double.parseDouble(df.format(other.getY() - this.getY()));
        double dist2 = Math.abs(xDiff2) + Math.abs(yDiff2);
        return ((dist1 + dist2)/2)+1;
    }

}

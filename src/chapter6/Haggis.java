package chapter6;

public class Haggis {
    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    double getDistanceTravelled(int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * primaryTime * primaryTime;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVal = acc * delay;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVal + secondaryTime + 0.5 * acc * secondaryTime * secondaryTime;
        }
        return result;
    }
}

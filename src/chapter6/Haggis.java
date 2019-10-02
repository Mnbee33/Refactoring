package chapter6;

public class Haggis {
    private double primaryForce;
    private double secondaryForce;
    private double mass;
    private int delay;

    double getDistanceTravelled(int time) {
        double result;
        final double primaryAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * primaryAcc * primaryTime * primaryTime;

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVal = primaryAcc * delay;
            final double secondaryAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVal + secondaryTime + 0.5 * secondaryAcc * secondaryTime * secondaryTime;
        }
        return result;
    }
}

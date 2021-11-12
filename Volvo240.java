import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25; // Trim factor for Volvo240

    /**
     * Constructor of Volvo240
     * Inherits Car.
     */
    public Volvo240() {
        super(4, 100, Color.black, "Volvo240");
    }

    /**
     * Method to determine speed factor of Volvo240.
     * @return speed factor. Speed factor is dependent whether the turbo is on or not.
     * Overrides the equivalent method in Car.
     */
    @Override
    protected double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }
}

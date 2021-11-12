import java.awt.*;

public class Saab95 extends Car{

    private boolean turboOn;

    /**
     * Constructor of Saab95
     * Inherits Car.
     */
    public Saab95(){
        super(2, 125, Color.black, "Saab95");
	    turboOn = false;
    }

    /**
     * Method to activate turbo
     */
    public void setTurboOn(){
	    turboOn = true;
    }
    /**
     * Method to deactivate turbo
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Method to determine speed factor
     * @return speed factor. Speed factor is dependent whether the turbo is on or not.
     * Overrides the equivalent method in Car.
     */
    @Override
    protected double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

}

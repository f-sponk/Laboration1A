import java.awt.*;

public abstract class Car implements Movable {

    protected int nrDoors;
    protected double enginePower;
    protected double currentSpeed;
    protected Color color;
    protected String modelName;
    protected Direction direction = Direction.NORTH;
    protected Point.Double position = new Point.Double(); // Default position for the car is x = 0,y = 0.

    /**
     * Constructor of Car. Takes nrDoors, enginePower, color and modelName as parameters.
     * @param nrDoors Number of doors.
     * @param enginePower Engine power.
     * @param color Color of car.
     * @param modelName Model name of car.
     */
    public Car(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        stopEngine();
    }
    /**
     * An enum for Direction.
     */
    enum Direction {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    /**
     * Metod to get current position.
     * @return position.
     */
    public Point.Double getPosition() {
        return position;
    }

    /**
     * Method to get number of doors.
     * @return nrDoors.
     */
    public int getNrDoors() {
        return nrDoors;
    }
    /**
     * Method to get engine power
     * @return engine power
     */
    public double getEnginePower() {
        return enginePower;
    }

    /**
     * Method to get current speed
     * @return current speed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Method to get color of car
     * @return current speed
     */
    public Color getColor(){
        return color;
    }

    /**
     * Method to set color of car
     */
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Method to start engine. Sets current speed.
     */
    protected void startEngine() {
        currentSpeed = 0.1;
    }

    /**
     * Method to stop engine. Sets current speed (to 0).
     */
    protected void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Method to change the cars position in a given direction.
     */
    public void move() {
        switch (direction) {
            case NORTH:
                position.setLocation(position.getX(),position.getY() + getCurrentSpeed());
                break;
            case SOUTH:
                position.setLocation(position.getX(),position.getY() - getCurrentSpeed());
                break;
            case EAST:
                position.setLocation(position.getX() + getCurrentSpeed(),position.getY());
                break;
            case WEST:
                position.setLocation(position.getX() - getCurrentSpeed(),position.getY());
                break;
        }
    }


    /**
     * Method to turn the car left.
     */
    public void turnLeft() {
        switch (direction) {
            case NORTH:
                direction = Direction.WEST;
                break;
            case SOUTH:
                direction = Direction.EAST;
                break;
            case EAST:
                direction = Direction.NORTH;
                break;
            case WEST:
                direction = Direction.SOUTH;
                break;
        }
    }
    /**
     * Method to turn the car right.
     */
    public void turnRight() {
        switch (direction) {
            case NORTH:
                direction = Direction.EAST;
                break;
            case SOUTH:
                direction = Direction.WEST;
                break;
            case EAST:
                direction = Direction.SOUTH;
                break;
            case WEST:
                direction = Direction.NORTH;
                break;
        }
    }

    /**
     * Abstract class of speed factor.
     */
    protected abstract double speedFactor();

    /**
     * Method to calculate current speed when speed is increasing by given amount.
     * @param amount of incrementSpeed.
     */
    protected void incrementSpeed(double amount) {
        if(speedFactor() < 0) {
            throw new RuntimeException("speedFactor is lower than 0!");
        }
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    /**
     * Method to calculate current speed when speed is decreasing by given amount.
     * @param amount of decrementSpeed.
     */
    protected void decrementSpeed(double amount){
        if(speedFactor() < 0) {
            throw new RuntimeException("speedFactor is lower than 0!");
        }
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    /**
     * Method to determine incrementSpeed. Amount may only accept value between 0 and 1.
     * @param amount of gas.
     */
    public void gas(double amount){
        if(amount < 0)
            amount = 0;
        else if(amount > 1)
            amount = 1;
        incrementSpeed(amount);
    }
    /**
     * Method to determine decrementSpeed. Amount may only accept value between 0 and 1.
     * @param amount of brake.
     */
    public void brake(double amount){
        if(amount < 0)
            amount = 0;
        else if(amount > 1)
            amount = 1;
        decrementSpeed(amount);
    }

}
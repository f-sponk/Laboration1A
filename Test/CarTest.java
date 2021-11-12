import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;


public class CarTest {

    private Volvo240 volvo;
    private Saab95 saab;

    @Before
    public void init() {
        volvo = new Volvo240();
        saab = new Saab95();
    }
    @Test
    public void testProperties() {
        volvo.setColor(Color.RED);
        assertEquals(Color.RED, volvo.getColor());
        assertEquals(4, volvo.getNrDoors());
        assertEquals(0, volvo.position.getX(), 0.00001);
        assertEquals(0, volvo.position.getX(), 0.00001);
        assertEquals(100, volvo.getEnginePower(), 0.00001);
        assertEquals(0, volvo.getCurrentSpeed(), 0.00001);
        assertEquals("Volvo240", volvo.modelName);
    }

    @Test
    public void testStartEngine() {
        volvo.startEngine();
        saab.startEngine();
        assertEquals(volvo.getCurrentSpeed(), 0.1, 0.0001);
        assertEquals(saab.getCurrentSpeed(), 0.1,0.0001);
    }

    @Test
    public void testMovementCar() {
        volvo.startEngine();
        volvo.move();

        assertEquals(0.1,volvo.getPosition().getY(),0.0001);volvo.turnLeft();
        for(int i = 0; i < 2; i++) {
            volvo.move();
        }
        assertEquals(-0.2,volvo.getPosition().getX(),0.0001);
        for(int i = 0; i < 2; i++) {
            volvo.turnRight();
        }
        volvo.move();
        assertEquals(-0.1,volvo.getPosition().getX(),0.0001);
        volvo.turnRight();
        volvo.move();
        assertEquals(0.0,volvo.getPosition().getY(),0.0001);


    }

    @Test
    public void speedTestVolvo(){
        volvo.startEngine();
        volvo.gas(0.7);
        volvo.brake(0.5);
        assertEquals(0.35,volvo.getCurrentSpeed(), 0.0001);
    }
    @Test
    public void speedTestSaab(){
        saab.startEngine();
        saab.setTurboOn();
        saab.gas(0.4);
        saab.brake(0.2);
        assertEquals(0.425,saab.getCurrentSpeed(),0.0001);
        saab.setTurboOff();
        saab.stopEngine();
        saab.gas(0.4);
        saab.brake(0.2);
        assertEquals(0.25,saab.getCurrentSpeed(),0.0001);

    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {

    private Point point;

    @BeforeEach

    public void setUp() {
        point = new Point();
    }

    @Test
    public void testCheckTrueCondition1() {
        // Test when point is inside the blue area, expecting "True"
        point.setX(-1);  // Set x-coordinate
        point.setY(-1);  // Set y-coordinate
        point.setR(4);   // Set radius
        point.check();   // Call the check method
        assertEquals("True", point.getRes());  // Assert the result is True
    }
    //true as expected

    @Test
    public void testCheckTrueCondition2() {
        // Another test case for when point is inside the blue area
        point.setX(1);   // Set x-coordinate
        point.setY(-1);  // Set y-coordinate
        point.setR(5);   // Set radius
        point.check();
        assertEquals("True",point.getRes());// Call the check method
    }

    @Test
    public void testCheckFalseCondition() {
        // Test when point is outside the blue area, expecting "False"
        point.setX(2);  // Set x-coordinate
        point.setY(2);  // Set y-coordinate
        point.setR(2);  // Set radius
        point.check();  // Call the check method
        assertEquals("False", point.getRes());  // Assert the result is False
    }

    @Test
    public void testCheckBoundaryCondition() {
        // Test for boundary condition, where point is on the border (edge case)
        point.setX(0);   // Set x-coordinate
        point.setY(0);   // Set y-coordinate
        point.setR(2);   // Set radius
        point.check();   // Call the check method
        assertEquals("True", point.getRes());  // Assert the result is True
    }
}

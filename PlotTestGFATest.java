package Assignment4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestGFATest {

    private Plot plot1, plot2, plot3, plot4;

    @BeforeEach
    public void setUp() {
        // Create some plot objects for testing
        plot1 = new Plot(1, 1, 2, 2);
        plot2 = new Plot(2, 1, 2, 2);
        plot3 = new Plot(4, 1, 2, 2);
        plot4 = new Plot(1, 1, 3, 3);
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot2)); // plot2 overlaps the right side of plot1
        assertFalse(plot1.overlaps(plot3)); // plot3 does not overlap plot1
    }

    @Test
    public void testEncompasses() {
        assertTrue(plot1.encompasses(plot4)); // plot4 is encompassed by plot1
        assertFalse(plot2.encompasses(plot4)); // plot4 is not encompassed by plot2
    }

    @Test
    public void testGetters() {
        assertEquals(1, plot1.getX());
        assertEquals(1, plot1.getY());
        assertEquals(2, plot1.getWidth());
        assertEquals(2, plot1.getDepth());
    }

    @Test
    public void testSetters() {
        plot1.setX(3);
        plot1.setY(4);
        plot1.setWidth(5);
        plot1.setDepth(6);

        assertEquals(3, plot1.getX());
        assertEquals(4, plot1.getY());
        assertEquals(5, plot1.getWidth());
        assertEquals(6, plot1.getDepth());
    }
}

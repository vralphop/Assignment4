package Assignment4;

public class Plot {
    
    private int x;
    private int y;
    private int width;
    private int depth;

    
    public Plot() {
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.getX(), otherPlot.getY(), otherPlot.getWidth(), otherPlot.getDepth());
    }

    
    public boolean overlaps(Plot plot) {
        
        return (x < plot.getX() + plot.getWidth() &&
                x + width > plot.getX() &&
                y < plot.getY() + plot.getDepth() &&
                y + depth > plot.getY());
    }

    public boolean encompasses(Plot plot) {
        
        return (x <= plot.getX() &&
                x + width >= plot.getX() + plot.getWidth() &&
                y <= plot.getY() &&
                y + depth >= plot.getY() + plot.getDepth());
    }

    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    @Override
    public String toString() {
       
        return x + "," + y + "," + width + "," + depth;
    }
}

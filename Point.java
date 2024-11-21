public class Point {
    private int x;
    private int y;

    public Point(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }

    @Override public String toString() {
        return "{" + x + "; " + y + "}";
    }
}

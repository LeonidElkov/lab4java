public class Point3D extends Point {
    private int z;

    public Point3D(double x, double y, double z) {
        super(x, y); // Вызов конструктора родительского класса Point
        this.z = (int) z; // Приведение z к int
    }

    @Override
    public String toString() {
        return super.toString() + "; " + z + "}"; // Вызов toString родительского класса и добавление z
    }
}

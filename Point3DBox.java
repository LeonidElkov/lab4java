public class Point3DBox {
    public static void addPointToBox(Box<? super Point3D> box, double x, double y, double z) {
        Point3D point = new Point3D(x, y, z);
        box.put(point);
        System.out.println("Добавлена точка: " + point);
    }

    public static void execute() {
        Box<Point3D> point3DBox = new Box<>();

        // Добавляем точку в коробку
        addPointToBox(point3DBox, 1.5, 2.5, 3.5);

        // Проверяем содержимое коробки
        Point3D retrievedPoint = point3DBox.get();
        System.out.println("Извлеченная точка: " + retrievedPoint);
    }
}

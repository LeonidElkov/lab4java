import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private int[] grades;

    // Конструктор
    public Student(String name, int... grades) {
        this.name = name;
        setGrades(grades);
    }

    // Метод для установки оценок с проверкой на диапазон
    private void setGrades(int... grades) {
        for (int grade : grades) {
            if (grade < 2 || grade > 5) {
                System.out.println("Ошибка: Оценка должна быть в диапазоне от 2 до 5.");
                this.grades = null; // Устанавливаем grades в null, чтобы избежать использования некорректных данных
                return; // Завершаем выполнение метода, если оценка некорректна
            }
        }
        this.grades = Arrays.copyOf(grades, grades.length);
    }

    // Метод для вычисления средней оценки
    public double getAverageGrade() {
        if (grades == null || grades.length == 0) {
            return 0; // Если нет оценок, возвращаем 0
        }
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    // Геттер для имени студента
    public String getName() {
        return name;
    }

    // Реализация метода compare из интерфейса Comparable
    @Override
    public int compare(Student otherStudent) {
        double thisAverage = this.getAverageGrade();
        double otherAverage = otherStudent.getAverageGrade();

        if (thisAverage > otherAverage) {
            return 1;
        } else if (thisAverage < otherAverage) {
            return -1;
        } else {
            return 0;
        }
    }

    // Метод toString
    @Override
    public String toString() {
        if (grades == null) {
            return name + ": нет оценок"; // Сообщение о том, что оценок нет
        }
        return name + ": " + Arrays.toString(grades);
    }
}

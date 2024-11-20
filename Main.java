import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("Выберите действие от 0 до 5: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ошибка! Введите целое число: ");
                scanner.next();
            }
            int d = scanner.nextInt();
            if (d < 0 || d > 5) {
                System.out.println("Введено неверное значение!");
                continue;
            }
            switch (d) {
                case 0:
                    System.out.println("Программа завершена.");
                    return;
                case 1:
                    Scanner scanner1 = new Scanner(System.in);

                    // Ввод количества студентов
                    System.out.print("Введите количество студентов: ");
                    int numberOfStudents = Integer.parseInt(scanner1.nextLine());

                    Student[] students = new Student[numberOfStudents];

                    for (int i = 0; i < numberOfStudents; i++) {
                        System.out.print("Введите имя студента: ");
                        String name = scanner1.nextLine();

                        System.out.print("Введите оценки (через пробел): ");
                        String[] gradesInput = scanner1.nextLine().split(" ");
                        int[] grades = new int[gradesInput.length];

                        // Проверка на корректность ввода оценок
                        boolean validGrades = true;
                        for (int j = 0; j < gradesInput.length; j++) {
                            try {
                                grades[j] = Integer.parseInt(gradesInput[j]);
                                if (grades[j] < 2 || grades[j] > 5) {
                                    System.out.println("Ошибка: Оценка должна быть в диапазоне от 2 до 5.");
                                    validGrades = false;
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: Введите корректное число для оценки.");
                                validGrades = false;
                                break;
                            }
                        }
                        if (validGrades) {
                            students[i] = new Student(name, grades);
                        } else {
                            System.out.println("Студент не был добавлен из-за некорректных оценок.");
                            i--; // Уменьшаем счетчик, чтобы повторить ввод для этого студента
                        }
                    }

                    // Вывод информации о студентах
                    System.out.println("\nИнформация о студентах:");
                    for (Student student : students) {
                        if (student != null) {
                            System.out.println(student);
                        }
                    }

                    // Создание двух студентов для сравнения
                    if (students.length >= 2) {
                        Student student1 = students[0];
                        Student student2 = students[1];

                        // Сравнение студентов
                        int comparisonResult = student1.compare(student2);
                        System.out.println("Результат сравнения: " + comparisonResult);
                        if (comparisonResult > 0) {
                            System.out.println(student1.getName() + " имеет более высокую среднюю оценку, чем " + student2.getName());
                        } else if (comparisonResult < 0) {
                            System.out.println(student1.getName() + " имеет более низкую среднюю оценку, чем " + student2.getName());
                        } else {
                            System.out.println(student1.getName() + " и " + student2.getName() + " имеют одинаковую среднюю оценку.");
                        }
                    } else {
                        System.out.println("Недостаточно студентов для сравнения.");
                    }
                    scanner1.close();
                    break;

                case 2:
                    Point3DBox.execute();
                    break;

                case 3:
                    //Применяем метод к списку строк, получая длины строк
                    List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
                    List<Integer> lengths = CollectionUtils.map(strings, String::length);
                    System.out.println("Длины строк: " + lengths);

                    //Применяем метод к списку целых чисел, получая их абсолютные значения
                    List<Integer> numbers = Arrays.asList(1, -3, 7);
                    List<Integer> absoluteValues = CollectionUtils.map(numbers, Math::abs);
                    System.out.println("Абсолютные значения: " + absoluteValues);

                    //Применяем метод к списку массивов целых чисел, получая максимальные значения
                    List<int[]> arrays = Arrays.asList(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{4, 5, 6});
                    List<Integer> maxValues = CollectionUtils.map(arrays, arr -> Arrays.stream(arr).max().orElseThrow());
                    System.out.println("Максимальные значения: " + maxValues);
                    break;

                case 4:
                    //Фильтруем строки, оставляя только те, которые имеют 3 или более символов
                    List<String> strings2 = Arrays.asList("qwerty", "asdfg", "zx");
                    List<String> filteredStrings = CollectionUtils2.filter(strings2, s -> s.length() >= 3);
                    System.out.println("Отфильтрованные строки: " + filteredStrings);

                    //Фильтруем целые числа, оставляя только отрицательные
                    List<Integer> numbers2 = Arrays.asList(1, -3, 7);
                    List<Integer> filteredNumbers = CollectionUtils2.filter(numbers2, n -> n < 0);
                    System.out.println("Отфильтрованные числа: " + filteredNumbers);

                    //Фильтруем массивы целых чисел, оставляя только те, которые не содержат положительных элементов
                    List<int[]> arrays2 = Arrays.asList(new int[]{1, 2, 3}, new int[]{-1, -2, -3}, new int[]{0, 0, 0}, new int[]{-4, -5});
                    List<int[]> filteredArrays = CollectionUtils2.filter(arrays2, arr -> Arrays.stream(arr).allMatch(n -> n <= 0));

                    //Для вывода массивов
                    System.out.print("Отфильтрованные массивы: ");
                    for (int[] array : filteredArrays) {
                        System.out.print(Arrays.toString(array) + " ");
                    }
            }
            break;
        }
            }
        }

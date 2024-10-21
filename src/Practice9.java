import java.util.Comparator;
public class Practice9 {
    public static class Student {
        private String name;
        private double GPA;

        public Student(String name, double GPA) {
            this.name = name;
            this.GPA = GPA;
        }

        public String getName() {
            return name;
        }

        public double getGPA() {
            return GPA;
        }
    }

    public static class SortingStudentsByGPA implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if (s1.getGPA() > s2.getGPA()) {
                return 1;
            } else if (s1.getGPA() < s2.getGPA()) {
                return -1;
            }
            return 0;
        }

        public void quickSort(Student[] students, int low, int high) {
            if (low < high) {
                int pi = partition(students, low, high);
                quickSort(students, low, pi - 1);
                quickSort(students, pi + 1, high);
            }
        }

        private int partition(Student[] students, int low, int high) {
            double pivot = students[high].getGPA();
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (compare(students[j], students[high]) >= 0) {
                    i++;
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
            Student temp = students[i + 1];
            students[i + 1] = students[high];
            students[high] = temp;
            return i + 1;
        }
    }
    public static void main(String[] args) {
        Student[] students = new Student[]{new Student("Dasha", 5.0), new Student("Jack", 4.1), new Student("Kate", 3.0), new Student("Alex", 4.7)};

        SortingStudentsByGPA sorter = new SortingStudentsByGPA();
        sorter.quickSort(students, 0, students.length - 1);

        for (Student student : students) {
            System.out.println(student.getName() + ": " + student.getGPA());
        }
    }

}
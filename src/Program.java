import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static java.util.Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        boolean quit = false;

        mainloop:
        while (!quit) {
            System.out.println(
                    "1) Add teacher\n" +
                    "2) Add student\n" +
                    "3) Show all people\n" +
                    "4) Show all teachers\n" +
                    "5) Show all students\n" +
                    "6) Show teacher by ID\n" +
                    "7) Show student by ID\n" +
                    "8) Show students by score range\n" +
                    "0) Quit\n" +
                    "Choose action: "
            );
            int action = scan.nextInt();
            scan.nextLine();
            switch (action) {
                case 1:
                    Teacher temp_teacher = new Teacher();
                    temp_teacher.input(scan);
                    people.add(temp_teacher);
                    System.out.println();
                    break;
                case 2:
                    Student temp_student = new Student();
                    temp_student.input(scan);
                    people.add(temp_student);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("People: \n");
                    for (Object person : people) {
                        System.out.println(person.toString() + "\n");
                    }
                    break;
                case 4:
                    System.out.println("Teachers: \n");
                    for (Object person : people) {
                        if (person instanceof Teacher) {
                            System.out.println(person.toString() + "\n");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Students: \n");
                    for (Object person : people) {
                        if (person instanceof Student) {
                            System.out.println(person.toString() + "\n");
                        }
                    }
                    break;
                case 6:
                    System.out.println("ID to search: ");
                    String teacher_id = scan.nextLine();
                    for (Object person : people) {
                        if (person instanceof Teacher) {
                            if (teacher_id.equals(((Teacher) person).id)) {
                                System.out.println(person.toString() + "\n");
                                continue mainloop;
                            }
                        }
                        else if (person instanceof Student) {
                            if (teacher_id.equals(((Student) person).id)) {
                                System.out.println("Not a teacher");
                                continue mainloop;
                            }
                        }
                    }
                    System.out.println("Doesn't exist");
                    break;
                case 7:
                    System.out.println("ID to search: ");
                    String student_id = scan.nextLine();
                    for (Object person : people) {
                        if (person instanceof Teacher) {
                            if (student_id.equals(((Teacher) person).id)) {
                                System.out.println("Not a student");
                                continue mainloop;
                            }
                        }
                        else if (person instanceof Student) {
                            if (student_id.equals(((Student) person).id)) {
                                System.out.println(person.toString() + "\n");
                                boolean quit2 = false;
                                while (!quit2) {
                                    System.out.println(
                                            "1) Show all scores\n" +
                                            "2) Insert a new score\n" +
                                            "3) Show average score\n" +
                                            "4) Return to main menu\n"
                                    );
                                    int action2 = scan.nextInt();
                                    scan.nextLine();
                                    switch (action2) {
                                        case 1:
                                            for (Score score : ((Student) person).scores) {
                                                System.out.println(
                                                        ((Student) person).scores.indexOf(score) +
                                                        " " + score.getCourse() + " " + score.getValue()
                                                );
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter course name: ");
                                            String course_name = scan.nextLine();
                                            System.out.println("Enter score: ");
                                            double score_value = scan.nextDouble();
                                            Score temp = new Score();
                                            temp.setCourse(course_name);
                                            temp.setValue(score_value);
                                            ((Student) person).scores.add(temp);
                                            break;
                                        case 3:
                                            System.out.println("Average score: " +
                                                                ((Student) person).getAverageScore());
                                            break;
                                        case 4:
                                            quit2 = true;
                                        default:
                                            System.out.println("Invalid option. Please try again");
                                    }
                                }
                                continue mainloop;
                            }
                        }
                    }
                    System.out.println("Doesn't exist");
                    break;
                case 8:
                    System.out.println("Enter minimum score: ");
                    double min_score = scan.nextDouble();
                    System.out.println("Enter maximum score: ");
                    double max_score = scan.nextDouble();
                    ArrayList<Student> students_in_range = new ArrayList<>();
                    for (Object person : people) {
                        if (person instanceof Student) {
                            if ((min_score <= ((Student) person).getAverageScore()) &&
                                    (((Student) person).getAverageScore() <= max_score)) {
                                students_in_range.add((Student)person);
                            }
                        }
                    }
                    System.out.println(
                            "Students with average score between " +
                            min_score + " and " + max_score + ": \n");
                    for (Student student : students_in_range) {
                        System.out.println(student.toString() + "\n");
                    }
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");

            }
        }
    }
}
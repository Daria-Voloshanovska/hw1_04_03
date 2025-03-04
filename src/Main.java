import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Programmer> programmers = new ArrayList<>();
        programmers.add(new Programmer("John", "Berlin", List.of(
                new Task(1, "Fix bug", "In progress", 10),
                new Task(2, "Write tests", "Done", 3))));
        programmers.add(new Programmer("John", "Berlin", List.of(
                        new Task(3, "Refactor code", "Done", 7),
                        new Task(4, "Deploy application", "In Progress", 2))));
                programmers.add(new Programmer("Charlie", "Munich", List.of(
                        new Task(5, "Code review", "In Progress", 6))));


        List<Task> filteredTasks = programmers.stream()
                .filter(p -> "Berlin".equals(p.getCity()))
                .flatMap(p -> p.getTasks().stream())
                .filter(task -> !"Done".equalsIgnoreCase(task.getStatus()) && task.getDaysInProcessing() > 5)
                .toList();
        filteredTasks.forEach(s -> System.out.println(s));

        List<Task> allTasks = getAllTasks(programmers);

        allTasks.forEach(task -> System.out.println(
                "Task " + task.getNumber() + " : " + task.getDescription() + " (" + task.getStatus() + ", " + task.getDaysInProcessing() + " days)"
        ));
    }

    public static List<Task> getAllTasks(List<Programmer> p) {
        return p.stream()
                .flatMap(list -> list.getTasks().stream())
                .toList();
    }
}
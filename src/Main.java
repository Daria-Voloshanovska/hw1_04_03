import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

List<Programmer> programmers  = new ArrayList<>();
        programmers .add(new Programmer("John","London",List.of(
        new Task(1,"Fix bug","In progress",3),
        new Task(2,"Write tests","To Do", 0))));
        programmers .add(new Programmer("John","Rio",List.of(
        new Task(3,"Review code","Done",5),
        new Task(4,"Deploy application","In Progress",2)
)));

List<Task> allTasks = getAllTasks(programmers);

allTasks.forEach(task -> System.out.println(
        "Task " + task.getNumber() + " : " + task.getDescription() + " (" + task.getStatus() + ", " + task.getDaysInProcessing() + " days)"
));
    }
public static List<Task> getAllTasks(List<Programmer> p){
        return p.stream()
                .flatMap(list -> list.getTasks().stream())
                .toList();
}
}
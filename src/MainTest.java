import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MainTest {

    private List<Programmer> programmers;

    @BeforeEach
    void setUp() {
        programmers  = new ArrayList<>();
        programmers .add(new Programmer("John","Berlin",List.of(
                new Task(1,"Fix bug","In progress",10),
                new Task(2,"Write tests","To Do", 0))));
        programmers .add(new Programmer("John","Berlin",List.of(
                new Task(3,"Refactor code","Done",7),
                new Task(4,"Deploy application","In Progress",2)
        )));
        programmers.add(new Programmer("Charlie", "Munich", List.of(
                new Task(5, "Code review", "In Progress", 6)
        )));
    }

    @Test
    void getAllTasks() {
        List<Task> allTasks = Main.getAllTasks(programmers);
        Assertions.assertFalse(allTasks.isEmpty());
        assertEquals(5, allTasks.size());

        Task firstTask = allTasks.get(0);
        Assertions.assertAll(
                () -> assertEquals(1, firstTask.getNumber()),
                () -> assertEquals("Fix bug", firstTask.getDescription()),
                () -> assertEquals("In progress", firstTask.getStatus()),
                () -> assertEquals(10, firstTask.getDaysInProcessing()));

        Task lastTask = allTasks.get(4);
        Assertions.assertAll(
                () -> assertEquals(5, lastTask.getNumber()),
                () -> assertEquals("Code review", lastTask.getDescription()),
                () -> assertEquals("In Progress", lastTask.getStatus()),
                () -> assertEquals(6, lastTask.getDaysInProcessing()));
    }
    @Test
    void filteredTasks(){
        List<Task> filteredTasks = programmers.stream()
                .filter(p -> "Berlin".equals(p.getCity()))
                .flatMap(p -> p.getTasks().stream())
                .filter(task -> !"Done".equalsIgnoreCase(task.getStatus()) && task.getDaysInProcessing() > 5)
                .toList();

        Assertions.assertFalse(filteredTasks.isEmpty());
        Assertions.assertEquals(1, filteredTasks.size());

        Task firstFilteredTask = filteredTasks.get(0);
        Assertions.assertAll(
                () -> assertEquals(1, firstFilteredTask.getNumber()),
                () -> assertEquals("Fix bug", firstFilteredTask.getDescription()),
                () -> assertEquals("In progress", firstFilteredTask.getStatus()),
                () -> assertEquals(10, firstFilteredTask.getDaysInProcessing()));
    }
    }

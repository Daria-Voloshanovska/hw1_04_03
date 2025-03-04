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
        programmers .add(new Programmer("John","London",List.of(
                new Task(1,"Fix bug","In progress",3),
                new Task(2,"Write tests","To Do", 0))));
        programmers .add(new Programmer("John","Rio",List.of(
                new Task(3,"Review code","Done",5),
                new Task(4,"Deploy application","In Progress",2)
        )));
    }

    @Test
    void getAllTasks() {
        List<Task> allTasks = Main.getAllTasks(programmers);
        Assertions.assertFalse(allTasks.isEmpty());
        assertEquals(4, allTasks.size());

        Task firstTask = allTasks.get(0);
        Assertions.assertAll(
                () -> assertEquals(1, firstTask.getNumber()),
                () -> assertEquals("Fix bug", firstTask.getDescription()),
                () -> assertEquals("In progress", firstTask.getStatus()),
                () -> assertEquals(3, firstTask.getDaysInProcessing()));

        Task lastTask = allTasks.get(3);
        Assertions.assertAll(
                () -> assertEquals(4, lastTask.getNumber()),
                () -> assertEquals("Deploy application", lastTask.getDescription()),
                () -> assertEquals("In Progress", lastTask.getStatus()),
                () -> assertEquals(2, lastTask.getDaysInProcessing()));
    }
}
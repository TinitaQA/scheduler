import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void shouldFindAnswerForQueryInEpicTrue() {
        String[] subtasks = {"Почитать книгу", "Сделать задание", "Посмотреть фильм"};
        Task epic = new Epic(3, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("фильм");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAnswerForQueryInEpicFalse() {
        String[] subtasks = {"Почитать книгу", "Сделать задание", "Посмотреть фильм"};
        Task epic = new Epic(3, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("филм");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAnswerForQueryInSimpleTaskTrue() {
        Task simpleTask = new SimpleTask(3,  "Посмотреть любимый фильм");

        boolean expected = true;
        boolean actual = simpleTask.matches("любимый");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAnswerForQueryInSimpleTaskFalse() {
        Task simpleTask = new SimpleTask(3,  "Посмотреть любимый фильм");

        boolean expected = false;
        boolean actual = simpleTask.matches("нелюбимый");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAnswerForQueryInMeetingTrue() {
        Task meeting = new Meeting(777,  "Темы представленных работ", "Арт-прокачка", "В пятницу после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Арт");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindAnswerForQueryInMeetingFalse() {
        Task meeting = new Meeting(777,  "Темы представленных работ", "Арт-прокачка", "В пятницу после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("арт");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldGetId() {

        Task task = new Task(777);

        int expected = 777;
        int actual = task.getId();
        Assertions.assertEquals(expected, actual);
    }
}

import by.zinovich.three.tv.programs.*;
import by.zinovich.three.tv.tvdirector.Director;
import by.zinovich.three.tv.tvdirector.Programs;
import org.junit.*;
import org.junit.jupiter.api.DisplayName;

import java.lang.annotation.Repeatable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class DirectorTest {
    private static Director director;
    private static TodaysProgram todaysProgram;

    @BeforeClass
    public static void setUp()   {
        director = new Director(21, "Максим");
        try {
            TVProgram tp1 = new News("Вечер с Соловьём Владимировым", 15);
            TVProgram tp2 = new Adds("Собачий корм", 3);
            TVProgram tp3 = new Adds("Кошачий корм \"Феникс\"", 2);
            TVProgram tp4 = new Cartoons("Бубка Гоб", 25);
            todaysProgram = new TodaysProgram();
            todaysProgram.programList.add(tp1);
            todaysProgram.programList.add(tp2);
            todaysProgram.programList.add(tp3);
            todaysProgram.programList.add(tp4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 500)
    public void findLongestProgram() throws Exception  {
        TVProgram actualTvProgram = director.FindLongestProgram(todaysProgram);
        TVProgram expectedTvProgram = new Cartoons("Бубка Гоб", 25);
        assertEquals(actualTvProgram.toString(), expectedTvProgram.toString());
        System.out.println("findLongestProgram test");
    }

    @Test
    public void searchProgramByType() throws Exception  {
        List<TVProgram> actualTvPrograms = director.SearchProgramByType(todaysProgram, Programs.Adds);
        List<TVProgram> expectedTvPrograms = new ArrayList<>();
        expectedTvPrograms.add(new Adds("Собачий корм", 3));
        expectedTvPrograms.add(new Adds("Кошачий корм \"Феникс\"", 2));

        assertEquals(actualTvPrograms.toString(), expectedTvPrograms.toString());
        System.out.println("searchProgramByType test");
    }

    @Test
    public void programTableDuration() throws Exception  {
        int actualDuration = director.ProgramTableDuration(todaysProgram);
        int expectedDuration = 15 + 3 + 2 + 25;
        assertEquals(actualDuration, expectedDuration);
        System.out.println("programTableDuration test");
    }

    @Ignore("Test undone")
    @Test
    public void sortProgramTable() throws Exception  {
        Assert.fail("sortProgramTable test");
    }

    @AfterClass
    public static void afterclass()
    {
        System.out.println("@AfterClass");
    }

    @Before
    public void text() {
        System.out.println("---------------------------------------------");
    }
}
import by.zinovich.three.tv.programs.*;
import by.zinovich.three.tv.tvdirector.Director;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class PDirectorTest {
    private TodaysProgram TP;
    private int expectedDuration;

    private static TodaysProgram todaysProgram1  = new TodaysProgram();
    private static TodaysProgram todaysProgram2 = new TodaysProgram();

    @BeforeClass
    public static void setUp() throws Exception {
        todaysProgram1.programList.add(new News("Вести", 14));
        todaysProgram1.programList.add(new Cartoons("Бубка гоб", 25));
        todaysProgram1.programList.add(new Adds("Реклама 1", 4));

        todaysProgram2.programList.add(new News("Вести2", 16));
        todaysProgram2.programList.add(new Cartoons("Бубка гоб2", 30));
        todaysProgram2.programList.add(new Adds("Реклама2", 2));
    }

    public PDirectorTest(TodaysProgram TPs, int expectedDuration) {
        this.TP = TPs;
        this.expectedDuration = expectedDuration;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                        {todaysProgram1, 43},
                        {todaysProgram2, 48}
                }
        );
    }

    @Test
    public void findLongestProgram() {
        Director d = new Director(1, "Dir");
        int expected =  expectedDuration;
        int actual = d.ProgramTableDuration(TP);
        assertEquals(expected, actual);
        System.out.println("findLongestProgram test");
    }
}
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class FrameTest {
    @Test
    public void frameCreationTest()
    {
        Frame f = new Frame("Chaiporn");
        assertEquals(f.name, "Chaiporn");
        assertEquals(f.scores, new ArrayList<Integer>());
    }

    @Test
    public void scoreInsertionTest()
    {
        Frame f = new Frame("sssss");
        f.throwBall(2);
        f.throwBall(5);
        assertEquals(f.scores, new ArrayList<>(Arrays.asList(2, 5)));
        f.throwBall(10);
        assertEquals(f.scores, new ArrayList<>(Arrays.asList(2, 5, 10, 0)));
        f.throwBall(1);
        f.throwBall(9);
        assertEquals(f.scores, new ArrayList<>(Arrays.asList(2, 5, 10, 0, 1, 9)));
    }

    @Test
    public void getScoreTest(){
        Frame f = new Frame("Jittat");
        assertEquals(f.getScore(), 0);
        f.throwBall(1);
        f.throwBall(4);
        assertEquals(f.getScore(), 5);
        f.throwBall(4);
        f.throwBall(5);
        assertEquals(f.getScore(), 14);
        f.throwBall(6);
        f.throwBall(4);
        // assertEquals(f.getScore(), 29);
        f.throwBall(5);
        f.throwBall(5);
        // assertEquals(f.getScore(), 49);
        f.throwBall(10);
        // assertEquals(f.getScore(), 60);
        f.throwBall(0);
        f.throwBall(1);
        // assertEquals(f.getScore(), 61);
        f.throwBall(7);
        f.throwBall(3);
        f.throwBall(6);
        f.throwBall(4);
        f.throwBall(10);
        f.throwBall(2);
        f.throwBall(8);
        f.throwBall(6);
        assertEquals(f.getScore(), 133);
    }
}
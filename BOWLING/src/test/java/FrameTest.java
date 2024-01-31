import org.example.entity.Frame;
import org.example.entity.Launch;
import org.example.entity.BowlingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class FrameTest {
    private Frame frame;
    @Mock
    private Launch launch;

    @Test
    void normalLaunch() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(3);
        frame = new Frame(launch,0);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(7)).thenReturn(3);
        frame.throwBall();
        Assertions.assertEquals(6, frame.getScore());
    }

    @Test
    void strikeCantLaunch2Time() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(10);
        frame = new Frame(launch,0);
        frame.throwBall();
        Assertions.assertThrowsExactly(BowlingException.class,()->frame.throwBall());
    }

    @Test
    void strikeWith2NormalLaunchOnTheLastFrame() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(10);
        frame = new Frame(launch,10);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(10)).thenReturn(4);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(6)).thenReturn(5);
        frame.throwBall();
        Assertions.assertEquals(19, frame.getScore());
    }

    @Test
    void spareWithNormalLaunch() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(5);
        frame = new Frame(launch,10);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(5)).thenReturn(5);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(10)).thenReturn(4);
        frame.throwBall();
        Assertions.assertEquals(14, frame.getScore());
    }

    @Test
    void strike2TimeWithNormalLaunch() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(10);
        frame = new Frame(launch,10);
        frame.throwBall();
        frame.throwBall();
        Mockito.when(launch.generateLaunch(10)).thenReturn(4);
        frame.throwBall();
        Assertions.assertEquals(24, frame.getScore());
    }

    @Test
    void finalRoundWith3Strike() {
        Mockito.when(launch.generateLaunch(10)).thenReturn(10);
        frame = new Frame(launch,10);
        frame.throwBall();
        frame.throwBall();
        frame.throwBall();
        Assertions.assertEquals(30, frame.getScore());

    }

    @Test
    void finalRoundWithSpareAndStrike() {
        frame = new Frame(launch, 10);
        Mockito.when(launch.generateLaunch(10)).thenReturn(5);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(5)).thenReturn(5);
        frame.throwBall();
        Mockito.when(launch.generateLaunch(10)).thenReturn(10);
        frame.throwBall();
        Assertions.assertEquals(20, frame.getScore());

    }
}

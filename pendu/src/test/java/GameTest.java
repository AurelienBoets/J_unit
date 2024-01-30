import org.example.entity.Game;
import org.example.entity.Word;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class GameTest {
    private Game game;
    @Mock
    private Word word;


    @BeforeEach
    void setUp() {
        Mockito.when(word.getValue()).thenReturn("google");
        game = new Game(word);
    }

    @Test
    void charInTheWord() {
        Assertions.assertTrue(game.attempt('o'));
    }

    @Test
    void charNotInTheWord() {
        Assertions.assertFalse(game.attempt('z'));
    }


    @Test
    void winGameWithManySameChar() {
        Mockito.when(word.getValue()).thenReturn("zoo");
        game = new Game(word);
        game.attempt('z');
        game.attempt('o');
        Assertions.assertTrue(game.isWin());
    }

    @Test
    void gameContinue() {
        game.attempt('b');
        Assertions.assertFalse(game.isWin());
    }

    @Test
    void getMask(){
        Assertions.assertEquals("------",game.getMask());
    }

    @Test
    void getMaskWith1Char(){
        game.attempt('e');
        Assertions.assertEquals("-----e",game.getMask());
    }
}

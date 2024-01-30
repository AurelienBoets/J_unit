package entity;

import org.example.model.Town;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TownTest {
    private Town town;


    @Test
    void noTown() {
        town = new Town();
        List<String> res = town.search("a");
        Assertions.assertTrue(res.isEmpty());
    }

    @Test
    void townSearchWith2Char() {
        town = new Town();
        List<String> res = town.search("Va");
        Assertions.assertEquals(Arrays.asList("Valence", "Vancouver"), res);
    }

    @Test
    void townSearchWithSpace() {
        town = new Town();
        List<String> res = town.search("Rott ");
        Assertions.assertEquals(List.of("Rotterdam"), res);
    }

    @Test
    void townSearchContain() {
        town = new Town();
        List<String> res = town.search("ape");
        Assertions.assertEquals(List.of("Budapest"), res);
    }

    @Test
    void townSearchAll() {
        town = new Town();
        List<String> res = town.search("*");
        Assertions.assertEquals(16, res.size());
    }
}

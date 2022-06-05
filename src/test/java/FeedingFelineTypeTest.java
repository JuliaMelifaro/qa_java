import com.example.Animal;
import com.example.Feline;
import com.example.Cat;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FeedingFelineTypeTest {


    @Test
    public void catFeedsAsPredator() {
        Feline testFeline = Mockito.mock(Feline.class);
        List<String> resProducts = List.of("Животные", "Птицы", "Рыба");
        Cat newCat = new Cat(testFeline);
        List<String> actualProducts = null;
        try {
            Mockito.when(testFeline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            actualProducts = newCat.getFood();
        } catch (Exception e) {
            System.out.println("This cat is broken");
        }
        assertEquals("Cat doesn't eat as feline", resProducts, actualProducts);
    }

    @Test
    public void lionFeedsAsPredator() {
        Animal testFeline = Mockito.mock(Feline.class);
        List<String> resProducts = List.of("Животные", "Птицы", "Рыба");
        List<String> actualProducts = null;
        Lion newLion;
        try {
            Mockito.when(testFeline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            newLion = new Lion((Feline) testFeline, "Самец");
            actualProducts = newLion.getFood();
        } catch (Exception e) {
            System.out.println("This lion is broken");
        }
        assertEquals("Lion doesn't eat as feline", resProducts, actualProducts);
    }
}

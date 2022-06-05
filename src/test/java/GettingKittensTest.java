import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

public class GettingKittensTest {

    @Test
    public void lionCanGetKittens() {
        Feline testFeline = Mockito.mock(Feline.class);
        int actualKittens = 0, expectedKittens = 1;
        Lion newLion;
        try {
            Mockito.when(testFeline.getKittens()).thenReturn(1);
            newLion = new Lion(testFeline, "Самец");
            actualKittens = newLion.getKittens();
        } catch (Exception e) {
            System.out.println("This lion is broken");
        }
        assertEquals("Lion has wrong amount of kittens", expectedKittens, actualKittens);
    }

    @Test
    public void felineCanGetSeveralKittens() {
        Feline feline = new Feline();
        int expectedKittens = (int)(Math.random()*5 + 2);
        int actualKittens = feline.getKittens(expectedKittens);
        assertEquals("Feline has wrong amount of kittens", expectedKittens, actualKittens);
    }

    @Test
    public void felineCanGetOneKitten() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Feline has wrong amount of kittens", expectedKittens, actualKittens);
    }
}

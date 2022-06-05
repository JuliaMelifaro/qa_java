import com.example.Feline;
import org.junit.Test;
import org.mockito.Mockito;
import com.example.Cat;
import static org.junit.Assert.assertEquals;

public class CatSoundTest {
    String catMustSay = "Мяу";

    @Test
    public void doesCatMeow(){
        Feline testFeline = Mockito.mock(Feline.class);
        Cat newCat = new Cat(testFeline);
        String catSaid = newCat.getSound();
        assertEquals("Cat doesn't sound right", catSaid, catMustSay);
    }
}

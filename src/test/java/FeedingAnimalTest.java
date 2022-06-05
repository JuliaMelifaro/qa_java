import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FeedingAnimalTest {

    private final String animalType;
    private final List<String> whatItEats;
    private final boolean resException;
    
    public FeedingAnimalTest(String animalType, List<String> whatItEats, boolean resException) {
        this.animalType = animalType;
        this.whatItEats = whatItEats;
        this.resException = resException;
    }
    
    @Parameterized.Parameters
    public static Object[] getLionData() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения"), false},
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), false},
                {"Гриб", null, true}
        };
    }
    
    @Test
    public void animalEatsAccordingToItType() {
        Animal testAnimal = new Animal();
        boolean isException = false;
        List<String> actuallyEats = null;
        try {
            actuallyEats = testAnimal.getFood(animalType);
        } catch (Exception e) {
            isException = true;
        }
        assertEquals("Not working correct with unknown animal", isException, resException);
        assertEquals("Don't feed according to it type", whatItEats, actuallyEats);
    }
}

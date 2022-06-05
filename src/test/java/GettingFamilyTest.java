import com.example.Animal;
import com.example.Feline;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettingFamilyTest {
    @Test
    public void felineFamilyIsCat() {
        String resultFamily = "Кошачьи";
        Feline testFeline = new Feline();
        String actualFamily = testFeline.getFamily();
        assertEquals("Feline has wrong family type", resultFamily, actualFamily);
    }

    @Test
    public void animalHasManyFamilyTypes() {
        String resultFamily = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        Animal testAnimal = new Animal();
        String actualFamily = testAnimal.getFamily();
        assertEquals("Animal has wrong family variations list", resultFamily, actualFamily);
    }
}

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Lion;
import com.example.Feline;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class HavingManeTest {
    private final String lionSex;
    private final boolean resultMane;
    private final boolean resException;

    public HavingManeTest(String lionSex, boolean resultMane, boolean resException) {
        this.lionSex = lionSex;
        this.resultMane = resultMane;
        this.resException = resException;
    }

    @Parameterized.Parameters
    public static Object[] getLionData() {
        return new Object[][] {
                {"Самец", true, false},
                {"Самка", false, false},
                {"Они", false, true}
        };
    }

    @Test
    public void havingManeDependsFromSex() {
        Feline testFeline = Mockito.mock(Feline.class);
        boolean isException = false, actualMane = false;
        Lion lionUnit;
        try {
            lionUnit = new Lion(testFeline, lionSex);
            actualMane = lionUnit.doesHaveMane();
        } catch (Exception e) {
            isException = true;
        }
        assertEquals("Not working correct with unknown sex", isException, resException);
        assertEquals("Having mane is not relate to sex", actualMane, resultMane);
    }

}



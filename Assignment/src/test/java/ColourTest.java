import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColourTest {
    @Test
    void createWhiteFromFloats(){
        Colour colour = new Colour(1.0f, 1.0f, 1.0f);
        Assertions.assertEquals("255, 255, 255", colour.getRGB());
    }

}

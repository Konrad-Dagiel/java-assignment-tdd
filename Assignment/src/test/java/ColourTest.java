import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class ColourTest {
    @Test
    void createWhiteFromFloats(){
        Colour colour = new Colour(1.0f, 1.0f, 1.0f);
        assertEquals("255, 255, 255", colour.getRGB());
    }

}

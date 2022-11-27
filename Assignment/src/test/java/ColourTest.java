import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ColourTest {
    @Test
    void onesShouldCreateWhite() throws IllegalArgumentException {
        Colour colour = new Colour(1.0f, 1.0f, 1.0f);
        Assertions.assertEquals("255, 255, 255", colour.getRGB());
    }
    @Test
    void inputsGreaterThanOneShouldThrowIllegalArgumentException(){
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Colour(1.1f, 1.1f, 1.1f)
        );
    }
    @Test
    void inputsLessThanZeroShouldThrowIllegalArgumentException(){
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Colour(-0.1f, -0.1f, -0.1f)
        );
    }
    @Test
    void input16777215ShouldCreateWhite(){
        Colour colour = new Colour(16777215);
        Assertions.assertEquals("255, 255, 255", colour.getRGB());
    }

    @Test
    void input16755455ShouldCreate255_170_255(){
        Colour colour = new Colour(16755455);
        Assertions.assertEquals("255, 170, 255", colour.getRGB());
    }
    @Test
    void input11184810ShouldCreate170_170_170(){
        Colour colour = new Colour(11184810);
        Assertions.assertEquals("170, 170, 170", colour.getRGB());
    }
    @Test
    void inputGreaterThan24BitsShouldThrowIllegalArgumentException(){
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Colour(16777216)
        );
    }

    @Test
    void inputLessThanZeroShouldThrowIllegalArgumentException(){
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Colour(-1)
        );
    }

    @Test
    void twoWhiteColoursShouldBeEqual(){
        Colour c1 = new Colour(1.0f,1.0f,1.0f);
        Colour c2 = new Colour(16777215);
        Assertions.assertEquals(c1, c2);
    }



}

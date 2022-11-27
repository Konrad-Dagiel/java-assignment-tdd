import java.util.Objects;

public class Colour {
    private final int red;
    private final int blue;
    private final int green;
    public Colour(float r, float g, float b) throws IllegalArgumentException {
        if (!((r>=0 && r <= 1) && (g >= 0 && g <= 1) && (b>=0 && b <=1))){
            throw new IllegalArgumentException("Values must be in range 0.0 - 1");
        }
        red = (int) (r*255);
        green = (int) (g*255);
        blue = (int) (b*255);
    }
    public Colour(int colourCode){
        if (colourCode > 16777215){
            throw new IllegalArgumentException("max 24 bits allowed");
        }
        if (colourCode < 0){
            throw new IllegalArgumentException("must be a positive integer");
        }
        red = extractBits(colourCode,1);
        green = extractBits(colourCode,9);
        blue = extractBits(colourCode,17);
    }
    public String getRGB(){
        return red+", " + green+", "+blue;
    }

    private int extractBits(int number, int position){
        return (((1 << 8) - 1) & (number >> (position - 1)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colour colour)) return false;
        return red == colour.red && blue == colour.blue && green == colour.green;
    }

}

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
        red = extractBits(colourCode,1,8);
        green = extractBits(colourCode,9,8);
        blue = extractBits(colourCode,17,8);
    }
    public String getRGB(){
        return red+", " + green+", "+blue;
    }

    private int extractBits(int number, int position, int bitsToExtract){
        return (((1 << bitsToExtract) - 1) & (number >> (position - 1)));
    }
}

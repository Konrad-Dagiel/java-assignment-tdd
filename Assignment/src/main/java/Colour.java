/**
 * Author: Konrad Dagiel
 * This class represents an RGB colour
 */
public class Colour {
    private final int red;
    private final int blue;
    private final int green;

    /**
     * This constructor instantiates a Colour with the help of three
     * floating point values which symbolize the intensity of each of the RGB colours.
     * @param r 0.0 - 1.0, the intensity of red in the Colour.
     * @param g 0.0 - 1.0, the intensity of blue in the Colour.
     * @param b 0.0 - 1.0, the intensity of green in the Colour.
     * @throws IllegalArgumentException if the floating point values are not in the range 0-1.
     */
    public Colour(float r, float g, float b) throws IllegalArgumentException {
        if (!((r>=0 && r <= 1) && (g >= 0 && g <= 1) && (b>=0 && b <=1))){
            throw new IllegalArgumentException("Values must be in range 0.0 - 1");
        }
        red = (int) (r*255);
        green = (int) (g*255);
        blue = (int) (b*255);
    }

    /**
     * This constructor instantiates a Colour with the help of one 24 bit integer.
     * Bits 16-23 are the red value, bits 8-15 are the green value, bits 0-7 are the red value.
     * @param colourCode 24 bit representation of the colour.
     * @throws IllegalArgumentException if the integer is negative or if the integer is >24 bits high.
     */
    public Colour(int colourCode) throws  IllegalArgumentException{
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

    /**
     * Returns a string representing the RGB value of the Colour.
     * @return a string containing the RGB values of the Colour in the order Red, Green, Blue.
     */
    public String getRGB(){
        return red+", " + green+", "+blue;
    }

    /**
     * Starting at the position specified, returns the next 8 bits (inclusive) of the given number.
     * @param number the integer representing the bit sequence.
     * @param position the position to start gathering 8 bits from.
     * @return the integer representation of the 8 bit sequence starting at position.
     */
    private int extractBits(int number, int position){
        return (((1 << 8) - 1) & (number >> (position - 1)));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Colour colour)) return false;
        return red == colour.red && blue == colour.blue && green == colour.green;
    }
    @Override
    public String toString(){
        return "RED: "+red+", GREEN: "+green+", BLUE: "+blue;
    }

}

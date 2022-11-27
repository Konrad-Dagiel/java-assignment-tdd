public class Colour {
    private final int red;
    private final int blue;
    private final int green;
    public Colour(float r, float g, float b){
        red = (int) (r*255);
        green = (int) (g*255);
        blue = (int) (b*255);
    }
    public String getRGB(){
        String RGBValue = red+", " + blue+", "+green;
        return RGBValue;
    }
}

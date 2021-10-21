package Engine;

import java.awt.Color;
import java.awt.Font;

public class Text extends GraphicObject{

    private String text; 
    private Color color;
    private Font font;

    public Text(Scene scene) {
        super(scene);
        text = "";
        color = Color.BLACK;
        font = new Font("Arial", Font.BOLD, 20);
        setRelative(true);
    }
    public Text(Scene scene, String text, int fontSize, Color color) {
        super(scene);
        this.text = text;
        this.color = color;
        font = new Font("Arial", Font.BOLD, fontSize);
        setRelative(true);
    }

    @Override
    public void render(RelativeGraphics relativeGraphics) {
        relativeGraphics.setColor(color);
        relativeGraphics.getGraphics().setFont(font);

        double fontWidth = relativeGraphics.getGraphics().getFontMetrics(font).stringWidth(text);

        if (this.getRelative()) {
            relativeGraphics.drawString(text, getGlobalX() - fontWidth/2, getGlobalY() + font.getSize()/2);
        }
        else {
            relativeGraphics.getGraphics().drawString(text, (int)(this.getGlobalX() - fontWidth/2), (int)(this.getGlobalY() + font.getSize()/2));
        }
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    
}

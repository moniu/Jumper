package Engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.awt.Image;

public class ResourceManager {
    HashMap<String,Image> loadedImages;
    public ResourceManager() {
        loadedImages = new HashMap<>();
    }
    public Image loadImage(String filename) {
        if (loadedImages.containsKey(filename)) {
            return loadedImages.get(filename);
        }
        try {
            File file = new File(filename);
            BufferedImage bufferedImage;
            bufferedImage = ImageIO.read(file);
            loadedImages.put(filename, bufferedImage);
            return bufferedImage;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

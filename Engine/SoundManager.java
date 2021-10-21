package Engine;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class SoundManager {
    private HashMap<String, Clip> clips;
    public SoundManager() {
        clips = new HashMap<>();
    }

    public void playSound(String filename) {
        Clip clip;
        if (!clips.containsKey(filename)) {
            preloadSound(filename);
        }
        clip = clips.get(filename);
        if (!clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void preloadSound(String filename) {
        try {
            if (!clips.containsKey(filename)) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filename).getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clips.put(filename, clip);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playLoop(String filename) {
        Clip clip;
        if (!clips.containsKey(filename)) {
            preloadSound(filename);
        }
        clip = clips.get(filename);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopLoop(String filename) {
        Clip clip;
        if (!clips.containsKey(filename)) {
            preloadSound(filename);
        }
        clip = clips.get(filename);
        clip.stop();
        clip.setFramePosition(0);
    }
}

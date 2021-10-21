package Engine;

import java.awt.event.*;

public class KeyHandler implements KeyListener{
    private boolean[] keysPressed;
    private boolean[] keysStateRead;

    public KeyHandler() {
        keysPressed = new boolean[1024];
        keysStateRead = new boolean[1024];

    }
    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        keysPressed[key] = true;
        keysStateRead[key] = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysPressed[e.getKeyCode()] = false;
        keysStateRead[e.getKeyCode()] = false;
        
    }

    public boolean getKeyPressed(int key) {
        return keysPressed[key];
    }
    public boolean getKeyPressedOnce(int key) {
        if (keysStateRead[key]) {
            return false;
        }
        keysStateRead[key] = true; 
        return keysPressed[key];
    }
    
}

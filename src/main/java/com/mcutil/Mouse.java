package com.mcutil;


public class Mouse {

    private int[] position;
    private boolean isPressed;

    public void update(int newX, int newZ) {
        this.position[0] = newX;
        this.position[1] = newZ;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public boolean isPressed() {
        return isPressed;
    }

    public void setPressed(boolean pressed) {
        isPressed = pressed;
    }
}

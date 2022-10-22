package com.yuan.tankgame01;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-10-22 08:47
 **/
public class Tank {
    private int x;//坦克横坐标
    private int y;//坦克纵坐标

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

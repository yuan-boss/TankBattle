package com.yuan.tankgame01;

import javax.swing.*;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-10-22 08:53
 **/
public class YuanBossTankGame01 extends JFrame {
    //定义Mypanel
    Mypanel mp = null;
    public static void main(String[] args) {
        YuanBossTankGame01 tankGame01 = new YuanBossTankGame01();

    }

    public YuanBossTankGame01(){
        mp = new Mypanel();
        this.add(mp);//把面板（就是游戏绘图区域）放入框内
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

package com.yuan.tankgame02;

import com.yuan.tankgame01.YuanBossTankGame01;

import javax.swing.*;

/**
 * @module:
 * @description:
 * @author: yuan_boss
 * @create: 2022-10-22 08:53
 **/
public class YuanBossTankGame02 extends JFrame {
    //定义Mypanel
    Mypanel mp = null;
    public static void main(String[] args) {
        YuanBossTankGame02 tankGame02 = new YuanBossTankGame02();

    }

    public YuanBossTankGame02(){
        mp = new Mypanel();
        this.add(mp);//把面板（就是游戏绘图区域）放入框内
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}

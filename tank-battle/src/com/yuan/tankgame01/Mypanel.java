package com.yuan.tankgame01;

import javax.swing.*;
import java.awt.*;

/**
 * @module:
 * @description: 坦克大战绘图区域
 * @author: yuan_boss
 * @create: 2022-10-22 08:49
 **/
public class Mypanel extends JPanel {
    //定义我的坦克
    Hero hero = null;

    public Mypanel() {
        hero = new Hero(100,100);//初始化自己的坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        drawTank(hero.getX(),hero.getY(),g,0,1);
    }

    /**
     * @Author yuan_boss
     * @Description 画坦克
     * @Date 9:07 2022/10/22
     * @Param x 坦克左上角 x 坐标
     * @Param y 坦克左上角 y 坐标
     * @Param g 画笔
     * @Param direct 坦克方向（上下左右）
     * @Param type 坦克类型
     * @return
     **/
    //编写方法，画出坦克
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        //根据不同类型的坦克，设置不同的颜色
        switch (type){
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向来绘制坦克
        switch (direct){
            case 0:
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 30,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//画出坦克盖子
                g.fillOval(x + 10,y + 20,20,20);//画出坦克圆形盖子
                g.drawLine(x + 20,y + 30,x + 20,y);//画出坦克炮筒


                break;
            default:
                System.out.println("暂时没有处理");

        }
    }
}

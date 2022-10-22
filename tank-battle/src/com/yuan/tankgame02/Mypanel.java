package com.yuan.tankgame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Vector;

/**
 * @module:
 * @description: 坦克大战绘图区域
 * @author: yuan_boss
 * @create: 2022-10-22 08:49
 **/
//为了监听键盘事件，实现KeyListener
public class Mypanel extends JPanel implements KeyListener {
    //定义我的坦克
    Hero hero = null;
    //定义敌人的坦克,放入Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public Mypanel() {
        hero = new Hero(100,100);//初始化自己的坦克
        //初始化敌人坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建敌人的坦克
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            //设置方向
            enemyTank.setDirect(2);
            //加入
            enemyTanks.add(enemyTank);
        }
        hero.setSpeed(2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        g.setColor(Color.red);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色
        //画出自己的坦克
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        //画出敌人的坦克,遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g, enemyTank.getDirect(),0);
        }
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
            case 0://敌人的坦克（青色）
                g.setColor(Color.cyan);
                break;
            case 1://我们的坦克（黄色）
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向来绘制坦克
        //direct 表示方向(0:向上 1：向右 2：向下 3：向左
        switch (direct){
            case 0:
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 30,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//画出坦克盖子
                g.fillOval(x + 10,y + 20,20,20);//画出坦克圆形盖子
                g.drawLine(x + 20,y + 30,x + 20,y);//画出坦克炮筒
                break;
            case 1://向右
                g.fill3DRect(x,y,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x ,y + 30,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//画出坦克盖子
                g.fillOval(x + 20,y + 10,20,20);//画出坦克圆形盖子
                g.drawLine(x + 30,y + 20,x + 60,y + 20);//画出坦克炮筒
                break;
            case 2://向下
                g.fill3DRect(x,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 30,y,10,60,false);//画出坦克左边的轮子
                g.fill3DRect(x + 10,y + 10,20,40,false);//画出坦克盖子
                g.fillOval(x + 10,y + 20,20,20);//画出坦克圆形盖子
                g.drawLine(x + 20,y + 30,x + 20,y + 60);//画出坦克炮筒
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x ,y + 30,60,10,false);//画出坦克左边的轮子
                g.fill3DRect(x + 10,y + 10,40,20,false);//画出坦克盖子
                g.fillOval(x + 20,y + 10,20,20);//画出坦克圆形盖子
                g.drawLine(x + 30,y + 20,x,y + 20);//画出坦克炮筒
                break;
            default:
                System.out.println("暂时没有处理");

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W){//按下w
            hero.setDirect(0);
            //向上移动
            hero.moveUp();
        }else if (e.getKeyCode() == KeyEvent.VK_D){//按下d
            hero.setDirect(1);
            //向右移动
            hero.moveRight();
        }else if (e.getKeyCode() == KeyEvent.VK_S){//按下s
            hero.setDirect(2);
            //向下移动
            hero.moveDown();
        }else if (e.getKeyCode() == KeyEvent.VK_A){//按下a
            hero.setDirect(3);
            //向左移动
            hero.moveLeft();
        }
        //让面板重绘
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

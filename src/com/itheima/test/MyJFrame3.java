package com.itheima.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {


    public MyJFrame3() throws HeadlessException {
        initJFrame();

        // 给 整个窗体 添加 键盘监听
        this.addKeyListener(this);

        //让界面显示出来
        this.setVisible(true);
    }

    private void initJFrame() {
        //设置界面宽、高
        this.setSize(603,680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        setAlwaysOnTop(true);//其他软件无法遮盖
        //设置界面居中
        setLocationRelativeTo(null);
        //设置关闭模式(不设置:点击x号关闭游戏界面，但代码不会停止)
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        // 一般不用
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 按住一直不松会反复调用,和鼠标监听的不同
        System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        //获取键盘上每一个键盘的编号(和ASCII码表无太大关系)
        int code = e.getKeyCode();
        System.out.println(code);
    }
}

package com.itheima.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {

    JButton jtb1 = new JButton("点击我");

    public MyJFrame2() {
        initJFrame();

        //设置 按钮的 位置和宽高
        jtb1.setBounds(0,0,100,50);
        // 给按钮绑定鼠标事件
        jtb1.addMouseListener(this);

        //将 按钮 添加到 界面中
        this.getContentPane().add(jtb1);

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
    public void mouseClicked(MouseEvent e) {//单击
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {//按下不松
        // 按住左键一直不松只会调用一次
        System.out.println("按下不松");
    }

    @Override
    public void mouseReleased(MouseEvent e) {//松开
        System.out.println("松开");
    }

    @Override
    public void mouseEntered(MouseEvent e) {//划入
        System.out.println("划入");
    }

    @Override
    public void mouseExited(MouseEvent e) {//划出
        System.out.println("划出");
    }
}

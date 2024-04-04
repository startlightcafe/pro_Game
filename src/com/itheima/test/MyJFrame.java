package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    //创建按钮对象
    JButton jtb1 = new JButton("点击我");
    JButton jtb2 = new JButton("再点击我");

    public MyJFrame() {
        initJFrame();

        //设置 按钮的 位置和宽高
        jtb1.setBounds(0,0,100,50);
        jtb2.setBounds(100,0,100,50);
        //给 按钮 添加  动作监听(事件监听的一种,只能监听鼠标左键点击、空格)
        jtb1.addActionListener(this);
        jtb2.addActionListener(this);
        //将 按钮 添加到 界面中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);



        //让界面显示出来
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //对当前按钮进行判断
        Object source = e.getSource();
        if(source.equals(jtb1)) {
            jtb1.setSize(80,80);
        }
        else if(source.equals(jtb2)) {
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500),r.nextInt(500));
        }
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
}

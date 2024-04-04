package com.itheima.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 {
    public static void main(String[] args) {
        //创建一个窗体
        JFrame jFrame = new JFrame();
        jFrame.setSize(603,680);//宽 高 (单位:像素)
        jFrame.setLocationRelativeTo(null);//窗体居中
        jFrame.setAlwaysOnTop(true);//窗体置顶
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);//取消组件居中

        //创建按钮对象
        JButton jtb = new JButton("点击我");
        //设置 按钮的 位置和宽高
        jtb.setBounds(0,0,100,50);
        //给 按钮 添加  动作监听(事件监听的一种,只能监听鼠标左键点击、空格)
        jtb.addActionListener(new ActionListener() {//匿名内部类的对象
            @Override
            public void actionPerformed(ActionEvent e) {
                //点击后触发的事件
                System.out.println("按钮被点击了");
            }
        });
        //将 按钮 添加到 界面中
        jFrame.getContentPane().add(jtb);

        //界面默认是隐藏的，需要手动展示
        jFrame.setVisible(true);
    }
}

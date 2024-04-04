package com.itheima.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterJFrame extends JFrame {
    //注册界面

    public RegisterJFrame() {
        //设置界面宽、高
        this.setSize(488,500);
        //设置界面标题
        this.setTitle("拼图注册界面 v1.0");
        //设置界面置顶
        setAlwaysOnTop(true);//其他软件无法遮盖
        //设置界面居中
        setLocationRelativeTo(null);

        //设置关闭模式(不设置:点击x号关闭游戏界面，但代码不会停止)
        //this.setDefaultCloseOperation(3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //让界面显示出来
        this.setVisible(true);
    }
}

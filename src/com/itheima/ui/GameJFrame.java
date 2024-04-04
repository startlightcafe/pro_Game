package com.itheima.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //游戏主界面

    //加载图片的时候，会根据二维数组中的数据进行加载
    int[][] data = new int[4][4];
    int x = 0, y = 0;//记录空白方块位置

    //正确(获胜)时的数据
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };

    int step = 0;//步数

    //3.创建选项下面的条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");
    JMenuItem accountItem = new JMenuItem("公众号");

    String path = "image/animal/animal3/";

    public GameJFrame() {
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuMar();

        //初始化数据（打乱）
        initData();

        //初始化图片
        initImage();

        //让界面显示出来
        this.setVisible(true);

    }

    private void initData() {
        //将一维数组打乱
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        //放到二维数组中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = arr[i];

        }
    }

    private void initImage() {

        //1.清空原本已经出现的所有图片
        this.getContentPane().removeAll();


        if (victory()) {
            JLabel v = new JLabel(new ImageIcon("image/win.png"));
            v.setBounds(203, 283, 197, 73);
            this.getContentPane().add(v);
        }

        //展示计数器的步数
        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);


        // 细节: 先加载的图片在上方，后加载的图片塞在下面。

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // data[][] 代表当前要加载的图片的序号
                ImageIcon icon = new ImageIcon(path + data[i][j] + ".jpg");
                JLabel jLabel1 = new JLabel(icon);
                jLabel1.setBounds(105 * j + 83, 105 * i + 134, 105, 105);//x y 宽 高

                // 给每一张小图片添加边框 (斜面边框,边框的一种)
                // 参数: 0图片凸起  1图片凹陷
                jLabel1.setBorder(new BevelBorder(1));

                this.getContentPane().add(jLabel1);
            }
        }

        //添加背景图片
        ImageIcon bg = new ImageIcon("image/background.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //2.刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuMar() {
        //1.创建菜单对象
        JMenuBar jMenuBar = new JMenuBar();

        //2.创建菜单中的选项 (功能  关于我们)
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");


        //给条目绑定事件(动作监听)
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);


        //4.将 条目 添加到 选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);






        //5.将 选项 添加到 菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //6.将 菜单 添加到 界面中
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        // 因为本类里面没有对应方法的话，就会去父类里面找，
        // 所以这里的 this 写不写都一样

        //设置界面宽、高
        this.setSize(603, 680);
        //设置界面标题
        this.setTitle("拼图单机版 v1.0");
        //设置界面置顶
        setAlwaysOnTop(true);//其他软件无法遮盖
        //设置界面居中
        setLocationRelativeTo(null);
        //设置关闭模式(不设置:点击x号关闭游戏界面，但代码不会停止)
        //this.setDefaultCloseOperation(3);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (victory()) return;
        int code = e.getKeyCode();
        if (code == 65) { // a

            this.getContentPane().removeAll();//!!!

            //加载完整图片
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);
            //加载背景图片
            ImageIcon bg = new ImageIcon("image/background.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();//!!!
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (victory()) return;//如果游戏已经胜利，则直接返回

        //对 上38 下40 左37 右39 进行判断
        int code = e.getKeyCode();
        if (code == 37 && y != 3) { //图片向左移动
            int tem = data[x][y];
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = tem;
            y++;
            step++; // 每移动一次，计数器自增
            initImage();

        } else if (code == 38 && x != 3) {//图片向上移动
            int tem = data[x][y];
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = tem;
            x++;
            step++;
            initImage();

        } else if (code == 39 && y != 0) {//图片向右移动
            int tem = data[x][y];
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = tem;
            y--;
            step++;
            initImage();

        } else if (code == 40 && x != 0) {//图片向下移动
            int tem = data[x][y];
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = tem;
            x--;
            step++;
            initImage();

        } else if (code == 65) { // a
            initImage();
        } else if (code == 87) { // 作弊码
            data = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
            x = 3;
            y = 3;
        }
    }

    private boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != win[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) { //菜单业务
        Object obj = e.getSource(); //获取点击的条目对象

        if (obj == replayItem) {
            step=0;
            initData();
            initImage();

            //step=0;//重置计步器不能放在下面，刷新界面也无法获得正确的展示
        } else if (obj == reLoginItem) {
            System.out.println("重新登录");
            //关闭当前界面
            this.setVisible(false);//隐藏当前界面
            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.out.println("关闭游戏");
            System.exit(0);//直接关闭虚拟机
        } else if (obj == accountItem) {
            System.out.println("公众号");

            //1.创建一个弹框对象
            JDialog jDialog = new JDialog();
            //2.创建 管理图片的容器对象
            JLabel jLabel = new JLabel(new ImageIcon("image/about.png"));
            //3.设置容器的位置和宽高 (相对于弹框)
            jLabel.setBounds(0,0,258,258);
            //4.将图片 添加到 弹框中(隐藏容器)
            jDialog.getContentPane().add(jLabel);
            //5.设置弹框的大小
            jDialog.setSize(344,344);

        }
    }
}

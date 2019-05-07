package swingawt;

import javax.swing.*;
import java.awt.*;

public class SelfW {
    JFrame f = new JFrame("应用");
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    JLabel jl1 = new JLabel("fsDefaultFS:");
    JTextField jtf1 = new JTextField(40);

    JPanel jp2 = new JPanel();
    JLabel jl2 = new JLabel("dataSource:");
    JTextField jtf2 = new JTextField(40);

    JPanel jp3 = new JPanel();
    JLabel jl3 = new JLabel("dataAfterClear:");
    JTextField jtf3 = new JTextField(40);

    JPanel jp4 = new JPanel();
    JLabel jl4 = new JLabel("personCorrelation:");
    JTextField jtf4 = new JTextField(40);

    JPanel jp5 = new JPanel();
    JLabel jl5 = new JLabel("trainMS:");
    JTextField jtf5 = new JTextField(40);

    JPanel jp6 = new JPanel();
    JLabel jl6 = new JLabel("qulifyData:");
    JTextField jtf6 = new JTextField(40);

    JPanel jp7 = new JPanel();
    JLabel jl7 = new JLabel("elements:");
    JTextField jtf7 = new JTextField(40);

    JPanel jp8 = new JPanel();
    JLabel jl8 = new JLabel("objectStorage:");
    JTextField jtf8 = new JTextField(40);

    JPanel jp9 = new JPanel();
    JLabel jl9 = new JLabel("isAutoPra:");
    JTextField jtf9 = new JTextField(40);

    JPanel jp10 = new JPanel();
    JLabel jl10 = new JLabel("opts:");
    JTextField jtf10 = new JTextField(40);

    JPanel jp11 = new JPanel();
    JLabel jl11 = new JLabel("size:");
    JTextField jtf11 = new JTextField(40);

    JPanel jp12 = new JPanel();
    JLabel jl12 = new JLabel("layer:");
    JTextField jtf12 = new JTextField(40);

    JPanel jp13 = new JPanel();
    JLabel jl13 = new JLabel("activation_function:");
    JTextField jtf13 = new JTextField(40);

    JPanel jp14 = new JPanel();
    JLabel jl14 = new JLabel("learningRate:");
    JTextField jtf14 = new JTextField(40);

    JPanel jp15 = new JPanel();
    JLabel jl15 = new JLabel("scaling_learning:");
    JTextField jtf15 = new JTextField(40);

    JPanel jp16 = new JPanel();
    JLabel jl16 = new JLabel("weighPenaltyL2:");
    JTextField jtf16 = new JTextField(40);

    JPanel jp17 = new JPanel();
    JLabel jl17 = new JLabel("nonSparsityPenalty:");
    JTextField jtf17 = new JTextField(40);

    JPanel jp18 = new JPanel();
    JLabel jl18 = new JLabel("sparityTarget:");
    JTextField jtf18 = new JTextField(40);

    JPanel jp19 = new JPanel();
    JLabel jl19 = new JLabel("inputZeroMaskedFraction:");
    JTextField jtf19 = new JTextField(40);

    JPanel jp20 = new JPanel();
    JLabel jl20 = new JLabel("dropoutFraction:");
    JTextField jtf20 = new JTextField(40);

    JPanel jp21 = new JPanel();
    JLabel jl21 = new JLabel("output_function:");
    JTextField jtf21 = new JTextField(40);

    JPanel jp22 = new JPanel();
    JLabel jl22 = new JLabel("kafkaargs:");
    JTextField jtf22 = new JTextField(40);

    JPanel jp24 = new JPanel();
    JLabel jl24 = new JLabel("user:");
    JTextField jtf24 = new JTextField(40);

    JPanel jp25 = new JPanel();
    JLabel jl25 = new JLabel("password:");
    JTextField jtf25 = new JTextField(40);

    JPanel jp26 = new JPanel();
    JLabel jl26 = new JLabel("driverClass:");
    JTextField jtf26 = new JTextField(40);

    JPanel jp27 = new JPanel();
    JLabel jl27 = new JLabel("jdbcUrl:");
    JTextField jtf27 = new JTextField(40);

    JPanel jp23 = new JPanel();
    Button bt1 = new Button("clear");
    Button bt2 = new Button("training");
    Button bt3 = new Button("forecasting");

    JPanel jpcenter = new JPanel();
    JLabel jlcenter = new JLabel("result:");
    JTextArea jta = new JTextArea();

    JPanel jpleft = new JPanel();
    JLabel jlleft = new JLabel("配置:");


    public static void main(String[] args){
        new SelfW().init();
    }
    public void init(){
        Font f1 =new Font("宋体",Font.PLAIN,  18);
        jl1.setFont(f1);jl2.setFont(f1);jl3.setFont(f1);jl4.setFont(f1);jl5.setFont(f1);
        jl6.setFont(f1);jl7.setFont(f1);jl8.setFont(f1);jl9.setFont(f1);jl10.setFont(f1);
        jl11.setFont(f1);jl12.setFont(f1);jl13.setFont(f1);jl14.setFont(f1);jl15.setFont(f1);
        jl16.setFont(f1);jl17.setFont(f1);jl18.setFont(f1);jl19.setFont(f1);jl20.setFont(f1);
        jl21.setFont(f1);jl22.setFont(f1);jl24 .setFont(f1);jl25.setFont(f1);jl26.setFont(f1);jl27.setFont(f1);
        jp1.add(jl1);jp1.add(jtf1);
        jp2.add(jl2);jp2.add(jtf2);
        jp3.add(jl3);jp3.add(jtf3);
        jp4.add(jl4);jp4.add(jtf4);
        jp5.add(jl5);jp5.add(jtf5);
        jp6.add(jl6);jp6.add(jtf6);
        jp7.add(jl7);jp7.add(jtf7);
        jp8.add(jl8);jp8.add(jtf8);
        jp9.add(jl9);jp9.add(jtf9);
        jp10.add(jl10);jp10.add(jtf10);
        jp11.add(jl11);jp11.add(jtf11);
        jp12.add(jl12);jp12.add(jtf12);
        jp13.add(jl13);jp13.add(jtf13);
        jp14.add(jl14);jp14.add(jtf14);
        jp15.add(jl15);jp15.add(jtf15);
        jp16.add(jl16);jp16.add(jtf16);
        jp17.add(jl17);jp17.add(jtf17);
        jp18.add(jl18);jp18.add(jtf18);
        jp19.add(jl19);jp19.add(jtf19);
        jp20.add(jl20);jp20.add(jtf20);
        jp21.add(jl21);jp21.add(jtf21);
        jp22.add(jl22);jp22.add(jtf22);
        jp24.add(jl24);jp24.add(jtf24);
        jp25.add(jl25);jp25.add(jtf25);
        jp26.add(jl26);jp26.add(jtf26);
        jp27.add(jl27);jp27.add(jtf27);
        jp.setLayout(new GridLayout(26,1));
        jp.add(jp1);jp.add(jp2);jp.add(jp3);jp.add(jp4);jp.add(jp5);
        jp.add(jp6);jp.add(jp7);jp.add(jp8);jp.add(jp9);
        jp.add(jp10);jp.add(jp11);jp.add(jp12);jp.add(jp13);
        jp.add(jp14);jp.add(jp15);jp.add(jp16);jp.add(jp17);
        jp.add(jp18);jp.add(jp19);jp.add(jp20);jp.add(jp21);jp.add(jp22);
        jp.add(jp24);jp.add(jp25);jp.add(jp26);jp.add(jp27);
        f.setLayout(new BorderLayout(30,5 ));
        //left
        jpleft.setLayout(new BorderLayout(20,20));
        Font font =new Font("黑体",Font.PLAIN,40);
        jlleft.setFont(font);
        jpleft.add(jlleft,BorderLayout.NORTH);
        jpleft.add(jp);

        f.add(jpleft,BorderLayout.WEST);

        //======按钮south
        Dimension dim = new Dimension(80, 50);
        bt1.setPreferredSize(dim);
        bt2.setPreferredSize(dim);
        bt3.setPreferredSize(dim);
        jp23.add(bt1);jp23.add(bt2);jp23.add(bt3);
        f.add(jp23,BorderLayout.SOUTH);

        //中部center
        jpcenter.setLayout(new BorderLayout(20,20));

        jlcenter.setFont(font);
        jpcenter.add(jlcenter,BorderLayout.NORTH);jpcenter.add(jta);
        f.setBounds(100,150,500,600);
        f.add(jpcenter);


        f.setVisible(true);
    }
}

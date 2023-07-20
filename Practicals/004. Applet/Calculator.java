import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/* <applet code = "Calculator.class" width = "260" height = "310"></applet> */

public class Calculator extends Applet implements ActionListener {
    TextField t1;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    Button add, sub, mul, div, eql, dot;

    String msg = "", tmp;
    int a, b;

    public void init() {
        setLayout(null);

        t1 = new TextField(20);

        button1 = new Button("1");
        button2 = new Button("2");
        button3 = new Button("3");
        button4 = new Button("4");
        button5 = new Button("5");
        button6 = new Button("6");
        button7 = new Button("7");
        button8 = new Button("8");
        button9 = new Button("9");
        button0 = new Button("0");

        add = new Button("+");
        sub = new Button("-");
        div = new Button("/");
        mul = new Button("*");
        dot = new Button(".");
        eql = new Button("=");

        add(t1);

        add(button7);
        add(button8);
        add(button9);
        add(div);

        add(button4);
        add(button5);
        add(button6);
        add(mul);

        add(button1);
        add(button2);
        add(button3);
        add(sub);

        add(dot);
        add(button0);
        add(eql);
        add(add);

        t1.setBounds(30, 30, 200, 40);
        button7.setBounds(30, 80, 44, 44);
        button8.setBounds(82, 80, 44, 44);
        button9.setBounds(134, 80, 44, 44);
        button4.setBounds(30, 132, 44, 44);
        button5.setBounds(82, 132, 44, 44);
        button6.setBounds(134, 132, 44, 44);
        button1.setBounds(30, 184, 44, 44);
        button2.setBounds(82, 184, 44, 44);
        button3.setBounds(134, 184, 44, 44);
        dot.setBounds(30, 236, 44, 44);
        button0.setBounds(82, 236, 44, 44);
        eql.setBounds(134, 236, 44, 44);
        add.setBounds(186, 236, 44, 44);
        sub.setBounds(186, 184, 44, 44);
        mul.setBounds(186, 132, 44, 44);
        div.setBounds(186, 80, 44, 44);

        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        // button0.addActionListener(this);
        // button0.addActionListener(this);
        div.addActionListener(this);
        mul.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        eql.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
            String str1 = t1.getText();
            tmp = str;
            a = Integer.parseInt(str1);
            msg = "";
        } else if (str.equals("=")) {
            String str2 = t1.getText();
            b = Integer.parseInt(str2);
            int sum = 0;
            if (tmp == "+")
                sum = a + b;
            else if (tmp == "-")
                sum = a - b;
            else if (tmp == "*")
                sum = a * b;
            else if (tmp == "/")
                sum = a / b;
            String str1 = String.valueOf(sum);
            t1.setText("" + str1);
            msg = "";
        } else {
            // String ae.getActionCommand();
            // str += ae.getActionCommand();
            msg += str;
            t1.setText("" + msg);
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(20, 20, 220, 270);
    }
}

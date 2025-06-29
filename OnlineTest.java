import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OnlineTest extends JFrame implements ActionListener
{
    OnlineTest()
    {
        getContentPane().setBackground(Color.PINK);
        setLayout(null);

        JLabel heading = new JLabel("Java Quiz");
        heading.setBounds(750, 60, 300, 45);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        heading.setForeground(new Color(30, 144, 254));
        add(heading);

        JLabel name = new JLabel("Enter your Name:");
        name.setBounds(810, 150, 300, 20);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setForeground(new Color(30, 144, 254));
        add(name);

        JTextField tfName = new JTextField();
        tfName.setBounds(735, 200, 300, 25);
        tfName.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfName);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);

        JLabel uid = new JLabel("Enter your UID:");
        uid.setBounds(810, 300, 300, 20);
        uid.setFont(new Font("Arial", Font.BOLD, 18));
        uid.setForeground(new Color(30, 144, 254));
        add(uid);

        JTextField tfUid = new JTextField();
        tfUid.setBounds(735, 350, 300, 25);
        tfUid.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfUid);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);

        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b3 = new JButton("Start");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        add(b1);
        add(b2);
        add(b3);

        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        b3.setBounds(810,450,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }


    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2,b3;
    ButtonGroup bg;
    int count=0, current=0, x=1, y=1, now=0;
    int m[]=new int[10];


    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Start"))
        {
            JOptionPane.showMessageDialog(this,"Kindly attempt all the questions. " +
                    "Each question carries 1 mark and there is no negative marking.");
            JOptionPane.showMessageDialog(this,"Wish you all the best!");
            Questions();
        }

        if(e.getSource()==b1)
        {
            if(check())
            {
                count = count + 1;
            }
            current++;
            Questions();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }

        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            Questions();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                Questions();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"Correct answers="+count);
            JOptionPane.showMessageDialog(this,"Thank You :)");
            System.exit(0);
        }
    }

    void Questions()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which one among these is not a primitive datatype?");
            jb[0].setText("int"); jb[1].setText("Float"); jb[2].setText("boolean"); jb[3].setText("char");
        }
        if(current==1)
        {
            l.setText("Que2: Which of the following helps in garbage collection in Java??");
            jb[0].setText("Constructor"); jb[1].setText("Destructor"); jb[2].setText("Daemon thread");
            jb[3].setText("User thread");
        }
        if(current==2)
        {
            l.setText("Que3: Which package is directly available to our class without importing it?");
            jb[0].setText("swing"); jb[1].setText("applet"); jb[2].setText("net"); jb[3].setText("lang");
        }
        if(current==3)
        {
            l.setText("Que4: String class is defined in which package?");
            jb[0].setText("lang"); jb[1].setText("Swing"); jb[2].setText("Applet"); jb[3].setText("awt");
        }
        if(current==4)
        {
            l.setText("Que5: Which package is imported for taking user inputs?");
            jb[0].setText("java.lang"); jb[1].setText("java.io"); jb[2].setText("java.util"); jb[3].setText("java.awt");
        }
        if(current==5)
        {
            l.setText("Que6: Which one among these is a Checked exception?");
            jb[0].setText("Arithmetic Exception"); jb[1].setText("Null pointer Exception"); jb[2].setText("I/O Exception");
            jb[3].setText("Number format Exception");
        }
        if(current==6)
        {
            l.setText("Que7: Which one among these is not a class? ");
            jb[0].setText("Applet"); jb[1].setText("Actionperformed"); jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if(current==7)
        {
            l.setText("Que8: Which one among these is a thread method?");
            jb[0].setText("open()"); jb[1].setText("close()"); jb[2].setText("connect()");
            jb[3].setText("start()");
        }
        if(current==8)
        {
            l.setText("Que9: Which method is not present in Applet class?");
            jb[0].setText("init()"); jb[1].setText("main()"); jb[2].setText("start()"); jb[3].setText("destroy()");
        }
        if(current==9)
        {
            l.setText("Que10: Which one among these is not a valid component?");
            jb[0].setText("JButton"); jb[1].setText("JList"); jb[2].setText("JButtonGroup");
            jb[3].setText("JTextArea");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());

        if(current==1)
            return(jb[2].isSelected());

        if(current==2)
            return(jb[3].isSelected());

        if(current==3)
            return(jb[0].isSelected());

        if(current==4)
            return(jb[2].isSelected());

        if(current==5)
            return(jb[2].isSelected());

        if(current==6)
            return(jb[1].isSelected());

        if(current==7)
            return(jb[3].isSelected());

        if(current==8)
            return(jb[1].isSelected());

        if(current==9)
            return(jb[2].isSelected());

        return false;
    }

    public static void main(String args[])
    {
        new OnlineTest();
    }
}

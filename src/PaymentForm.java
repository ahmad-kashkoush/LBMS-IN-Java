//package guiproject1;
import java.awt.*;
import javax.swing.*;

    /**
     *
     * @author W.A.K
     */
    public class PaymentForm extends JFrame{
        JPanel p1 = new JPanel();
        JLabel title=new JLabel("PayMent");
        JLabel Name = new JLabel("YourName: ");
        JTextField tName = new JTextField();

        JLabel Address = new JLabel("Address: ");
        JTextField tAddress = new JTextField();

        JLabel Phone = new JLabel("PhoneNumber: ");
        JTextField tPhone = new JTextField();

        JLabel Credit = new JLabel("Credit: ");
        JTextField tCredit = new JTextField();

        JLabel VCC = new JLabel("VCC: ");
        JTextField tVCC = new JTextField();


        public PaymentForm(){
            this.setTitle("Payment");
            this.setSize(400,500);
            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.add(p1);
//   p1.setBackground(Color.lightGray);
            p1.add(title);
            p1.add(Name);
            p1.add(tName);
            p1.add(Address);
            p1.add(tAddress);
            p1.add(Phone);
            p1.add(tPhone);
            p1.add(Credit);
            p1.add(tCredit);
            p1.add(VCC);
            p1.add(tVCC);
            p1.setLayout(null);

            title.setBounds(130,5,250,100);
            title.setFont(new Font (Font.SANS_SERIF, Font.BOLD, 25) );

            int x=30,y=100,w=150,h=30;
            int xt=150,wt=200,r=30;


            Name.setBounds(x,y,w,h);
            tName.setBounds(xt,y,wt,h);
            Name.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
            y+= h+r;

            Address.setBounds(x,y,w,h);
            tAddress.setBounds(xt,y,wt,h);
            Address.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

            y+= h+r;

            Phone.setBounds(x,y,w,h);
            tPhone.setBounds(xt,y,wt,h);
            Phone.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

            y+= h+r;

            Credit.setBounds(x,y,w,h);
            tCredit.setBounds(xt,y,wt,h);
            Credit.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

            y+= h+r;

            VCC.setBounds(x,y,w,h);
            tVCC.setBounds(xt,y,wt,h);
            VCC.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));

        }

    }



import javax.swing.*;
import java.awt.*;

public class LoginForm extends JFrame{
    JLabel LEmail = new JLabel("Email ");
    JLabel LPassword  = new JLabel("Password ");
    JLabel LAnotherAccount  = new JLabel("Another Account");
    JLabel FormTitle=new JLabel("Login");
    JTextField TEmail = new JTextField();
    JTextField TPassword  = new JTextField();
    JTextField TAnotherAccount = new JTextField();
    JButton BLogin = new JButton("login");
    JLabel BForget = new JLabel("forgot your Password ?");

    public LoginForm() {
        this.setTitle("login");
        this.setSize(500, 500);
        this.setLocation(500, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);



        int LabelWidth=100, LabelHeight=30;
        int txtFieldWidth=LabelWidth*3;
        int x=25;
        int row=x, PrvHeight=0;
        int col=25, col2=col+LabelWidth+10+30;

        FormTitle.setFont(new Font(Font.SANS_SERIF, NORMAL, 28));
        FormTitle.setBounds(200, 5, 250, 100);

        row+=x+15+5; PrvHeight+=LabelHeight;
        LEmail.setBounds(col, row+PrvHeight, LabelWidth, LabelHeight);
        TEmail.setBounds(col2, row+PrvHeight, txtFieldWidth, LabelHeight);

        row+=x+15; PrvHeight+=LabelHeight;
        LPassword.setBounds(col, row+PrvHeight, LabelWidth, LabelHeight);
        TPassword.setBounds(col2, row+PrvHeight, txtFieldWidth, LabelHeight);

        row+=x+15; PrvHeight+=LabelHeight;
        LAnotherAccount.setBounds(col, row+PrvHeight, LabelWidth+30, LabelHeight);
        TAnotherAccount.setBounds(col2, row+PrvHeight, txtFieldWidth, LabelHeight);

        row+=x+15; PrvHeight+=LabelHeight;
        BForget.setBounds(col, row+PrvHeight, txtFieldWidth, LabelHeight);
        row+=x+15; PrvHeight+=LabelHeight;
        BLogin.setBounds(col2, row+PrvHeight, LabelWidth, LabelHeight);


        this.add(LPassword);
        this.add(BForget);
        this.add(FormTitle);
        this.add(LEmail);
        this.add(TEmail);
        this.add(LAnotherAccount);
        this.add(TPassword);
        this.add(TAnotherAccount);
        this.add(BLogin);

    }

}
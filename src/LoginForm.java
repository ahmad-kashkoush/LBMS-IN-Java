import javax.swing.*;

public class LoginForm extends JFrame{
    JLabel LEmail = new JLabel("Email ");
    JLabel LPassword  = new JLabel("Password ");
    JLabel LAnotherAccount  = new JLabel("Another account");
    JTextField TEmail = new JTextField();
    JTextField TPassword  = new JTextField();
    JTextField TAnotherAccount = new JTextField();
    JButton BLogin = new JButton("login");
    JLabel BForget = new JLabel("forgot your Password ?");

    public LoginForm() {
        this.setTitle("login");
        this.setSize(500, 700);
        this.setLocation(500, 100);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        LEmail.setBounds(20, 20, 130, 25);
        this.add(LEmail);
        LPassword.setBounds(20, 60, 130, 25);
        this.add(LPassword);
        LAnotherAccount.setBounds(20, 100, 130, 25);
        this.add(LAnotherAccount);
        TEmail.setBounds(150, 23, 130, 22);
        this.add(TEmail);
        this.add(TPassword);
        TPassword.setBounds(150, 63, 130, 22);
        this.add(TAnotherAccount);
        TAnotherAccount.setBounds(150, 103, 130, 22);

        BLogin.setBounds(120, 180, 80, 22);
        this.add(BLogin);
        BForget.setBounds(20, 140, 165, 22);
        this.add(BForget);

    }

}
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author W.A.K
 *
 */
public class RegisterForm extends JFrame {
    JPanel p1 = new JPanel();
    JLabel title = new JLabel("Registeration");
    JButton Admin =new JButton("Login as Adim");
    JButton User =new JButton("Login as User");
    JButton Sign =new JButton("Sign Up");
//    ButtonGroup g1=new ButtonGroup();

    public RegisterForm(){

        this.setTitle("Registration Form");
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(p1);

        p1.add(title);
        p1.add(Admin);
        p1.add(User);
        p1.add(Sign);
        p1.setLayout(null);
        title.setBounds(120,5,250,100);
        title.setFont(new Font ("Arial", Font.BOLD, 25) );
        int btnWidth=150 , btnHeight=30;
        int x=30, y=100;
        User.setBounds(x,y,btnWidth,btnHeight);
        x+=btnWidth+20;
        Admin.setBounds(x,y,btnWidth,btnHeight);
        x-=btnWidth-60;
        y+=btnHeight+30;
        Sign.setBounds(x,y,btnWidth,btnHeight);

User.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        LoginForm lg;
        try {
            lg = new LoginForm();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
});
Sign.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        SignUPForm lg;
        try {
            lg = new SignUPForm();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

});
Admin.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        LoginForm lg;
        try {
            lg = new LoginForm();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
});

}
}

 
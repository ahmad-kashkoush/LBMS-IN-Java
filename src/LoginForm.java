import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class LoginForm extends JFrame{
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    JLabel LEmail = new JLabel("Email ");
    JLabel LPassword  = new JLabel("Password ");
    JLabel LAnotherAccount  = new JLabel("Another Account");
    JLabel FormTitle=new JLabel("Login");
    JTextField TEmail = new JTextField();
    JPasswordField TPassword  = new JPasswordField();

    JTextField TAnotherAccount = new JTextField();
    JButton BLogin = new JButton("login");
    JLabel BForget = new JLabel("forgot your Password ?");

    public LoginForm() throws SQLException {
        this.setTitle("login");
        this.setSize(500, 800);
        this.setLocation(600, 25);

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


        BLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String eml = TEmail.getText();
                String pss = TPassword.getText();
                System.out.println(eml + " " + pss);
                AdmenMenu ad;
                if (Objects.equals(eml, "admin123") && Objects.equals(pss, "admin123")) {
                    dispose();
                    try {
                        ad = new AdmenMenu();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {

                    String anotherAccount = TAnotherAccount.getText();
                    if (eml.isEmpty())
                        JOptionPane.showMessageDialog(null, "Can't Leave Email empty");
                    else if (pss.isEmpty())
                        JOptionPane.showMessageDialog(null, "Can't Leave Password Empty");
                    else {
                        try {
                            if (Wrong(eml, pss)) {
                                JOptionPane.showMessageDialog(null, "Wrong Email or password");
                                TPassword.setText("");
                                TEmail.setText("");
                                TAnotherAccount.setText("");
                            } else {
                                dispose();
                               UserMenu usr = new UserMenu();
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                }
            }
        });


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
    private Boolean Wrong(String a, String b) throws SQLException {
        PreparedStatement stm=conn.prepareStatement("SELECT * FROM USERS  WHERE Email=? and Password=?;");
        stm.setString(1, a);
        stm.setString(2, b);
        ResultSet res=stm.executeQuery();
        if(res.next())
            return false;
        return true;
    }

}
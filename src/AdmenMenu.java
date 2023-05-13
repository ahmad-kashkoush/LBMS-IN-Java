import javax.swing.*;
import java.awt.*;

public class AdmenMenu extends JFrame {
    JPanel p2 = new JPanel();
    JLabel Admen_menu = new JLabel("Admen User");
    JButton v_book = new JButton("View Books");
    JButton add_book = new JButton("View Books");
    JButton v_users = new JButton("View Books");
    JButton Edit_book = new JButton("View Books");
    JButton add_users = new JButton("View Books");
    JButton Remove_users = new JButton("View Books");
    public AdmenMenu(){
        this.setTitle("Add Book");
        this.setSize(400,300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p2);
        p2.add(Admen_menu);
        p2.add(v_book);
        p2.add(add_book);
        p2.add(v_users);
        p2.add(Edit_book);
        p2.add(add_users);
        p2.add(Remove_users);
        p2.setLayout(null);
        Admen_menu.setBounds(120,10,300,50);
        Admen_menu.setFont(new Font("Normal", Font.BOLD, 20));
        int BtnWidth=150;
        int col=50, col2=col+BtnWidth+10;
        v_book.setBounds(col,70,BtnWidth,30);
        add_book.setBounds(col2,70,BtnWidth,30);

        v_users.setBounds(col,120,BtnWidth,30);
        Edit_book.setBounds(col2,120,BtnWidth,30);

        add_users.setBounds(col,170,BtnWidth,30);
        Remove_users.setBounds(col2,170,BtnWidth,30);
    }

}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdmenMenu extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    JPanel p2 = new JPanel();
    JLabel Admen_menu = new JLabel("Admen User");
    JButton v_book = new JButton("View Books");
    JButton add_book = new JButton("Add Books");
    JButton v_users = new JButton("View Users");
    JButton Edit_book = new JButton("Edit Books");
    JButton add_users = new JButton("Add Users");
    JButton Remove_users = new JButton("Remove Users");
    public AdmenMenu() throws SQLException {
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
        v_users.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    JFrame view;
                    view=new JFrame();
                    JTable tb=new JTable();
                    view.setSize(800, 800);
                    view.setTitle("Veiw Users");
                    view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    view.setResizable(false);
                    view.setVisible(true);
                    view.setLayout(new GridLayout(1, 1));
                    DefaultTableModel dtm=new DefaultTableModel();
                    dtm.addColumn("id");
                    dtm.addColumn("FirstName");
                    dtm.addColumn("SecondName");
                    dtm.addColumn("Gender");
                    dtm.addColumn("categories");
                    dtm.addColumn("Email");
                    dtm.addColumn("Phone");
                    dtm.addColumn("Password");
                    dtm.addColumn("BirthDate");
                    dtm.addRow(new Object[]{"id","FirstName","SecondName","Gender","categories" ,"Email" ,"Phone" ,"Password" , "BirthDate" } );
                    tb.setModel(dtm);
                    view.setLayout(new GridLayout(1,1 ));
                    try {
                        PreparedStatement bks=conn.prepareStatement("SELECT * FROM USERS;");
                        ResultSet res= bks.executeQuery();
                        while(res.next()) {
                            dtm.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9)});
                        }
                        tb.setModel(dtm);

                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                    view.add(tb);

                }

            }
        });
    }

}
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CategoryForm extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    String[] arr_category = new String[]{"All", "Programming", "Science", "Science  Fiction", "Cartoon", "Magic", "Mystery"};
    JPanel pc = new JPanel();
    JLabel choose_category = new JLabel ("<< Choose The Category You want >>");
    JComboBox cho_category = new JComboBox(arr_category);
    JButton done = new JButton("Done");
    JButton usr=new JButton("Back");
    public CategoryForm() throws SQLException {

        this.setTitle("Category");
        this.setSize(500,300);
        this.setLocation(600, 25);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pc);
        pc.setLayout(null);
        pc.add(choose_category);
        pc.add(cho_category);
        pc.add(done);
        pc.add(usr);

        choose_category.setBounds(28,40,400,50);
        choose_category.setFont(new Font("Normal", Font.BOLD, 18));

        cho_category.setBounds(90,100,200,30);
        cho_category.setFont(new Font("Normal", Font.BOLD, 12));

        done.setBounds(25,180,450,30);
        usr.setBounds(25, 30+180+10, 450, 30);

         done.addActionListener( new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 dispose();
                 JFrame view;
                 view = new JFrame();
                 JTable tb = new JTable();

                 JButton usrMenu = new JButton("User Menu");

                 String ctg = cho_category.getSelectedItem().toString();
                 view.setSize(800, 800);
                 view.setLocation(600, 25);
                 view.setTitle("VeiwBooks");
                 view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 view.setResizable(false);
                 view.setVisible(true);
                 view.setLayout(null);

                 usrMenu.setBounds(50, 700, 700, 50);
                  tb.setRowHeight(25);


                 DefaultTableModel dtm = new DefaultTableModel();
                 dtm.addColumn("id");
                 dtm.addColumn("BookName");
                 dtm.addColumn("quantity");
                 dtm.addColumn("numberOfPages");
                 dtm.addColumn("category");
                 dtm.addColumn("Price");
                 dtm.addRow(new Object[]{"id", "BookName", "quantity", "numberOfPages", "category", "Price"});
                 tb.setModel(dtm);
                 tb.getTableHeader().setFont(new Font("Segeo UI", Font.BOLD, 12));
                 tb.getTableHeader().setBackground(new Color(30, 136, 203));
                 tb.getTableHeader().setForeground(new Color(255, 255, 255));
                 try {
                     PreparedStatement bks;
                     if (ctg != "All") {
                         bks = conn.prepareStatement("SELECT * FROM Book WHERE category=?;");
                         bks.setString(1, ctg);
                     } else
                         bks = conn.prepareStatement("SELECT * FROM Book;");
                     ResultSet res = bks.executeQuery();
                     while (res.next()) {
                         dtm.addRow(new Object[]{res.getString("id"), res.getString("BookName"), res.getString(3), res.getString(4), res.getString(5), res.getInt(6)});
                     }
                     tb.setModel(dtm);

                 } catch (SQLException ex) {
                     throw new RuntimeException(ex);
                 }

                 usrMenu.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         view.dispose();
                         UserMenu men;
                         try {
                             men = new UserMenu();
                         } catch (SQLException ex) {
                             throw new RuntimeException(ex);
                         }

                     }
                 });

                JScrollPane ppp=new JScrollPane(tb);
                ppp.setBounds(0, 0, 800, 700);
                 view.add(ppp);
                 view.add(usrMenu);
             }

         });
        usr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                UserMenu men;
                try {
                    men = new UserMenu();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });


    }


    }




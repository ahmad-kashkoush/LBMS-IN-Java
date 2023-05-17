import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserMenu extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    JPanel pnl=new JPanel();
    JLabel FormTitle=new JLabel("User Menu");
    JButton []btn={
            new JButton("View Boooks"),
            new JButton("My Books"),
            new JButton("Recommend "),
            new JButton("My Purchases"),
            new JButton("Buy Book")
    };

    public UserMenu() throws SQLException {

        this.setSize(500, 600);
        this.setLocation(600, 25);
        this.setTitle("User Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new GridLayout(1, 1));

        pnl.setLayout(null);
        this.add(pnl);
        int btnWidth=150, btnHeight=30;
        int x=25, y=25;
        FormTitle.setBounds(100, y, 300, btnHeight);
        FormTitle.setFont(new Font(Font.SANS_SERIF, NORMAL, 28));
        y+=25+btnHeight+10;
        for(int i=0;i<btn.length;i++){
            btn[i].setBounds(x, y, btnWidth*3, btnHeight+20);
                y+=btnHeight+30+20;

        }
        pnl.add(FormTitle);
        for(int i=0;i<btn.length;i++)
            pnl.add(btn[i]);

        btn[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaymentForm pay;
                try {
                    pay = new PaymentForm();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
 btn[0].addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         dispose();
         CategoryForm c;
         try {
             c = new CategoryForm();
         } catch (SQLException ex) {
             throw new RuntimeException(ex);
         }

     }
 });
 btn[1].addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         dispose();
         CategoryForm c;
         try {
             c = new CategoryForm();
         } catch (SQLException ex) {
             throw new RuntimeException(ex);
         }

     }
 });
 btn[2].addActionListener(new ActionListener() {
     @Override
     public void actionPerformed(ActionEvent e) {
         dispose();
         JFrame view=new JFrame();
         view.setLocation(600, 25);
         view.setTitle("Recommended");
         view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         view.setResizable(false);
         view.setVisible(true);
         view.setSize(500, 800);
         JPanel p1=new JPanel(), p2=new JPanel();
         JLabel l=new JLabel("Enter BookName you Recommend");
         l.setFont(new Font(Font.SANS_SERIF, NORMAL, 26));
         JButton enter=new JButton("Enter");
         JButton usrMenu=new JButton("UserMenu");

         JTextField t=new JTextField();
         DefaultTableModel dtm=new DefaultTableModel();
         JTable tb=new JTable();
         view.setLayout(null);
         p2.setLayout(null);
         p1.setLayout(null);
         dtm.addColumn("Book Name");
         tb.getTableHeader().setFont(new Font("Segeo UI", Font.BOLD, 12));
         tb.getTableHeader().setBackground(new Color(30, 136, 203));
         tb.getTableHeader().setForeground(new Color(255, 255, 255));
         tb.setModel(dtm);



         p1.setBounds(0, 0, 500, 200);
         p2.setBounds(0, 200, 500, 600);

         l.setBounds(10, 10, 500, 60);
         t.setBounds(50, 80, 190, 30);
         enter.setBounds(250, 80, 190, 30);

         JScrollPane ppp=new JScrollPane(tb);
         ppp.setBounds(0, 0, 500, 500);
         usrMenu.setBounds(50,510,400,30 );






         p2.add(ppp);
         p2.add(usrMenu);
         p1.add(l);p1.add(t);
         p1.add(enter);

         view.add(p1);
         view.add(p2);


         enter.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 String txt=t.getText();
                 if(!txt.isEmpty()){
                  dtm.addRow(new Object[]{txt});
                  t.setText("");

                 }
                 tb.setModel(dtm);
             }
         });
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
     }
 });
        btn[3].addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                JFrame view;
                view = new JFrame();
                JTable tb = new JTable();

                JButton usrMenu = new JButton("User Menu");

                view.setSize(800, 800);
                view.setLocation(600, 25);
                view.setTitle("view my purshases");
                view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                view.setResizable(false);
                view.setVisible(true);
                view.setLayout(null);

                usrMenu.setBounds(50, 700, 700, 50);
                tb.setRowHeight(25);


                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn("id");
                dtm.addColumn("BookName");
                dtm.addColumn("UserId");
                dtm.addColumn("Price");
                tb.setModel(dtm);
                tb.getTableHeader().setFont(new Font("Segeo UI", Font.BOLD, 12));
                tb.getTableHeader().setBackground(new Color(30, 136, 203));
                tb.getTableHeader().setForeground(new Color(255, 255, 255));
                try {
                    String Id=JOptionPane.showInputDialog("Enter Your Id:");

                    PreparedStatement bks;
                    bks = conn.prepareStatement("SELECT * FROM Buy where UserId=?;");
                    bks.setInt(1, Integer.parseInt(Id));
                    ResultSet res = bks.executeQuery();
                    while (res.next()) {
                        dtm.addRow(new Object[]{res.getString("id"), res.getString("BookName"), res.getString(3), res.getString(4)});
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





    }
}

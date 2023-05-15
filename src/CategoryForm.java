import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CategoryForm extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    String[] arr_category = new String[]{"Programming", "Science", "Science  Fiction", "Cartoon", "Magic", "Mystery"};
    JPanel pc = new JPanel();
    JLabel choose_category = new JLabel ("<< Choose The Category You want >>");
    JComboBox cho_category = new JComboBox(arr_category);
    JButton done = new JButton("Done");
    public CategoryForm() throws SQLException {

        this.setTitle("Category");
        this.setSize(400,300);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(pc);
        pc.setLayout(null);
        pc.add(choose_category);
        pc.add(cho_category);
        pc.add(done);

        choose_category.setBounds(28,40,350,50);
        choose_category.setFont(new Font("Normal", Font.BOLD, 18));

        cho_category.setBounds(90,100,200,30);
        cho_category.setFont(new Font("Normal", Font.BOLD, 12));

        done.setBounds(115,180,100,30);
         done.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFrame view;
            view=new JFrame();
            JTable tb=new JTable();


            String ctg=cho_category.getSelectedItem().toString();

            view.setSize(800, 800);
            view.setTitle("VeiwBooks");
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setResizable(false);
            view.setVisible(true);
            view.setLayout(new GridLayout(1, 1));
            DefaultTableModel dtm=new DefaultTableModel();
            dtm.addColumn("id");
            dtm.addColumn("BookName");
            dtm.addColumn("quantity");
            dtm.addColumn("numberOfPages");
            dtm.addColumn("category");
            dtm.addRow(new Object[]{"id","BookName","quantity","numberOfPages","category"} );
            tb.setModel(dtm);
            view.setLayout(new GridLayout(1,1 ));
            try {
                PreparedStatement bks=conn.prepareStatement("SELECT * FROM Book WHERE category=?;");
                bks.setString(1, ctg);

                ResultSet res= bks.executeQuery();
                while(res.next()) {
                    dtm.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)});
                }
                tb.setModel(dtm);

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            view.add(tb);

        }

        });

    }


    }




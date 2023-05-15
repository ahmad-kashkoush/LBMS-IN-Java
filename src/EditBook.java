import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EditBook extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");

    String[] arr_quantity = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    JPanel p3 = new JPanel();
    JLabel edit_book =new JLabel("Edit Book");
    JLabel Id_Book = new JLabel("Enter The ID Book");
    JTextField  id_book = new JTextField();
    JLabel Edit_Quantity =new JLabel("choose The New Qunatity");
    JComboBox edit_quantity = new JComboBox(arr_quantity);
    JButton save = new JButton("Save Changes");

    public EditBook() throws SQLException {
        this.setTitle("Edit Book");
        this.setSize(430,330);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p3);
        p3.add(edit_book);
        p3.add(Id_Book);
        p3.add(id_book);
        p3.add(Edit_Quantity);
        p3.add(edit_quantity);
        p3.add(save);
        p3.setLayout(null);

        edit_book.setBounds(140,30,100,25);
        edit_book.setFont(new Font("Normal", Font.BOLD, 20));

        Id_Book.setBounds(40,80,150,30);
        Id_Book.setFont(new Font("SansSerif", Font.BOLD, 13));
        id_book.setBounds(180,80,200,30);

        Edit_Quantity.setBounds(15,140,200,30);
        Edit_Quantity.setFont(new Font("SansSerif", Font.BOLD, 13));
        edit_quantity.setBounds(180,140,200,30);

        save.setBounds(120,210,150,30);

        save.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//                JFrame AdmenMenu = new JFrame("A new game!");
//                AdmenMenu.setVisible(true);
////                AdmenMenu.add(new AdmenMenu());
////                AdmenMenu.pack();


                String id=id_book.getText();
                try {
                    if(!IdExists(id)){
                        id_book.setText("");
                        JOptionPane.showMessageDialog(null, "Id Doesn't exist");
                    }else{
                        PreparedStatement ps=conn.prepareStatement("Update Book set quantity=? where id=?");
                        String typedText = ((JTextField)edit_quantity.getEditor().getEditorComponent()).getText();

                        ps.setInt(1, Integer.parseInt(typedText));
                        ps.setString(2, id);
                        ps.executeUpdate();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
    }


    private Boolean IdExists(String idd) throws SQLException {

            PreparedStatement stm=conn.prepareStatement("SELECT * FROM Book  WHERE id=?");
            stm.setString(1, idd);
            ResultSet res=stm.executeQuery();
            if(res.next())
                    return true;
            return false;
        }

    public void Jshow(){
        this.setTitle("Edit Book");
        this.setSize(430,330);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p3);
        p3.add(edit_book);
        p3.add(Id_Book);
        p3.add(id_book);
        p3.add(Edit_Quantity);
        p3.add(edit_quantity);
        p3.add(save);
        p3.setLayout(null);

        edit_book.setBounds(140,30,100,25);
        edit_book.setFont(new Font("Normal", Font.BOLD, 20));

        Id_Book.setBounds(40,80,150,30);
        Id_Book.setFont(new Font("SansSerif", Font.BOLD, 13));
        id_book.setBounds(180,80,200,30);

        Edit_Quantity.setBounds(15,140,200,30);
        Edit_Quantity.setFont(new Font("SansSerif", Font.BOLD, 13));
        edit_quantity.setBounds(180,140,200,30);

        save.setBounds(120,210,150,30);

        save.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame AdmenMenu = new JFrame("A new game!");
                AdmenMenu.setVisible(true);
//                AdmenMenu.add(new  AddBookForm());
                AdmenMenu.pack();
                AdmenMenu.setVisible(true);
            }

        });
    }
    public void close(){
        this.setTitle("Edit Book");
        this.setSize(430,330);
        this.setResizable(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p3);
        p3.add(edit_book);
        p3.add(Id_Book);
        p3.add(id_book);
        p3.add(Edit_Quantity);
        p3.add(edit_quantity);
        p3.add(save);
        p3.setLayout(null);

        edit_book.setBounds(140,30,100,25);
        edit_book.setFont(new Font("Normal", Font.BOLD, 20));

        Id_Book.setBounds(40,80,150,30);
        Id_Book.setFont(new Font("SansSerif", Font.BOLD, 13));
        id_book.setBounds(180,80,200,30);

        Edit_Quantity.setBounds(15,140,200,30);
        Edit_Quantity.setFont(new Font("SansSerif", Font.BOLD, 13));
        edit_quantity.setBounds(180,140,200,30);

        save.setBounds(120,210,150,30);

//        save.addActionListener( new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                JFrame AdmenMenu = new JFrame("A new game!");
//                AdmenMenu.setVisible(false);
//                try {
//                    AdmenMenu.add(new  AddBookForm());
//                } catch (SQLException ex) {
//                    throw new RuntimeException(ex);
//                }
//                AdmenMenu.pack();
//                AdmenMenu.setVisible(false);
//
//            }
//
//        });
    }

}

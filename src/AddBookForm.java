import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;

public  class AddBookForm extends JFrame {
    Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LBMS", "root", "2003");
    String[] arr_quantity = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    JPanel p1 = new JPanel();
    JLabel title = new JLabel("Add Book");
    JLabel NameBook  = new JLabel("Name Book");
    JTextField Namebook = new JTextField();
    JLabel ID  = new JLabel("ID");
    JTextField Id= new JTextField();
    JLabel Quantity  = new JLabel("Quantity");
    JComboBox quantity = new JComboBox(arr_quantity);
    JLabel NumberOfPages  = new JLabel("Number Of Pages");
    JTextField NumberofPages = new JTextField();
    JLabel Category  = new JLabel("Category");
    JTextField category= new JTextField();
    JButton Save =new JButton("Save Changes");
    public  AddBookForm() throws SQLException {
    }
    public void Jshow(){
        this.setTitle("Add Book");
        this.setSize(400,500);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p1);
        //   p1.setBackground(Color.GRAY);
        p1.add(title);
        p1.add(NameBook);
        p1.add(Namebook);
        p1.add(ID);
        p1.add(Id);
        p1.add(Quantity);
        p1.add(quantity);
        p1.add(NumberOfPages);
        p1.add(NumberofPages);
        p1.add(Category);
        p1.add(category);
        p1.add(Save);
        p1.setLayout(null);

        title.setBounds(122,20,250,100);
        title.setFont(new Font("Normal", Font.BOLD, 26));

        NameBook.setBounds(40,120,150,25);
        NameBook.setFont(new Font("Arial", Font.PLAIN, 15));
        Namebook.setBounds(150,120,200,30);

        ID.setBounds(65,170,150,25);
        ID.setFont(new Font("Arial", Font.PLAIN, 15));
        Id.setBounds(150,170,200,25);

        Quantity.setBounds(50,220,150,25);
        Quantity.setFont(new Font("Arial", Font.PLAIN, 15));
        quantity.setBounds(150,220,200,25);

        NumberOfPages.setBounds(25,270,150,25);
        NumberOfPages.setFont(new Font("Arial", Font.PLAIN, 15));
        NumberofPages.setBounds(150,270,200,25);

        Category.setBounds(50,320,150,25);
        Category.setFont(new Font("Arial", Font.PLAIN, 15));
        category.setBounds(150,320,200,25);

        Save.setBounds(122,370,150,30);

        Save.addActionListener( new ActionListener() {
            public void  actionPerformed(ActionEvent e) {
                JFrame AdmenMenu = new JFrame("A new game!");
                try {
                    if(CheckIdDB(Id.getText())) {
                        Id.setText("");
                        JOptionPane.showMessageDialog(null, "Id Alread Exists");
                    }else {
                        PreparedStatement st = conn.prepareStatement("INSERT INTO Book(id, BookName, quantity, numberOfPages, category) values (?,?, ?, ?, ?) ");
                        st.setString(1, NameBook.getText());
                        st.setString(1, Id.getText());

                        st.setString(2, Namebook.getText());
                        String typedText;
                        typedText = ((JTextField) quantity.getEditor().getEditorComponent()).getText();
                        st.setInt(3, Integer.parseInt(typedText));
                        st.setInt(4, Integer.parseInt(NumberofPages.getText()));
                        st.setString(5, category.getText());
                        st.executeUpdate();

                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }




            }
        });

    }
    private Boolean CheckIdDB(String idd) throws SQLException {
        PreparedStatement stm=conn.prepareStatement("SELECT * FROM Book  WHERE id=?");
        stm.setString(1, idd);
        ResultSet res=stm.executeQuery();
        while(res.next()){
            if(res.getString("id")==idd)
                return false;
        }
        return true;
    }
    public void close(){
        this.setTitle("Add Book");
        this.setSize(400,500);
        this.setResizable(false);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(p1);
        //   p1.setBackground(Color.GRAY);
        p1.add(title);
        p1.add(NameBook);
        p1.add(Namebook);
        p1.add(ID);
        p1.add(Id);
        p1.add(Quantity);
        p1.add(quantity);
        p1.add(NumberOfPages);
        p1.add(NumberofPages);
        p1.add(Category);
        p1.add(category);
        p1.add(Save);
        p1.setLayout(null);

        title.setBounds(122,20,250,100);
        title.setFont(new Font("Normal", Font.BOLD, 26));

        NameBook.setBounds(40,120,150,25);
        NameBook.setFont(new Font("Arial", Font.PLAIN, 15));
        Namebook.setBounds(150,120,200,30);

        ID.setBounds(65,170,150,25);
        ID.setFont(new Font("Arial", Font.PLAIN, 15));
        Id.setBounds(150,170,200,25);

        Quantity.setBounds(50,220,150,25);
        Quantity.setFont(new Font("Arial", Font.PLAIN, 15));
        quantity.setBounds(150,220,200,25);

        NumberOfPages.setBounds(25,270,150,25);
        NumberOfPages.setFont(new Font("Arial", Font.PLAIN, 15));
        NumberofPages.setBounds(150,270,200,25);

        Category.setBounds(50,320,150,25);
        Category.setFont(new Font("Arial", Font.PLAIN, 15));
        category.setBounds(150,320,200,25);

        Save.setBounds(122,370,150,30);

        Save.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame AdmenMenu = new JFrame("A new game!");
                AdmenMenu.setVisible(false);
                AdmenMenu.add(new AdmenMenu());
                AdmenMenu.pack();



            }

        });
    }

}
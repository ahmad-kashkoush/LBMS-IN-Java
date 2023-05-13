import javax.swing.*;
import java.awt.*;

    public class AddBookForm extends JFrame {
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
        public AddBookForm(){
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
        }



    }


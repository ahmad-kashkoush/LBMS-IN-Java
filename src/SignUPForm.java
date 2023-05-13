import javax.swing.*;
import java.awt.*;

public class SignUPForm extends JFrame {
    public SignUPForm(){
        this.setSize(500, 850);
        this.setTitle("Sign UP");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new GridLayout(1, 1));

        arrSet();
        SetBounds();
        AddComponents();
    }
    public void SetBounds(){
        pnl.setLayout(null);
        int LabelWidth=100, LabelHeight=30;

        int txtFieldWidth=LabelWidth*3;
        int x=25;

        int row=x, PrvHeight=0;
        FormTitle.setFont(new Font(Font.SANS_SERIF, NORMAL, 28));
        FormTitle.setBounds(200, 5, 250, 100);
        row+=x+15; PrvHeight+=LabelHeight;
        int col=25, col2=col+LabelWidth+10;
        First.setBounds(col,row+PrvHeight, LabelWidth, LabelHeight );
        tFirst.setBounds(col2,row+PrvHeight, txtFieldWidth, LabelHeight);


        row+=x; PrvHeight+=LabelHeight;
        Second.setBounds(col, row+PrvHeight,LabelWidth, LabelHeight);
        tSecond.setBounds(col2,row+PrvHeight, txtFieldWidth, LabelHeight );


        row+=x; PrvHeight+=LabelHeight;
        Gender.setBounds(col, row+PrvHeight,LabelWidth, LabelHeight);
        gndr[0].setBounds(col2, row+PrvHeight, LabelWidth, LabelHeight);
        gndr[1].setBounds(col2+LabelWidth,row+PrvHeight, LabelWidth, LabelHeight);


        row+=x;PrvHeight+=LabelHeight;
        Categorie.setBounds(col, row+PrvHeight, LabelWidth, LabelHeight);
        row+=x;PrvHeight+=LabelHeight;
        int xx=col+10;
        for(int i=0;i<Categories.length;i++){
             Categories[i].setBounds(xx,PrvHeight+row,LabelWidth, LabelHeight);
             xx+=LabelWidth;
             if(i%2==1){
                 row+=x;
                 PrvHeight+=LabelHeight;
                 xx=col;
             }
        }

        row+=x;PrvHeight+=LabelHeight;
        Email.setBounds(col,row+PrvHeight, LabelWidth, LabelHeight );
        tEmail.setBounds(col2,row+PrvHeight, txtFieldWidth, LabelHeight);

        row+=x;PrvHeight+=LabelHeight;
        Phone.setBounds(col,row+PrvHeight, LabelWidth, LabelHeight );
        tPhone.setBounds(col2,row+PrvHeight, txtFieldWidth, LabelHeight);


        row+=x;PrvHeight+=LabelHeight;
        DOP.setBounds(col,row+PrvHeight, LabelWidth, LabelHeight );
        day.setBounds(col2, row+PrvHeight, LabelWidth, LabelHeight);
        month.setBounds(col2+LabelWidth, row+PrvHeight, LabelWidth, LabelHeight);
        year.setBounds(col2+2*LabelWidth, row+PrvHeight, LabelWidth, LabelHeight);

        row+=x;PrvHeight+=LabelHeight;
        Password.setBounds(col,row+PrvHeight, LabelWidth, LabelHeight );
        tPassword.setBounds(col2,row+PrvHeight, txtFieldWidth, LabelHeight);

        row+=x;PrvHeight+=LabelHeight;
        AcceptTerms.setBounds(col, row+PrvHeight, LabelWidth*2, LabelHeight);

        row+=x;PrvHeight+=LabelHeight;
        Submit.setBounds(col2, row+PrvHeight, LabelWidth, LabelHeight);
        Reset.setBounds(col2+LabelWidth+15, row+PrvHeight, LabelWidth, LabelHeight);
    }
    public void arrSet(){
        for(int i=0;i<100;i++){
            if(i<=30)arrDay[i]=Integer.toString(i+1);
            arrYear[i]=Integer.toString(2000+i+1);
        }
      day=new JComboBox(arrDay);
      month=new JComboBox(arrMonth);
      year=new JComboBox(arrYear);
    }
    public void AddComponents(){
        this.add(pnl);
        //labels
        pnl.add(First);
        pnl.add(Second);
        pnl.add(Categorie);
        pnl.add(Email);
        pnl.add(Phone);
        pnl.add(Password);
        pnl.add(Gender);
        pnl.add(FormTitle);
        pnl.add(DOP);

        // textFields
        pnl.add(tFirst);
        pnl.add(tSecond);
        pnl.add(tEmail);
        pnl.add(tPhone);
        pnl.add(tPassword);


        //checkbox and radio buttons
        g1.add(gndr[0]);
        g1.add(gndr[1]);
        pnl.add(gndr[0]);
        pnl.add(gndr[1]);
        for(int i=0;i<Categories.length;i++)
            pnl.add(Categories[i]);
        pnl.add(AcceptTerms);

        // Buttons
        pnl.add(Submit);
        pnl.add(Reset);

        // comboBox
        pnl.add(day);
        pnl.add(month);
        pnl.add(year);

    }
    JPanel pnl=new JPanel();
    JLabel FormTitle=new JLabel("Sign UP");
    JLabel First=new JLabel("FirstName");
    JLabel Second=new JLabel("SecondName");
    JLabel Categorie=new JLabel("Categories");
    JLabel Email=new JLabel("Email");
    JLabel Phone=new JLabel("Phone");
    JLabel Gender=new JLabel("Gender: ");
    JLabel Password=new JLabel("Password");
    JLabel DOP=new JLabel("BirthDate: ");
    JTextField tFirst=new JTextField();
    JTextField tSecond=new JTextField();
    JTextField tEmail=new JTextField();
    JTextField tPhone=new JTextField();

    JPasswordField tPassword=new JPasswordField("Password");
    ButtonGroup g1=new ButtonGroup();
    JRadioButton []gndr={new JRadioButton("Male"), new JRadioButton("Female")};


    JCheckBox []Categories={
            new JCheckBox("All"),
            new JCheckBox("Science"),
            new JCheckBox("Science2"),
            new JCheckBox("Science3")
    };
    JCheckBox AcceptTerms=new JCheckBox("Accept Terms of services");
    String []arrDay=new String[31];
    String []arrMonth={"January","February","March","April","May","June","July", "August","September","October","November","December"};
    String []arrYear=new String[100];

    JButton Submit=new JButton("Submit");
    JButton Reset=new JButton("Reset");
    JComboBox day=new JComboBox(arrDay);
    JComboBox month=new JComboBox(arrMonth);
    JComboBox year=new JComboBox(arrYear);


}

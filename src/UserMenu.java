import javax.swing.*;
import java.awt.*;

public class UserMenu extends JFrame {
    JPanel pnl=new JPanel();
    JLabel FormTitle=new JLabel("User Menu");
    JButton []btn={
            new JButton("View Boooks"),
            new JButton("My Books"),
            new JButton("Recommend "),
            new JButton("My Purchases"),
            new JButton("Buy Books")
    };

    public UserMenu(){
        this.setSize(400, 300);
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
            btn[i].setBounds(x, y, btnWidth, btnHeight);
            x+=btnWidth+10;
            if(i%2==1){
                x=25;
                y+=btnHeight+10;
            }
        }
        pnl.add(FormTitle);
        for(int i=0;i<btn.length;i++)
            pnl.add(btn[i]);

    }
}

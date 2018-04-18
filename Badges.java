package trial1;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Badges extends JFrame {
    
    private JLabel badge1 = new JLabel();
    private JLabel badge2 = new JLabel();
    private JLabel badge3 = new JLabel();
    private JLabel badge4 = new JLabel();
    private JLabel badge5 = new JLabel();
    private JLabel badge6 = new JLabel();
    private JLabel badge7 = new JLabel();
    private JLabel badge8 = new JLabel();
    private JButton back = new JButton();
     //private JLabel score = new JLabel("Score");

    Badges() {
    initcomponents();
    initevents();
    }

    public void initcomponents(){
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BITSian Hangman!");
            
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
            
        java.net.URL imageURLx = Trial1.class.getResource("images/back.jpg");
        ImageIcon iconx = new ImageIcon(imageURLx);
        back.setIcon(iconx);
        back.setLocation(10, 10);
        back.setSize(50, 50);
        
        // badge 1
        java.net.URL imageURL = Trial1.class.getResource("images/gray_badge.png");
        ImageIcon icon1 = new ImageIcon(imageURL);
        badge1.setIcon(icon1);
        badge1.setLocation(40, 75);
        badge1.setSize(150, 150);
       
        java.net.URL imageURL1 = Trial1.class.getResource("images/gray_badge1.png"); 
        ImageIcon icon2 = new ImageIcon(imageURL1);
        badge2.setIcon(icon2);
        badge2.setLocation(230, 75);
        badge2.setSize(150, 150);
         
        java.net.URL imageURL3 = Trial1.class.getResource("images/gray_badge2.png");
        ImageIcon icon3 = new ImageIcon(imageURL3);
        badge3.setIcon(icon3);
        badge3.setLocation(420, 75);
        badge3.setSize(150, 150);
        
        java.net.URL imageURL4 = Trial1.class.getResource("images/gray_badge3.png");
        ImageIcon icon4 = new ImageIcon(imageURL4);
        badge4.setIcon(icon4);
        badge4.setLocation(610, 75);
        badge4.setSize(150, 150);
        
        java.net.URL imageURL5 = Trial1.class.getResource("images/gray_badge4.png");
        ImageIcon icon5 = new ImageIcon(imageURL5);
        badge5.setIcon(icon5);
        badge5.setLocation(40, 275);
        badge5.setSize(150, 150);
        
        java.net.URL imageURL6 = Trial1.class.getResource("images/gray_badge5.png");
        ImageIcon icon6 = new ImageIcon(imageURL6);
        badge6.setIcon(icon6);
        badge6.setLocation(230, 275);
        badge6.setSize(150, 150);
        
        java.net.URL imageURL7 = Trial1.class.getResource("images/gray_badge6.png");
        ImageIcon icon7 = new ImageIcon(imageURL7);
        badge7.setIcon(icon7);
        badge7.setLocation(420, 275);
        badge7.setSize(150, 150);
        
        java.net.URL imageURL8 = Trial1.class.getResource("images/gray_badge7.png");
        ImageIcon icon8 = new ImageIcon(imageURL8);
        badge8.setIcon(icon8);
        badge8.setLocation(610, 275);
        badge8.setSize(150, 150);
        
//        score.setLocation(200,600);
//        score.setSize(100, 100);
//        score.setFont(new Font("Arial", Font.BOLD, 50));
//        score.setForeground(Color.GREEN);
            
        panel1.setLayout(null);
        panel1.add(badge1);
        panel1.add(badge2);
        panel1.add(badge3);
        panel1.add(badge4);
        panel1.add(badge5);
        panel1.add(badge6);
        panel1.add(badge7);
        panel1.add(badge8);
        panel1.add(back);
        //panel1.add(score);
        
        panel1.setVisible(true);
        this.add(panel1);
        this.setVisible(true);
    }  
    
    public void initevents() {
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    trial1.MainMenu menu = new trial1.MainMenu();
                }
            });
    }

}

package trial1;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class MainMenu extends JFrame{
    
        //Components
        private JLabel header = new JLabel("BPHC HANGMAN");
        private JButton play  = new JButton("Play!");
        private JButton achievements  = new JButton("Achievements");
        private JButton highscores  = new JButton("High Scores");
        private JButton exit  = new JButton("Exit");
        private JLabel sound3label = new JLabel();
        private JLabel hangmanlabel = new JLabel();
        private JLabel logo = new JLabel();
            
        
        MainMenu(){
            initcomponent();
            initevent();
        }
        
        public void initcomponent() {
            this.setSize(800,800);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("BITSian Hangman!");
            
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.BLACK);
            
            //Title
            header.setLocation(200,30);
            header.setSize(600, 100);
            header.setFont(new Font("Arial", Font.BOLD, 50));
            header.setForeground(Color.GREEN);
            
            //Image of hangman
            java.net.URL imageURL = Trial1.class.getResource("images/HangPicResized.jpg");
            ImageIcon icon1 = new ImageIcon(imageURL);
            hangmanlabel.setIcon(icon1);
            hangmanlabel.setLocation(25, 500);
            hangmanlabel.setSize(225, 225);
            
            //Image of sound3 mute button
            java.net.URL imageURL2 = Trial1.class.getResource("images/sound3.png");
            ImageIcon icon2 = new ImageIcon(imageURL2);
            sound3label.setIcon(icon2);
            sound3label.setLocation(650, 400);
            sound3label.setSize(75, 70);
                    
            //Button1
            play.setLocation(275, 150);
            play.setSize(250, 100);
            play.setFont(new Font("Arial", Font.PLAIN, 40));
            play.setBackground(Color.BLUE);
            play.setForeground(Color.RED);
            
            //Button2
            achievements.setLocation(260, 300);
            achievements.setSize(280, 100);
            achievements.setFont(new Font("Arial", Font.PLAIN, 40));
            achievements.setBackground(Color.BLUE);
            achievements.setForeground(Color.RED);
            
            //Button3
            highscores.setLocation(275, 450);
            highscores.setSize(250, 100);
            highscores.setFont(new Font("Arial", Font.PLAIN, 40));
            highscores.setBackground(Color.BLUE);
            highscores.setForeground(Color.RED);
            
            //Button4
            exit.setLocation(275, 600);
            exit.setSize(250, 100);
            exit.setFont(new Font("Arial", Font.PLAIN, 40));
            exit.setBackground(Color.BLUE);
            exit.setForeground(Color.RED);
            
            java.net.URL imageURL9 = Trial1.class.getResource("images/bits_pilani.jpg");
            ImageIcon icon9 = new ImageIcon(imageURL9);
            logo.setIcon(icon9);
            logo.setLocation(25, 150);
            logo.setSize(220, 220);
            
            //Add to panel, then frame
            panel1.setLayout(null);
            panel1.add(header);
            panel1.add(play);
            panel1.add(achievements);
            panel1.add(highscores);
            panel1.add(exit);
            panel1.add(hangmanlabel);
            panel1.add(sound3label);
            panel1.add(logo);
            panel1.setVisible(true);
            this.add(panel1);
            this.setVisible(true);
        }
        
        //ActionListeners call respective functions
        public void initevent() {
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    System.exit(1);
                }
            });

            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StartPlay(e);
                }
            });

            achievements.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListAchievements(e);
                }
            });
            
            highscores.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ListHighScores(e);
                }
            });
            
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ExitTheApp(e);
                }
            });
            
            sound3label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    java.net.URL imageURL = Trial1.class.getResource("images/mute2.png");
                    ImageIcon icon2 = new ImageIcon(imageURL);
                    sound3label.setIcon(icon2);
                }
            });
        }
        
        //Function bodies
        private void StartPlay(ActionEvent e){
            trial1.PlayMenu menu2 = new trial1.PlayMenu();
        }
        
        private void ListAchievements(ActionEvent e){
            trial1.Badges badges = new trial1.Badges();
        }
        
        private void ListHighScores(ActionEvent e){
            
        }
        
        private void ExitTheApp(ActionEvent e){
            System.exit(1);
        }
        
    }
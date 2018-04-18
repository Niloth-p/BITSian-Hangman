package trial1;

import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class PlayMenu extends JFrame{
    
        //Components
        private JLabel header = new JLabel("BPHC HANGMAN");
        private JButton play  = new JButton("Play!");
        private String[] Players = {"Single Player", "Multi Player"};
        private JComboBox PlayersList = new JComboBox(Players);
        private String[] Timer = {"Classic", "Timed"};
        private JComboBox TimerOptions = new JComboBox(Timer);
        private String[] Categories = {"Groups", "Faculties", "Campus", "Misc", "Fests and Events", "Courses"};
        private JComboBox CategoriesList = new JComboBox(Categories);
        
        PlayMenu(){
            initcomponent();
            initevent();
        }
        
        public void initcomponent() {
            this.setSize(800,800);
            this.setLocationRelativeTo(null);
            this.setResizable(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("BITSian Hangman!");
            
            JPanel panel1 = new JPanel();
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
            panel1.setBackground(Color.BLACK);
            
            //Title
            //header.setLocation(200,30);
            //header.setSize(600, 100);
            header.setFont(new Font("Arial", Font.BOLD, 50));
            //Font - MIN, Size - MIN
            header.setForeground(Color.GREEN);
            
            //SP/MP ComboBox
            PlayersList.setSelectedIndex(0);
            PlayersList.setFont(new Font("Arial", Font.PLAIN, 40));
            PlayersList.setPreferredSize(new Dimension(250, 100));
            PlayersList.setAlignmentX(CENTER_ALIGNMENT);
                        
            //Classic/Timed ComboBox
            TimerOptions.setSelectedIndex(0);
            TimerOptions.setFont(new Font("Arial", Font.PLAIN, 40));
            TimerOptions.setPreferredSize(new Dimension(250, 100));
            TimerOptions.setAlignmentX(CENTER_ALIGNMENT);
            
            //Categories ComboBox
            CategoriesList.setSelectedIndex(0);
            CategoriesList.setFont(new Font("Arial", Font.PLAIN, 40));
            CategoriesList.setPreferredSize(new Dimension(250, 100));
            CategoriesList.setAlignmentX(CENTER_ALIGNMENT);
            
            //Play! Button
            //play.setLocation(275, 600);
            //play.setSize(250, 100);
            play.setFont(new Font("Arial", Font.PLAIN, 40));
            //Font, Size - MIN
            play.setBackground(Color.BLUE);
            play.setForeground(Color.RED);
            play.setAlignmentX(CENTER_ALIGNMENT);
            play.setPreferredSize(new Dimension(250, 100));
            
            //Add to panel, then frame
            panel1.add(Box.createRigidArea(new Dimension(0,50)));
            panel1.add(header);
            panel1.add(Box.createRigidArea(new Dimension(0,70)));
            panel1.add(PlayersList);
            panel1.add(Box.createRigidArea(new Dimension(0,100)));
            panel1.add(TimerOptions);
            panel1.add(Box.createRigidArea(new Dimension(0,100)));
            panel1.add(CategoriesList);
            panel1.add(Box.createRigidArea(new Dimension(0,100)));
            panel1.add(play);
            panel1.add(Box.createRigidArea(new Dimension(0,70)));
            panel1.setVisible(true);
            this.add(panel1);
            this.setVisible(true);
        }
        
        //ActionListeners call respective functions
        public void initevent() {
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e){
                    System.exit(1);
                }
            });

//          PlayList.addActionListener(new ActionListener() {
//              @Override
//              public void actionPerformed(ActionEvent e) {
//                  String petName = (String)cb.getSelectedItem();
//                  updateLabel(petName);
//              }
//          }
        
            play.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        trial1.GameScreen gamescreen = new trial1.GameScreen((String)PlayersList.getSelectedItem(), (String)TimerOptions.getSelectedItem(), (String) CategoriesList.getSelectedItem());
                    } catch (IOException ex) {
                        Logger.getLogger(PlayMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });   
        }
    }

//Size - setMinimumSize, setPreferredSize, and setMaximumSize
//Alignment - setAlignmentX and setAlignmentY
//Space between components
//Borders - especially for the sides wala distance

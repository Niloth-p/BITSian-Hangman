package trial1;

import java.awt.Canvas;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.canvas.GraphicsContext;

public class GameScreen extends JFrame{
    
    private JLabel header = new JLabel("BPHC HANGMAN");
    private List<JButton> buttonList = new ArrayList<JButton>();
    private JButton a  = new JButton("A");
    private JButton b  = new JButton("B");
    private JButton c  = new JButton("C");
    private JButton d  = new JButton("D");
    private JButton e  = new JButton("E");
    private JButton f  = new JButton("F");
    private JButton g  = new JButton("G");
    private JButton h  = new JButton("H");
    private JButton i  = new JButton("I");
    private JButton j  = new JButton("J");
    private JButton k  = new JButton("K");
    private JButton l  = new JButton("L");
    private JButton m  = new JButton("M");
    private JButton n  = new JButton("N");
    private JButton o  = new JButton("O");
    private JButton p  = new JButton("P");
    private JButton q  = new JButton("Q");
    private JButton r  = new JButton("R");
    private JButton s  = new JButton("S");
    private JButton t  = new JButton("T");
    private JButton u  = new JButton("U");
    private JButton v  = new JButton("V");
    private JButton w  = new JButton("W");
    private JButton x  = new JButton("X");
    private JButton y  = new JButton("Y");
    private JButton z  = new JButton("Z");
    private JLabel space = new JLabel("Loading"); 
    private JButton back = new JButton();
    private JLabel hangmanlabel = new JLabel();
    private String blanks = "";
    
    GameScreen(String players, String timed, String category) throws IOException{
        //if(timed == "Timed")
            
        
        initcomponent();
        setupword(category);
        initevent();
    }
    
    public void initcomponent() throws IOException {
        this.setSize(800,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("BITSian Hangman!");
            
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.BLACK);
        
//        String[] texts = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
//        for(int i = 0; i < 26; i++) {
//            String name = texts[i].toLowerCase();
//            JButton name = new JButton(texts[i]);
//            buttonList.add(button);
//            panel1.add(button);
//        }
        
//        HangmanGame game = new HangmanGame();
        
        //Title
        header.setLocation(200,30);
        header.setSize(600, 100);
        header.setFont(new Font("Arial", Font.BOLD, 50));
        header.setForeground(Color.GREEN);
    
        //Alphabets
        Alphabets();
        
        //Back
        java.net.URL imageURLx = Trial1.class.getResource("images/back.jpg");
        ImageIcon iconx = new ImageIcon(imageURLx);
        back.setIcon(iconx);
        back.setLocation(10, 10);
        back.setSize(50, 50);
        
        //Blanks Label
        space.setLocation(350,100);
        space.setSize(425, 300);
        space.setFont(new Font("Arial", Font.BOLD, 50));
        space.setForeground(Color.GREEN);
        space.setText("<html>" + "blanks" + "<html>");
        
        //setLocation(50, 175);
        //setSize(250, 450);  
        //fillOval(145, 205, 60, 60);
        //drawLine()
        //GameScreen game = new GameScreen();
        //game.paint(null);
        
        //Add to panel, then frame
        panel1.setLayout(null);
        panel1.add(header);
        panel1.add(a);
        panel1.add(b);
        panel1.add(c);
        panel1.add(d);
        panel1.add(e);
        panel1.add(f);
        panel1.add(g);
        panel1.add(h);
        panel1.add(i);
        panel1.add(j);
        panel1.add(k);
        panel1.add(l);
        panel1.add(m);
        panel1.add(n);
        panel1.add(o);
        panel1.add(p);
        panel1.add(q);
        panel1.add(r);
        panel1.add(s);
        panel1.add(t);
        panel1.add(u);
        panel1.add(v);
        panel1.add(w);
        panel1.add(x);
        panel1.add(y);
        panel1.add(z);
        panel1.add(back);
        panel1.add(hangmanlabel);
        buttonList.add(a);
        buttonList.add(b);
        buttonList.add(c);
        buttonList.add(d);
        buttonList.add(e);
        buttonList.add(f);
        buttonList.add(g);
        buttonList.add(h);
        buttonList.add(i);
        buttonList.add(j);
        buttonList.add(k);
        buttonList.add(l);
        buttonList.add(n);
        buttonList.add(o);
        buttonList.add(p);
        buttonList.add(q);
        buttonList.add(r);
        buttonList.add(s);
        buttonList.add(t);
        buttonList.add(u);
        buttonList.add(v);
        buttonList.add(w);
        buttonList.add(x);
        buttonList.add(y);
        buttonList.add(z);
        for (JButton b : buttonList) {
            b.setEnabled(true);
            b.addActionListener(new addButtonListener());
        }
        panel1.add(space);
        panel1.setVisible(true);
        this.add(panel1);
        this.setVisible(true);
        
        //while(gameOver == 0 && win ==0)
    }
    
    //ActionListeners call respective functions
    public void initevent() {
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(1);
            }
        });
        
        back.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    trial1.MainMenu menu = new trial1.MainMenu();
                }
            });

//            a.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    a.setForeground(Color.RED);
//                }
//            });

        //addButtonListener obj = new addButtonListener();
        //obj.actionPerformed(e);
    }
    
    public double wordidcomputer;
    public String wordComputer;
    public int wordLength;
    final int FULL_HANGMAN = 6;
    final int WORDLIST_SIZE = 54;
    private int noOfTriesLeft = FULL_HANGMAN;
    private int hangman = 0;
    //private String wordUser = createDummyArray(wordLength);
    private String wordUser;
    private int wrongTries = 0;
    private int win = 0;
    private int gameOver = 0;
    private int flag = 0;
    private String newWordUser; 
    
    public void setupword(String category) throws IOException {
        wordidcomputer = getRandomIntegerBetweenRange(1,WORDLIST_SIZE);
        wordComputer = getWordfromFile(wordidcomputer, category);  
        System.out.println("word : " + wordComputer);
        wordLength = wordComputer.length();
        blanks = wordComputer;
        blanks = blanks.replaceAll("[a-zA-Z]", "*");
        space.setText("<html>" + blanks + "</html>");
        flag = 0;
        wordUser = blanks;
    }
    
    public double getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return x;
    }
    
    public String getWordfromFile(double wordidcomputer, String category) throws IOException {
        System.out.println("id : " + String.valueOf((int)wordidcomputer));
        String line = Files.readAllLines(Paths.get("F:\\Imay\\Sem6\\OOP\\Hangman\\WordList.txt")).get((int)wordidcomputer);
        String [] splitSt =line.split(",");
        //while(splitSt[2] != category)
        //    wordidcomputer = getRandomIntegerBetweenRange(1,WORDLIST_SIZE);
        return splitSt[1];
    }
    
    public String createDummyArray(int wordLength) {
	char[] array = new char[wordLength];
    	int pos = 0;
    	while (pos < wordLength) {
            if(wordComputer.charAt(pos) != ' ')
        	array[pos] = '*';
            else 
        	array[pos] = ' ';
            pos++;
    	}
    	return new String(array);
    }
    
    public void GetNoOfTriesLeft() {
	noOfTriesLeft -= 1;
    }
    
    public int checkWin() {
	if(wordComputer.equalsIgnoreCase(wordUser)) {	
            System.out.println("Inside Checkwin");
            return (1);
	}	
	else return (0);
    }
    
//    public int HangmanBodyPart() {
//	hangman += 1;
//	if(hangman == FULL_HANGMAN)
//            return (1);
//	else return (0);
//    }
    
//    public void paint(Graphics g)
//    {
//        g.setColor(Color.WHITE);
//        g.drawOval(145, 205, 60, 60);
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//        g.drawLine();
//    }
    
    public void Alphabets() {
        a.setLocation(75, 550);
        a.setSize(35, 35);
        a.setFont(new Font("Arial", Font.BOLD, 24));
        a.setBackground(Color.BLUE);
        a.setForeground(Color.GREEN);
        a.setBorder(null);
       
        b.setLocation(125, 550);
        b.setSize(35, 35);
        b.setFont(new Font("Arial", Font.BOLD, 24));
        b.setBackground(Color.BLUE);
        b.setForeground(Color.GREEN);
        b.setBorder(null);
        
        c.setLocation(175, 550);
        c.setSize(35, 35);
        c.setFont(new Font("Arial", Font.BOLD, 24));
        c.setBackground(Color.BLUE);
        c.setForeground(Color.GREEN);
        c.setBorder(null);
        
        d.setLocation(225, 550);
        d.setSize(35, 35);
        d.setFont(new Font("Arial", Font.BOLD, 24));
        d.setBackground(Color.BLUE);
        d.setForeground(Color.GREEN);
        d.setBorder(null);
        
         e.setLocation(275, 550);
        e.setSize(35, 35);
        e.setFont(new Font("Arial", Font.BOLD, 24));
        e.setBackground(Color.BLUE);
        e.setForeground(Color.GREEN);
        e.setBorder(null);
        
         f.setLocation(325, 550);
        f.setSize(35, 35);
        f.setFont(new Font("Arial", Font.BOLD, 24));
        f.setBackground(Color.BLUE);
        f.setForeground(Color.GREEN);
        f.setBorder(null);
        
         g.setLocation(375, 550);
        g.setSize(35, 35);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.setBackground(Color.BLUE);
        g.setForeground(Color.GREEN);
        g.setBorder(null);
        
         h.setLocation(425, 550);
        h.setSize(35, 35);
        h.setFont(new Font("Arial", Font.BOLD, 24));
        h.setBackground(Color.BLUE);
        h.setForeground(Color.GREEN);
        h.setBorder(null);
        
         i.setLocation(475, 550);
        i.setSize(35, 35);
        i.setFont(new Font("Arial", Font.BOLD, 24));
        i.setBackground(Color.BLUE);
        i.setForeground(Color.GREEN);
        i.setBorder(null);
        
         j.setLocation(525, 550);
        j.setSize(35, 35);
        j.setFont(new Font("Arial", Font.BOLD, 24));
        j.setBackground(Color.BLUE);
        j.setForeground(Color.GREEN);
        j.setBorder(null);
        
         k.setLocation(575, 550);
        k.setSize(35, 35);
        k.setFont(new Font("Arial", Font.BOLD, 24));
        k.setBackground(Color.BLUE);
        k.setForeground(Color.GREEN);
        k.setBorder(null);
        
        l.setLocation(625, 550);
        l.setSize(35, 35);
        l.setFont(new Font("Arial", Font.BOLD, 24));
        l.setBackground(Color.BLUE);
        l.setForeground(Color.GREEN);
        l.setBorder(null);
        
         m.setLocation(675, 550);
        m.setSize(35, 35);
        m.setFont(new Font("Arial", Font.BOLD, 24));
        m.setBackground(Color.BLUE);
        m.setForeground(Color.GREEN);
        m.setBorder(null);
        
        n.setLocation(75, 600);
        n.setSize(35, 35);
        n.setFont(new Font("Arial", Font.BOLD, 24));
        n.setBackground(Color.BLUE);
        n.setForeground(Color.GREEN);
        n.setBorder(null);
        
        o.setLocation(125, 600);
        o.setSize(35, 35);
        o.setFont(new Font("Arial", Font.BOLD, 24));
        o.setBackground(Color.BLUE);
        o.setForeground(Color.GREEN);
        o.setBorder(null);
        
         p.setLocation(175, 600);
        p.setSize(35, 35);
        p.setFont(new Font("Arial", Font.BOLD, 24));
        p.setBackground(Color.BLUE);
        p.setForeground(Color.GREEN);
        p.setBorder(null);
        
         q.setLocation(225, 600);
        q.setSize(35, 35);
        q.setFont(new Font("Arial", Font.BOLD, 24));
        q.setBackground(Color.BLUE);
        q.setForeground(Color.GREEN);
        q.setBorder(null);
        
         r.setLocation(275, 600);
        r.setSize(35, 35);
        r.setFont(new Font("Arial", Font.BOLD, 24));
        r.setBackground(Color.BLUE);
        r.setForeground(Color.GREEN);
        r.setBorder(null);
        
         s.setLocation(325, 600);
        s.setSize(35, 35);
        s.setFont(new Font("Arial", Font.BOLD, 24));
        s.setBackground(Color.BLUE);
        s.setForeground(Color.GREEN);
        s.setBorder(null);
        
         t.setLocation(375, 600);
        t.setSize(35, 35);
        t.setFont(new Font("Arial", Font.BOLD, 24));
        t.setBackground(Color.BLUE);
        t.setForeground(Color.GREEN);
        t.setBorder(null);
        
         u.setLocation(425, 600);
        u.setSize(35, 35);
        u.setFont(new Font("Arial", Font.BOLD, 24));
        u.setBackground(Color.BLUE);
        u.setForeground(Color.GREEN);
        u.setBorder(null);
        
         v.setLocation(475, 600);
        v.setSize(35, 35);
        v.setFont(new Font("Arial", Font.BOLD, 24));
        v.setBackground(Color.BLUE);
        v.setForeground(Color.GREEN);
        v.setBorder(null);
        
         w.setLocation(525, 600);
        w.setSize(35, 35);
        w.setFont(new Font("Arial", Font.BOLD, 24));
        w.setBackground(Color.BLUE);
        w.setForeground(Color.GREEN);
        w.setBorder(null);
        
         x.setLocation(575, 600);
        x.setSize(35, 35);
        x.setFont(new Font("Arial", Font.BOLD, 24));
        x.setBackground(Color.BLUE);
        x.setForeground(Color.GREEN);
        x.setBorder(null);
        
         y.setLocation(625, 600);
        y.setSize(35, 35);
        y.setFont(new Font("Arial", Font.BOLD, 24));
        y.setBackground(Color.BLUE);
        y.setForeground(Color.GREEN);
        y.setBorder(null);
        
         z.setLocation(675, 600);
        z.setSize(35, 35);
        z.setFont(new Font("Arial", Font.BOLD, 24));
        z.setBackground(Color.BLUE);
        z.setForeground(Color.GREEN);
        z.setBorder(null);
    }
    
    class addButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent ev) {
            char ch = '#';
            if(ev.getSource() == a) {
                ch = 'a';
                a.setForeground(Color.RED);
            }
            if(ev.getSource() == b) {
                ch = 'b';
                b.setForeground(Color.RED);
            }
            if(ev.getSource() == c) {
                ch = 'c';
                c.setForeground(Color.RED);
            }
            if(ev.getSource() == d) {
                ch = 'd';
                d.setForeground(Color.RED);
            }
            if(ev.getSource() == e) {
                ch = 'e';
                e.setForeground(Color.RED);
            }
            if(ev.getSource() == f) {
                ch = 'f';
                f.setForeground(Color.RED);
            }
            if(ev.getSource() == g) {
                ch = 'g';
                g.setForeground(Color.RED);
            }
            if(ev.getSource() == h) {
                ch = 'h';
                h.setForeground(Color.RED);
            }
            if(ev.getSource() == i) {
                ch = 'i';
                i.setForeground(Color.RED);
            }
            if(ev.getSource() == j) {
                ch = 'j';
                j.setForeground(Color.RED);
            }
            if(ev.getSource() == k) {
                ch = 'k';
                k.setForeground(Color.RED);
            }
            if(ev.getSource() == l) {
                ch = 'l';
                l.setForeground(Color.RED);
            }
            if(ev.getSource() == m) {
                ch = 'm';
                m.setForeground(Color.RED);
            }
            if(ev.getSource() == n) {
                ch = 'n';
                n.setForeground(Color.RED);
            }
            if(ev.getSource() == o) {
                ch = 'o';
                o.setForeground(Color.RED);
            }
            if(ev.getSource() == p) {
                ch = 'p';
                p.setForeground(Color.RED);
            }
            if(ev.getSource() == q) {
                ch = 'q';
                q.setForeground(Color.RED);
            }
            if(ev.getSource() == r) {
                ch = 'r';
                r.setForeground(Color.RED);
            }
            if(ev.getSource() == s) {
                ch = 's';
                s.setForeground(Color.RED);
            }
            if(ev.getSource() == t) {
                ch = 't';
                t.setForeground(Color.RED);
            }
            if(ev.getSource() == u) {
                ch = 'u';
                u.setForeground(Color.RED);
            }
            if(ev.getSource() == v) {
                ch = 'v';
                v.setForeground(Color.RED);
            }
            if(ev.getSource() == w) {
                ch = 'w';
                w.setForeground(Color.RED);
            }
            if(ev.getSource() == x) {
                ch = 'x';
                x.setForeground(Color.RED);
            }
            if(ev.getSource() == y) {
                ch = 'y';
                y.setForeground(Color.RED);
            }
            if(ev.getSource() == z) {
                ch = 'z';
                z.setForeground(Color.RED);
            }
                       
        flag = 0;
        wordComputer = wordComputer.toLowerCase();
        System.out.println(ch + ", length = " + String.valueOf(wordLength) + ',' + wordComputer);
        for(int n=0; n<wordLength; n++)	{
            if(wordComputer.charAt(n) == ch){
		flag++;
		//System.out.println("flag = " + flag);
		if(n==0){
                    newWordUser = ch + wordUser.substring(n+1);
                    System.out.println(newWordUser);
		}
		else {
                    newWordUser = wordUser.substring(0,n) + ch + wordUser.substring(n+1);
                    System.out.println(newWordUser);
		}
                wordUser = newWordUser;
            }
	}
        space.setText(wordUser);
        
        if(wordUser == wordComputer)
            gameOver = 2;
        
	if(flag == 0) {
            wrongTries += 1;
            noOfTriesLeft -= 1;
            //gameOver = HangmanBodyPart();
            //System.out.println("wrongTries =" + wrongTries);
            if(wrongTries == 1) {
                java.net.URL imageURL = Trial1.class.getResource("images/1.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(123, 170);
            }
            else if(wrongTries == 2) {
                java.net.URL imageURL = Trial1.class.getResource("images/2.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(155, 215);
            }
            else if (wrongTries == 3) {
                java.net.URL imageURL = Trial1.class.getResource("images/3_final.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(150, 200);
            }
            else if(wrongTries == 4) {
                java.net.URL imageURL = Trial1.class.getResource("images/4.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(139, 196);
            }
            else if (wrongTries == 5) {
                java.net.URL imageURL = Trial1.class.getResource("images/5.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(120, 194);
            }
            else if (wrongTries == 6) {
                java.net.URL imageURL = Trial1.class.getResource("images/6.png");
                ImageIcon icon1 = new ImageIcon(imageURL);
                hangmanlabel.setIcon(icon1);
                hangmanlabel.setLocation(100, 200);
                hangmanlabel.setSize(150, 190);
                gameOver = 1;
            }
	}
        
        win = checkWin();
	//System.out.println("Win = " + win);
        if (gameOver == 1) {
            System.out.println("You lost the game");
            //Do some animation
            for (JButton b : buttonList) {
                b.setEnabled(false);
            }
        }
	else if (gameOver==2) {
            System.out.println("You win!");
                //try {
                    //String line2 = Files.readAllLines(Paths.get("F:\\Imay\\Sem6\\OOP\\Hangman\\StatList.txt")).get(1);
                    //int temp = Integer.parseInt(line2);
                    //temp = temp + 1;
//                    List<String> fileContent = new ArrayList<>(Files.readAllLines(, StandardCharsets.UTF_8));
//
//for (int i = 0; i < fileContent.size(); i++) {
//    if (fileContent.get(i).equals("old line")) {
//        fileContent.set(i, "new line");
//        break;
//    }
//}
//
//Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
//                    //Do some animation
//                } catch (IOException ex) {
//                    Logger.getLogger(GameScreen.class.getName()).log(Level.SEVERE, null, ex);
               // }
        }
    }
    }
}
         
    
 
package Trial1;

import java.io.*;
import java.sql.*;
import java.util.*;

public class InsertFileData{
    
    public static void main(String[] args){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            String myUrl = "jdbc:mysql://localhost:3306/temp";
            Connection con = DriverManager.getConnection(myUrl, "root", "");
            //System.out.println("Here!");
            Statement st=con.createStatement();
            
            //System.out.println("Here1");
            FileInputStream fstream = new FileInputStream("Desktop\\WordList.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            System.out.println("Here2");
            String strLine;
            ArrayList list=new ArrayList();
            while((strLine = br.readLine()) != null) {
                list.add(strLine);
            }
            
            System.out.println("After while loop");
            Iterator itr;
            for(itr=list.iterator(); itr.hasNext(); ) {
                String str=itr.next().toString();  
                String [] splitSt =str.split(" ");
                String id="",word="",category="";
                for(int i = 0 ; i < splitSt.length ; i++) {
                    id=splitSt[0];
                    word=splitSt[1];
                    category=splitSt[2];
                }

                System.out.println("word is " + word);
                int k=st.executeUpdate("insert into temp(id,word,category) values('"+id+"','"+word+"','"+category+"')");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
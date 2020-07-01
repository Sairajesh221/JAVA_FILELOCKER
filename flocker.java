import java.awt.*;

import java.awt.event.*;

import java.io.File;
import java.io.IOException;

import java.io.FileNotFoundException;

import java.io.FileWriter;

import java.util.Scanner;

import java.io.FileReader;

import javax.swing.WindowConstants;

import javax.swing.JDialog;

public class flocker extends WindowAdapter implements ActionListener

{
   
Frame f=new Frame("FLocker Application/Tool");
   
Button b1=new Button("create");

   Button b2=new Button("delete");

   Button b3=new Button("lock");

   Button b4=new Button("Unlock");

   Button b5=new Button("Write File");

   Button b6=new Button("Read File");

   TextArea t1=new TextArea();

   TextArea t2=new TextArea();

   TextField tf1=new TextField();

   TextField tf2=new TextField();

   TextField tf3=new TextField();

   TextField tf4=new TextField();

   Label l1=new Label("Folder name:");

   Label l2=new Label("File name:");

   Label l3=new Label("Password(lock):");

   Label l4=new Label("Password(unlock):");

   JDialog d;

   String passkey;

   String fname=tf1.getText()+'/'+tf2.getText();

   flocker()
{
   l1.setBounds(50,50,80,30);

   tf1.setBounds(150,50,300,30);

   l2.setBounds(50,100,80,30);

   tf2.setBounds(150,100,300,30);

   t1.setBounds(50,300,300,300);

   t2.setBounds(450,300,300,300);

   b1.setBounds(500,50,100,30);

   b2.setBounds(650,50,100,30);

   l3.setBounds(50,150,150,30);

   tf3.setBounds(200,150,300,30);

   b3.setBounds(550,150,200,30);

   l4.setBounds(50,200,150,30);

   tf4.setBounds(200,200,300,30);

   b4.setBounds(550,200,200,30);

   b5.setBounds(50,650,100,30);

   b6.setBounds(450,650,100,30);

   b1.addActionListener(this);

   b2.addActionListener(this);

   b3.addActionListener(this);

   b4.addActionListener(this);

   b5.addActionListener(this);

   b6.addActionListener(this);

try{
   f.addWindowListener(new WindowAdapter(){

     public void windowClosing(WindowEvent we)
{

      System.exit(0);

    }
});
   }

catch(NullPointerException npe)

{
  System.out.println("Exception occured..!");
}

try
{
  d.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
}

catch(NullPointerException k){};

  f.add(b1);

  f.add(b2);

  f.add(b3);

  f.add(b4);

  f.add(b5);

  f.add(b6);

  f.add(t1);

  f.add(t2);

  f.add(tf1);

  f.add(tf2);

  f.add(tf3);

  f.add(tf4);

  f.add(l1);

  f.add(l2);

  f.add(l3);

  f.add(l4);

  f.setSize(800,800);

  f.setLayout(null);

  f.setVisible(true);

  t2.setEditable(false);

}



public void actionPerformed(ActionEvent e)

{

 if(e.getSource()==b1)

  {

   d=new JDialog(f,"File creation",false);

   
d.setBounds(350,350,400,200);

   try 
    { 
     File file = new File(tf1.getText()+'/'+tf2.getText());
    /*If file gets created then the createNewFile() 
* method would return true or if the file is   * already present it would return false*/

    boolean fvar = file.createNewFile();
	 
    if (fvar)
      {
		
		
       d.add( new Label ("File has been created successfully"));
     
  d.setVisible(true);

      }
    else
     {

      d.add( new Label ("File already present at the specified location"));  
		
      d.setVisible(true);
     }

   } 
    catch (IOException p)
     {
    		
      System.out.println("Exception Occurred:");

      p.printStackTrace();
	 
     }
 
   
}

if(e.getSource()==b2)

{
 

d=new JDialog(f,"File deletion",true);
 
d.setBounds(350,350,400,200);

 File file = new File(tf1.getText()+'/'+tf2.getText());

 if(file.delete()) 

   { 
     d.add( new Label ("File deleted successfully"));  

     d.setVisible(true);

   } 
   
  else
       
  {
    d.add( new Label ("Failed to delete the file"));  

    d.setVisible(true);
   
  }
 


}

if(e.getSource()==b5)

{

  try
    { 
     
FileWriter fi=new FileWriter(tf1.getText()+'/'+tf2.getText());

     fi.write(t1.getText());

     fi.close();

     d=new JDialog(f,"Write File",false);
     
d.setBounds(350,350,400,200);
     
d.add( new Label ("Contents succesfully written"));
     
d.setVisible(true);
     
}

   catch(IOException ioe)

    {
      d=new JDialog(f,"Read File",false);
      
d.setBounds(350,350,400,200);

      d.add( new Label ("Failed to write onto file"));
      
d.setVisible(true);

      System.out.println("Exception Occurred:");
    }

}

if(e.getSource()==b6)

 {
  try
   { 

    Scanner in = new Scanner(new FileReader(tf1.getText()+'/'+tf2.getText()));

    StringBuilder sb = new StringBuilder();

while(in.hasNext()) 
{

  sb.append(in.next()).append(" ");

}

in.close();

t2.setText(sb.toString());
}

catch(FileNotFoundException g)

{

  d=new JDialog(f,"Read File",false);

  d.setBounds(350,350,400,200);

  d.add( new Label ("File doesn't exist"));
  
d.setVisible(true);

}

}

if(e.getSource()==b3)

{

  passkey=tf3.getText();

  tf3.setText("**************");

  d=new JDialog(f,"File locked",false);

  d.setBounds(350,350,400,200);

  d.add( new Label ("Read and write functions disabled for the above file"));  

  d.setVisible(true);


  b5.setEnabled(false);

  b6.setEnabled(false);

  t1.setEditable(false);


}

if(e.getSource()==b4)

{

 if(passkey.equals(tf4.getText()))

  {

   d=new JDialog(f,"File unlock",false);

   d.setBounds(350,350,400,200);

   d.add( new Label ("File successfully unlocked")); 
   d.setVisible(true);

   tf3.setText("");

   tf4.setText("");

   b5.setEnabled(true);

   b6.setEnabled(true);

   t1.setEditable(true);

}

else

{

  d=new JDialog(f,"File unlock",false);

  d.setBounds(350,350,400,200);

  d.add( new Label ("Wrong password entered"));
  
d.setVisible(true);

}

}

}

public static void main(String[] args)
{
new flocker();

}
}
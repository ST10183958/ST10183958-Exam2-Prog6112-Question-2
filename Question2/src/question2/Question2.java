package question2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;

public class Question2 extends JFrame implements ActionListener {
    // menubar
    static JMenuBar MenuBar;
 
    // JMenu
    static JMenu File, Tool;
 
    // Menu items
    static JMenuItem Exit, Process, Clear, Save_Report;
 
    // create a frame
    static JFrame frame;
 
    // a label
    static JLabel l;
 
    // main class
    public static void main(String[] args) {
        // create an object of the class
        Question2 m = new Question2();
 
        // create a frame
        frame = new JFrame("Menu demo");
 
 
        // Menu creation 
        // create a menubar
        MenuBar = new JMenuBar();
 
        // create a menu
        File = new JMenu("File");
        Tool = new JMenu("Tool");
 
        // create menuitems
        Exit = new JMenuItem("Exit");
        Process = new JMenuItem("Process");
        Clear = new JMenuItem("Clear");
        Save_Report = new JMenuItem("Save Report");
 

        Exit.addActionListener(m);
        Process.addActionListener(m);
        Clear.addActionListener(m);
        Save_Report.addActionListener(m);
        // add ActionListener to menuItems

        // add menu items to menu
        File.add(Exit);
        Tool.add(Process);
        Tool.add(Clear);
        Tool.add(Save_Report);
 
        // add menu options File and Tool to top menu bar
        MenuBar.add(File);
        MenuBar.add(Tool);
 
        // add menubar to frame
        frame.setJMenuBar(MenuBar);
        // Menu creation 
        
        //Body creation
        JLabel l1,l2,l3,l4,l5;

        
        l1 = new JLabel("Movie:");
        l1.setBounds(20,50,200,23);
        frame.add(l1);
        
        String[] Movies = {"Napoleon", "Oppemheimer", "Damsel"};
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Napoleon", "Oppemheimer", "Damsel"});
        JComboBox cb = new JComboBox(Movies);
        comboBox.setBounds(200,50,130,23);
        frame.add(comboBox);
        
        //Input fields
        JTextField NumOfTickets = new JTextField(15);
        NumOfTickets.setBounds(200,100,130,23);
        l2 = new JLabel("NUMBER OF TICKETS");
        l2.setBounds(20,100,200,23);
        frame.add(NumOfTickets);
        frame.add(l2);
        
        JTextField TicketPrice = new JTextField(15);
        TicketPrice.setBounds(200,150,130,23);
        l3 = new JLabel("TICKET PRICE");
        l3.setBounds(20,150,200,23);
        frame.add(TicketPrice);
        frame.add(l3);
        

        
        l5 = new JLabel("TICKET REPORT");
        l5.setBounds(5,230,200,23);
        JTextArea ReportBox = new JTextArea(5, 20);
        ReportBox.setBounds(5,250,380,221);
        frame.add(l5);
        frame.add(ReportBox);
        //Body creation
 
        // set the size of the frame
        frame.setLayout(null);
        frame.setSize(400,500);
        frame.setVisible(true);
        
        // Menu item selection functions
        
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Process.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MovieName = (String) comboBox.getSelectedItem();
                String NumTicket = NumOfTickets.getText();
                String Price = TicketPrice.getText();
               
                ReportBox.setEditable(false);
                
                String output = MovieTickets(MovieName,NumTicket,Price);
                ReportBox.setText(output);
                ReportBox.setEditable(false);

            }
        });
        Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReportBox.setText("");
            }
        });

        ////////////////////////////////
    };
    
    public void actionPerformed(ActionEvent e)
    {
       

    };
    
    public static String MovieTickets(String MovieName, String NumTicket, String Price) {
            boolean MovieNameMet = false;
            boolean TicketPriceMet = false;
            boolean NumOfTicketsMet = false;
            
            // Validating movie name
            if(MovieName==null) {
                MovieNameMet = false;
            } else {
                MovieNameMet = true;
            };
            
            // Validating number of tickets name
            if(NumTicket==null) {
                TicketPriceMet = false;
            } else {
                TicketPriceMet = true;
            };
            
            // Validating movie price name
            if(Price==null) {
                NumOfTicketsMet = false;
            } else {
                NumOfTicketsMet = true;
            };
            
          
        String OutputData;
        if(MovieNameMet==true && TicketPriceMet==true && NumOfTicketsMet==true) {
            //Performing calculations to be outputted 
            float vat = (float) 0.14;
            float vatDiff = 0;
            float PriceWithVAT = 0;
                
            
            float calculatedSales = Integer.valueOf(NumTicket) * Integer.valueOf(Price);
            vatDiff = calculatedSales*vat;
            PriceWithVAT = calculatedSales+vatDiff;
            OutputData = "MOVIE NAME: "+MovieName +'\n'+ "MOVIE TICKET PRICE: "+Price+ '\n' + "NUMBER OF TICKETS: "+NumTicket+ '\n' + "TOTAL TICKET PRICES: "+PriceWithVAT;
        
            //saving the data to a text file
                try {  
                    File myObj = new File("report.txt");  
                    if (myObj.createNewFile()) {  
                      System.out.println("File created: " + myObj.getName());  
                      System.out.println("Absolute path: " + myObj.getAbsolutePath());  
                      FileWriter myWriter = new FileWriter(myObj.getName());
                      myWriter.write(OutputData);
                      myWriter.close();
                    } else {  
                      System.out.println("File already exists.");  
                    }  
                  } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();  
                  } 

        } else {
            OutputData = "INPUTS NOT FILLED IN";
        }
        
        return OutputData;
    };
}
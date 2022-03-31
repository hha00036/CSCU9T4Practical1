// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {
    
	String[] athlete = {"Swimming","Cycling", "Running"};
	
    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField where = new JTextField(10);
    private JTextField repetitions = new JTextField(4);
    private JTextField recovery = new JTextField(4);
    private JTextField terrain = new JTextField(10);
    private JTextField tempo = new JTextField(10);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labwhere = new JLabel(" Location:");
    private JLabel labrep = new JLabel(" Repetitions:");
    private JLabel labrec = new JLabel(" Recovery:"); 
    private JLabel labter = new JLabel(" Terrain:"); 
    private JLabel labtemp = new JLabel(" Tempo:"); 
    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton lookUpAllByDate = new JButton("Find All Records");
    private JButton remove = new JButton("Remove Record");
    private JComboBox athleteList = new JComboBox(athlete);
	

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true); 	
            add(labwhere);
            add(where);
            where.setEditable(true);
        	add(labrep);
            add(repetitions);
            repetitions.setEditable(true);
            add(labrec);
            add(recovery);
            recovery.setEditable(true);
        	 add(labter);
             add(terrain);
             terrain.setEditable(true);
             add(labtemp);
             add(tempo);
             tempo.setEditable(true);
        add(athleteList);
        athleteList.addActionListener(this);
        add(addR);
        addR.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(lookUpAllByDate);
        lookUpAllByDate.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(720, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry(athleteList.getSelectedItem().toString());
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == lookUpAllByDate) {
            message = lookupAllEntries();
        }
        if (event.getSource() == remove) {
            
        }
        if (event.getSource() == athleteList) {
            athleteList.getSelectedItem(); 	
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        String message = "Record added\n";
        System.out.println("Adding "+what+" entry to the records");
        String n = name.getText();
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        float km = java.lang.Float.parseFloat(dist.getText());
        int h = Integer.parseInt(hours.getText());
        int mm = Integer.parseInt(mins.getText());
        int s = Integer.parseInt(secs.getText());
        String wh = where.getText();
        int rep = Integer.parseInt(repetitions.getText());
        int rec = Integer.parseInt(recovery.getText());
        String ter = terrain.getText();
        String temp = tempo.getText();
        
       if (athleteList.getSelectedItem().equals("Swimming"))
        {
        	SwimmingAthlete ar = new SwimmingAthlete(n, d, m, y, h, mm, s, km, wh);
        	myAthletes.addSwimEntry(ar);
        }
        else if (athleteList.getSelectedItem().equals("Running"))
        {
        	RunningAthlete ar = new RunningAthlete(n, d, m, y, h, mm, s, km, rep, rec);
        	myAthletes.addRunEntry(ar);
        	
        }
        else if (athleteList.getSelectedItem().equals("Cycling"))
        {
        	CyclingAthlete ar = new CyclingAthlete(n, d, m, y, h, mm, s, km, ter, temp);
        	myAthletes.addCycleEntry(ar);
           
        }
        
        return message;
    }
    
    public String lookupEntry() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
    }
    
    
    public String lookupAllEntries() {
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupAllEntries(d, m, y);
        return message;
    }
    
    public String RemoveEntry() {
    
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        String n = name.getText();
        outputArea.setText("deleting record ...");
        String result = myAthletes.removeEntry(n, d, m, y);
        outputArea.setText(result);
        String message = "Record removed";
        return message;
    }
     

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        where.setText("");
        recovery.setText("");
        repetitions.setText("");
        terrain.setText("");
        tempo.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(AthleteRunRecord ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI


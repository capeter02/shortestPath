package algShortest;

import javax.swing.*;

import dataStructure.GraphData;

import java.awt.*;
import java.awt.event.*;

public class GraphicInterface implements ActionListener {
    private JLabel label = new JLabel("Shortest Path:  0     ");
    private JFrame frame = new JFrame();
    private String[] cityNames;
    private JComboBox<String> home;
    private JComboBox<String> destinations;
    private GraphData G;
    
	public GraphicInterface(GraphData G) {
    	
    	//creates combo boxes and labels
    	this.cityNames = new String[]{"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose", "Fresno", "Austin", "Jacksonville", "Fort Worth"};
    	home = new JComboBox<String>(cityNames);
    	destinations = new JComboBox<String>(cityNames);
    	Label homeLabel = new Label("Home: ");
    	Label destLabel = new Label("Destination: ");
    	this.G = G;

        // the clickable button
        JButton button = new JButton("Find Shortest Path");
        button.addActionListener(this);

        // the panel with the button and text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 20, 60));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(homeLabel);
        panel.add(home);
        panel.add(destLabel);
        panel.add(destinations);
        panel.add(button);
        panel.add(label);
        

        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // process the button clicks
    public void actionPerformed(ActionEvent e) {
    	
    	//variables that return the value in the combo box
    	int homeSelection = home.getSelectedIndex();
    	int destSelection = destinations.getSelectedIndex();
    	ShortestPath ShortPath = new ShortestPath(G, homeSelection, destSelection);
    	
    	
        label.setText("Shortest Path:  "  + ShortPath.pathTo());
        
    }

    // create one Frame
    public static void main(String[] args) {
    	
    }
    
    
}
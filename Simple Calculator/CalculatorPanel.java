/*
 *   Simple Calculator
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Calculator.CommandAction;
import Calculator.InsertAction;


public class CalculatorPanel extends JPanel
{

	private JTextField display;
	private JPanel panel;

	public CalculatorPanel(){
		setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(BorderFactory.createEmptyBorder(10,10,5,10));

		// add the display
		display = new JTextField();
		display.setText("0.0");
		display.setPreferredSize(new Dimension(160, 20));
		display.setEditable(false);
		display.setBackground(Color.white);

		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(160, 20));
		textPanel.add(display);
		
		// add the buttons in a 4 x 4 grid, margin is 10 x 10 pixel
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 10, 10));
		
		add(panel);
		
		final String str[] = {"7","8","9","/","4","5","6","*","1","2","3","-",".","0","=","+",};
		JButton buttons[] = new JButton[str.length]; 

		add(textPanel);


		// use for loop to add button
		for (int i = 0; i < str.length; i++) {
			buttons[i] = new JButton(str[i]);
			panel.add(buttons[i]);
		}
		
		// use for loop to add action
	
		for(int i = 0;i < str.length; i++)
	    {
	    buttons[i].addActionListener(linstener);
	    }
		
		display.addActionListener((ActionListener) this);
			
		
	}
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean start = true;
    private double result = 0;
    private JTextField display;
    private JPanel panel;
    private String lastCommand; 
    ActionListener insert = new InsertAction();
    ActionListener command = new CommandAction();

    private class InsertAction implements ActionListener {
        // difine insert action method
        public void actionPerformed(ActionEvent event) {

            String input = event.getActionCommand();
            if (start) {
                display.setText(""); 
                // set defalt display is empty
                start = false;
                // if first input"-"，display as negative number
                if (input.equals("-"))
                    display.setText(display.getText() + "-");
            }

            if (!input.equals("-")) {
                if (input.equals(".")) {
                     if (display.getText().trim().indexOf(".") == -1) {
                         // when input decimal, determine whether already input decimal
                         display.setText(display.getText() + input);
                     }
                 } else
                     display.setText(display.getText() + input);
             }
        }
    }

    private class CommandAction implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            String command = evt.getActionCommand();
            if (start) {
                lastCommand = command;
            } else {
                calculate(Double.parseDouble(display.getText()));
                lastCommand = command;
                start = true; 
                // remember input operation
            }
        }
    }

    public void calculate(double x) {
        if (lastCommand.equals("+"))
            result += x;
        else if (lastCommand.equals("-"))
            result -= x;
        else if (lastCommand.equals("*"))
            result *= x;
        else if (lastCommand.equals("/"))
            result /= x;
        else if (lastCommand.equals("="))
            result = x; 
        // calculation process of calculator
        // display result
        display.setText("" + result);
    }


	public static void main (String[] args)
	{
		Calculator calc = new Calculator();
		calc.setTitle("Calculator");
		calc.setSize(250,270);
		calc.setVisible(true);
		calc.setResizable(false);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
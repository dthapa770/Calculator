package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField expressionTextField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] buttonText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[buttonText.length];

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.expressionTextField.setPreferredSize(new Dimension(600, 50));
        this.expressionTextField.setFont(new Font("Courier", Font.BOLD, 28));
        this.expressionTextField.setForeground(new Color(Color.HSBtoRGB(255f,255,255)));

        add(expressionTextField, BorderLayout.NORTH);
        expressionTextField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button tempButtonReference;
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            tempButtonReference = new Button(buttonText[i]);
            tempButtonReference.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = tempButtonReference;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.buttonText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /**
     * This function is triggered anytime a button is pressed
     * on our Calculator GUI.
     * @param actionEventObject Event object generated when a
     *                    button is pressed.
     */

    public void actionPerformed(ActionEvent actionEventObject) {
        String button= actionEventObject.getActionCommand();

        switch(button)
        {
            case "1":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "2":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "3":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "4":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "5":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "6":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "7":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "8":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "9":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "0":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "(":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case ")":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "+":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "-":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "*":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "/":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "^":
                expressionTextField.setText(expressionTextField.getText()+button);
                break;

            case "C":
                String text =this.expressionTextField.getText();
                if(text.length()>0){
                    this.expressionTextField.setText(text.substring(0,text.length()-1));
                }
                break;

            case "CE":
                expressionTextField.setText("");
                break;

            case "=":
                if(expressionTextField.getText().equals(""))
                    expressionTextField.setText("No Expression Found");
                else
                {
                    Evaluator Object = new Evaluator();
                    int result= 0;
                    try {
                        result = Object.evaluateExpression(expressionTextField.getText());
                    } catch (Exception e) {
                        expressionTextField.setText("Enter Valid input!");
                    }
                    expressionTextField.setText(Integer.toString(result));
                }
                break;

            default:
                expressionTextField.setText("Enter Valid input!");

        }

    }
}

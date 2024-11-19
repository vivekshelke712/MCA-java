package practicals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUIApp {
    public static void main(String[] args) {
        // Create the JFrame
        JFrame frame = new JFrame("Simple GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());


        JLabel label = new JLabel("Enter text below and click the button:");
        frame.add(label);


        JTextField textField = new JTextField(20);
        frame.add(textField);


        JButton button = new JButton("Display Text");
        frame.add(button);


        JLabel resultLabel = new JLabel("");
        frame.add(resultLabel);

        // Add ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textField.getText();
                resultLabel.setText("You entered: " + inputText);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

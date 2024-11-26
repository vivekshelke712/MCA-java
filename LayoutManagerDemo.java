package practicals;

import javax.swing.*;
import java.awt.*;

public class LayoutManagerDemo {

    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Layout Manager Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 2)); // Divide JFrame into 2x2 sections

        // BorderLayout Panel
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.add(new JButton("North"), BorderLayout.NORTH);
        borderPanel.add(new JButton("South"), BorderLayout.SOUTH);
        borderPanel.add(new JButton("East"), BorderLayout.EAST);
        borderPanel.add(new JButton("West"), BorderLayout.WEST);
        borderPanel.add(new JButton("Center"), BorderLayout.CENTER);
        frame.add(borderPanel);


        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(new JButton("Button 1"));
        flowPanel.add(new JButton("Button 2"));
        flowPanel.add(new JButton("Button 3"));
        flowPanel.add(new JButton("Button 4"));
        frame.add(flowPanel);


        JPanel gridPanel = new JPanel(new GridLayout(2, 3));
        gridPanel.add(new JButton("1"));
        gridPanel.add(new JButton("2"));
        gridPanel.add(new JButton("3"));
        gridPanel.add(new JButton("4"));
        gridPanel.add(new JButton("5"));
        gridPanel.add(new JButton("6"));
        frame.add(gridPanel);

        // BoxLayout Panel
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.Y_AXIS));
        boxPanel.add(new JButton("Button A"));
        boxPanel.add(new JButton("Button B"));
        boxPanel.add(new JButton("Button C"));
        frame.add(boxPanel);

        // Make the JFrame visible
        frame.setVisible(true);
    }
}

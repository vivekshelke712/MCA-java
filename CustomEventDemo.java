package practicals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Custom event class
class AlarmEvent {
    private Object source;

    public AlarmEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}

// Listener interface for the alarm event
interface AlarmListener {
    void onAlarmTriggered(AlarmEvent event);
}

// Alarm handler class implementing the listener interface
class AlarmHandler implements AlarmListener {
    @Override
    public void onAlarmTriggered(AlarmEvent event) {
        // Display a message when the alarm is triggered
        System.out.println("Alarm triggered! Responding to the event.");
        JOptionPane.showMessageDialog(null, "Alarm has been triggered!");
    }
}

// Main class for the JFrame and button
public class CustomEventDemo {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Custom Event Demo");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JPanel for the button
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a JButton to trigger the alarm
        JButton triggerButton = new JButton("Trigger Alarm");

        // Create an instance of the alarm handler
        AlarmHandler alarmHandler = new AlarmHandler();

        // Add ActionListener to the button
        triggerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Trigger the custom alarm event
                AlarmEvent alarmEvent = new AlarmEvent(this);
                alarmHandler.onAlarmTriggered(alarmEvent);
            }
        });

        // Add the button to the panel
        panel.add(triggerButton);

        // Add the panel to the frame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}

package phonelist;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 *
 *
 * @author yaw
 * @version 13 Jan 2015
 */
public class PhonePanel extends JPanel {

    // back-end: board data
    private LinkedList list;

    private JTextField name;
    private JTextField number;
    JTextArea textArea;

    //constructor
    public PhonePanel() {
        list = new LinkedList();

        setPreferredSize(new Dimension(260, 140));
        setLayout(new BorderLayout());

        //Fields and labels.
        name = new JTextField(16);
        number = new JTextField(16);
        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setLabelFor(name);

        JLabel numberLabel = new JLabel("Number: ");
        numberLabel.setLabelFor(number);

        JPanel field1 = new JPanel();
        field1.setLayout(new BorderLayout());
        field1.add(name, BorderLayout.CENTER);
        field1.add(nameLabel, BorderLayout.WEST);

        JPanel field2 = new JPanel();
        field2.setLayout(new BorderLayout());
        field2.add(number, BorderLayout.CENTER);
        field2.add(numberLabel, BorderLayout.WEST);

        JPanel fields = new JPanel();
        fields.setLayout(new GridLayout(2, 1));
        fields.add(field1);
        fields.add(field2);

        //Create a text area.
        textArea = new JTextArea("\n");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.black));

        //Buttons:
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(2, 2));

        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new AddContact());
        buttonPane.add(addButton);

        JButton removeButton = new JButton("Remove Contact");
        removeButton.addActionListener(new RemoveContact());
        buttonPane.add(removeButton);

        JButton searchButton = new JButton("Search Contact");
        searchButton.addActionListener(new SearchContact());
        buttonPane.add(searchButton);

        JButton allButton = new JButton("Show All");
        allButton.addActionListener(new ShowAll());
        buttonPane.add(allButton);

        //pack stuff together
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(fields, BorderLayout.CENTER);
        pane.add(textArea, BorderLayout.PAGE_START);
        pane.add(buttonPane, BorderLayout.SOUTH);

        add(pane, BorderLayout.CENTER);
    }

    public void save() {
        list.save();
    }

    private class AddContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String contactName = name.getText();
            String contactNumber = number.getText();
            list.add(new Contact(contactName, contactNumber));
            name.setText("");
            number.setText("");
            textArea.setText("Contact added.\n");
            System.out.println(contactName + ", " + contactNumber);
        }
    }

    private class SearchContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String contactName = name.getText();
            Contact contact = list.search(contactName);
            if (contact != null) {
                textArea.setText("Name: " + contact.getName() + "\n" + "Number: " + contact.getNumber());
            } else {
                textArea.setText("Contact not found.\n");
            }
        }
    }

    private class ShowAll implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JDialog popup = new JDialog();
            String output = list.getAll();
            JTextArea allContacts = new JTextArea(output);
            allContacts.setLineWrap(false);
            allContacts.setWrapStyleWord(true);
            allContacts.setEditable(false);
            allContacts.setBorder(BorderFactory.createLineBorder(Color.black));
            popup.add(allContacts);
            popup.pack();
            popup.setLocationRelativeTo(null);
            popup.setVisible(true);
        }
    }

    private class RemoveContact implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String contactName = name.getText();
            if (list.remove(contactName)) {
                textArea.setText("Contact removed.\n");
            } else {
                textArea.setText("Contact not found.\n");
            }
        }
    }
}

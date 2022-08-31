package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton tierAbfragenButton;
    private JButton tierEinfügenButton;
    private JButton tierLöschenButton;
    //private JButton tierartErstellenButton;
    private JButton tiereDurchsuchenButton;
    private JTextField chipnummerField, nameField, alterField, geschlechtField,
            tierartField, persönlichkeitField;

    public MainView() {
        setTitle("Tierverwaltung");
        setSize(400, 300);
        addComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void addComponents() {
        setLayout( new BorderLayout() );
        JPanel topPanel = new JPanel( new FlowLayout() );
        JPanel centerPanel = new JPanel( new GridLayout(6,2) );
        JPanel bottomPanel = new JPanel( new FlowLayout() );
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        topPanel.add( new JLabel("Unser kleiner Zooladen") );

        centerPanel.setBorder( new EmptyBorder(5,5,5,5) );
        centerPanel.add( new JLabel("Chipnummer:") );
        chipnummerField = new JTextField();
        centerPanel.add( chipnummerField );
        centerPanel.add( new JLabel("Name:") );
        nameField = new JTextField();
        centerPanel.add( nameField );
        centerPanel.add( new JLabel("Alter:") );
        alterField = new JTextField();
        centerPanel.add( alterField );
        centerPanel.add( new JLabel("Geschlecht:") );
        geschlechtField = new JTextField();
        centerPanel.add( geschlechtField );
        centerPanel.add( new JLabel("Tierart:") );
        tierartField = new JTextField();
        centerPanel.add( tierartField );
        centerPanel.add( new JLabel("Persönlichkeit:") );
        persönlichkeitField = new JTextField();
        centerPanel.add( persönlichkeitField );

        JButton beendenButton = new JButton("Beenden");
        beendenButton.addActionListener( e -> dispose() );

        tierAbfragenButton = new JButton("Abfragen");
        tierEinfügenButton  = new JButton("Einfügen");
        tierLöschenButton = new JButton("Löschen");
        //tierartErstellenButton = new JButton("Tierart erstellen");
        tiereDurchsuchenButton = new JButton("Durchsuchen");

        bottomPanel.add(tierAbfragenButton);
        bottomPanel.add(tierEinfügenButton);
        bottomPanel.add(tierLöschenButton);
        bottomPanel.add(tiereDurchsuchenButton);
        bottomPanel.add(beendenButton);
    }

    public void addTierAbfragenButtonListener(ActionListener listener) {
        tierAbfragenButton.addActionListener(listener);
    }

    public void addTierEinfügenButtonListener(ActionListener listener) {
        tierEinfügenButton.addActionListener(listener);
    }

    public void addTierLöschenButtonListener(ActionListener listener) {
        tierLöschenButton.addActionListener(listener);
    }

    public int getChipnummer() {
        try {
            return Integer.parseInt(chipnummerField.getText());
        }
        catch (NumberFormatException e) {
            zeigeFehlerMeldung("Ungültige Chipnummer");
            return 0;
        }
    }

    public String getName() {
        return nameField.getText();
    }

    public void setName(String name)  {
        nameField.setText(name);
    }

    public int getAlter() {
        try {
            return Integer.parseInt(alterField.getText());
        }
        catch (NumberFormatException e) {
            zeigeFehlerMeldung("Ungültiges Alter");
            return 0;
        }
    }
    public void setAlter(int alter) {
        if (alter <= 0) {
            alterField.setText("");
        } else {
            alterField.setText(String.valueOf(alter));
        }
    }

    public char getGeschlecht() {
        return geschlechtField.getText().charAt(0);
    }

    public void setGeschlecht(char geschlecht) {
        geschlechtField.setText( String.valueOf(geschlecht) );
    }

    public String getTierart() {
        return tierartField.getText();
    }

    public void setTierart(String tierart) {
        tierartField.setText(tierart);
    }

    public String getPersönlichkeit() {
        return persönlichkeitField.getText();
    }

    public void setPersönlichkeit(String persönlichkeit) {
        persönlichkeitField.setText(persönlichkeit);
    }

    public void zeigeMeldung(String nachricht) {
        JOptionPane.showMessageDialog(this, nachricht, "Information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void zeigeFehlerMeldung(String nachricht) {
        JOptionPane.showMessageDialog(this, nachricht, "Fehler",
                JOptionPane.ERROR_MESSAGE);
    }

    public boolean zeigeRückfrage(String nachricht) {
        return JOptionPane.showConfirmDialog(this, nachricht, "Rückfrage", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION;
    }
}

package UI;

import events.Controller;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by siwei on 20/8/15.
 */
public class GUIMain {

    public static void main(String arg[]){
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("KWIC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        //Menus
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        JMenuItem itemNew = new JMenuItem("New");
        menuFile.add(itemNew);
        JMenuItem itemOpen = new JMenuItem("Open");
        menuFile.add(itemOpen);
        JMenuItem itemSave = new JMenuItem("Save");
        menuFile.add(itemSave);
        menuFile.addSeparator();
        JMenuItem itemQuit = new JMenuItem("Quit");
        menuFile.add(itemQuit);

        //Add contents to the window.
        final GUI mGUI = new GUI();
        frame.add(mGUI);
        //frame.setUndecorated(true);
        //Display the window.
        frame.addWindowListener(new WindowAdapter() {
            public void windowOpened(WindowEvent e) {
                //mGUI.setFocus();
            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        //mGUI.showResult("result..");

        addListeners(mGUI);
        mGUI.showMessage("Event mode.");

    }

    private static void addListeners(GUI mGUI){
        final JTextArea titleText = mGUI.titleText;
        final JTextArea ignoreText = mGUI.ignoreText;
        final JTextArea resultPanel = mGUI.resultPanel;

        final Controller controller = new Controller();
        controller.init(mGUI);

        titleText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                controller.process(titleText.getText(), ignoreText.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                controller.process(titleText.getText(), ignoreText.getText());
            }

        });

        ignoreText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                controller.process(titleText.getText(), ignoreText.getText());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                controller.process(titleText.getText(), ignoreText.getText());
            }

        });
    }
}

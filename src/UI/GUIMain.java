package UI;

import events.Controller;
import filter.MainLogic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by siwei on 20/8/15.
 */
public class GUIMain {

    public static final String APP_TITLE = "KWIC";
    private enum Mode{
        EVENT, FILTER
    }

    public static Mode mode;
    public static void main(String arg[]){
        mode = Mode.EVENT;
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(APP_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final GUI mGUI = new GUI();

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

        ActionListener actionModeEvent = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mGUI.showMessage("Event mode.");
                mode = Mode.EVENT;
            }
        };

        ActionListener actionModeFilter = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mGUI.showMessage("Filter mode.");
                mode = Mode.FILTER;
            }
        };

        JRadioButtonMenuItem eventMode = new JRadioButtonMenuItem("Event");
        eventMode.setSelected(true);
        eventMode.addActionListener(actionModeEvent);
        JRadioButtonMenuItem filterMode = new JRadioButtonMenuItem("Filter");
        filterMode.addActionListener(actionModeFilter);

        JMenu modeMenu = new JMenu("Mode");
        ButtonGroup group = new ButtonGroup();
        group.add(eventMode);
        group.add(filterMode);

        modeMenu.add(eventMode);
        modeMenu.add(filterMode);

        menuBar.add(modeMenu);
        //menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Add contents to the window.

        frame.add(mGUI);
        //frame.setUndecorated(true);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        addListeners(mGUI);
        mGUI.showMessage("Event mode.");

    }

    private static void addListeners(GUI mGUI){
        final JTextArea titleText = mGUI.titleText;
        final JTextArea ignoreText = mGUI.ignoreText;
        final JTextArea resultPanel = mGUI.resultPanel;

        final Controller eventController = new Controller();
        eventController.setOutputGUI(mGUI);

        final MainLogic filterController = new MainLogic();
        filterController.setOutputGUI(mGUI);

        titleText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (mode == Mode.EVENT) {
                    eventController.process(titleText.getText(), ignoreText.getText());
                } else {
                    filterController.process(titleText.getText(), ignoreText.getText());
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (mode == Mode.EVENT) {
                    eventController.process(titleText.getText(), ignoreText.getText());
                } else {
                    filterController.process(titleText.getText(), ignoreText.getText());
                }
            }

        });

        ignoreText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (mode == Mode.EVENT) {
                    eventController.process(titleText.getText(), ignoreText.getText());
                } else {
                    filterController.process(titleText.getText(), ignoreText.getText());
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (mode == Mode.EVENT) {
                    eventController.process(titleText.getText(), ignoreText.getText());
                } else {
                    filterController.process(titleText.getText(), ignoreText.getText());
                }
            }

        });
    }
}

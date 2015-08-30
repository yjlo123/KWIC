package UI;

import events.Controller;
import filter.MainLogic;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by siwei on 20/8/15.
 */
public class GUIMain {

    public static final String APP_TITLE = "KWIC";
    private enum Mode{
        EVENT, FILTER
    }

    public static Mode mode;
    static final GUI mGUI = new GUI();

    static final JTextArea titleText = mGUI.titleText;
    static final JTextArea ignoreText = mGUI.ignoreText;

    static final Controller eventController = new Controller();
    static final MainLogic filterController = new MainLogic();

    public static void main(String arg[]){
        mode = Mode.EVENT;
        eventController.setOutputGUI(mGUI);
        filterController.setOutputGUI(mGUI);
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(APP_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);




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

        ActionListener actionRun = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateWithTime();
            }
        };


        ActionListener actionExit = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        ActionListener actionClear = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mGUI.clear();
            }
        };


        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        //Menus
        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        JMenuItem itemClear = new JMenuItem("Clear");
        menuFile.add(itemClear);
        itemClear.addActionListener(actionClear);

        menuFile.addSeparator();

        JMenuItem itemQuit = new JMenuItem("Quit");
        menuFile.add(itemQuit);
        itemQuit.addActionListener(actionExit);

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

        JMenu runMenu = new JMenu("Run");
        JMenuItem itemRun = new JMenuItem("Run");
        itemRun.addActionListener(actionRun);
        runMenu.add(itemRun);
        menuBar.add(runMenu);

        //menuBar.setBorder(new BevelBorder(BevelBorder.RAISED));

        //Add contents to the window.

        frame.add(mGUI);
        //frame.setUndecorated(true);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        addListeners();
        mGUI.showMessage("Event mode.");

    }

    private static void addListeners(){


        titleText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

        });

        ignoreText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

        });
    }

    public static void update(){
        if (mode == Mode.EVENT) {
            eventController.process(titleText.getText(), ignoreText.getText());
        } else {
            filterController.process(titleText.getText(), ignoreText.getText());
        }

    }

    public static void updateWithTime(){
        long startTime = System.currentTimeMillis();
        update();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if (mode == Mode.EVENT) {
            mGUI.showMessage("Event mode. Total time used: "+totalTime+" ms.");
        }else{
            mGUI.showMessage("Filter mode. Total time used: "+totalTime+" ms.");
        }
    }
}

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
    public static final String FILTER_MODE = "Filter mode.";
    public static final String EVENT_MODE = "Event mode.";

    private enum Mode{
        EVENT, FILTER
    }

    public static Mode mode;
    public static boolean realTime;
    static final GUI mGUI = new GUI();

    static final JTextArea titleText = GUI.titleText;
    static final JTextArea ignoreText = GUI.ignoreText;

    static final Controller eventController = new Controller();
    static final MainLogic filterController = new MainLogic();
    static DocumentListener realTimeListener;

    public static void main(String arg[]){
        mode = Mode.EVENT;
        realTime = true;
        realTimeListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {}

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

        };
        createAndShowGUI();
    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame(APP_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        ActionListener actionModeEvent = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.showMessage(EVENT_MODE);
                mode = Mode.EVENT;
            }
        };

        ActionListener actionModeFilter = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.showMessage(FILTER_MODE);
                mode = Mode.FILTER;
            }
        };

        ActionListener actionRun = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateWithTime();
            }
        };

        ActionListener actionRealTime = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realTime = !realTime;
                addListeners(realTime);
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

        //Menus

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        // file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem itemClear = new JMenuItem("Clear");
        fileMenu.add(itemClear);
        itemClear.addActionListener(actionClear);
        fileMenu.addSeparator();
        JMenuItem itemQuit = new JMenuItem("Quit");
        fileMenu.add(itemQuit);
        itemQuit.addActionListener(actionExit);

        // mode menu
        JMenu modeMenu = new JMenu("Mode");
        menuBar.add(modeMenu);
        ButtonGroup group = new ButtonGroup();
        JRadioButtonMenuItem eventMode = new JRadioButtonMenuItem("Event");
        eventMode.setSelected(true);
        eventMode.addActionListener(actionModeEvent);
        JRadioButtonMenuItem filterMode = new JRadioButtonMenuItem("Filter");
        filterMode.addActionListener(actionModeFilter);
        group.add(eventMode);
        group.add(filterMode);
        modeMenu.add(eventMode);
        modeMenu.add(filterMode);

        // run menu
        JMenu runMenu = new JMenu("Run");
        JMenuItem itemRun = new JMenuItem("Run");
        itemRun.addActionListener(actionRun);
        runMenu.add(itemRun);
        runMenu.addSeparator();
        JCheckBoxMenuItem itemRealTime = new JCheckBoxMenuItem("Real-time", true);
        itemRealTime.addActionListener(actionRealTime);
        runMenu.add(itemRealTime);
        menuBar.add(runMenu);


        //Add contents to the window.
        frame.add(mGUI);
        //Display the window.
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        addListeners(realTime);
        GUI.showMessage(EVENT_MODE);

    }

    // add realtime listener
    private static void addListeners(boolean b){
        if (b) {
            titleText.getDocument().addDocumentListener(realTimeListener);
            ignoreText.getDocument().addDocumentListener(realTimeListener);
        }else{
            titleText.getDocument().removeDocumentListener(realTimeListener);
            ignoreText.getDocument().removeDocumentListener(realTimeListener);
        }
    }

    // compute results
    public static void update(){
        if (mode == Mode.EVENT) {
            eventController.process();
        } else {
            filterController.process();
        }

    }

    // compute result with measurement
    public static void updateWithTime(){
        long startTime = System.currentTimeMillis();
        update();
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if (mode == Mode.EVENT) {
            GUI.showMessage(EVENT_MODE + " Total time used: " + totalTime + " ms.");
        }else{
            GUI.showMessage(FILTER_MODE + " Total time used: " + totalTime + " ms.");
        }
    }
}

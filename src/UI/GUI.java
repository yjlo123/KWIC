package UI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by siwei on 20/8/15.
 */

public class GUI extends JPanel implements ActionListener {

    protected JTextField msgBox;
    public JTextArea titleText;
    public JTextArea ignoreText;
    public static JTextArea resultPanel;

    GridBagConstraints gbc = new GridBagConstraints();

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    public GUI() {
        super(new GridBagLayout());
        Font font = new Font("Courier", Font.BOLD, 15);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 5);

        msgBox = new JTextField();
        msgBox.setFont(font);
        msgBox.setBorder(BorderFactory.createMatteBorder(
                0, 5, 5, 5, Color.GRAY));
        msgBox.setForeground(Color.GREEN);
        msgBox.setBackground(Color.BLACK);
        msgBox.setEditable(false);
        msgBox.setHorizontalAlignment(JTextField.LEFT);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(msgBox, gbc);

        titleText = new JTextArea(20, 25);
        titleText.setForeground(Color.GREEN);
        titleText.setBackground(Color.BLACK);
        titleText.setCaretColor(Color.WHITE);
        titleText.setFont(font);
        titleText.setEditable(true);
        titleText.setLineWrap(true);
        JScrollPane scrollTitleText = new JScrollPane(titleText);
        scrollTitleText.setBorder(border);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(scrollTitleText, gbc);

        ignoreText = new JTextArea(10, 25);
        ignoreText.setForeground(Color.GREEN);
        ignoreText.setBackground(Color.BLACK);
        ignoreText.setCaretColor(Color.WHITE);
        ignoreText.setFont(font);
        ignoreText.setEditable(true);
        ignoreText.setLineWrap(true);
        JScrollPane scrollIgnoreText = new JScrollPane(ignoreText);
        scrollIgnoreText.setBorder(BorderFactory.createMatteBorder(
                0, 5, 5, 5, Color.GRAY));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(scrollIgnoreText, gbc);

        resultPanel = new JTextArea(30, 40);
        resultPanel.setForeground(Color.GREEN);
        resultPanel.setBackground(Color.BLACK);
        resultPanel.setFont(font);
        resultPanel.setLineWrap(true);
        resultPanel.setEditable(false);
        JScrollPane scrollResultText = new JScrollPane(resultPanel);
        scrollResultText.setBorder(BorderFactory.createMatteBorder(
                5, 0, 5, 5, Color.GRAY));
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridheight = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(scrollResultText, gbc);
    }

    public static void showResult(String result){
        //System.out.println(result);
        resultPanel.setText(result);
    }

    public void showMessage(String msg) {
        msgBox.setText(msg);
    }

    public void clear(){
        titleText.setText("");
        ignoreText.setText("");
    }
}

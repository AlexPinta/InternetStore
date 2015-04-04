package internet.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class AutorizationWindow {

    public static void main(String[] args) {
        initWindowAutorization();

        System.out.println("Hi mahai");


    }

    private static  void initWindowAutorization() {

            JFrame mainForm = new JFrame("Login window");
            JPanel mainPanel = new JPanel();
            JLabel loginLabel = new JLabel("Login:");
            JLabel passwordLabel = new JLabel("Password:");
            JTextField loginField = new JTextField();
            JTextField passwordField = new JPasswordField();
            JButton buttonOk = new JButton("Ok");
            JButton buttonClose = new JButton("Close");


            mainForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainForm.setLocation(700, 350);
            mainForm.setSize(300, 150);
            mainForm.setResizable(false);
            mainForm.add(mainPanel);

            mainPanel.setVisible(true);
            mainPanel.setLayout(new GridLayout(3, 2));
            mainPanel.add(loginLabel);
            mainPanel.add(loginField);
            mainPanel.add(passwordLabel);
            mainPanel.add(passwordField);
            mainPanel.add(buttonOk);
            mainPanel.add(buttonClose);

            /*buttonOk.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {

                }
            });*/

            buttonClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    //WindowEvent windowEvent = new WindowEvent(mainForm, WindowEvent.WINDOW_CLOSED);
                    //mainForm.dispose();
                    System.exit(0);
                }
            });

            mainForm.setVisible(true);
    }




}


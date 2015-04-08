package internet.view;


import sun.text.resources.FormatData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.Format;
import java.util.Formatter;

public class AutorizationWindow {
    private static Connection myConnection = null;
    private static String url = "jdbc:mysql://localhost/internetstore";
    private static Statement stmt = null;

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


        mainForm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        buttonOk.addActionListener(new ActionListener() {
                                       @Override
                                       public void actionPerformed(ActionEvent event) {
                                           String sqlQuery = "SELECT id, UserName, Password FROM users";
                                           try {
                                               Class.forName("com.mysql.jdbc.Driver").newInstance();
                                               myConnection = DriverManager.getConnection(url, "root", "Qwerty12345");
                                               stmt = myConnection.createStatement();
                                               ResultSet rsUsers = stmt.executeQuery(sqlQuery);
                                               while (rsUsers.next()) {

                                                   int id = rsUsers.getInt("id");
                                                   String userName = rsUsers.getString("userName");
                                                   String password = rsUsers.getString("Password");

                                                   System.out.print("ID: " + id);
                                                   System.out.print(", Name: " + userName);
                                                   System.out.println(", Password: " + password);
                                               }
                                               rsUsers.close();
                                               stmt.close();
                                               myConnection.close();
                                           } catch (Exception e) {
                                               e.printStackTrace();

                                           } finally {
                                               try {
                                                   if (stmt != null) {
                                                       stmt.close();
                                                   }
                                               } catch (SQLException se) {
                                                   se.printStackTrace();
                                               }
                                               try {
                                                   if (myConnection != null) {
                                                       myConnection.close();
                                                   }
                                               } catch (SQLException se) {
                                                   se.printStackTrace();
                                               }
                                           }

                                       }
                                   }

        );

        buttonClose.addActionListener(new

                                              ActionListener() {
                                                  @Override
                                                  public void actionPerformed(ActionEvent e) {

                                                      //WindowEvent windowEvent = new WindowEvent(mainForm, WindowEvent.WINDOW_CLOSED);
                                                      //mainForm.dispose();
                                                      System.exit(0);
                                                  }
                                              }

        );

        mainForm.setVisible(true);
    }


}


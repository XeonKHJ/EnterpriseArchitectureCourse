package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import Classes.User;

import java.awt.event.*;

import java.awt.*;

public class UserListPage extends Page {
    private JFrame _frame;
    private JButton _addStudentButton;
    private ListModel usersModel = new DefaultListModel<User>();
    public UserListPage(JFrame frame)
    {
        usersModel = 
        _frame = frame;
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(2, 1));
        var addStudentPanel = new JPanel();
        
        _addStudentButton = new JButton("添加学生");
        //_addStudentButton.setSize(new DimensionUIResource(40, 20));
        addStudentPanel.add(_addStudentButton);
        panel.add(addStudentPanel);
        frame.add(panel);
        
        JList userList = new JList()
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(new DimensionUIResource(1024, 768));
        frame.setTitle("提交作业");
        // frame.pack();
        frame.setVisible(true);
    }
}

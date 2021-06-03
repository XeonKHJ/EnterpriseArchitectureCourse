package Pages;

import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import Classes.HomeworkManagerSession;
import Classes.User;
import Classes.UserListPageEventArgs;
import Enums.Operations;
import Enums.Roles;

import java.awt.event.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.awt.*;

public class UserListPage extends Page implements ActionListener {
    private JFrame _frame;
    private JButton _addStudentButton;
    private JTextArea usernameArea = new JTextArea("用户名");
    private JTextArea passwordArea = new JTextArea("密码");
    private JTextArea roleArea = new JTextArea("角色");
    private JPanel studentListPanel;
    private Dictionary buttonUserDict = new  Hashtable();
    public UserListPage(JFrame frame, User loginedUser)
    {
        
        _frame = frame;
        frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        var extraPanel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(3, 1));

        if(loginedUser.getRole() == Roles.Admin)
        {
            var addStudentPanel = new JPanel();
        
            addStudentPanel.setLayout(new GridLayout(1,3));
            addStudentPanel.add(usernameArea);
            addStudentPanel.add(passwordArea);
            addStudentPanel.add(roleArea);
            extraPanel.add(addStudentPanel);
            
            _addStudentButton = new JButton("添加学生");
            _addStudentButton.addActionListener(this);
            //_addStudentButton.setSize(new DimensionUIResource(40, 20));
            addStudentPanel.add(_addStudentButton);
            panel.add(extraPanel);
        }
        frame.add(panel);
        studentListPanel = new JPanel();
        studentListPanel.setLayout(new GridLayout(0,1));
        for(var user : HomeworkManagerSession.Users)
        {
            if(loginedUser.getRole() == Roles.Teacher)
            {
                if(user.getRole() == Roles.Student)
                {
                    JButton button = new JButton();
                    button.setText("" + user.getId() + " " + user.getAccount());
                    buttonUserDict.put(button, user);
                    button.addActionListener(this);
                    studentListPanel.add(button);
                }
            }
            else if(loginedUser.getRole() == Roles.Admin)
            {
                JButton button = new JButton();
                button.setText("" + user.getId() + " " + user.getAccount());
    
                studentListPanel.add(button);
            }

        }
        panel.add(studentListPanel);
        // set up the frame and display it
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setTitle("提交作业");
        // frame.pack();
        frame.setVisible(true);
    }

    public void UpdatePage()
    {
        //studentListPanel.removeAll();
        _frame.getContentPane().removeAll();
        JPanel panel = new JPanel();
        var extraPanel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(3, 1));
        var addStudentPanel = new JPanel();
        addStudentPanel.setLayout(new GridLayout(1,3));
        addStudentPanel.add(usernameArea);
        addStudentPanel.add(passwordArea);
        addStudentPanel.add(roleArea);
        extraPanel.add(addStudentPanel);
        _addStudentButton = new JButton("添加学生");
        _addStudentButton.addActionListener(this);
        //_addStudentButton.setSize(new DimensionUIResource(40, 20));
        addStudentPanel.add(_addStudentButton);
        panel.add(extraPanel);
        _frame.add(panel);
        studentListPanel = new JPanel();
        studentListPanel.setLayout(new GridLayout(0,1));
        for(var user : HomeworkManagerSession.Users)
        {
            JButton button = new JButton();
            button.setText("" + user.getId() + " " + user.getAccount() + " " + user.getRole().name());
            studentListPanel.add(button);
        }
        panel.add(studentListPanel);
        // set up the frame and display it
        _frame.add(panel, BorderLayout.CENTER);
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        _frame.pack();
        _frame.setTitle("提交作业");
        // frame.pack();
        _frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == _addStudentButton)
        {
            String username = usernameArea.getText();
            String password = passwordArea.getText();
            String roleString = roleArea.getText();
            Roles role = null;
            if(roleString.equals("Teacher"))
            {
                role = Roles.Teacher;
            }
            else if(roleString.equals("Student"))
            {
                role = Roles.Student;
            }
            else if(roleString.equals("admin"))
            {
                role = Roles.Admin;
            }
    
            if(role != null)
            {
                //HomeworkManagerSession.Users.add(new User(HomeworkManagerSession.Users.size(), role, password, username));
                var newUser = new User(HomeworkManagerSession.Users.size(), role, username, password);
                InvokePageEvent(PageTypes.UserListPage, new UserListPageEventArgs(Operations.AddUser, newUser) );
            }
        }
        else{
            User user = (User)buttonUserDict.get(e.getSource());
            InvokePageEvent(PageTypes.UserListPage, new UserListPageEventArgs(Operations.CommentHomwork, user));
        }
        //UpdatePage();
    }
}

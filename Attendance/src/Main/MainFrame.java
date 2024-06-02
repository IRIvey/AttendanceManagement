package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Student.*;

public class MainFrame extends JFrame {
    private Student[] students = new Student[100];
    private Teacher[] teachers = new Teacher[100];
    private int studentCounter = 0;
    private int teacherCounter = 0;

    public MainFrame() {
        setTitle("Student Attendance Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        JButton launchStudentFormButton = new JButton("Launch Student Form");
        JButton launchTeacherFormButton = new JButton("Launch Teacher Form");
        JButton launchAttendanceFormButton = new JButton("Launch Attendance Form");

        panel.add(launchStudentFormButton);
        panel.add(launchTeacherFormButton);
        panel.add(launchAttendanceFormButton);

        launchStudentFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new StudentFrame(students, studentCounter).setVisible(true);
            }
        });

        launchTeacherFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TeacherFrame(teachers, teacherCounter).setVisible(true);
            }
        });

        launchAttendanceFormButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AttendanceFrame(students, studentCounter).setVisible(true);
            }
        });

        add(panel, BorderLayout.CENTER);
    }
    }
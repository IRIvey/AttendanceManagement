package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFrame extends JFrame {
    private Teacher[] teachers;
    private int teacherCounter;

    public TeacherFrame(Teacher[] teachers, int teacherCounter) {
        this.teachers = teachers;
        this.teacherCounter = teacherCounter;
        setTitle("Teacher Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton addTeacherButton = new JButton("Add Teacher");
        JButton displayTeacherButton = new JButton("Display Teacher");
        JButton updateTeacherButton = new JButton("Update Teacher");

        add(addTeacherButton);
        add(displayTeacherButton);
        add(updateTeacherButton);

        addTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTeacher();
            }
        });

        displayTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayTeacher();
            }
        });

        updateTeacherButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateTeacher();
            }
        });
    }

    private void addTeacher() {
        if (teacherCounter < teachers.length) {
            teachers[teacherCounter] = new Teacher();
            teachers[teacherCounter].getInfo();
            teacherCounter++;
        } else {
            JOptionPane.showMessageDialog(this, "Cannot add more teachers. Array is full.");
        }
    }

    private void displayTeacher() {
        StringBuilder teacherInfo = new StringBuilder();
        for (int i = 0; i < teacherCounter; i++) {
            teacherInfo.append("Teacher ").append(i + 1).append(":\n");
            teacherInfo.append("Name: ").append(teachers[i].name).append("\n");
            teacherInfo.append("Faculty ID: ").append(teachers[i].facultyID).append("\n");
            teacherInfo.append("Department: ").append(teachers[i].department).append("\n");
            teacherInfo.append("-----------------------------------\n");
        }
        JTextArea textArea = new JTextArea(teacherInfo.toString());
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(380, 260));
        JOptionPane.showMessageDialog(this, scrollPane, "Teachers", JOptionPane.INFORMATION_MESSAGE);
    }

    private void updateTeacher() {
        String teacherID = JOptionPane.showInputDialog(this, "Enter the Faculty ID of the teacher to update:");
        for (int i = 0; i < teacherCounter; i++) {
            if (teachers[i].facultyID.equals(teacherID)) {
                teachers[i].getInfo();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Teacher not found.");
    }

    public static void main(String[] args) {
        Teacher[] teachers = new Teacher[10]; // Example array size
        int teacherCounter = 0;
        TeacherFrame frame = new TeacherFrame(teachers, teacherCounter);
        frame.setVisible(true);
    }
}

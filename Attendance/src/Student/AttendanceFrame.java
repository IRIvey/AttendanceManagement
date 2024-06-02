package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttendanceFrame extends JFrame {
    private Student[] students;
    private int studentCounter;

    public AttendanceFrame(Student[] students, int studentCounter) {
        this.students = students;
        this.studentCounter = studentCounter;
        setTitle("Attendance Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton displayAttendanceButton = new JButton("Display Attendance");
        JButton updateAttendanceButton = new JButton("Update Attendance");

        add(displayAttendanceButton);
        add(updateAttendanceButton);

        displayAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayAttendance();
            }
        });

        updateAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateAttendance();
            }
        });
    }

    private void displayAttendance() {
        try {
            String rollNoStr = JOptionPane.showInputDialog(this, "Enter RollNo of the student to display attendance:");
            int rollNo = Integer.parseInt(rollNoStr);

            boolean found = false;
            for (int i = 0; i < studentCounter; i++) {
                if (students[i].rollno == rollNo) {
                    students[i].DisplayAttendance();
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student record not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Roll No. Please enter a valid number.");
        }
    }

    private void updateAttendance() {
        try {
            String rollNoStr = JOptionPane.showInputDialog(this, "Enter RollNo of the student to update attendance:");
            int rollNo = Integer.parseInt(rollNoStr);

            boolean found = false;
            for (int i = 0; i < studentCounter; i++) {
                if (students[i].rollno == rollNo) {
                    students[i].UpdateAttendance();
                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student record not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Roll No. Please enter a valid number.");
        }
    }
}

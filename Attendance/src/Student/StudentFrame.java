package Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentFrame extends JFrame {
    private Student[] students;
    private int studentCounter;

    public StudentFrame(Student[] students, int studentCounter) {
        this.students = students;
        this.studentCounter = studentCounter;
        setTitle("Student Management");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        JButton addStudentButton = new JButton("Add Student");
        JButton displayStudentButton = new JButton("Display Student");
        JButton updateAttendanceButton = new JButton("Update Attendance");

        add(addStudentButton);
        add(displayStudentButton);
        add(updateAttendanceButton);

        addStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        displayStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStudent();
            }
        });

        updateAttendanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateStudentAttendance();
            }
        });
    }

    private void addStudent() {
        try {
            JTextField rollNoField = new JTextField(5);
            JTextField nameField = new JTextField(10);
            JTextField dobField = new JTextField(10);
            JTextField semesterField = new JTextField(5);
            JTextField streamField = new JTextField(10);
            JTextField numSubjectsField = new JTextField(5);

            JPanel panel = new JPanel(new GridLayout(0, 2));
            panel.add(new JLabel("Roll No:"));
            panel.add(rollNoField);
            panel.add(new JLabel("Name:"));
            panel.add(nameField);
            panel.add(new JLabel("Date of Birth (DD/MM/YYYY):"));
            panel.add(dobField);
            panel.add(new JLabel("Semester:"));
            panel.add(semesterField);
            panel.add(new JLabel("Stream:"));
            panel.add(streamField);
            panel.add(new JLabel("Number of Subjects:"));
            panel.add(numSubjectsField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Add Student",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                int rollNo = Integer.parseInt(rollNoField.getText());
                String name = nameField.getText();
                String[] dobParts = dobField.getText().split("/");
                int day = Integer.parseInt(dobParts[0]);
                int month = Integer.parseInt(dobParts[1]);
                int year = Integer.parseInt(dobParts[2]);
                String stream = streamField.getText();
                int semester = Integer.parseInt(semesterField.getText());
                int numSubjects = Integer.parseInt(numSubjectsField.getText());

                students[studentCounter] = new Student();
                students[studentCounter].rollno = rollNo;
                students[studentCounter].name = name;
                students[studentCounter].dob.dd = day;
                students[studentCounter].dob.mm = month;
                students[studentCounter].dob.yyyy = year;
                students[studentCounter].stream = stream;
                students[studentCounter].Semester = semester;
                students[studentCounter].numos = numSubjects;
                students[studentCounter].subjects = new String[numSubjects];
                students[studentCounter].teachers = new Teacher[numSubjects];

                for (int i = 0; i < numSubjects; i++) {
                    String subject = JOptionPane.showInputDialog(this, "Enter subject " + (i + 1) + ":");
                    students[studentCounter].subjects[i] = subject;

                    String facultyName = JOptionPane.showInputDialog(this, "Enter Faculty Name for subject " + subject + ":");
                    String facultyID = JOptionPane.showInputDialog(this, "Enter Faculty ID for subject " + subject + ":");
                    String department = JOptionPane.showInputDialog(this, "Enter Department for subject " + subject + ":");
                    Teacher teacher = new Teacher(facultyName, facultyID, department);
                    students[studentCounter].teachers[i] = teacher;
                }

                students[studentCounter].CalculateAttendance();
                studentCounter++;
                JOptionPane.showMessageDialog(this, "Student added successfully!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid data.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void displayStudent() {
        try {
            String rollNoStr = JOptionPane.showInputDialog(this, "Enter RollNo of the student to display:");
            int rollNo = Integer.parseInt(rollNoStr);

            boolean found = false;
            for (int i = 0; i < studentCounter; i++) {
                if (students[i].rollno == rollNo) {
                    StringBuilder studentInfo = new StringBuilder();
                    studentInfo.append("Name: ").append(students[i].name).append("\n");
                    studentInfo.append("Date Of Birth: ").append(students[i].dob.dd).append("/")
                            .append(students[i].dob.mm).append("/").append(students[i].dob.yyyy).append("\n");
                    studentInfo.append("RollNo: ").append(students[i].rollno).append("\n");
                    studentInfo.append("Semester: ").append(students[i].Semester).append("\n");
                    studentInfo.append("Stream: ").append(students[i].stream).append("\n");
                    studentInfo.append("Subjects:\n");
                    for (int j = 0; j < students[i].numos; j++) {
                        studentInfo.append("- ").append(students[i].subjects[j]).append("\n");
                        studentInfo.append("  Teacher: ").append(students[i].teachers[j].name).append("\n");
                        studentInfo.append("  Faculty ID: ").append(students[i].teachers[j].facultyID).append("\n");
                        studentInfo.append("  Department: ").append(students[i].teachers[j].department).append("\n");
                    }
                    studentInfo.append("\n");

                    StringBuilder attendanceInfo = new StringBuilder();
                    attendanceInfo.append("-------------------------------------------------------------------------------------------------------------------\n");
                    attendanceInfo.append(String.format("%10s %10s %15s %10s  %10s\n","Subject","Present","Missed","LOA","Attendance"));
                    attendanceInfo.append("-------------------------------------------------------------------------------------------------------------------\n");
                    for (int j = 0; j < students[i].numos; j++) {
                        attendanceInfo.append(String.format("%10s %15s %20s %15s %10.2s\n",students[i].subjects[j],     students[i].WorkingDays[j]     ,     students[i].AbsentDays[j]     ,       students[i].LOAoff[j]       ,    students[i].totalAttendance[j]));
                    }
                    attendanceInfo.append("-------------------------------------------------------------------------------------------------------------------\n");

                    JTextArea textArea = new JTextArea(studentInfo.toString() + "\n" + attendanceInfo.toString());
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new Dimension(400, 260));
                    JOptionPane.showMessageDialog(this, scrollPane, "Student Details", JOptionPane.INFORMATION_MESSAGE);

                    found = true;
                    break;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student record not found!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Roll No. Please enter a valid number.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void updateStudentAttendance() {
        try {
            JTextField rollNoField = new JTextField(5);

            JPanel panel = new JPanel(new GridLayout(0, 1));
            panel.add(new JLabel("Enter Roll No:"));
            panel.add(rollNoField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Update Attendance",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                int rollNo = Integer.parseInt(rollNoField.getText());

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
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input for Roll No. Please enter a valid number.");
        }
    }
}

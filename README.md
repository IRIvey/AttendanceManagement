# Student Attendance Management System

This is a Java-based application to manage student attendance. It provides a GUI to add, display, and update information about students, teachers, and their attendance records.

## Features

- **Student Management**: Add, display, and update student details.
- **Teacher Management**: Add, display, and update teacher details.
- **Attendance Management**: Calculate, display, and update attendance for students.

## Project Structure

The project is organized into several packages and classes:

### Packages and Classes

- `Main`: Contains the main entry point of the application.
  - `Main`: Initializes the main frame of the application.
  - `MainFrame`: The main GUI frame with buttons to launch student, teacher, and attendance forms.

- `Student`: Contains the student and teacher classes and their related functionality.
  - `Student`: Represents a student and implements the `Attendance` interface.
  - `Teacher`: Represents a teacher with their details.
  - `StudentFrame`: GUI frame for managing students.
  - `TeacherFrame`: GUI frame for managing teachers.
  - `AttendanceFrame`: GUI frame for managing student attendance.
  - `Attendance`: An interface for attendance-related methods.
  - `Date`: Helper class to manage date-related operations.
  - `DataException`: Custom exception class for handling data-related errors.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher.
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse, VS Code).

### Running the Application

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/yourusername/student-attendance-management.git
   cd student-attendance-management

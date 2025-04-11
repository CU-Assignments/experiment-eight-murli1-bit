<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Portal</title>
</head>
<body>
    <h1>Student Attendance Form</h1>
    <form action="AttendanceServlet" method="post">
        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required><br><br>
        
        <label for="attendanceDate">Date:</label>
        <input type="date" id="attendanceDate" name="attendanceDate" required><br><br>
        
        <label for="status">Attendance Status:</label>
        <select id="status" name="status" required>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>

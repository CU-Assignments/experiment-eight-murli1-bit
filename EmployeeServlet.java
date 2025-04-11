# EmployeeServlet

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Search Employee by ID</h2>");
        out.println("<form method='post'>");
        out.println("Employee ID: <input type='text' name='empId'/>");
        out.println("<input type='submit' value='Search'/>");
        out.println("</form>");

        String empId = request.getParameter("empId");
        if (empId != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");
                PreparedStatement ps = con.prepareStatement("SELECT * FROM employees WHERE id = ?");
                ps.setString(1, empId);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    out.println("<h3>Employee Details:</h3>");
                    out.println("ID: " + rs.getInt("id") + "<br>");
                    out.println("Name: " + rs.getString("name") + "<br>");
                    out.println("Position: " + rs.getString("position") + "<br>");
                } else {
                    out.println("<h3>No employee found with ID: " + empId + "</h3>");
                }
                con.close();
            } catch (Exception e) {
                out.println("<h3>Error: " + e.getMessage() + "</h3>");
            }
        }
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

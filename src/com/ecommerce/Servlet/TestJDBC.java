package com.ecommerce.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.Webapp.DBConnection;

/**
 * Servlet implementation class TestJDBC
 */
@WebServlet("/TestJDBC")
public class TestJDBC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestJDBC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		PrintWriter out = response.getWriter();
		
		// Load data from config properties
		InputStream in = getServletContext().getResourceAsStream("/config.properties");
		Properties properties = new Properties();
		properties.load(in);
		
		//fetch properties
		
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		
		// Registering the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// create connection
		DBConnection conn = new DBConnection(url, username, password);
		
		//print response
		
		out.println("<html><body>");
		out.println("<h1> DB Connection is Initialized !!</h1>");
		out.println("</body></html>");
		
		//Close Connection
		
		conn.closeConnection();
		
		}catch(SQLException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

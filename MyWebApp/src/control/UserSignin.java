package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DBConnection;

/**
 * Servlet implementation class UserSignin
 */
@WebServlet("/UserSignin")
public class UserSignin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserSignin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		String passwordCheck = (String) request.getParameter("checkpassword");

		Connection conn = null;
		Statement sta = null;
		boolean flag = false;

		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			if(password.equals(passwordCheck)){
				String sql = "insert into userinfo values('" + userName + "','" + password + "'" + ")";
				int rs = sta.executeUpdate(sql);
				if(rs!=0){
					flag = true;
				}
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//flag = false;
		} finally {
			try {
				sta.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (flag) {
			request.getRequestDispatcher("/signin_success.jsp").forward(request, response);
		} else
			request.getRequestDispatcher("/signin_failure.jsp").forward(request, response);

	}

}

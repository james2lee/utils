package com.james.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用Statement和PrepareStatement连接数据库
  @author JAMES
 */
public class JdbcTest {
	
	public JdbcTest() {}
	
	public static void main(String[] args) {
		//connWithStatement();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/user";
			String user = "root";
			String password = "root";
			String sql = "SELECT * FROM user";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");	
				String username = resultSet.getString("username");
				System.out.println(id+"<-->"+username);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private static void connWithStatement() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			String url = "jdbc:mysql://127.0.0.1:3306/user";
			String user = "root";
			String password = "root";
			String sql = "SELECT * FROM user";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");	
				String username = resultSet.getString("username");
				System.out.println(id+"<-->"+username);
			}
		} catch (ClassNotFoundException e) {
			new RuntimeException("com.mysql.jdbc.Driver不存在，请检查！");
		} catch (SQLException e) {
			new RuntimeException("DriverManager获取Connection出错！");
		}finally{
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}

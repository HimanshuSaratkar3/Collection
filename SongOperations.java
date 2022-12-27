package com.hs;	
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class SongOperations {
	static private Connection connection;
	static private PreparedStatement preparedStatement;
	static private ResultSet resultSet;
	private static Properties properties;
	static private int result;
	static private String filepath = "C:\\J2EE\\Project\\resources\\info.properties";
	private static Scanner scanner = new Scanner(System.in);
	
	static private int id;
	static private String name;
	static private String singer;
	static private String movie;
	static private String liricist;
	static private String duration;
	
	private void openConnection() {
		try {
			FileReader fileReader = new FileReader(filepath);
			properties = new Properties();
			properties.load(fileReader);
			Class.forName(properties.getProperty("driverpath"));
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);		
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public void displayAllSongs() {
		openConnection();
		try {
			preparedStatement = connection.prepareStatement(properties.getProperty("query"));
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(1)+"|"
						+resultSet.getString(2)+" | "
						+resultSet.getString(3)+" | "
						+resultSet.getString(4)+" | "
						+resultSet.getString(5)+" | "
						+resultSet.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void selectSong(int a) {
		openConnection();
		try {
			preparedStatement = connection.prepareStatement(properties.getProperty("query3"));
			preparedStatement.setInt(1, a);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				System.out.println(resultSet.getString(2)+" is now playing");
			} 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	  public void addSong()  {
		openConnection();
		try {
			preparedStatement = connection.prepareStatement(properties.getProperty("query1"));
			
			System.out.println("Enter the id : ");
			id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			
			System.out.println("Enter the Name of the Song");
			name =scanner.next();
			preparedStatement.setString(2, name);
			
			System.out.println("Enter the Singer of the Song");
			singer =scanner.next();
			preparedStatement.setString(3, singer);
			
			System.out.println("Enter the Movie of the Song");
			movie =scanner.next();
			preparedStatement.setString(4, movie);
			
			System.out.println("Enter the Liriscist of the Song");
			liricist =scanner.next();
			preparedStatement.setString(5, liricist);
			
			System.out.println("Enter the  duration of the Song");
			duration =scanner.next();
			preparedStatement.setString(6, duration);
			
			result = preparedStatement.executeUpdate();
			System.out.println(result + "row(s) added");
			
			closeConnection();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
	 public void removeSong() {
		openConnection();
		try {
			preparedStatement = connection.prepareStatement(properties.getProperty("query2"));
			
			System.out.println("Enter the id of the song to be deleted");
			id = scanner.nextInt();
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	 public void update() {
		openConnection();
		try {
			displayAllSongs();
			
			System.out.println();
			System.out.println("enter the coloum to edit");
			System.out.println("1. Name");
			System.out.println("2. Singer");
			System.out.println("3. Movie");
			System.out.println("4. Liricist");
			System.out.println("5. Duration");
			System.out.println();
			System.out.println("enter the choice");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				preparedStatement = connection.prepareStatement(properties.getProperty("query4"));
				System.out.println("enter the name :");
				String name = scanner.next();
				preparedStatement.setString(1, name);
				
				System.out.println("Enter the id :");
				int id = scanner.nextInt();
				preparedStatement.setInt(2, id);
				break;
			case 2:
				preparedStatement = connection.prepareStatement(properties.getProperty("query5"));
				System.out.println("Enter the singer :");
				String singer = scanner.next();
				preparedStatement.setString(1, singer);
				
				System.out.println("Enter the id :");
				int id1 = scanner.nextInt();
				preparedStatement.setInt(2, id1);
				break;
			case 3:
				preparedStatement = connection.prepareStatement(properties.getProperty("query6"));
				System.out.println("enter the movie :");
				String movie = scanner.next();
				preparedStatement.setString(1, movie);
				
				System.out.println("Enter the id :");
				int id3 = scanner.nextInt();
				preparedStatement.setInt(2, id3);
				break;
			case 4:
				preparedStatement = connection.prepareStatement(properties.getProperty("query7"));
				System.out.println("enter the liricist :");
				String liricist = scanner.next();
				preparedStatement.setString(1, liricist);
				
				System.out.println("Enter the id :");
				int id4 = scanner.nextInt();
				preparedStatement.setInt(2, id4);
				break;
			case 5:
				preparedStatement = connection.prepareStatement(properties.getProperty("query8"));
				System.out.println("enter the duration :");
				String duration = scanner.next();
				preparedStatement.setString(1, duration);
				
				System.out.println("Enter the id :");
				int id5 = scanner.nextInt();
				preparedStatement.setInt(2, id5);
				break;

			default:
				System.out.println("....out of context...");
				break;
			}
					
			result = preparedStatement.executeUpdate();
			System.out.println(result + "row(s) edited");
			
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}

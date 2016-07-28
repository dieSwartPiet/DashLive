import java.math.BigInteger;
import java.sql.*;

import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
public class LoginModel {
	Connection connection;
	public LoginModel(){
		connection = SqliteConnection.Connector();
		if(connection == null){
			System.out.println("connection not successful");
			System.exit(1);
		}
	}
	
	public boolean isDbConnected(){
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean isLoggedIn(String admin, String pass) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "select * from admin where name = ? and password = ?";
		try{
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, admin);
			preparedStatement.setString(2, pass);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		finally{
			preparedStatement.close();
			resultSet.close();
		}
	}
	
	public boolean signUp(String name,String surname, String password) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Statement state = null;
		String query = "select * from admin where name = ? and surname = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while(resultSet.next())
			{
				count++;
			}
			resultSet.close();
			if(count == 1)
			{
				return false;
			}
			else{
				state = connection.createStatement();
				resultSet = state.executeQuery("select COUNT(*) from admin");
				int increment = (int) resultSet.getObject(1);
				String query1 = "insert into admin values ("+(increment+1)+" , '"+name+"' ,'"+surname+"' , '"+password+"')";
				state.executeUpdate(query1);
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		finally{
			preparedStatement.close();
			resultSet.close();
			state.close();
		}
		
	}
	
	public boolean memeberContacts(String name,String surname, int age, BigInteger cell, String gender, String address, String city, int postal, String membership, String email) throws SQLException{
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Statement state = null;
		String query = "select * from members where name = ? and surname = ?";
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, surname);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			while(resultSet.next())
			{
				count++;
			}
			resultSet.close();
			if(count == 1)
			{
				return false;
			}
			else{
				state = connection.createStatement();
				resultSet = state.executeQuery("select COUNT(*) from members");
				int increment = (int) resultSet.getObject(1);
				String query1 = "insert into members values ("+(increment+1)+" , '"+name+"' ,'"+surname+"' , '"+age+"' , '"+cell+"' ,'"+gender+"' ,'"+address+"' ,'"+city+"' ,'"+postal+"' ,'"+membership+"' ,'"+email+"')";
				state.executeUpdate(query1);
				return true;
			}
		} catch (SQLException e) {
			return false;
		}
		finally{
			preparedStatement.close();
			resultSet.close();
			state.close();
		}
	}
	
	public void loadDatabaseData(ObservableList<Members> data, TableView<Members> table) throws SQLException
	{
		String query="select * from members";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try
		{
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				data.add(new Members(
						resultSet.getString("members_id"),
						resultSet.getString("name"),
						resultSet.getString("surname"),
						resultSet.getString("age"),
						resultSet.getString("cell"),
						resultSet.getString("gender"),
						resultSet.getString("address"),
						resultSet.getString("city"),
						resultSet.getString("postal"),
						resultSet.getString("membership"),
						resultSet.getString("email")
						));
				table.setItems(data);
				System.out.println("name "+resultSet.getString("name"));
				System.out.println("surn+ "+resultSet.getString("surname"));
				System.out.println("age+ "+resultSet.getString("age"));
				System.out.println("cell+ "+resultSet.getString("cell"));
				System.out.println("gender+ "+resultSet.getString("gender"));
				System.out.println("addre+ "+resultSet.getString("address"));
				System.out.println("city+ "+resultSet.getString("city"));
				System.out.println("posn+ "+resultSet.getString("postal"));
				System.out.println("email+ "+resultSet.getString("email"));
			}
			preparedStatement.close();
			resultSet.close();
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}

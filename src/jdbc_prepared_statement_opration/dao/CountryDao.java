package jdbc_prepared_statement_opration.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc_prepared_statement_opration.connection.CountryConnection;
import jdbc_prepared_statement_opration.dto.Country;

public class CountryDao{
	PreparedStatement preparedStatement;
	Connection connection=CountryConnection.getCountryConnection();
	//save method
public Country saveCountry( Country country) {
	String insertCountryQuery="insert into country values(?,?,?,?)";
	
	
	try {
 preparedStatement=connection.prepareStatement(insertCountryQuery);
	 preparedStatement.setInt(1, country.getCountryid());
	 preparedStatement.setString(2, country.getCountryname());
	 preparedStatement.setString(3, country.getCountryCapital());
	 preparedStatement.setInt(4, country.getCountryStates());
	 preparedStatement.execute();
	 System.out.println("data stord");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return country;
}


public int deleteCountryById(int CountryId) {
	
	String deleteQuery="delete from country where id=?";
	try {
		 preparedStatement=connection.prepareStatement( deleteQuery);
		preparedStatement.setInt(1,CountryId);
		return preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	return 0;
	}

//getById
public Country getById(int countryId) {
	String selectQuery="select * from country where id=?";
	try {
		 preparedStatement=connection.prepareStatement(selectQuery);
		preparedStatement.setInt(1, countryId);
		ResultSet resultSet=preparedStatement.executeQuery();
		if(resultSet.next()) {
			
			Country country=new Country();
			country.setCountryid(resultSet.getInt("id"));
			country.setCountryname(resultSet.getString("name"));
			country.setCountryCapital(resultSet.getString("capital"));
			country.setCountryStates(resultSet.getInt("states"));
			return country;
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	
	
}

//display method


public List<Country> displayCountries(){

	try {
		String displayCountryQuerry="select * from country";
		PreparedStatement preparedStatement=connection.prepareStatement(displayCountryQuerry);
	
		 
		 ResultSet resultSet=preparedStatement.executeQuery();
		
		List<Country> products=new ArrayList<Country>();
		
		while(resultSet.next()) {
			Country country=new Country();
			int id=resultSet.getInt("id"); 
			String name=resultSet.getString("name");
			String capital=resultSet.getString("capital");
			int states=resultSet.getInt("states");
			country.setCountryid(id);
			country.setCountryname(name);
			country.setCountryCapital(capital);
			country.setCountryStates(states);
		products.add(country); 
		}
		 return products;
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}		
				
				
			return null;
}

public int updateCountryName(int cId,String cName) {
	
	String updateQuerry="update country set name=? where id=?";
	 
	try {
		preparedStatement = connection.prepareStatement( updateQuerry);
		preparedStatement.setString(1, cName);
		preparedStatement.setInt(2, cId);
	return preparedStatement.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return 0;


}
public int updateCountryStates(int id,int s) {
	
	String updateQuerry="update country set states=? where id=?";
  try {
	preparedStatement= connection.prepareStatement(updateQuerry);
	preparedStatement.setInt(1, s);
	preparedStatement.setInt(2,id);
	return preparedStatement.executeUpdate();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  return 0;
	
}

// update country capital
public int updateCountryCapital(int id,String cap) {
	
	String updateQuerry="update country set capital=? where id=?";
	try {
	preparedStatement=	connection.prepareStatement(updateQuerry);
		preparedStatement.setInt(2, id);
		preparedStatement.setString(1,cap);
		 return preparedStatement.executeUpdate();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}




















}

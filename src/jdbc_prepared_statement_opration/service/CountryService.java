package jdbc_prepared_statement_opration.service;


import java.util.List;

import jdbc_prepared_statement_opration.dao.CountryDao;
import jdbc_prepared_statement_opration.dto.Country;
import jdbc_prepared_statement_opration.exception.IdNotFoundException;
//save method
public class CountryService {
	CountryDao countryDao=new CountryDao();
	public Country saveCountry( Country country) {
		
		if(country.getCountryStates()>=10 && (country.getCountryStates()<=30)&&(country.getCountryCapital().length()>=5))
{
	return countryDao.saveCountry(country);

}
				return country;
	}
	//display method
	

	//delete method
	public int deleteCountryById(int countryId) {
		
	Country country=countryDao.getById(countryId);
if(country!=null) {
	return countryDao.deleteCountryById(countryId);
	
}
else {
	System.out.println("id not found");
	return 0;
}

	}
	public Country getById(int countryId) {
		Country country=countryDao.getById(countryId);
		if(country!=null) {
			return country;
			
		}else {
		try {	
		throw new IdNotFoundException("id not found plss check it once");
		}
		catch(IdNotFoundException e)	{
			System.err.println(e.getMessage());
		}
			
			return null;
		
		}
		
	}
	
	//display method
	public List<Country> displayCountries(){
		
		List <Country> countrys=countryDao.displayCountries();
return countrys;		
	}
	
	
	//update method for country name
	public int updateCountryName(int cId,String cName) {
		
		
		return countryDao.updateCountryName(cId, cName);
	}
	
	//update method foe COUNTRY state
	public int updateCountryStates(int cId,int cstate) {
		
		
		return countryDao.updateCountryStates(cId, cstate);
	}
		
	//update method foe COUNTRY capital
		public int updateCountryCapital(int cId,String cCap) {
			
			
			return countryDao.updateCountryCapital(cId, cCap);
		}
		
		
		
		
		
		
	
	
}



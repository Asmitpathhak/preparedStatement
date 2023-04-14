package jdbc_prepared_statement_opration.controller;


import java.util.List;
import java.util.Scanner;

import jdbc_prepared_statement_opration.dto.Country;
import jdbc_prepared_statement_opration.service.CountryService;

public class CountryController {
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);
    Country country=new Country();
    CountryService countryService=new CountryService();
	while (true) {
		System.out.println("Enter Your Choice : ");
		System.out.println("1.Insert\n2.Delete\n3.Update\n4.Display\n5.Exit");
		int ch = sc.nextInt();
		switch (ch) {
		case 1: {
			System.out.println("Enter Countryy Id : ");
			country.setCountryid(sc.nextInt());
			System.out.println("Enter Country Name : ");
			String name=sc.next();
			name=name+sc.nextLine();
			country.setCountryname(name);
			
			System.out.println("Enter  Country Capital : ");
			country.setCountryCapital(sc.nextLine());
            System.out.println("enter a no. of state");
            country.setCountryStates(sc.nextInt());
			countryService.saveCountry(country);
		}break;
		case 2:{
	System.out.println("enter id to delete your country");
	int id=sc.nextInt();
	countryService.deleteCountryById(id);
	}break;
		
		case 3:{
	
			System.out.println("enter what you wnat to update \n1:countryname\n2:capital\n3:states");
			int c=sc.nextInt();
			switch(c) {
			case 1:{
				System.out.println("enter Country Id");
				int id=sc.nextInt();
				System.out.println("ENTER A NAME ");
				String n=sc.next();
				int r=countryService.updateCountryName(id, n);
				if(r==1) {System.out.println("countryNAME UPDATED");}
				else {System.out.println("country name not updated");}
				}break;
			case 2:{
				System.out.println("enter Country Id");
				int id1=sc.nextInt();
				System.out.println("ENTER A Capital NAME ");
				String n=sc.next();
				int r=countryService.updateCountryCapital(id1, n);
				
				if(r==1) {System.out.println("country CAPITAL UPDATED");}
				else {System.out.println("country CAPITAL not updated");}
				
				}break;
			case 3:{
				System.out.println("enter Country Id");
				int id2=sc.nextInt();
				System.out.println("ENTER TOTAL STATES ");
				int n=sc.nextInt();
				int r=countryService.updateCountryStates(id2, n);
				if(r==1) {System.out.println("country STATES UPDATED");}
				else {System.out.println("country STATES not updated");}
				}break;
			default:{System.out.println("enter valid choice");}
				}
		
		
		}break;
		
		case 4:{
		
				List<Country> countrys=countryService.displayCountries();
				for(Country a:countrys) {
					System.out.println("id is:"+a.getCountryid());
					System.out.println("name is:"+a.getCountryname());
					System.out.println("capital is:"+a.getCountryCapital());
					System.out.println("states are:"+a.getCountryStates());
					
					System.out.println("===============================");
					
				}

			
			
		}break;

		default:
		{
			System.out.println("enter valid command");}
		}
		}}}

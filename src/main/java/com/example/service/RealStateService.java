package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RealStateForm;

@Controller
@RequestMapping(value="/service") 
public class RealStateService {

	@Autowired
	private DataSource dataSource;

	@GetMapping(value="/realstateform/")
	public String get(@ModelAttribute RealStateForm form){ 
//		@PathVariable String algo
		
		return "index";
	}
	
	@PostMapping
	public String saveForm() {

		try (Connection connection = dataSource.getConnection()) {
			
			String query = "INSERT INTO REALSTATEFORM ("
					+ "id,"
					+ "reference, "
					+ "onStreet, "
					+ "Streetnumber, "
					+ "onStreetbtwone, "
					+ "onStreetbtwtwo, "
					+ "status, "
					+ "mcc, "
					+ "mcd, "
					+ "toilette, "
					+ "canttoilette, "
					+ "garage, "
					+ "garaberoof) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//			PreparedStatement st = connection.prepareStatement(query);
//			st.setInt(1, 1);
//			st.setString(2, "mock1");
//			st.setString(3, "mock2");
//			st.setString(4, "mock3");
//			st.setString(5, "mock4");
//			st.setString(6, "mock4");
//			st.setString(7, "mock5");
//			st.setString(8, "mock6");
//			st.setString(9, "mock7");
//			st.setString(10, "mock8");
//			st.setString(11, "mock9");
//			st.setString(12, "mock10");
//			st.setString(13, "mock11");
//			st.execute();
			
			Statement st = connection.createStatement();
			st.execute("insert into REALSTATEFORM (id,reference,onStreet,Streetnumber,onStreetbtwone,onStreetbtwtwo,status, mcc,mcd,toilette,canttoilette,garage,garaberoof)values(2,'mock1','mock2','mock3','mock4','mock5','mock6','mock7','mock8','mock9','mock10','mock11','mock12')");
			
			ResultSet rs = st.executeQuery("SELECT * FROM REALSTATEFORM");

			ArrayList<String> output = new ArrayList<String>();
			String msg="";
			while (rs.next()) {
				msg +="Read from DB: " + rs.getString("reference") +", ";
			}

			return msg;
		} catch (Exception e) {
			return e.getMessage();
		}

	}

}

package com.ms.wmadv.modelrecommend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WMTAdvModelRecommendationRepository {

	@Value("${database.server}")
	private String databaseServer;

	@Value("${database.name}")
	private String databaseName;
	
	@Value("${database.username}")
	private String username;
	
	@Value("${database.password}")
	private String password;
	
	//private String url = "jdbc:sqlserver://ilasqldbserver.database.windows.net:1433;database=ilasqldb;user=ilamuruk@ilasqldbserver;password=Dec2019M;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	private String url = "jdbc:sqlserver://azuredtabasesrvr9.database.windows.net:1433;database=azuredatabase9;user=azuredtabaseuser9@azuredtabasesrvr9;password=Welcometoazure#1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
	
	
	public List<Product> fetchProductById(String id){
		
		String url = DBConstants.urlPrefix + databaseServer +"/" +databaseName + "?" + DBConstants.sslConfig + "&" + DBConstants.timeConfig;
		List<Product> products = new ArrayList<>();
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myDbConn = DriverManager.getConnection(url, username , password);
			
			String sql = "Select * from product where id=?;";
			
			PreparedStatement prepStatement = myDbConn.prepareStatement(sql);
			prepStatement.setString(1, id);
			ResultSet results = prepStatement.executeQuery(sql);
			
			while (results.next())
			{
				Product product = new Product(results.getInt("rownum"), results.getString("symbol"), results.getString("product_name") , results.getDouble("marketcap") , results.getString("sector"),  results.getString("industry"),
						 results.getString("asset_class"),  results.getDouble("close_price") ,  results.getDouble("risk_score") ,  results.getDouble("return_2019") ,  results.getDouble("return_2018") ,
						 results.getDouble("return_2017") ,  results.getDouble("return_2016") ,  results.getDouble("return_2015") ,  results.getDouble("return_2014") ,  results.getDouble("return_2013") ,
						 results.getDouble("return_2012") ,  results.getDouble("return_2011") ,  results.getDouble("return_2010") );
						
				products.add(product);
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
		
	}


public List<Product> fetchAllProducts(){
	
	String url = DBConstants.urlPrefix + databaseServer +"/" +databaseName + "?" + DBConstants.sslConfig + "&" + DBConstants.timeConfig;
	List<Product> products = new ArrayList<>();
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection myDbConn = DriverManager.getConnection(url, username , password);
		
		String sql = "Select * from product;";
		
		Statement statement = myDbConn.createStatement();
		ResultSet results = statement.executeQuery(sql);
		
		while (results.next())
		{
			Product product = new Product(results.getInt("rownum"), results.getString("symbol"), results.getString("product_name") , results.getDouble("marketcap") , results.getString("sector"),  results.getString("industry"),
					 results.getString("asset_class"),  results.getDouble("close_price") ,  results.getDouble("risk_score") ,  results.getDouble("return_2019") ,  results.getDouble("return_2018") ,
					 results.getDouble("return_2017") ,  results.getDouble("return_2016") ,  results.getDouble("return_2015") ,  results.getDouble("return_2014") ,  results.getDouble("return_2013") ,
					 results.getDouble("return_2012") ,  results.getDouble("return_2011") ,  results.getDouble("return_2010") );
					
			products.add(product);
			
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return null;
	
}

public List<Product> fetchProductsBySymbol(String symbol){
	
	String url = DBConstants.urlPrefix + databaseServer +"/" +databaseName + "?" + DBConstants.sslConfig + "&" + DBConstants.timeConfig;
	List<Product> products = new ArrayList<>();
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection myDbConn = DriverManager.getConnection(url, username , password);
		
		String sql = "Select * from product where symbol=?;";
		
		PreparedStatement prepStatement = myDbConn.prepareStatement(sql);
		prepStatement.setString(1, symbol);
		ResultSet results = prepStatement.executeQuery(sql);
		
		while (results.next())
		{
			Product product = new Product(results.getInt("rownum"), results.getString("symbol"), results.getString("product_name") , results.getDouble("marketcap") , results.getString("sector"),  results.getString("industry"),
					 results.getString("asset_class"),  results.getDouble("close_price") ,  results.getDouble("risk_score") ,  results.getDouble("return_2019") ,  results.getDouble("return_2018") ,
					 results.getDouble("return_2017") ,  results.getDouble("return_2016") ,  results.getDouble("return_2015") ,  results.getDouble("return_2014") ,  results.getDouble("return_2013") ,
					 results.getDouble("return_2012") ,  results.getDouble("return_2011") ,  results.getDouble("return_2010") );
					
			products.add(product);
			
		}
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	
	return null;
	
}

}
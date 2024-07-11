package org.car.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class DbHelper {
	
	protected DbConfig db = DbConfig.getDbInstance();
	protected Connection conn = DbConfig.getConnection();
	protected PreparedStatement stmt =DbConfig.getStatement();
	protected ResultSet rs = DbConfig.getResultSet();
	
	

}

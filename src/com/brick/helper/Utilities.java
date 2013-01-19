package com.brick.helper;

import java.sql.ParameterMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;

public class Utilities {
	public static String getEngFromNepali(String date) throws SQLException {
		String simpleProc = "{ call NEPALI(?,?) }";
		CallableStatement cs = (CallableStatement) connection.prepareCall(simpleProc);
		cs.registerOutParameter(2, java.sql.Types.VARCHAR);
		cs.setString(1, "2068-09-01");
		cs.execute();
		String param1 = cs.getString("VENGDATE");
		System.out.println("param1=" + param1);
		ParameterMetaData pmeta = cs.getParameterMetaData();
		if (pmeta == null) {
		System.out.println("Vendor does not support ParameterMetaData");
		} else {
		System.out.println(pmeta.getParameterType(1));
		}
		connection.close();

		return "";

		}

}

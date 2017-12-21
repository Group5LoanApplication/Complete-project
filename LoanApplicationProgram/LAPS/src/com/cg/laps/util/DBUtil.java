package com.cg.laps.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.cg.laps.exception.LoanException;

public class DBUtil {
	private static DBUtil instance = null;
	static Connection conn;
	static {

		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:/OracleDs");
			conn = source.getConnection();
		} catch (Exception e) {
			try {
				throw new SQLException(e.getMessage());
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static DBUtil getInstance()throws LoanException {
		synchronized (DBUtil.class) {
			if (instance == null) {
				instance = new DBUtil();
			}
		}
		return instance;
	}
}

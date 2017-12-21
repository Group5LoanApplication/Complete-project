package com.cg.laps.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

import com.cg.laps.exception.LoanException;
import com.cg.laps.util.DBUtil;

public class DBUtilTest {

	@Test
	public void testConnection() throws LoanException {

		Connection con;
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:/OracleDs");
			con = DBUtil.getConnection();
			assertNotNull(con);
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	
	@Ignore
	@Test(expected = LoanException.class)
	public void testConnection2() throws LoanException {
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:/OracleDS");
			//OracleDS does Not exist so it will raise exception.
			Connection con = DBUtil.getConnection();
		} catch (NamingException e) {
			throw new LoanException("Failed");
		}
	}
}

package org.ph.jasuis;

import java.sql.*;

public class Conexion {
	private Statement stat; // variable para ejecucion de sql
	private Connection conn;

	public Conexion() throws Exception {
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:jaSuis.db");

		stat = conn.createStatement();
		conn.setAutoCommit(true);
	}

	public ResultSet ejecutarSql(String sql) {

		ResultSet rs = null;
		try {
			rs = stat.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	public void cerrarConexion() {
		try {
			//conn.commit();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Connection getConeccion() {
		return conn;
	}

	public boolean ejecutar(String sql) {
		boolean r = false;
		try {
			r = stat.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	
}

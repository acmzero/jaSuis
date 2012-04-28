package org.ph.jasuis;

public class BaseDatos {

	private static Conexion conn;

	public BaseDatos() throws Exception {
		conn = new Conexion();
		crearTablaJugadores();
		System.out.println("constructor");
		conn.cerrarConexion();

	}

	private boolean crearTablaJugadores() {
		String sql = "create table jugadores(jugador_id integer primary key, nombre varchar(60),nick varchar(25), edad int, rating int);";
		return conn.ejecutar(sql);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("main");
		BaseDatos bd=new BaseDatos();
		
	}
}

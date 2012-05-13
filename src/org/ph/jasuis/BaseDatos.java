package org.ph.jasuis;

import java.util.ArrayList;
import java.util.Iterator;

public class BaseDatos {

	private static Conexion conn;

	public BaseDatos() throws Exception {
		conn = new Conexion();
		crearTablas();
		insertarDatosDeEjemplo();
		conn.cerrarConexion();

	}

	
	public static void main(String[] args) throws Exception {
		System.out.println("main");
		BaseDatos bd=new BaseDatos();
		
	}
	private void insertarDatosDeEjemplo(){
		ArrayList<String> comandos = new ArrayList<String>();
		comandos.add("insert into jugadores values(null,\"heli\",\"heli\",23,1400);");
		comandos.add("insert into jugadores values(null,\"Pedro\",\"piter\",22,400);");
		comandos.add("insert into equipos values(null,'Fenix','Santiago');");
		comandos.add("insert into jugadores_en_equipo VALUES (1,1);");
		comandos.add("insert into jugadores_en_equipo VALUES (1,2);");
		Iterator it=comandos.iterator();
		while(it.hasNext()){
			conn.ejecutar((String) it.next());
		}
		
	}
	private void crearTablas(){
		ArrayList<String> comandos = new ArrayList<String>();
		comandos.add("create table jugadores(jugador_id integer primary key, nombre varchar(60),nick varchar(25), edad int, rating int);");
		comandos.add("create table equipos(equipo_id integer primary key,nombre varchar(50),procedencia varchar(50));");
		comandos.add("create table jugadores_en_equipo(equipo_id integer,jugador_id integer);");
		Iterator it=comandos.iterator();
		while(it.hasNext()){
			conn.ejecutar((String) it.next());
		}
		
	}
}

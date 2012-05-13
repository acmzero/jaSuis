package org.ph.jasuis;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Equipo {
	private int id;
	private String nombre;
	private ArrayList<Jugador> jugadores;
	
	private String procedencia;
	private ArrayList<Integer> idJugadores;
	private Conexion con;
	private Statement stat;

	private void iniciarConexion() throws Exception{
		con=new Conexion();
		stat=con.getStatement();
	}
	
	//Constructor para nuevo equipo
	public Equipo(){
		iniciarVariables();
	}
	public Equipo(int ID) throws Exception{
		id=ID;
		iniciarConexion();
		String sql="select * from equipos where equipo_id="+id;
		ResultSet rs=stat.executeQuery(sql);
		if(rs.next()){
			nombre=rs.getString("nombre");
			procedencia=rs.getString("procedencia");
		}else{
			System.out.println("Equipo no existe.");
			
		}
		jugadores=new ArrayList<Jugador>();
		idJugadores=new ArrayList<Integer>();
		llenarJugadores();
	}
	private void llenarJugadores() throws Exception{
		String sql ="select jugador_id from jugadores_en_equipo where equipo_id="+id;
		ResultSet rs=stat.executeQuery(sql);
		while(rs.next()){
			Jugador aj=new Jugador(rs.getInt("jugador_id"));
			addJugador(aj);
		}
		System.out.println("Tamaño del equipo "+nombre+": "+getTamano());
	}
	
	//
	// Getters and Setters
	//
	public String getNombre() {
		return nombre;
	}

	public String getProcedencia() {
		return procedencia;
	}
	public Jugador getJugador(int i){
		return (Jugador)jugadores.get(i);
	}
	
	public int getTamano(){
		return idJugadores.size();
	}
	//
	//

	public void iniciarVariables(){
		id=-1;
		nombre="";
		procedencia="";
		jugadores=new ArrayList<Jugador>();
		idJugadores=new ArrayList<Integer>();
	}
	
	public boolean addJugador(Jugador j){
		
		if(idJugadores.contains(j.getId())){
			System.out.println("Jugador actualmente en el equipo");
			return false;
		}else{
			jugadores.add(j);
			idJugadores.add(j.getId());
			return true;
		}
	}
	public void imprimirNombres(){
		Iterator it=jugadores.iterator();
		while(it.hasNext()){
			Jugador j=(Jugador)it.next();
			System.out.println(j.getNick());
		}
	}
}

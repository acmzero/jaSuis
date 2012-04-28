package org.ph.jasuis;
import java.sql.Connection;
import java.sql.ResultSet;

import org.ph.jasuis.Conexion;
public class Jugador {
	//variables del Jugador
	private String nombre,nick; 
	private int id,edad,rating;
	private Conexion conn;
	//constructor para jugadores existentes, se solicita como parametro la id
	public Jugador(int ID) throws Exception {
		id=ID;
		conn=new Conexion();
		ResultSet rs=conn.ejecutarSql("select * from jugadores where jugador_id="+id);
		while(rs.next()){
			nombre=rs.getString("nombre");
			nick=rs.getString("nick");
			edad=rs.getInt("edad");
			rating=rs.getInt("rating");
		}
	}
	
	//sobreescritura del constructor para jugadores nuevos
	public Jugador(){
		iniciarVariables();
	}
	
	//metodo para que no esten vacias las variables del jugador
	private void iniciarVariables(){
		nombre="";
		nick="";
		edad=0;
		rating=0;
		id=-1;
	}

}

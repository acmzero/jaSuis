package org.ph.jasuis;

public class Pruebas {

	
	public static void main(String[] args) throws Exception {
		
		Jugador heli=new Jugador();
		System.out.println(heli.getNombre());
		Equipo fenix=new Equipo(1);
		System.out.println(fenix.getNombre());
		fenix.imprimirNombres();
	}

}

package trabajopractico;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class Equipo {
	private String nombre;
	private String ciudad;
	private LinkedList<Jugador> jugadores;

	public Equipo(String nombre, String ciudad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.jugadores = new LinkedList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public int getCantidadJugadores() {
		return jugadores.size();
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", jugadores=" + jugadores + "]";
	}

	public void agregarJugador(Jugador jugador) {
		jugadores.add(jugador);
		JOptionPane.showMessageDialog(null, "Jugador agregado" + jugador);
	}

	public void eliminarJugador(String nombre) {
		boolean encontrado = false;
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equalsIgnoreCase(nombre)) {
				jugadores.remove(jugador);
				JOptionPane.showMessageDialog(null, "Jugador eliminado" + jugador);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
		}
	}

	public Jugador buscarJugador(String nombre) {
		for (Jugador jugador : jugadores) {
			if (jugador.getNombre().equalsIgnoreCase(nombre)) {
				return jugador;

			}
		}
		return null;
	}

	public static void JCasa(Equipo equipo) {
		equipo.getJugadores().add(new Jugador("Alan", "Pilar", 1, 26));
		equipo.getJugadores().add(new Jugador("Agustin", "Hooker", 2, 20));
		equipo.getJugadores().add(new Jugador("Uriel", "Pilar", 3, 23));
		equipo.getJugadores().add(new Jugador("Lautaro", "Segunda linea", 4, 20));
		equipo.getJugadores().add(new Jugador("Nicolas", "Segunda linea", 5, 20));
		equipo.getJugadores().add(new Jugador("Marcos", "Ala", 6, 20));
		equipo.getJugadores().add(new Jugador("German", "Ala", 7, 34));
		equipo.getJugadores().add(new Jugador("Maximo", "Octavo", 8, 18));
		equipo.getJugadores().add(new Jugador("Santino", "Medio scrum", 9, 19));
		equipo.getJugadores().add(new Jugador("Gonzalo", "Apertura", 10, 22));
		equipo.getJugadores().add(new Jugador("Franco", "Wing", 11, 27));
		equipo.getJugadores().add(new Jugador("Jesus", "Centro", 12, 27));

	}

	public static void JLujan(Equipo equipo) {
		equipo.getJugadores().add(new Jugador("Fernando", "Pilar", 1, 19));
		equipo.getJugadores().add(new Jugador("Mariano", "Hooker", 2, 40));
		equipo.getJugadores().add(new Jugador("Nicolas", "Pilar", 3, 20));
		equipo.getJugadores().add(new Jugador("Thomas", "Segunda linea", 4, 19));
		equipo.getJugadores().add(new Jugador("Lucas", "Segunda linea", 5, 29));
		equipo.getJugadores().add(new Jugador("Matias", "Ala", 6, 24));
		equipo.getJugadores().add(new Jugador("Agustin", "Ala", 7, 39));
		equipo.getJugadores().add(new Jugador("Patricio", "Octavo", 8, 29));
		equipo.getJugadores().add(new Jugador("Santiago", "Medio scrum", 9, 32));
		equipo.getJugadores().add(new Jugador("Luciano", "Apertura", 10, 27));
		equipo.getJugadores().add(new Jugador("Marcos", "Wing", 11, 22));
		equipo.getJugadores().add(new Jugador("Alejandro", "Centro", 12, 19));

	}

	public static void JMonte(Equipo equipo) {
		equipo.getJugadores().add(new Jugador("Thiago", "Pilar", 1, 23));
		equipo.getJugadores().add(new Jugador("Augusto", "Hooker", 2, 43));
		equipo.getJugadores().add(new Jugador("Alejo", "Pilar", 3, 27));
		equipo.getJugadores().add(new Jugador("Facundo", "Segunda linea", 4, 22));
		equipo.getJugadores().add(new Jugador("Ignacion", "Segunda linea", 5, 24));
		equipo.getJugadores().add(new Jugador("Luciano", "Ala", 6, 26));
		equipo.getJugadores().add(new Jugador("Angel", "Ala", 7, 30));
		equipo.getJugadores().add(new Jugador("Ezequiel", "Octavo", 8, 21));
		equipo.getJugadores().add(new Jugador("Enzo", "Medio scrum", 9, 32));
		equipo.getJugadores().add(new Jugador("Gustavo", "Apertura", 10, 23));
		equipo.getJugadores().add(new Jugador("Ariel", "Wing", 11, 27));
		// equipo.getJugadores().add(new Jugador("Bruno", "Centro", 12, 19));

	}

}
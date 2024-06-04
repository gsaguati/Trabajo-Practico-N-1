package trabajopractico;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class GestorEquipos {
	private static final String Jugador = null;
	private LinkedList<Equipo> equipos;

	public GestorEquipos() {
		this.equipos = new LinkedList<>();

	}

	public LinkedList<Equipo> getEquipos() {
		return equipos;
	}

	public void agregarEquipo() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo:");
		String ciudad = JOptionPane.showInputDialog("Ingrese la ciudad del equipo:");
		Equipo equipo = new Equipo(nombre, ciudad);
		equipos.add(equipo);
		JOptionPane.showMessageDialog(null, "Equipo agregado");
	}

	public void eliminarEquipo() {
		int equipoElegido = elegirEquipo(equipos);
		Equipo equipo = equipos.get(equipoElegido);
		JOptionPane.showMessageDialog(null, "Usted seleccionó al equipo: " + equipo.getNombre());
		equipos.remove(equipo);
		JOptionPane.showMessageDialog(null, "Equipo eliminado");
	}

	public void buscarEquipo() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo a buscar:");
		Equipo equipo = buscarEquipoPorNombre(nombre);
		if (equipo != null) {
			JOptionPane.showMessageDialog(null, equipo.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Equipo no encontrado");
		}
	}

	private Equipo buscarEquipoPorNombre(String nombre) {
		for (Equipo equipo : equipos) {
			if (equipo.getNombre().equalsIgnoreCase(nombre)) {
				return equipo;
			}
		}
		return null;
	}

	public void agregarJugadorAEquipo() {
		int equipoElegido = elegirEquipo(equipos);
		Equipo equipo = equipos.get(equipoElegido);
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador:");
		String posicion = JOptionPane.showInputDialog("Ingrese la posición del jugador:");
		int numeroCamiseta;
		while (true) {
			numeroCamiseta = Integer
					.parseInt(JOptionPane.showInputDialog("Ingrese el número de camiseta del jugador:"));
			boolean numeroCamisetaUsado = false;
			for (Jugador jugador : equipo.getJugadores()) {
				if (jugador.getNumeroCamiseta() == numeroCamiseta) {
					numeroCamisetaUsado = true;
					JOptionPane.showMessageDialog(null,
							"El número de camiseta ya está en uso. \nPor favor, elija otro número.");
					break;
				}
			}
			if (!numeroCamisetaUsado) {
				break;
			}
		}
		int edad;
		while (true) {
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del jugador:"));
			if (edad < 18) {
				JOptionPane.showMessageDialog(null, "La edad del jugador debe ser mayor de 18 años");
			} else {
				break;
			}
		}

		Jugador jugador = new Jugador(nombre, posicion, numeroCamiseta, edad);
		equipo.agregarJugador(jugador);
	}

	public void eliminarJugadorDeEquipo() {
		int equipoElegido = elegirEquipo(equipos);
		Equipo equipo = equipos.get(equipoElegido);
		String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador a eliminar:");
		equipo.eliminarJugador(nombreJugador);
	}

	public void buscarJugadorEnEquipo() {
		int equipoElegido = elegirEquipo(equipos);
		Equipo equipo = equipos.get(equipoElegido);
		if (equipo != null) {
			String nombreJugador = JOptionPane.showInputDialog("Ingrese el nombre del jugador a buscar:");
			Jugador jugador = equipo.buscarJugador(nombreJugador);
			if (jugador != null) {
				JOptionPane.showMessageDialog(null, jugador.toString());
			} else {
				JOptionPane.showMessageDialog(null, "Jugador no encontrado.");
			}
		}
	}

	public static int elegirEquipo(LinkedList<Equipo> equipos) {

		String[] arregloEquipo = new String[equipos.size()];
		for (int i = 0; i < arregloEquipo.length; i++) {
			arregloEquipo[i] = equipos.get(i).getNombre();
		}
		int seleccionado = JOptionPane.showOptionDialog(null, "Seleccione un equipo", null, 0, 0, null, arregloEquipo,
				arregloEquipo);
		return seleccionado;
	}

	public Equipo JugarPartido(Equipo equipo1, Equipo equipo2) {
		if (equipo1 == equipo2) {
			JOptionPane.showMessageDialog(null, "No se puede jugar entre el mismo equipo");
			return null;
		} else {
			if (equipo1.getJugadores().size() < 12 || equipo2.getJugadores().size() < 12) {
				JOptionPane.showMessageDialog(null, "No se puede jugar, faltan jugadores");
				if (equipo1.getJugadores().size() < 12) {
					JOptionPane.showMessageDialog(null, "Le faltan jugadores a " + equipo1.getNombre());
				}
				if (equipo2.getJugadores().size() < 12) {
					JOptionPane.showMessageDialog(null, "Le faltan jugadores a " + equipo2.getNombre());
				}
				return null;
			} else {

				JOptionPane.showMessageDialog(null,
						"Se enfrentan " + equipo1.getNombre() + " vs " + equipo2.getNombre());

				int puntos1;
				int puntos2;
				int p1;
				int p2;
				int resultadoFinal1;
				int resultadoFinal2;
				do {
					puntos1 = (int) (Math.random() * 25);
				} while (puntos1 < 3 || puntos1 == 4);
				do {
					puntos2 = (int) (Math.random() * 25);
				} while (puntos2 < 3 || puntos2 == 4);

				JOptionPane.showMessageDialog(null, "El resultado del primer tiempo es: " + equipo1.getNombre() + " "
						+ puntos1 + " vs " + equipo2.getNombre() + " " + puntos2);
				do {
					p1 = (int) (Math.random() * 25);
				} while (p1 < 3 || p1 == 4);
				do {
					p2 = (int) (Math.random() * 25);
				} while (p2 < 3 || p2 == 4);
				resultadoFinal1 = puntos1 + p1;
				resultadoFinal2 = puntos2 + p2;
				if (resultadoFinal1 == resultadoFinal2) {
					JOptionPane.showMessageDialog(null, "Hay Alargue");

					int puntos11;
					int puntos21;
					int p11;
					int p21;
					int resultadoFinal11;
					int resultadoFinal21;
					do {
						puntos11 = (int) (Math.random() * 11);
					} while (puntos11 < 3 || puntos11 == 4);
					do {
						puntos21 = (int) (Math.random() * 11);
					} while (puntos21 < 3 || puntos21 == 4);

					JOptionPane.showMessageDialog(null, "El resultado del primer tiempo del alargue: "
							+ equipo1.getNombre() + " " + puntos11 + " vs " + equipo2.getNombre() + " " + puntos21);
					do {
						p11 = (int) (Math.random() * 11);
					} while (p11 < 3 || p11 == 4);
					do {
						p21 = (int) (Math.random() * 11);
					} while (p21 < 3 || p21 == 4);
					resultadoFinal11 = puntos11 + p11;
					resultadoFinal21 = puntos21 + p21;
					JOptionPane.showMessageDialog(null, "El resultado final es: " + equipo1.getNombre() + " "
							+ resultadoFinal11 + " vs " + equipo2.getNombre() + " " + resultadoFinal21);
					if (resultadoFinal11 > resultadoFinal21) {
						JOptionPane.showMessageDialog(null, "El Ganador es " + equipo1.getNombre());
						return equipo1;
					} else {
						JOptionPane.showMessageDialog(null, "El Ganador es " + equipo2.getNombre());
						return equipo2;
					}

				} else {
					JOptionPane.showMessageDialog(null, "El resultado final es: " + equipo1.getNombre() + " "
							+ resultadoFinal1 + " vs " + equipo2.getNombre() + " " + resultadoFinal2);
					if (resultadoFinal1 > resultadoFinal2) {
						JOptionPane.showMessageDialog(null, "El Ganador es " + equipo1.getNombre());
						return equipo1;
					} else {
						JOptionPane.showMessageDialog(null, "El Ganador es " + equipo2.getNombre());
						return equipo2;
					}
				}

			}
		}

	}
}

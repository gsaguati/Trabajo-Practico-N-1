package trabajopractico;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		GestorEquipos gestorEquipos = new GestorEquipos();
		Equipo padua = new Equipo("Padua", "Merlo");
		Equipo lujan = new Equipo("Lujan", "Lujan");
		Equipo monte = new Equipo("Monte Grande", "Monte Grande");
		gestorEquipos.getEquipos().add(padua);
		gestorEquipos.getEquipos().add(lujan);
		gestorEquipos.getEquipos().add(monte);
		Equipo.JCasa(padua);
		Equipo.JLujan(lujan);
		Equipo.JMonte(monte);

		String[] opciones = { "Opciones", "Opciones de Equipo", "Jugar partido", "Equipos", "Salir" };
		int opcion;

		do {
			opcion = JOptionPane.showOptionDialog(null, "Elija una opción", "Gestión de Equipos de Rugby",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

			switch (opcion) {
			case 0:
				String[] opcionesDeEquipo = { "Agregar Equipos", "Eliminar Equipo", "Buscar Equipo", "Volver" };
				int opcionEquipo = 0;
				do {
					opcionEquipo = JOptionPane.showOptionDialog(null, "Elija que acción se va a realizar", null, opcion,
							opcionEquipo, null, opcionesDeEquipo, opcionesDeEquipo[0]);
					switch (opcionEquipo) {
					case 0:
						gestorEquipos.agregarEquipo();
						break;
					case 1:
						gestorEquipos.eliminarEquipo();
						break;
					case 2:
						gestorEquipos.buscarEquipo();
						break;
					case 3:
						break;
					}
				} while (opcionEquipo != 3);

				break;

			case 1:
				String[] verEquipos = { "Agregar Jugador", "Eliminar Jugador", "Buscar Jugador", "Ver Jugadores",
						"Volver" };
				int opc = 0;
				do {
					opc = JOptionPane.showOptionDialog(null, "Elija que acción se va a realizar", null, opcion, opc,
							null, verEquipos, verEquipos[0]);
					switch (opc) {
					case 0:
						gestorEquipos.agregarJugadorAEquipo();
						break;
					case 1:

						gestorEquipos.eliminarJugadorDeEquipo();
						break;
					case 2:
						gestorEquipos.buscarJugadorEnEquipo();
						break;
					case 3:
						int equipoElegido = gestorEquipos.elegirEquipo(gestorEquipos.getEquipos());
						JOptionPane.showMessageDialog(null,
								"Usted seleccionó al equipo:" + gestorEquipos.getEquipos().get(equipoElegido));
						break;
					case 4:
						break;
					}
				} while (opc != 4);
				break;
			case 2:
				gestorEquipos.JugarPartido(
						gestorEquipos.getEquipos().get(gestorEquipos.elegirEquipo(gestorEquipos.getEquipos())),
						gestorEquipos.getEquipos().get(gestorEquipos.elegirEquipo(gestorEquipos.getEquipos())));
				break;
			case 3:
				int equipoElegido3 = gestorEquipos.elegirEquipo(gestorEquipos.getEquipos());
				JOptionPane.showMessageDialog(null,
						"Seleccionó al equipo:" + gestorEquipos.getEquipos().get(equipoElegido3));
				break;
			case 4:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida");
				break;
			}

		} while (opcion != 4);
	}

}
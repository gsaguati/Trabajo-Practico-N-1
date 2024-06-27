package trabajopractico;
import javax.swing.JOptionPane;
import java.util.LinkedList;

public class Partidos {
    private Equipo equipo1;
    private Equipo equipo2;
    private int puntos1;
    private int puntos2;
    private String fase;
    private LinkedList<Equipo> equipos;

    public Partidos(LinkedList<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void iniciarTorneo() {
        if (equipos.size() < 8) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 8 equipos para iniciar el torneo.");
            return;
        }
        LinkedList<Equipo> cuartos = jugarFase("los cuartos de final", equipos);
        LinkedList<Equipo> semifinales = jugarFase("las semifinales", cuartos);
        LinkedList<Equipo> finalistas = jugarFase("la final", semifinales);
        Equipo campeon = jugarFase("Campeón", finalistas).get(0);
        JOptionPane.showMessageDialog(null, "El equipo campeón es: " + campeon.getNombre());
    }

    private LinkedList<Equipo> jugarFase(String fase, LinkedList<Equipo> equipos) {
        LinkedList<Equipo> ganadores = new LinkedList<>();
         if (fase.equals("Campeón") && equipos.size() == 1) {
            ganadores.add(equipos.get(0));
            return ganadores;
        }
        JOptionPane.showMessageDialog(null, "Comienza la fase de " + fase);
       
        for (int i = 0; i < equipos.size(); i += 2) {
            Equipo equipo1 = equipos.get(i);
            Equipo equipo2 = equipos.get(i + 1);
            Equipo ganador = jugarPartido(equipo1, equipo2, fase);
            if (ganador != null) {
                ganadores.add(ganador);
            }
        }
        return ganadores;
    }

    public Equipo jugarPartido(Equipo equipo1, Equipo equipo2, String fase) {
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
            	  this.equipo1 = equipo1;
                  this.equipo2 = equipo2;
                  this.fase = fase;
                  JOptionPane.showMessageDialog(null, "Se enfrentan " + equipo1.getNombre() + " vs " + equipo2.getNombre() + " en " + fase);  

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

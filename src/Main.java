import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


        //examen1

        Turnos newTurno = null;

        int seleccion = 0;
        do {
            String[] opciones = {"Registrar turno", "evaluar salud", "Leer informe", "Salir"};
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:

                    String nombreAnimal = JOptionPane.showInputDialog("Nombre de Animal?");
                    String newCliente = JOptionPane.showInputDialog("Client?");
                    String rasa = JOptionPane.showInputDialog("Rasa?");

                    String diaStr;
                    do {
                        diaStr = JOptionPane.showInputDialog(null, "Dia de turno? ");
                        if (diaStr == null) diaStr = "";
                    } while (!Turnos.isDia(diaStr));

                    String mesStr;
                    do {
                        mesStr = JOptionPane.showInputDialog(null, "Mes de turno? ");
                        if (mesStr == null) mesStr = "";
                    } while (!Turnos.isMes(mesStr));

                    String anoStr;
                    do {
                        anoStr = JOptionPane.showInputDialog(null, "Ano de turno? ");
                        if (anoStr == null) anoStr = "";
                    } while (!Turnos.isAno(anoStr));

                    newTurno = new Turnos(nombreAnimal, rasa, newCliente, Integer.parseInt(diaStr), Integer.parseInt(mesStr), Integer.parseInt(anoStr));

                    break;
                case 1:
                    if (newTurno != null) {
                        newTurno.evaluarAspectosSalud();
                    } else
                        JOptionPane.showMessageDialog(null, "No hay turnos, de primero pulsa <Registrar turno>");
                    break;
                case 2:
                    if (newTurno != null) {
                        JOptionPane.showMessageDialog(null, newTurno.getInforme());
                    } else
                        JOptionPane.showMessageDialog(null, "No hay turnos, de primero pulsa <Registrar turno>");
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        } while (seleccion != 3);


    }
}
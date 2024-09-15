import javax.swing.*;
import java.time.LocalDate;

public class Turnos {
    private final String[] aspectosSalud = {"Emocional", "Temperatura", "Dental"};
    private static String informe = "";

    private String nombreAnimal;
    private String rasa;
    private String cliente;
    private LocalDate fecha;
    private int dia;
    private int mes;
    private int anio;

    private int[] evaluacionAspectosSalud; // 1 al 10

    public Turnos(String nombreAnimal, String rasa, String cliente, int dia, int mes, int anio) {
        this.nombreAnimal = nombreAnimal;
        this.rasa = rasa;
        this.cliente = cliente;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public void evaluarAspectosSalud() {
        evaluacionAspectosSalud = new int[aspectosSalud.length];
        for (int i = 0; i < aspectosSalud.length; i++) {
            String califStr;
            do {
                califStr = JOptionPane.showInputDialog(null, "calfica de 1 a 10 la aspecto " + aspectosSalud[i]);
                if (califStr == null) califStr = "";
            } while (!isNumeroDe_1_10(califStr));
            evaluacionAspectosSalud[i] = Integer.parseInt(califStr);
        }

        agregarInfoEnInforme();
    }

    private void agregarInfoEnInforme() {

        String info = "\n Nombre de Animal: " + nombreAnimal +
                "\n Rasa: " + rasa +
                "\n Cliente: " + cliente +
                "\n Fecha: " + dia + "." + mes + "." + anio + "\n";

        String calificasionesDeEtapas = "";
        for (int i = 0; i < evaluacionAspectosSalud.length; i++) {
            calificasionesDeEtapas += " Aspecto " + aspectosSalud[i] + ": " + evaluacionAspectosSalud[i] + ", ";
        }

        informe += info + "\n " + calificasionesDeEtapas + "\n ";

    }

    public String getInforme() {
        return informe;
    }

    public static boolean isNumeroDe_1_10(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 10) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAno(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 10000) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMes(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 12) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDia(String str) {
        if (str.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') return false;
            }
            int mes = Integer.parseInt(str);
            if (mes < 1 || mes > 31) {
                return false;
            }
        }
        return true;
    }

}

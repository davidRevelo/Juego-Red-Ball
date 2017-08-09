package Clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilidades {

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static Date stringToDate(String fecha) {

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
        Date aux = null;
        try {
            aux = formatoDelTexto.parse(fecha);
        } catch (ParseException ex) {
        }
        return aux;
    }

    public static String formateDate(Date fecha) {
        if (fecha == null) {
            fecha = new Date();
        }
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy/MM/dd");
        return formatoDelTexto.format(fecha);
    }

    public static int objectToInt(Object Obj) {
        int NumInt = Integer.parseInt(objectToString(Obj));
        return NumInt;
    }

    public static double objectToDouble(Object Obj) {
        String Str = Obj.toString();
        double NumDouble = Double.parseDouble(Str);
        return NumDouble;
    }

    public static boolean objectToBoolean(Object Obj) {
        String CadBooleana = objectToString(Obj);
        Boolean booleano = Boolean.valueOf(CadBooleana);
        return booleano;
    }

    public static String objectToString(Object Obj) {
        String Str = "";
        if (Obj != null) {
            Str = Obj.toString();
        }
        return Str;
    }

    public static Date objectToDate(Object Obj) {
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        Date aux = null;
        try {
            aux = formatoDelTexto.parse(objectToString(Obj));
        } catch (ParseException ex) {
            System.out.println("Epa epa error al convertir");
        }
        return aux;
    }
    
}

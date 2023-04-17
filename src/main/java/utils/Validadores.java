/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ildex
 */
public class Validadores {

    public boolean validaRfc(String s) {
        CharSequence cadena = s;
        String recadena = "^(?!^.{13}$)(^[A-Z]{4})(^[0-9]{6})(^([A-Z]|[0-9]){3}$)$";
        Pattern pattern = Pattern.compile(recadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaNumSerie(String s) {
        CharSequence cadena = s;
        String recadena = "^[A-Z]{3}-\\\\d{3}$";
        Pattern pattern = Pattern.compile(recadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaCaracteristicasVehiculo(String s) {
        CharSequence cadena = s;
        String recadena = "^[a-zA-Z]{100}$";
        Pattern pattern = Pattern.compile(recadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaModelo(String s) {
        CharSequence cadena = s;
        String recadena = "^[0-9]{1,10}$";
        Pattern pattern = Pattern.compile(recadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }

    public boolean validaPlaca(String s) {
        CharSequence cadena = s;
        String recadena = "^[A-Za-z]{3}-\\\\d{3}$";
        Pattern pattern = Pattern.compile(recadena);
        Matcher matcher = pattern.matcher(cadena);
        return matcher.matches();
    }
}

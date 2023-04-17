
package com.itson.dominio;
import org.jasypt.util.text.BasicTextEncryptor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 * Esta clase nos ayuda a encriptar y desencriptar los nombres de las personas
 * @author aracelyC
 */

@Converter(autoApply = false)
public class Encriptacion implements AttributeConverter<String, String> {
    /**
     * Clave para la encriptar y desencriptar datos
     */
    private static final String CLAVE = "itsonnainariagen";
    private static final BasicTextEncryptor ENCRIPTAR_NOMBRE = new BasicTextEncryptor();
    /**
     * Establece la clave 
     */
    static {
        ENCRIPTAR_NOMBRE.setPassword(CLAVE);
    }
    /**
     * Metodo que convierte el atributo encriptada 
     * @param atributo a ser encriptado
     * @return la cadena encriptada 
     */
    @Override
    public String convertToDatabaseColumn(String atributo) {
        return ENCRIPTAR_NOMBRE.encrypt(atributo);
    }
    /**
     * Metodo que convierte la cadena en su forma original desencriptada y devuelve
     * el resultado
     * @param dato la cadena que esta encriptada y pasa a ser desencriptada
     * @return la cadena de desencriptada
     */
    @Override
    public String convertToEntityAttribute(String dato) {
        return ENCRIPTAR_NOMBRE.decrypt(dato);
    }
}

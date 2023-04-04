
package com.itson.proyectobda;
import org.jasypt.util.text.BasicTextEncryptor;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
/**
 *
 * @author aracelyC
 */


@Converter(autoApply = true)
public class Encriptacion implements AttributeConverter<String, String> {

    private static final String CLAVE = "itson";
    private static final BasicTextEncryptor ENCRIPTAR_NOMBRE = new BasicTextEncryptor();

    static {
        ENCRIPTAR_NOMBRE.setPassword(CLAVE);
    }

    @Override
    public String convertToDatabaseColumn(String atributo) {
        return ENCRIPTAR_NOMBRE.encrypt(atributo);
    }

    @Override
    public String convertToEntityAttribute(String dato) {
        return ENCRIPTAR_NOMBRE.decrypt(dato);
    }
}

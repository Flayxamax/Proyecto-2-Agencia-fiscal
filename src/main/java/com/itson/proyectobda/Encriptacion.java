
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

    private static final String SECRET_KEY = "itson";
    private static final BasicTextEncryptor TEXT_ENCRYPTOR = new BasicTextEncryptor();

    static {
        TEXT_ENCRYPTOR.setPassword(SECRET_KEY);
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return TEXT_ENCRYPTOR.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return TEXT_ENCRYPTOR.decrypt(dbData);
    }
}

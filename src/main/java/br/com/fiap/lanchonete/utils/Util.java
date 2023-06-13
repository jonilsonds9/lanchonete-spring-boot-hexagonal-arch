package br.com.fiap.lanchonete.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

public class Util {
	
    public static String dataToString(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return getConversionService().convert(data, String.class);
    }
    
    public static LocalDate stringToData(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataString) {
        return LocalDate.parse(dataString);
    }
    
    public static FormattingConversionService getConversionService() {
        FormattingConversionService conversionService = new DefaultFormattingConversionService();
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setDateFormatter(DateTimeFormatter.ISO_LOCAL_DATE);
        registrar.registerFormatters(conversionService);
        return conversionService;
    }
}

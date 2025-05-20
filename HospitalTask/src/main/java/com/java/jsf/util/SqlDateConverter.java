package com.java.jsf.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SqlDateConverter implements Converter {

    private static final String PATTERN = "yyyy-MM-dd";

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.trim().isEmpty()) return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
            sdf.setLenient(false);
            java.util.Date utilDate = sdf.parse(value);
            return new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            throw new ConverterException("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) return "";
        if (value instanceof java.sql.Date) {
            return new SimpleDateFormat(PATTERN).format((java.sql.Date) value);
        }
        return value.toString(); // fallback
    }
}


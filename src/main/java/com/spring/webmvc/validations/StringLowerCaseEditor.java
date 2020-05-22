package com.spring.webmvc.validations;

import java.beans.PropertyEditorSupport;

public class StringLowerCaseEditor extends PropertyEditorSupport
{
    @Override
    public String getAsText()
    {
        return getValue() != null ? getValue().toString() : "";
    }

    @Override
    public void setAsText( String text ) throws IllegalArgumentException
    {
        setValue( text.toLowerCase() );
    }
}

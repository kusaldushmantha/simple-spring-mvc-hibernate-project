package com.spring.webmvc.aspect;

import com.spring.webmvc.validations.StringLowerCaseEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class AllControllerAdvice
{
//    @InitBinder
//    public void initBinder( WebDataBinder dataBinder )
//    {
//        StringLowerCaseEditor lowerCaseEditor = new StringLowerCaseEditor();
//        dataBinder.registerCustomEditor( String.class, lowerCaseEditor );
//    }
}

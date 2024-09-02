package com.jwebmp.core.databind;

import java.lang.annotation.Annotation;

public interface IConfiguration
{
    Object value();

    Class<? extends Annotation> annotationType();
}

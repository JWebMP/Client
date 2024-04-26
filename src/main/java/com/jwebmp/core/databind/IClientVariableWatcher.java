package com.jwebmp.core.databind;

import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;


/**
 * SPI for handling variable watchers. The returned string must be JavaScript that will watch the given variable
 */
@FunctionalInterface
public interface IClientVariableWatcher
{
    /**
     * SPI for handling variable watchers. The returned string must be JavaScript that will watch the given variable
     *
     * @param watchName    The variable watch name
     * @param variableName The variable name
     * @param eventClass   The event class
     * @return The java script to render
     */
    String onClientVariableRequest( String watchName,  String variableName,  Class<? extends IEvent<?, ?>> eventClass);
}

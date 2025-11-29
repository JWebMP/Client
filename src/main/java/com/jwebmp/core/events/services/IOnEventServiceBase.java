package com.jwebmp.core.events.services;

import com.guicedee.client.services.IDefaultService;
import com.jwebmp.core.htmlbuilder.javascript.events.interfaces.IEvent;

public interface IOnEventServiceBase<J extends IOnEventServiceBase<J>>
        extends IDefaultService<J>
{
    /**
     * Occurs when the event is called
     */
    void onCreate(IEvent<?, ?> e);

    /**
     * Occurs when the event is called
     */
    void onCall(IEvent<?, ?> e);
}

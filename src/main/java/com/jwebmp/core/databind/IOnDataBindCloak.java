package com.jwebmp.core.databind;

import com.guicedee.client.services.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentDataBindingBase;


/**
 * SPI to do something when on bind is called
 */
@FunctionalInterface
public interface IOnDataBindCloak extends IDefaultService<IOnDataBindCloak>
{
    /**
     * SPI to do something when on bind is called
     *
     * @param component The component to bind
     */
    void onCloak( IComponentDataBindingBase<?> component);
}

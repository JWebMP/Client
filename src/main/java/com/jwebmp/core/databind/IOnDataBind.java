package com.jwebmp.core.databind;

import com.guicedee.client.services.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentDataBindingBase;


/**
 * SPI to do something when on bind is called
 */
public interface IOnDataBind<J extends IOnDataBind<J>>
        extends IDefaultService<J>
{
    /**
     * SPI to do something when on bind is called
     *
     * @param component    The component to bind
     * @param bindingValue The binding value to adhere to
     */
    void onBind( IComponentDataBindingBase<?> component, String bindingValue);
}

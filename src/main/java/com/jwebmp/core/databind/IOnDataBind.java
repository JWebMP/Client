package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentDataBindingBase;
import jakarta.validation.constraints.NotNull;

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
    void onBind(@NotNull IComponentDataBindingBase<?> component, String bindingValue);
}

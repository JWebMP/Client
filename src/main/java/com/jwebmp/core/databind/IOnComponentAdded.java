package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface IOnComponentAdded<J extends IOnComponentAdded<J>> extends IDefaultService<J>
{
    /**
     * intercepts the html render and provides a return value on whether children should be rendered
     *
     * @param component
     * @return
     */
    void onComponentAdded(IComponentHierarchyBase<GlobalChildren, ?> parent, IComponentHierarchyBase<GlobalChildren, ?> component);
}

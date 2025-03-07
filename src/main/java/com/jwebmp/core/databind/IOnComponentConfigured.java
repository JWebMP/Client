package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.html.interfaces.GlobalChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface IOnComponentConfigured<J extends IOnComponentConfigured<J>> extends IDefaultService<J>
{
    /**
     * intercepts the html render and provides a return value on whether children should be rendered
     *
     * @param component The component being added
     */
    void onComponentConfigured(IComponentHierarchyBase<GlobalChildren, ?> parent, IComponentHierarchyBase<GlobalChildren, ?> component);
}

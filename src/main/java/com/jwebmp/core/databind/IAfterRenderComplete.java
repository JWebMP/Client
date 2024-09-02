package com.jwebmp.core.databind;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface IAfterRenderComplete<J extends IAfterRenderComplete<J>> extends IDefaultService<J>
{
    void process(IComponentHierarchyBase<?, ?> componentHierarchyBase);
}

package com.jwebmp.core.databind;

import com.guicedee.client.services.IDefaultService;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface IAfterRenderComplete<J extends IAfterRenderComplete<J>> extends IDefaultService<J>
{
    void process(IComponentHierarchyBase<?, ?> componentHierarchyBase);
}

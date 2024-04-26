package com.jwebmp.interception.services;

import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

public interface ScriptProvider
{
    IComponentHierarchyBase<?, ?> produceScript();
}

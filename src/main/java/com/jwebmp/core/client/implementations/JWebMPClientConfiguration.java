package com.jwebmp.core.client.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceConfig;
import com.guicedee.guicedinjection.interfaces.IGuiceConfigurator;

public class JWebMPClientConfiguration implements IGuiceConfigurator
{
    @Override
    public IGuiceConfig<?> configure(IGuiceConfig<?> config)
    {
        config = config.setClasspathScanning(true)
                .setAllowPaths(true)
                .setFieldInfo(true)
                .setMethodInfo(true)
                .setAnnotationScanning(true)
                .setIgnoreClassVisibility(true)
                .setIgnoreFieldVisibility(true)
                .setIgnoreMethodVisibility(true);
        return config;
    }
}

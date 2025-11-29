package com.jwebmp.core.client.implementations;

import com.guicedee.client.services.IGuiceConfig;
import com.guicedee.client.services.lifecycle.IGuiceConfigurator;

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

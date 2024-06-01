package com.jwebmp.core.client.implementations;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;

import com.guicedee.guicedservlets.servlets.services.scopes.CallScope;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;
import com.jwebmp.interception.services.JWebMPInterceptionBinder;
import com.jwebmp.interception.services.SiteCallIntercepter;
import net.sf.uadetector.UserAgentStringParser;
import net.sf.uadetector.service.UADetectorServiceFactory;

import java.util.ServiceLoader;

@SuppressWarnings("unchecked")
public class JWebMPClientBinder extends AbstractModule implements IGuiceModule<JWebMPClientBinder>
{
    private static final UserAgentStringParser userAgentParser = UADetectorServiceFactory.getResourceModuleParser();

    @Override
    protected void configure()
    {
        bind(UserAgentStringParser.class)
                .toInstance(userAgentParser);


        bind(AjaxResponse.class)
                .in(CallScope.class);

        bind(AjaxCall.class)
                .in(CallScope.class);

        bind(JWebMPInterceptionBinder.AjaxCallInterceptorKey)
                .toProvider(() -> IGuiceContext
                        .instance()
                        .getLoader(AjaxCallIntercepter.class, ServiceLoader.load(AjaxCallIntercepter.class)))
                .in(Singleton.class);

        bind(JWebMPInterceptionBinder.DataCallInterceptorKey)
                .toProvider(() -> IGuiceContext.instance()
                                               .getLoader(DataCallIntercepter.class, ServiceLoader.load(DataCallIntercepter.class)))
                .in(Singleton.class);

        bind(JWebMPInterceptionBinder.SiteCallInterceptorKey)
                .toProvider(() -> IGuiceContext.instance()
                                               .getLoader(SiteCallIntercepter.class, ServiceLoader.load(SiteCallIntercepter.class)))
                .in(Singleton.class);

    }
}

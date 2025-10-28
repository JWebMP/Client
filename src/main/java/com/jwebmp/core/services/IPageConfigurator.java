package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.guicedee.guicedinjection.interfaces.IServiceEnablement;


/**
 * A service for configuration built pages
 */
public interface IPageConfigurator<J extends IPageConfigurator<J>>
        extends IDefaultService<J>, IServiceEnablement<J>
{
    /**
     * Configures the given page for the parameters
     *
     * @param page The page incoming
     * @return The original page incoming or a new page, never null
     */

    IPage<?> configure(IPage<?> page);

    /**
     * Allows to configure the page used in angular compilations (Angular plugin down reference sigh)
     *
     * @param page The page currently
     * @return An updated page or a new page
     */
    default IPage<?> configureAngular(IPage<?> page)
    {
        return page;
    }
}

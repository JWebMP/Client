package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.*;
import jakarta.validation.constraints.*;

/**
 * A service for configuration built pages
 */
public interface IPageConfigurator<J extends IPageConfigurator<J>>
		extends IDefaultService<J>, IServiceEnablement<J>
{
	/**
	 * Configures the given page for the parameters
	 *
	 * @param page
	 * 		The page incoming
	 *
	 * @return The original page incoming or a new page, never null
	 */
	@NotNull
	IPage<?> configure(IPage<?> page);
}

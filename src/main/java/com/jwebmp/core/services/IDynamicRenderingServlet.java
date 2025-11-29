package com.jwebmp.core.services;

import com.guicedee.client.services.IDefaultService;
import com.guicedee.client.services.IServiceEnablement;
import com.jwebmp.core.base.interfaces.*;

/**
 * Renders a script that can be done dynamically through a servlet or placed directly into the page at a location (sort order)
 */
public interface IDynamicRenderingServlet<J extends IDynamicRenderingServlet<J>>
		extends IDefaultService<J>, IServiceEnablement<J>
{
	/**
	 * Returns the script location
	 *
	 * @return The script
	 */
	String getScriptLocation(IPage<?> page);

	/**
	 * Render the script that can be dynamically built
	 *
	 * @return The string builder for the script
	 */
	IComponentHierarchyBase<?,?> renderScript(IPage<?> page);

	/**
	 * Method newScript ...
	 *
	 * @param contents
	 * 		of type String
	 *
	 * @return Script
	 */
	IComponentHierarchyBase<?, ?> newScript(String contents);
}

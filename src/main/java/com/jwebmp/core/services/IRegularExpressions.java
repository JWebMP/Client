package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.*;

import java.util.*;
import java.util.regex.*;

/**
 * Marks default regular expressions to add to the DTO, used with a Service Locator
 */
@FunctionalInterface
public interface IRegularExpressions<J extends IRegularExpressions<J>>
		extends IDefaultService<J>
{
	/**
	 * Returns a map of patterns to add
	 *
	 * @return
	 */
	Map<String, Pattern> addPatterns();
}

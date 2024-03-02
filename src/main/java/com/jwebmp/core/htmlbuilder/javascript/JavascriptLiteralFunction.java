/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.core.htmlbuilder.javascript;

import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.base.servlets.interfaces.*;

import java.util.*;

/**
 * This Class renders a base function with sections denoted for dynamic building
 *
 * @author GedMarc
 * @since 30 Dec 2015
 */
public abstract class JavascriptLiteralFunction<J extends JavascriptLiteralFunction<J>> extends JavascriptFunction<J>
{
	/**
	 * The closing string '}'
	 */
	private final StringBuilder literalFunctionEndingString = new StringBuilder("}");
	/**
	 * The first rendered starting string
	 */
	private StringBuilder literalFunctionStartingString;
	/**
	 * Any arguments to be passed into the function
	 */
	private List<String> functionArugments;
	
	/**
	 * An actual function
	 */
	public JavascriptLiteralFunction()
	{
	
	}
	
	/**
	 * Adds the component, and all of its children's JavaScript into this function
	 *
	 * @param c The root component to start at
	 */
	public void addComponentsJavascript(IComponentHierarchyBase<?, ?> c)
	{
		addComponentsJavascript(c, true);
	}
	
	/**
	 * Adds the component, and all of its children's JavaScript into this function
	 *
	 * @param c               The root component to start at
	 * @param includeChildren Whether or not to include children
	 */
	@SuppressWarnings("unused")
	public void addComponentsJavascript(IComponentHierarchyBase<?, ?> c, boolean includeChildren)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(c.renderJavascriptAll());
		getLiteralFunction().append(sb);
	}
	
	/**
	 * The actual string to include in the function
	 *
	 * @return
	 */
	public abstract StringBuilder getLiteralFunction();
	
	/**
	 * Sets the function's ending string
	 *
	 * @return
	 */
	public StringBuilder getLiteralFunctionStartingString()
	{
		return literalFunctionStartingString;
	}
	
	/**
	 * Sets the function starting string
	 *
	 * @param literalFunctionStartingString
	 */
	public void setLiteralFunctionStartingString(StringBuilder literalFunctionStartingString)
	{
		this.literalFunctionStartingString = literalFunctionStartingString;
	}
	
	/**
	 * Gets any functional argument that may be required
	 *
	 * @return
	 */
	public final List<String> getFunctionArugments()
	{
		if (functionArugments == null)
		{
			functionArugments = new ArrayList<>();
		}
		return functionArugments;
	}
	
	/**
	 * Sets any functional arguments required
	 *
	 * @param functionArugments
	 */
	public final void setFunctionArugments(List<String> functionArugments)
	{
		this.functionArugments = functionArugments;
	}
	
	/**
	 * Returns this functions output string
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return renderFunction();
	}
	
	/**
	 * Renders this function (calls to string)
	 *
	 * @return
	 */
	@Override
	public String renderFunction()
	{
		StringBuilder returnable = new StringBuilder();
		literalFunctionStartingString = new StringBuilder("function (" + functionArugments
				                                                                 .toString()
				                                                                 .replace("[", "")
				                                                                 .replace("]", "") + ") {");
		returnable.append(literalFunctionStartingString);
		returnable.append(getLiteralFunction());
		returnable.append(literalFunctionEndingString);
		return returnable.toString();
	}
	
}

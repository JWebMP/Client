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

import com.fasterxml.jackson.annotation.*;

/**
 * This Class renders the given function as the result for a given json property
 *
 * @author GedMarc
 * @since 14 Dec 2015
 */
public abstract class JavascriptFunction<J extends JavascriptFunction<J>>
		extends JavaScriptPart<J>
{


	/**
	 * Constructs a new function
	 */
	public JavascriptFunction()
	{
		//Nothing needed
	}

	/**
	 * Renders the to function method as the JSON Value
	 *
	 * @return
	 */
	@JsonValue
	@JsonRawValue
	@Override
	public String toString()
	{
		return renderFunction();
	}

	/**
	 * Render the full function including function(){};
	 *
	 * @return
	 */
	public abstract String renderFunction();
}

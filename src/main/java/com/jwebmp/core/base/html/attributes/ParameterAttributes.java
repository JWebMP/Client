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
package com.jwebmp.core.base.html.attributes;

import com.jwebmp.core.base.html.interfaces.*;

/**
 * Defines the attributes for a parameter
 *
 * @author GedMarc
 * @version 1.0
 * @since Mar 1, 2015
 */
public enum ParameterAttributes
		implements AttributeDefinitions
{

	/**
	 * Specifies the name of a parameter
	 */
	Name,
	/**
	 * Not supported in HTML5. Specifies the media type of the parameter
	 *
	 * @deprecated
	 */
	@Deprecated
	Type,
	/**
	 * Specifies the value of the parameter
	 */
	Value,
	/**
	 * Not supported in HTML5
	 * <p>
	 * Specifies the type of the value
	 * data
	 * ref
	 * object
	 *
	 * @deprecated
	 */
	@Deprecated
	ValueType;

	@Override
	public boolean isKeyword()
	{
		return false;
	}
	
	@Override
	public String toString()
	{
		return name().toLowerCase();
	}
}

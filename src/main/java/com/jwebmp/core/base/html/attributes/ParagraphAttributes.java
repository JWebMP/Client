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
 * Defines all the attributes for a paragraph
 *
 * @author GedMarc
 * @version 1.0
 * @since Mar 1, 2015
 */
public enum ParagraphAttributes
		implements AttributeDefinitions
{

	/**
	 * Specifies the alignment of the text within a paragraph
	 * <p>
	 * left
	 * right
	 * center
	 * justify
	 *
	 * @deprecated Not supported in HTML 5
	 */
	@Deprecated
	Align;

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

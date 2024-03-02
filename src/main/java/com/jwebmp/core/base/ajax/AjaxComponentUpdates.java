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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.base.interfaces.*;
import com.jwebmp.core.htmlbuilder.javascript.*;
import jakarta.validation.constraints.*;

/**
 * A JSON Class for component updates
 */
public class AjaxComponentUpdates<J extends AjaxComponentUpdates<J>>
		extends JavaScriptPart<J>
{
	/**
	 * The stored HTML
	 */
	@JsonProperty("html")
	private String html;
	/**
	 * An assigned ID for a component action
	 */
	@JsonProperty("id")
	private String id;
	/**
	 * The type for an action, defaulted to Replace
	 */
	@JsonProperty("insertType")
	private AjaxComponentInsertType insertType;

	/**
	 * Constructs an update class from a given component
	 *
	 * @param component
	 */
	public AjaxComponentUpdates(IComponentHierarchyBase<?,?> component)
	{
		component.setTiny(true);
		html = component.toString(true);
		id = component.asBase().getID();
		insertType = AjaxComponentInsertType.Replace;
	}

	/**
	 * Returns the HTML of the component
	 *
	 * @return
	 */
	public String getHtml()
	{
		return html;
	}

	/**
	 * Sets the HTML
	 *
	 * @param html
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setHtml(String html)
	{
		this.html = html;
		return (J) this;
	}

	/**
	 * Returns which component ID is getting replaced
	 *
	 * @return
	 */
	public String getId()
	{
		return id;
	}

	/**
	 * Sets the ID being used for the insert type
	 *
	 * @param id
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setId(String id)
	{
		this.id = id;
		return (J) this;
	}

	/**
	 * Sets the type of insert that should occur on component ID
	 *
	 * @return
	 */
	public AjaxComponentInsertType getInsertType()
	{
		return insertType;
	}

	/**
	 * Sets the type of insert that should occur on component ID
	 *
	 * @param insertType
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setInsertType(AjaxComponentInsertType insertType)
	{
		this.insertType = insertType;
		return (J) this;
	}

}

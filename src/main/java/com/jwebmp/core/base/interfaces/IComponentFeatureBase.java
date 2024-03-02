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
package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.references.*;
import com.jwebmp.core.base.servlets.enumarations.*;
import com.jwebmp.core.htmlbuilder.javascript.*;
import jakarta.validation.constraints.*;

import java.util.*;

/**
 * @param <F>
 * @param <J>
 * @author GedMarc
 * @since 2016/09/26
 */
public interface IComponentFeatureBase<F extends GlobalFeatures, J extends IComponentFeatureBase<F,J>>
		extends LifeCycle,GlobalFeatures
{
	/**
	 * Adds a feature to the collection
	 *
	 * @param feature
	 * @return
	 */
	J addFeature(IComponentFeatureBase<?, ?> feature);
	
	/**
	 * Adds a variable to the collection
	 *
	 * @param variable
	 */
	J addVariable(String variable);
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<CSSReference> getCssReferencesAll();
	
	/**
	 * Adds in the JavaScript References for the Features
	 *
	 * @return
	 */
	Set<JavascriptReference> getJavascriptReferencesAll();
	
	/**
	 * Returns the name of this feature
	 *
	 * @return the name of this feature
	 */
	String getName();
	
	/**
	 * Returns any client side options available with this component
	 *
	 * @return
	 */
	JavaScriptPart<?> getOptions();
	
	/**
	 * Gets the render priority of this feature
	 *
	 * @return
	 */
	RequirementsPriority getPriority();
	
	/**
	 * Returns all Queries Associated with a component
	 *
	 * @return
	 */
	Set<StringBuilder> getQueriesAll();
	
	/**
	 * Sets the sort order for this feature. Default 10000
	 *
	 * @return
	 */
	Integer getSortOrder();
	
	/**
	 * Returns the list of variables
	 *
	 * @return
	 */
	Set<String> getVariables();
	
	/**
	 * Sets if this feature must be rendered in an $(document).ready statement
	 *
	 * @return If this feature has executed the assignFunctionToComponents method
	 */
	boolean isRenderAfterLoad();
	
	/**
	 * Removes a feature from the components collection
	 * <p>
	 *
	 * @param feature The feature to be removed
	 *                <p>
	 * @return True or false on whether it could be removed, e.g. if it ever
	 * existed.
	 */
	J removeFeature(F feature);
	
	/**
	 * Removes a variable from the collection
	 *
	 * @param variable
	 */
	J removeVariable(String variable);
	
	/**
	 * Renders the JavaScript for this Builder
	 *
	 * @return A string builder containing the raw JavaScript to send
	 */
	StringBuilder renderJavascript();
	
	/**
	 * Specifies whether or not this feature actually contains some JavaScript lines or is just a link
	 *
	 * @return True if a script is located inside the feature
	 */
	boolean scriptAvailable();
	
	/**
	 * Returns a list of all the features associated with this component
	 * <p>
	 *
	 * @return An ArrayList of features
	 */
	@NotNull
	Set<F> getFeatures();
	
	/**
	 * Checks if this feature has been configured and rendered with all the features
	 */
	void checkAssignedFunctions();
	
	/**
	 * Sets the associated component
	 *
	 * @param component
	 * @return This object
	 */
	J setComponent(IComponentHierarchyBase<?, ?> component);
	
	/**
	 * Gets the component
	 *
	 * @return A typed component
	 */
	IComponentHierarchyBase<?, ?> getComponent();
	
}

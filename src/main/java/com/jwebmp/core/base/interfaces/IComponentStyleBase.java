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

import com.jwebmp.core.htmlbuilder.css.enumarations.CSSTypes;

import java.util.Map;

@SuppressWarnings("unused")
/**
 * A slim view of a component featuring the styling methods
 *
 * @param <J>
 * 		Returns this class
 *
 * @author GedMarc
 * @since Sep 26, 2016
 */
public interface IComponentStyleBase<J extends IComponentStyleBase<J>>
        extends CastableComponent<J> {

    /**
     * Adds a CSS object to the component with the given type
     *
     * @param type    The CSS Type
     * @param cssItem Thee CSS Item to add
     * @return Always this object
     */
    J addCSSEntry(CSSTypes type, ICSSImpl cssItem);

    /**
     * Removes a CSS item for the component
     *
     * @param cssType The CSS Type Entry to remove
     * @return Always this object
     */
    J removeCSSEntry(CSSTypes cssType);

    /**
     * Gets the CSS Object used for styling
     *
     * @return The CSS Implementation Object for default (CSSTypes.None)
     */
    ICSSImpl getCss();

    /**
     * Sets the CSS Object used for styling
     *
     * @param css The CSS Implementation object to add
     * @return Always this object
     */
    J setCss(ICSSImpl css);

    /**
     * Returns the currently assigned CSS Name
     *
     * @return The currently assigned css Name for this objects style
     */
    String getCssName();

    /**
     * Sets the currently assigned CSS Name
     *
     * @param cssName Sets the CSS Name to a valid value
     * @return Always this object
     */
    J setCssName(String cssName);

    /**
     * Returns the current HashMap of all CSS Entries for the component
     *
     * @return The CSS Types and Implementations for each type for this object
     */
    Map<CSSTypes, ICSSImpl> getCssTypeHashMap();

    /**
     * Renders the component CSS at the specified tab count with the &lt;style&gt; tag
     * <p>
     *
     * @param tabCount Tab indentation for the SQL
     * @return The Component CSS
     */
    StringBuilder renderCss(int tabCount);

    /**
     * Renders the component CSS at the specified tab count with the &lt;style&gt; tag This includes everything from this classes CSS, to
     * the CSS for each field. It will also populate the lower level
     * child CSS for fields in this class
     * <p>
     *
     * @param tabCount           Tab indentation for the SQL
     * @param renderOpening      Whether or not to render the opening XML tag for a CSS style
     * @param renderInQuotations Sets whether to render the CSS Fields in Quotations
     * @param isAjaxCall         Sets whether the CSS is being called from an AJAX call
     *                           <p>
     * @return The Component CSS
     */
    
    StringBuilder renderCss(int tabCount, boolean renderOpening, boolean renderInQuotations, boolean isAjaxCall);
}

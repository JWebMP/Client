package com.jwebmp.core.htmlbuilder.css.themes;

import com.jwebmp.core.base.references.*;

import java.util.*;

/**
 * Provides the base required to enable Theming
 *
 * @author GedMarc
 * @version 1.0
 * @since 2012/10/01
 */
public interface ITheme
{

	/**
	 * The Actual Class Name for the Theme
	 *
	 * @return
	 */
	String getClassName();

	/**
	 * A list of CSS files associated with the theme
	 *
	 * @return ArrayList of String
	 */
	List<CSSReference> getCssReferences();

	/**
	 * Returns a list of all the JavaScript references
	 *
	 * @return An array list of JavaScript references
	 */
	List<JavascriptReference> getJavascriptReferences();

	/**
	 * Returns the URL of the size 30 icon
	 *
	 * @return The Size 30 Icon URL
	 */
	String getSize30Icon();

	/**
	 * Returns the URL of the size 630 icon
	 *
	 * @return The Size 60 Icon URL
	 */
	String getSize60Icon();

	/**
	 * Returns the URL of the size 90 icon
	 *
	 * @return The Size 90 Icon URL
	 */
	String getSize90Icon();

	/**
	 * Gets the name of this theme
	 *
	 * @return String theme class name
	 */
	String getName();
}

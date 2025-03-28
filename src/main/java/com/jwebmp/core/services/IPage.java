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
package com.jwebmp.core.services;

import com.guicedee.guicedinjection.interfaces.IDefaultService;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.client.Browsers;
import com.jwebmp.core.base.client.HTMLVersions;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.PageChildren;
import com.jwebmp.core.base.interfaces.IComponentHTMLAttributeBase;
import com.jwebmp.core.base.interfaces.IComponentHTMLBase;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.interfaces.IComponentStyleBase;
import com.jwebmp.core.base.references.CSSReference;
import com.jwebmp.core.base.references.JavascriptReference;
import com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments;


/**
 * Defines a page for use with IPage
 *
 * @author GedMarc
 * @since Nov 21, 2016
 */
public interface IPage<J extends IPage<J> & IComponentHierarchyBase<PageChildren, J>>
        extends IDefaultService<J>, IComponentStyleBase<J>, IComponentHTMLAttributeBase<NoAttributes, J>,
        IHtml<PageChildren, J> {

    DevelopmentEnvironments getRunningEnvironment();

    /**
     * Returns the document type that will be rendered with this HTML page real-time
     * <p>
     *
     * @return Document Type
     */
    @SuppressWarnings("unused")
    IComponentHTMLBase<?> getDocumentType();

    @SuppressWarnings("unused")
    AjaxResponse<?> onConnect(AjaxCall<?> call, AjaxResponse<?> response);

    /**
     * Returns the fields available for entry on this page
     *
     * @return The Page Fields object
     */
    //PageOptions<?> getOptions();


    /**
     * If the page is currently in mobile or smart tablet
     *
     * @return If the page is mobile or smart tablet
     */
    boolean isMobileOrSmartTablet();

    /**
     * Renders the pages HTML
     *
     * @param renderHtml If to render the html, just a place holder, must always render
     * @return The output HTML for this page
     */
    String toString(boolean renderHtml);

    /**
     * Returns the current browser or FireFox
     *
     * @return
     */
    Browsers getBrowser();

    /**
     * Sets the component browser to render for
     *
     * @param browser
     * @return
     */
    J setBrowser(Browsers browser);

    /**
     * Returns a valid HTML Version
     * <p>
     *
     * @return Browser
     */
    HTMLVersions getHtmlVersion();

    IComponentHierarchyBase<BodyChildren, ?> getBody();

    J addCssReference(CSSReference cssReference);

    J addJavaScriptReference(JavascriptReference jsReference);
}

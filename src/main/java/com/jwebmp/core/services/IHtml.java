package com.jwebmp.core.services;

import com.jwebmp.core.base.client.Browsers;
import com.jwebmp.core.base.client.HTMLVersions;
import com.jwebmp.core.base.html.interfaces.children.BodyChildren;
import com.jwebmp.core.base.html.interfaces.children.HeadChildren;
import com.jwebmp.core.base.html.interfaces.children.HtmlChildren;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;
import com.jwebmp.core.base.servlets.enumarations.DevelopmentEnvironments;

public interface IHtml<C extends HtmlChildren, J extends IComponentHierarchyBase<C, J>>
{
    /**
     * Returns the body object
     *
     * @return
     */
    IComponentHierarchyBase<BodyChildren, ?> getBody();

    /**
     * Returns the current browser or FireFox
     *
     * @return
     */
    Browsers getBrowser();

    /**
     * Returns the current browser or FireFox
     *
     * @param browser
     */
    J setBrowser(Browsers browser);

    /**
     * Returns a valid HTML Version
     * <p>
     *
     * @return Browser
     */
    HTMLVersions getHtmlVersion();

    /**
     * Returns the currently set running environment
     * <p>
     *
     * @return The current Environment.
     */
    DevelopmentEnvironments getRunningEnvironment();

    /**
     * Sets the global running environment value
     * <p>
     *
     * @param runningEnvironmentSetting The running environment value
     */
    @SuppressWarnings("unchecked")
    J setRunningEnvironment(DevelopmentEnvironments runningEnvironmentSetting);

    /**
     * Returns the head object on the HTML Tag
     *
     * @return
     */
    IComponentHierarchyBase<HeadChildren, ?> getHead();

    /**
     * Sets the body for this class
     *
     * @param body
     */

    @SuppressWarnings("unchecked")
    J setBody(IBody<?, ?> body);

    /**
     * Sets the header object for this html page
     *
     * @param head
     * @return
     */
    @SuppressWarnings("unchecked")
    J setHead(IHead head);
}

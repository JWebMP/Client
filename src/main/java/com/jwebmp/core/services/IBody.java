package com.jwebmp.core.services;

import com.jwebmp.core.base.html.interfaces.children.BodyFeatures;

public interface IBody<F extends BodyFeatures, J extends IBody<F, J>> {
    @SuppressWarnings("unchecked")
    J setFullScreen();

    /**
     * If the scripts have been rendered
     *
     * @return
     */
    boolean isRenderedScripts();

    /**
     * If the scripts have been rendered
     *
     * @param renderedScripts
     * @return
     */
    J setRenderedScripts(boolean renderedScripts);
}

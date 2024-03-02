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
package com.jwebmp.core.base.html.interfaces;

import com.jwebmp.core.base.interfaces.*;

/**
 * Defines the general interface for components that is allowed on most components
 *
 * @author MMagon
 * @version 1.0
 * @since 2014/10/26
 */

public interface GlobalChildren {
    void init();

    void preConfigure();

    boolean isConfigured();

    boolean isInitialized();

    void destroy();

    /**
     * Access the casting methods for this object
     *
     * @return
     */
    default CastableComponent cast() {
        return (CastableComponent) this;
    }

    /**
     * Returns the HTML for the given object
     * <p>
     *
     * @param outputHtml Dummy holder for specifying HTML output
     * @return The class and the associated ID and children count
     */
    String toString(boolean outputHtml);

    /**
     * Returns this components HTML after configuration and pre-rendering
     *
     * @param tabCount The number of tabs to indent by
     * @return The sting with the given tab counts
     */
    String toString(Integer tabCount);

}

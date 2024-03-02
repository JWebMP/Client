package com.jwebmp.core.base.servlets.interfaces;

/**
 * A Marker for the Css Component type
 *
 * @param <J>
 */
public interface ICSSComponent<J extends ICSSComponent<J>> extends IComponent<J> {
    String getID();
}

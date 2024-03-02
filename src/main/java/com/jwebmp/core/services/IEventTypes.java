package com.jwebmp.core.services;

public interface IEventTypes<J extends Enum<J> & IEventTypes<J>>
{
	/**
	 * Get the class type that this AJAX event type is matched to
	 *
	 * @return Get the class type that this AJAX event type is matched to
	 */
	Class getClassType();
	
	/**
	 * Gets the Ajax Event Types that this event is linked to
	 *
	 * @return Gets the Ajax Event Types that this event is linked to
	 */
	Class getAjaxOptionsReturn();
	
	Enum from(String value);
}

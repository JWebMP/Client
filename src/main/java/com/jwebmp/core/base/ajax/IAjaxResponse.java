package com.jwebmp.core.base.ajax;

import com.guicedee.services.jsonrepresentation.IJsonRepresentation;

import java.io.Serializable;
import java.util.Map;

public interface IAjaxResponse<J extends AjaxResponse<J>> extends Serializable, IJsonRepresentation<J>
{
    Map<String, String> getProperties();

    J addDataResponse(String listener, IJsonRepresentation<?> json);

    J addDataResponse(String listener, Map json) throws Exception;

    J addDataResponse(String listener, String result);

    /**
     * If the server action was a success
     *
     * @return
     */
    boolean isSuccess();

    /**
     * If the server action was a success, default is no
     *
     * @param success
     */
    void setSuccess(boolean success);

    /**
     * Returns the map going back for the local storage
     *
     * @return
     */
    Map<String, String> getLocalStorage();

    /**
     * Sets the map for the local storage going back
     *
     * @param localStorage
     */
    void setLocalStorage(Map<String, String> localStorage);

    /**
     * Gets the local session going back
     *
     * @return
     */
    Map<String, String> getSessionStorage();

    /**
     * The session storage going back
     *
     * @param sessionStorage
     */
    void setSessionStorage(Map<String, String> sessionStorage);

    /**
     * List of all data sending objects to pop out
     *
     * @return
     */
    Map<String, Object> getDataReturns();
}

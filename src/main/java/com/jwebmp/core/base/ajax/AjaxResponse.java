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
package com.jwebmp.core.base.ajax;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.guicedee.guicedservlets.servlets.services.scopes.CallScope;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;
import com.jwebmp.core.base.servlets.interfaces.IFeature;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.*;

/**
 * A response sent back to the client
 *
 * @author GedMarc
 * @since 27 Apr 2016
 */
@SuppressWarnings("MissingClassJavaDoc")
@CallScope
public class AjaxResponse<J extends AjaxResponse<J>>
        extends JavaScriptPart<J>
{
    /**
     * Whether or not the response is a success or not
     */
    @JsonProperty("success")
    private boolean success = true;

    /**
     * All relevant client reactions to perform
     */
    @JsonProperty("reactions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<AjaxResponseReaction<?>> reactions;

    /**
     * An additional list of features that can fire
     */
    @JsonIgnore
    private Set<IFeature<?, ?>> features;

    /**
     * A list of local storage items and their keys
     */
    private Map<String, String> localStorage;

    /**
     * A list of local storage items and their keys
     */
    private Map<String, String> sessionStorage;

    private Map<String, String> properties = new HashMap<>();

    public Map<String, String> getProperties()
    {
        return properties;
    }

    @JsonProperty("data")
    private Map<String, Object> dataReturns = new HashMap<>();

    public J addDataResponse(String listener, IJsonRepresentation<?> json)
    {
        dataReturns.put(listener, json);
        return (J) this;
    }

    public J addDataResponse(String listener, Map json) throws Exception
    {
        dataReturns.put(listener, json);
        return (J) this;
    }

    public J addDataResponse(String listener, String result)
    {
        dataReturns.put(listener, result);
        return (J) this;
    }

    /**
     * Sets the properties for this response
     *
     * @param properties
     * @return
     */
    public AjaxResponse<J> setProperties(Map<String, String> properties)
    {
        this.properties = properties;
        return this;
    }

    /**
     * Returns all the feature queries for the given response
     *
     * @return
     */
    @JsonProperty("features")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @SuppressWarnings("unused")
    protected Set<String> getFeatureQueries()
    {
        Set<String> list = new LinkedHashSet<>();
        getFeatures().forEach(feature ->
        {
            feature.toString();
            list.add(feature.renderJavascript()
                    .toString());
        });
        return list;
    }

    /**
     * Gets features assigned to the response
     *
     * @return
     */
    public Set<IFeature<?, ?>> getFeatures()
    {
        if (features == null)
        {
            features = new TreeSet<>();
        }
        return features;
    }

    /**
     * Sets features assigned to the response
     *
     * @param features
     */
    public void setFeatures(Set<IFeature<?, ?>> features)
    {
        this.features = features;
    }

    /**
     * If the server action was a success
     *
     * @return
     */
    public boolean isSuccess()
    {
        return success;
    }

    /**
     * If the server action was a success, default is no
     *
     * @param success
     */
    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    /**
     * Convenience method to add a feature to the feature group
     *
     * @param feature The feature to add
     * @return J Always this
     */
    @SuppressWarnings("unchecked")
    public J addFeature(IFeature<?, ?> feature)
    {
        getFeatures().add(feature);
        return (J) this;
    }

    /**
     * Adds a client reaction to be performed
     *
     * @param reaction
     */
    @SuppressWarnings("unchecked")

    public J addReaction(AjaxResponseReaction<?> reaction)
    {
        getReactions().add(reaction);
        return (J) this;
    }

    /**
     * Returns the list of client reactions available
     *
     * @return
     */
    public Set<AjaxResponseReaction<?>> getReactions()
    {
        if (reactions == null)
        {
            reactions = new LinkedHashSet<>();
        }
        return reactions;
    }

    /**
     * Returns the map going back for the local storage
     *
     * @return
     */
    public Map<String, String> getLocalStorage()
    {
        if (localStorage == null)
        {
            localStorage = new HashMap<>();
        }
        return localStorage;
    }

    /**
     * Sets the map for the local storage going back
     *
     * @param localStorage
     */
    public void setLocalStorage(Map<String, String> localStorage)
    {
        this.localStorage = localStorage;
    }

    /**
     * Gets the local session going back
     *
     * @return
     */
    public Map<String, String> getSessionStorage()
    {
        if (sessionStorage == null)
        {
            sessionStorage = new HashMap<>();
        }
        return sessionStorage;
    }

    /**
     * The session storage going back
     *
     * @param sessionStorage
     */
    public void setSessionStorage(Map<String, String> sessionStorage)
    {
        this.sessionStorage = sessionStorage;
    }

    /**
     * List of all data sending objects to pop out
     *
     * @return
     */
    public Map<String, Object> getDataReturns()
    {
        if (dataReturns == null)
        {
            dataReturns = new HashMap<>();
        }
        return dataReturns;
    }
}

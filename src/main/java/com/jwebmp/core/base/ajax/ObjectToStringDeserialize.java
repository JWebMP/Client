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

import tools.jackson.core.*;
import tools.jackson.databind.*;
import com.jwebmp.core.htmlbuilder.javascript.*;

/**
 * Deserializes a field returned in JSON as an object into a string
 *
 * @author GedMarc
 * @since Nov 9, 2016
 */
class ObjectToStringDeserialize
                extends ValueDeserializer<Object>
{
        /**
         * An instant to serialize everything as tostring
         */
        public ObjectToStringDeserialize()
        {
                //No config needed
        }

        @Override
        public Object deserialize(JsonParser jp, DeserializationContext dc)
        {
                JsonNode node = jp.readValueAsTree();
                return new JavaScriptPart().objectAsString(node);
        }
}

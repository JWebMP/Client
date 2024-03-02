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
package com.jwebmp.core.base.html.attributes;

import com.jwebmp.core.base.html.interfaces.*;

/**
 * @author MMagon
 */
public enum AudioAttributes
		implements AttributeDefinitions
{
	/**
	 * Specifies that the audio will start playing as soon as it is ready
	 */
	Autoplay,
	/**
	 * Specifies that audio controls should be displayed (such as a play/pause button etc)
	 */
	Controls,
	/**
	 * Specifies that the audio will start over again, every time it is finished
	 */
	Loop,
	/**
	 * Specifies that the audio output should be muted
	 */
	Muted,
	/**
	 * Specifies if and how the author thinks the audio should be loaded when the page loads
	 */
	Preload,
	/**
	 * Specifies the URL of the audio file
	 */
	Src;

	@Override
	public String toString()
	{
		return super.toString()
		            .toLowerCase();
	}

	@Override
	public boolean isKeyword()
	{
		return false;
	}

	public enum AudioPreloadTypes
	{
		Auto,
		Metadata,
		None
	}
}

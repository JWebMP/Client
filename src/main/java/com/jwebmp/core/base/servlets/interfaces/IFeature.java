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
package com.jwebmp.core.base.servlets.interfaces;

import com.jwebmp.core.base.html.interfaces.*;
import com.jwebmp.core.base.interfaces.*;

/**
 * Specifies a feature that can be added to a component A feature is a client side script that runs. Essentially is JavaScript commands that get added to a system.
 *
 * @author GedMarc
 * @version 1.8
 * 		<p>
 * 		1.0 - Initial Creation 1.2 Added minified support 1.3 CSS file additional support
 * @since 2011/05/03
 */
public interface IFeature<F extends GlobalFeatures, J extends IFeature<F,J>>
		extends GlobalFeatures, IComponentFeatureBase<F,J>
{

}

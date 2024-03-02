package com.jwebmp.core.base.interfaces;

import com.jwebmp.core.base.html.interfaces.children.*;
import com.jwebmp.core.base.html.interfaces.children.generics.*;

/**
 * Interface that denotes the type of Icon
 */
public interface IIcon<C, J extends IComponentBase<J> & IIcon<C, J>>
        extends FormChildren, BodyChildren, ParagraphChildren, PhraseChildren, ListItemChildren, ListChildren {
    /**
     * If the string class or a component should be used.
     * Determined is string class is null
     *
     * @return
     */
    default boolean isCssClass() {
        return getClassName() == null;
    }

    /**
     * A class name to be applied
     *
     * @return
     */
    String getClassName();

    /**
     * A component to render that is the actual icon
     *
     * @return
     */
    IComponentHierarchyBase<?, ?> getIconComponent();
}

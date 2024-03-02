package com.jwebmp.core.base.interfaces;

import java.io.Serializable;

public interface CastableComponent<J extends CastableComponent<J>> extends Serializable {


    /**
     * This class with the associated exposed methods
     *
     * @return This component type-casted
     */
    default IComponentHTMLBase<?> asTagBase() {
        return (IComponentHTMLBase<?>) this;
    }

    /**
     * This class with the associated exposed methods
     *
     * @return This component type-casted
     */
    default IComponentEventBase<?, ?> asEventBase() {
        return (IComponentEventBase<?, ?>) this;
    }

    /**
     * This class with the associated exposed methods
     *
     * @return This component type-casted
     */
    default IComponentFeatureBase<?, ?> asFeatureBase() {
        return (IComponentFeatureBase<?, ?>) this;
    }

    /**
     * Returns the components exposed dependency methods
     *
     * @return This component type-casted
     */
    default IComponentDependencyBase<?> asDependencyBase() {
        return (IComponentDependencyBase<?>) this;
    }

    /**
     * Returns the components exposed dependency methods
     *
     * @return This component type-casted
     */
    default IComponentHierarchyBase<?, ?> asHierarchyBase() {
        return (IComponentHierarchyBase<?, ?>) this;
    }

    /**
     * Returns the components exposed dependency methods
     *
     * @return This component type-casted
     */
    default IComponentStyleBase<?> asStyleBase() {
        return (IComponentStyleBase<?>) this;
    }


    /**
     * Returns the base exposed methods
     *
     * @return This component type-casted
     */
    default IComponentBase<?> asBase() {
        return (IComponentBase<?>) this;
    }

    /**
     * Returns the base exposed methods
     *
     * @return This component type-casted
     */
    default IComponentDataBindingBase<?> asAngularBase() {
        return (IComponentDataBindingBase<?>) this;
    }

    /**
     * Shortcut to adding a style attribute
     *
     * @param property the style string to add
     * @return This object
     */
    J addStyle(String property, String value);

    /**
     * Shortcut to adding a style attribute
     *
     * @param style the style string to add
     * @return This object
     */
    J addStyle(String style);
}

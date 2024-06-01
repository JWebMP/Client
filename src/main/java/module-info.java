import com.guicedee.guicedinjection.interfaces.IGuiceConfigurator;
import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.core.client.implementations.JWebMPClientBinder;
import com.jwebmp.core.client.implementations.JWebMPClientConfiguration;

module com.jwebmp.client {
    uses com.jwebmp.interception.services.AjaxCallIntercepter;
    uses com.jwebmp.interception.services.DataCallIntercepter;
    uses com.jwebmp.interception.services.SiteCallIntercepter;
    exports com.jwebmp.core.base.ajax;
    exports com.jwebmp.core.base.client;
    exports com.jwebmp.core.base.html.attributes;
    exports com.jwebmp.core.base.html.interfaces;
    exports com.jwebmp.core.base.html.interfaces.children;
    exports com.jwebmp.core.base.html.interfaces.events;
    exports com.jwebmp.core.base.interfaces;
    exports com.jwebmp.core.base.references;
    exports com.jwebmp.core.base.servlets.enumarations;
    exports com.jwebmp.core.base.servlets.interfaces;
    exports com.jwebmp.core.generics;
    exports com.jwebmp.core.htmlbuilder.css.enumarations;
    exports com.jwebmp.core.htmlbuilder.css.themes;
    exports com.jwebmp.core.htmlbuilder.javascript;
    exports com.jwebmp.core.htmlbuilder.javascript.events.interfaces;
    exports com.jwebmp.core.services;

    exports com.jwebmp.core.annotations;

    exports com.jwebmp.core.events.services;
    exports com.jwebmp.core.databind;
    exports com.jwebmp.interception.services;

    exports com.jwebmp.core.base.html.interfaces.children.generics;

    exports com.jwebmp.core.plugins;

    exports com.jwebmp.core.exceptions;

    requires transitive com.guicedee.client;
    requires transitive com.guicedee.jsonrepresentation;
    requires org.apache.commons.io;

    requires static lombok;
    requires static org.apache.commons.lang3;
    requires transitive net.sf.uadetector.core;
    requires transitive net.sf.uadetector.resources;

    provides IGuiceModule with JWebMPClientBinder;
    provides IGuiceConfigurator with JWebMPClientConfiguration;

    opens com.jwebmp.core.base.ajax to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.client to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.html.attributes to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.html.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.html.interfaces.children to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.html.interfaces.events to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.references to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.servlets.enumarations to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.servlets.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.generics to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.enumarations to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.themes to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.javascript to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.javascript.events.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.services to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.events.services to com.fasterxml.jackson.databind, com.google.guice;
}
# JWebMP Client

[![Build](https://github.com/JWebMP/Client/actions/workflows/maven-publish.yml/badge.svg)](https://github.com/JWebMP/Client/actions/workflows/build.yml)
[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp/jwebmp-client)](https://central.sonatype.com/artifact/com.jwebmp/jwebmp-client)
[![Maven Snapshot](https://img.shields.io/nexus/s/com.jwebmp/jwebmp-client?server=https%3A%2F%2Foss.sonatype.org&label=Maven%20Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/jwebmp/jwebmp-client/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Guice 7](https://img.shields.io/badge/Guice-7%2B-green)
![Vert.X 5](https://img.shields.io/badge/Vert.x-5%2B-green)
![Maven 4](https://img.shields.io/badge/Maven-4%2B-green)

**Client SPI** library for [JWebMP](https://jwebmp.com) — defines the contracts, AJAX pipeline types, HTML component interfaces, call interceptor SPIs, and component model that all JWebMP modules program against without pulling in the full core runtime.

Provides the `AjaxCall`/`AjaxResponse` pipeline, `IPage`/`IPageConfigurator` page contracts, the `SiteCallIntercepter` interception chain, and the component-model interface hierarchy (`IComponentHierarchyBase`, `IComponentHTMLBase`, etc.) that higher-level modules ([core](../core), [vertx](../vertx), plugins) build on top of. Extension is SPI-driven via `ServiceLoader`.

Every interface defined here serves **dual purposes**:
- **Compile-time contracts** — higher-level modules code against the interfaces in this library, enabling strict type safety across the ecosystem without circular dependencies
- **Runtime SPI discovery** — implementations are discovered via `ServiceLoader` (`provides…with` in JPMS or `META-INF/services`), keeping the module graph clean and extensible

Built on [GuicedEE Client](../../GuicedEE/client) · [JWebMP](https://jwebmp.com) · JPMS module `com.jwebmp.client` · Java 25+

## 📦 Installation

```xml
<dependency>
  <groupId>com.jwebmp</groupId>
  <artifactId>jwebmp-client</artifactId>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp:jwebmp-client:2.0.0-RC4")
```
</details>

> Version is managed by the [JWebMP BOM](../bom/README.MD).

## ✨ Features

- **AJAX pipeline DTOs** — `AjaxCall` and `AjaxResponse` are `CallScope`-scoped, JSON-serializable objects that carry request payloads and DOM update instructions between browser and server
- **Three interceptor SPIs** — `SiteCallIntercepter`, `AjaxCallIntercepter`, `DataCallIntercepter` — each uses CRTP and `IDefaultService` for sort-ordered, pluggable request processing
- **Page contracts** — `IPage`, `IPageConfigurator`, `IBody`, `IHead`, `IHtml` define the full page lifecycle without depending on core rendering
- **Component model interfaces** — `IComponentHierarchyBase`, `IComponentHTMLBase`, `IComponentHTMLAttributeBase`, `IComponentStyleBase`, `IComponentFeatureBase`, `IComponentEventBase`, `IComponentDataBindingBase`, `IComponentDependencyBase`, `IComponentThemeBase`, `IComponentHTMLOptionsBase`, and `IComponentBase` form the type-safe component tree
- **Databind hooks** — `IOnDataBind`, `IOnDataBindCloak`, `IOnComponentAdded`, `IOnComponentHtmlRender`, `IOnComponentConfigured`, `IAfterRenderComplete`, and `IClientVariableWatcher` fire at specific points in the render lifecycle
- **Render-ordering SPIs** — `RenderBeforeLinks`, `RenderAfterLinks`, `RenderBeforeScripts`, `RenderAfterScripts`, `RenderBeforeDynamicScripts`, `RenderAfterDynamicScripts` — fine-grained control over asset insertion order
- **User-agent detection** — UADetector parser bound as a Guice singleton for browser/device detection (`Browsers`, `BrowserGroups`, `CSSVersions`, `HTMLVersions`)
- **Plugin metadata annotations** — `@ComponentInformation`, `@PluginInformation`, `@FeatureInformation`, `@PageConfiguration` for discovery and documentation
- **Jackson integration** — `JavaScriptPart` base class provides JSON serialization for all component options via `IJsonRepresentation`
- **CSS/JS reference types** — `CSSReference` and `JavascriptReference` model external stylesheets and scripts with version metadata
- **HTML child-constraint interfaces** — `GlobalChildren`, `GlobalFeatures`, `HTMLFeatures`, `FormChildren`, and marker interfaces enforce parent/child relationships at compile time
- **Generics toolkit** — `WebReference`, `Pair`, `XYObject`, `FileTemplates`, `CompassPoints`, `Direction`, `Positions`, and more — reusable typed data structures
- **Exception hierarchy** — `InvalidRequestException`, `MissingComponentException`, `NullComponentException`, `NoServletFoundException`, `UserSecurityException` — typed error semantics for the request pipeline
- **Script provider SPI** — `ScriptProvider` allows dynamic script components to be contributed to any page
- **Static strings** — `StaticStrings` centralises well-known constants used across the framework

## 🚀 Quick Start

### Register a page configurator via JPMS `ServiceLoader`

```java
module my.app {
    requires com.jwebmp.client;

    provides com.jwebmp.core.services.IPageConfigurator
        with my.app.MyPageConfigurator;
}
```

### Implement the configurator — it runs before each page render

```java
public class MyPageConfigurator
        implements IPageConfigurator<MyPageConfigurator> {

    @Override
    public IPage<?> configure(IPage<?> page) {
        // add CSS/JS references, configure body children, etc.
        return page;
    }

    @Override
    public Integer sortOrder() {
        return 100;  // higher = later
    }
}
```

### Intercept AJAX calls

```java
public class AuditInterceptor
        implements AjaxCallIntercepter<AuditInterceptor> {

    @Override
    public void intercept(AjaxCall<?> call, AjaxResponse<?> response) {
        log.info("AJAX event: {}", call.getEventType());
    }

    @Override
    public Integer sortOrder() {
        return 10;
    }
}
```

### Provide a dynamic script

```java
public class InlineScript implements ScriptProvider {
    @Override
    public IComponentHierarchyBase<?, ?> produceScript() {
        // return a component that renders as a <script> block
    }
}
```

## 📐 AJAX Pipeline Flow

```
Browser event
 └─ JSON payload → AjaxCall (deserialized, CallScope-scoped)
     └─ SiteCallIntercepter chain (sorted by sortOrder)
         └─ AjaxCallIntercepter chain (AJAX events only)
         └─ DataCallIntercepter chain (startup data calls only)
             └─ Event handler processes call
                 └─ AjaxResponse built (component updates, reactions, scripts)
                     └─ JSON response → Browser applies DOM updates
```

## 🔌 SPI Extension Points

All SPIs are discovered via `ServiceLoader`. Register implementations with JPMS `provides...with` or `META-INF/services`.

### `SiteCallIntercepter`

Intercepts every site call (first page load). Local storage, session storage, and other client-side items are not yet available:

```java
public class MySecurityInterceptor
        implements SiteCallIntercepter<MySecurityInterceptor> {

    @Override
    public void intercept(AjaxCall<?> call, AjaxResponse<?> response) {
        // validate session, check IP, etc.
    }

    @Override
    public Integer sortOrder() {
        return 10;  // run early
    }
}
```

### `AjaxCallIntercepter`

Intercepts AJAX event calls — extends `SiteCallIntercepter` so the same `intercept()` method applies:

```java
public class AuditInterceptor
        implements AjaxCallIntercepter<AuditInterceptor> {

    @Override
    public void intercept(AjaxCall<?> call, AjaxResponse<?> response) {
        log.info("AJAX event: {}", call.getEventType());
    }
}
```

### `DataCallIntercepter`

Intercepts startup data calls — fires immediately after page delivery:

```java
public class InitDataInterceptor
        implements DataCallIntercepter<InitDataInterceptor> {

    @Override
    public void intercept(AjaxCall<?> call, AjaxResponse<?> response) {
        // load initial data into the response
    }
}
```

### `IPageConfigurator`

Configures pages before rendering. Implements `IDefaultService` (sort-ordered) and `IServiceEnablement` (can be toggled on/off):

```java
public class AnalyticsConfigurator
        implements IPageConfigurator<AnalyticsConfigurator> {

    @Override
    public IPage<?> configure(IPage<?> page) {
        page.addJavaScriptReference(analyticsScript);
        return page;
    }
}
```

### `ScriptProvider`

Provides dynamic script components to the page:

```java
public class InlineScript implements ScriptProvider {
    @Override
    public IComponentHierarchyBase<?, ?> produceScript() {
        // return a component that renders as a <script> block
    }
}
```

### Render-ordering SPIs

| SPI | Purpose |
|---|---|
| `RenderBeforeLinks` | Insert content before CSS `<link>` tags |
| `RenderAfterLinks` | Insert content after CSS `<link>` tags |
| `RenderBeforeScripts` | Insert content before `<script>` tags |
| `RenderAfterScripts` | Insert content after `<script>` tags |
| `RenderBeforeDynamicScripts` | Insert content before dynamic/inline scripts |
| `RenderAfterDynamicScripts` | Insert content after dynamic/inline scripts |

### Databind / Lifecycle SPIs

| SPI | Purpose |
|---|---|
| `IOnDataBind` | Fires when a component's data-bind is processed |
| `IOnDataBindCloak` | Fires for cloaked data-bind components |
| `IOnComponentAdded` | Fires when a child is added to a component |
| `IOnComponentConfigured` | Fires after component configuration completes |
| `IOnComponentHtmlRender` | Fires during component HTML rendering |
| `IAfterRenderComplete` | Fires after full render completes |
| `IClientVariableWatcher` | Monitors client-side variable changes |

## 🧱 Component Model Interface Hierarchy

The client defines the full interface chain that [core](../core) implements with concrete classes:

```
IComponentBase                   → ID, name, properties, JSON serialization
 └─ IComponentHierarchyBase     → parent/child tree, CSS/JS references
     └─ IComponentHTMLBase      → tag rendering, text, raw HTML
         └─ IComponentHTMLAttributeBase → HTML attributes (typed enums)
             └─ IComponentHTMLOptionsBase → JavaScript options (JavaScriptPart)
                 └─ IComponentStyleBase     → inline CSS via the CSS builder
                     └─ IComponentThemeBase     → theme support
                         └─ IComponentDataBindingBase → data-bind hooks
                             └─ IComponentDependencyBase  → CSS/JS dependency refs
                                 └─ IComponentFeatureBase    → Feature attachment
                                     └─ IComponentEventBase     → Event attachment
```

These interfaces use CRTP generics so that concrete implementations in [core](../core) expose fluent APIs without unchecked casts.

## 🗺️ Module Graph

```
com.jwebmp.client
 ├── com.guicedee.client              (DI, lifecycle, CallScope)
 ├── com.guicedee.jsonrepresentation  (JSON serialization — IJsonRepresentation)
 ├── jakarta.activation
 ├── org.apache.commons.io
 ├── io.smallrye.mutiny               (reactive types)
 ├── net.sf.uadetector.core           (user-agent parsing)
 └── net.sf.uadetector.resources
```

## 🧩 JPMS

Module name: **`com.jwebmp.client`**

The module:
- **exports** `com.jwebmp.core.base.ajax`, `com.jwebmp.core.base.client`, `com.jwebmp.core.base.html.attributes`, `com.jwebmp.core.base.html.interfaces`, `com.jwebmp.core.base.html.interfaces.children`, `com.jwebmp.core.base.html.interfaces.children.generics`, `com.jwebmp.core.base.html.interfaces.events`, `com.jwebmp.core.base.interfaces`, `com.jwebmp.core.base.references`, `com.jwebmp.core.base.servlets.enumarations`, `com.jwebmp.core.base.servlets.interfaces`, `com.jwebmp.core.generics`, `com.jwebmp.core.htmlbuilder.css.enumarations`, `com.jwebmp.core.htmlbuilder.css.themes`, `com.jwebmp.core.htmlbuilder.javascript`, `com.jwebmp.core.htmlbuilder.javascript.events.interfaces`, `com.jwebmp.core.services`, `com.jwebmp.core.annotations`, `com.jwebmp.core.events.services`, `com.jwebmp.core.databind`, `com.jwebmp.interception.services`, `com.jwebmp.core.plugins`, `com.jwebmp.core.exceptions`
- **provides** `IGuiceModule` with `JWebMPClientBinder`, `IGuiceConfigurator` with `JWebMPClientConfiguration`
- **uses** `AjaxCallIntercepter`, `DataCallIntercepter`, `SiteCallIntercepter`
- **opens** all exported packages to `com.fasterxml.jackson.databind` for JSON serialization; `com.jwebmp.core.events.services` additionally to `com.google.guice`

## 🏗️ Key Classes

| Class | Role |
|---|---|
| `AjaxCall` | Incoming AJAX request payload — deserialized from JSON, `CallScope`-scoped |
| `AjaxResponse` | Outgoing AJAX response — carries component updates, reactions, and scripts |
| `AjaxComponentUpdates` | Describes a single component DOM update (insert type, HTML content) |
| `AjaxResponseReaction` | Client-side reaction (redirect, dialog, etc.) with `ReactionType` |
| `AjaxComponentInsertType` | Enum — where to insert a component update (replace, append, prepend, etc.) |
| `HeadersDTO` | Typed wrapper for HTTP headers passed through the AJAX pipeline |
| `JavaScriptPart` | Base class for all JSON-serializable component options (via `com.guicedee.jsonrepresentation`) |
| `JWebMPClientBinder` | `IGuiceModule` — binds `AjaxCall`/`AjaxResponse` in `CallScope`, interceptor sets as singletons, `UserAgentStringParser` |
| `JWebMPClientConfiguration` | `IGuiceConfigurator` — enables classpath, annotation, field, and method scanning |
| `JWebMPInterceptionBinder` | Guice `Key` constants for the three interceptor sets |
| `CSSReference` | Models an external CSS stylesheet with version metadata |
| `JavascriptReference` | Models an external JavaScript file with version metadata |
| `IPage` | Full page abstraction — head, body, browser, document type, CSS/JS references |
| `IPageConfigurator` | SPI — configure a page before rendering |
| `IBody` / `IHead` / `IHtml` | Page-section contracts |
| `SiteCallIntercepter` | SPI — intercept site-level calls |
| `AjaxCallIntercepter` | SPI — intercept AJAX event calls (extends `SiteCallIntercepter`) |
| `DataCallIntercepter` | SPI — intercept startup data calls (extends `SiteCallIntercepter`) |
| `ScriptProvider` | SPI — provide dynamic script components |
| `PageConfiguration` | Annotation — maps a page to a URL path |
| `ComponentInformation` | Annotation — metadata for component discovery/docs |
| `PluginInformation` | Annotation — metadata for plugin discovery/docs |
| `FeatureInformation` | Annotation — metadata for feature discovery/docs |
| `FileTemplates` | Utility for managing and rendering file templates |
| `WebReference` | Base class for `CSSReference` and `JavascriptReference` |
| `StaticStrings` | Centralised well-known string constants |

### HTML Interface Types

| Interface | Purpose |
|---|---|
| `GlobalChildren` | Marker for elements that accept any flow/phrasing content |
| `GlobalFeatures` | Marker for global HTML features |
| `HTMLFeatures` | Marker for HTML-specific features |
| `FormChildren` | Marker for elements valid inside `<form>` |
| `NoClosingTag` | Marker for void elements (`<br>`, `<img>`, etc.) |
| `NoIDTag` | Marker for elements that should not render an `id` attribute |
| `NoClassAttribute` | Marker for elements that should not render a `class` attribute |
| `DisplayObjectType` | Enum — block, inline, inline-block rendering hint |
| `AttributeDefinitions` | Enum — standard HTML attributes |
| `ContainerType` | Enum — container classification |

### Client / Browser Types

| Class | Purpose |
|---|---|
| `Browsers` | Enum of known browsers |
| `BrowserGroups` | Enum grouping browsers by engine/vendor |
| `CSSVersions` | Enum of CSS specification levels |
| `HTMLVersions` | Enum of HTML specification levels |
| `HttpMethodTypes` | Enum of HTTP methods (GET, POST, PUT, DELETE, …) |
| `InternetExplorerCompatibilityMode` | IE-specific compatibility mode settings |

### Exception Types

| Exception | Purpose |
|---|---|
| `InvalidRequestException` | Malformed or invalid AJAX request |
| `MissingComponentException` | Referenced component not found in the tree |
| `NullComponentException` | Null component passed where one is required |
| `NoServletFoundException` | No servlet/handler registered for the request path |
| `UserSecurityException` | Security violation during request processing |

## ⚙️ Configuration

`JWebMPClientConfiguration` enables the following `IGuiceConfig` settings at startup:

| Setting | Value | Purpose |
|---|---|---|
| `classpathScanning` | `true` | Scan the classpath for SPI implementations |
| `allowPaths` | `true` | Allow path-based scanning |
| `fieldInfo` | `true` | Collect field-level metadata |
| `methodInfo` | `true` | Collect method-level metadata |
| `annotationScanning` | `true` | Enable annotation discovery |
| `ignoreClassVisibility` | `true` | Scan non-public classes |
| `ignoreFieldVisibility` | `true` | Scan non-public fields |
| `ignoreMethodVisibility` | `true` | Scan non-public methods |

## 🧪 Build & Test

```bash
# Build
mvn -B -ntp -DskipTests package

# Test
mvn -B -ntp verify
```

Prerequisites: Java 25+, Maven 3.9+

## 🤝 Contributing

Issues and pull requests are welcome — please add tests for new SPI implementations or interceptors.

## 📄 License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

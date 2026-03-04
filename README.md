# JWebMP Client

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.client/jwebmp-client)](https://central.sonatype.com/artifact/com.jwebmp.client/jwebmp-client)
[![Maven Snapshot](https://img.shields.io/nexus/s/com.jwebmp.client/jwebmp-client?server=https%3A%2F%2Foss.sonatype.org&label=Maven%20Snapshot)](https://oss.sonatype.org/content/repositories/snapshots/com/jwebmp/client/jwebmp-client/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Guice 7](https://img.shields.io/badge/Guice-7%2B-green)
![Vert.X 5](https://img.shields.io/badge/Vert.x-5%2B-green)
![Maven 4](https://img.shields.io/badge/Maven-4%2B-green)

**Client SPI** library for [JWebMP](https://jwebmp.com) — defines the contracts, AJAX pipeline types, HTML component interfaces, call interceptor SPIs, and component model that all JWebMP modules program against without pulling in the full core runtime.
Provides the `AjaxCall`/`AjaxResponse` pipeline, `IPage`/`IPageConfigurator` page contracts, and `SiteCallIntercepter` interception chain that higher-level modules ([core](../core), [vertx](../vertx), plugins) build on top of. Extension is SPI-driven via `ServiceLoader`.

Built on [GuicedEE Client](../../GuicedEE/client) · [JWebMP](https://jwebmp.com) · JPMS module `com.jwebmp.client` · Java 25+

## 📦 Installation

```xml
<dependency>
  <groupId>com.jwebmp.client</groupId>
  <artifactId>jwebmp-client</artifactId>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.client:jwebmp-client:2.0.0-SNAPSHOT")
```
</details>

> Version is managed by the [JWebMP BOM](../bom/README.MD).

## ✨ Features

- **AJAX pipeline DTOs** — `AjaxCall` and `AjaxResponse` are `CallScope`-scoped, JSON-serializable objects that carry request payloads and DOM update instructions between browser and server
- **Three interceptor SPIs** — `SiteCallIntercepter`, `AjaxCallIntercepter`, `DataCallIntercepter` — each uses CRTP and `IDefaultService` for sort-ordered, pluggable request processing
- **Page contracts** — `IPage`, `IPageConfigurator`, `IBody`, `IHead`, `IHtml` define the full page lifecycle without depending on core rendering
- **Component model interfaces** — `IComponentHierarchyBase`, `IComponentHTMLBase`, `IComponentHTMLAttributeBase`, `IComponentStyleBase` form the type-safe component tree
- **Databind hooks** — `IOnDataBind`, `IOnComponentAdded`, `IOnComponentHtmlRender`, `IAfterRenderComplete` and others fire at specific points in the render lifecycle
- **User-agent detection** — UADetector parser bound as a Guice singleton for browser detection
- **Plugin metadata annotations** — `@ComponentInformation`, `@PluginInformation`, `@FeatureInformation`, `@PageConfiguration` for discovery and documentation
- **Jackson integration** — `JavaScriptPart` base class provides JSON serialization for all component options via `IJsonRepresentation`

## 🚀 Quick Start

Register a page configurator via JPMS `ServiceLoader`:

```java
module my.app {
    requires com.jwebmp.client;

    provides com.jwebmp.core.services.IPageConfigurator
        with my.app.MyPageConfigurator;
}
```

Implement the configurator — it runs before each page render:

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
- **exports** `com.jwebmp.core.base.ajax`, `com.jwebmp.core.base.interfaces`, `com.jwebmp.core.services`, `com.jwebmp.interception.services`, `com.jwebmp.core.annotations`, `com.jwebmp.core.databind`, `com.jwebmp.core.plugins`, `com.jwebmp.core.generics`, and others
- **provides** `IGuiceModule` with `JWebMPClientBinder`, `IGuiceConfigurator` with `JWebMPClientConfiguration`
- **uses** `AjaxCallIntercepter`, `DataCallIntercepter`, `SiteCallIntercepter`

## 🏗️ Key Classes

| Class | Role |
|---|---|
| `AjaxCall` | Incoming AJAX request payload — deserialized from JSON, `CallScope`-scoped |
| `AjaxResponse` | Outgoing AJAX response — carries component updates, reactions, and scripts |
| `AjaxComponentUpdates` | Describes a single component DOM update |
| `AjaxResponseReaction` | Client-side reaction (redirect, dialog, etc.) |
| `JavaScriptPart` | Base class for all JSON-serializable component options |
| `JWebMPClientBinder` | `IGuiceModule` — binds `AjaxCall`/`AjaxResponse` in `CallScope`, interceptor sets as singletons, `UserAgentStringParser` |
| `JWebMPClientConfiguration` | `IGuiceConfigurator` — enables classpath, annotation, field, and method scanning |
| `JWebMPInterceptionBinder` | Guice `Key` constants for the three interceptor sets |
| `IPage` | Full page abstraction — head, body, browser, document type, CSS/JS references |
| `IPageConfigurator` | SPI — configure a page before rendering |
| `SiteCallIntercepter` | SPI — intercept site-level calls |
| `AjaxCallIntercepter` | SPI — intercept AJAX event calls (extends `SiteCallIntercepter`) |
| `DataCallIntercepter` | SPI — intercept startup data calls (extends `SiteCallIntercepter`) |
| `ScriptProvider` | SPI — provide dynamic script components |

## 🤝 Contributing

Issues and pull requests are welcome — please add tests for new SPI implementations or interceptors.

## 📄 License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

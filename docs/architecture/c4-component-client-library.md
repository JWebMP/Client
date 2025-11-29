# C4 Level 3 — Components (JWebMP Client Library)

```mermaid
flowchart LR
    Binder[JWebMPClientBinder<br/>Guice module] --> AjaxScope[AjaxCall / AjaxResponse<br/>CallScope]
    Binder --> Interceptors[Interceptors<br/>Ajax/Data/Site via ServiceLoader]
    Binder --> UAParser[UserAgentStringParser]

    Config[JWebMPClientConfiguration] --> Scan[Classpath & annotation scanning]

    ComponentModel[Component Model<br/>IComponent*, attributes, events] --> Render[Renderers<br/>DefaultRenderer, services]
    ComponentModel --> References[CSSReference / JavascriptReference]

    AjaxScope --> Interceptors
    Interceptors --> EventSvc[Event Services<br/>IOn* interfaces]
    Render --> Browser[Browser output]
    EventSvc --> AjaxScope
    References --> Browser
```

**Key interactions**
- `JWebMPClientBinder` wires call-scoped AJAX request/response objects and locator keys for interceptors, exposing UA detection to consumers.
- `JWebMPClientConfiguration` configures the GuicedEE environment to scan annotations and ignore visibility limits.
- The Component Model defines HTML elements, attributes, events, and lifecycle hooks that render via `DefaultRenderer` and attach script/style references.
- Interceptors wrap AJAX calls before/after invoking event services, populating `AjaxResponse` for the browser.

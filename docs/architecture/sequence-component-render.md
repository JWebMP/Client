# Sequence — Component Render Lifecycle

```mermaid
sequenceDiagram
    participant Dev as Developer Code
    participant Component as Component/Attribute Model
    participant Renderer as DefaultRenderer
    participant References as CSS/JS References
    participant Browser

    Dev->>Component: Construct component tree (CRTP fluent setters)
    Component->>Renderer: Request HTML output
    Renderer->>Component: Traverse children, attributes, events
    Renderer->>References: Collect CSSReference/JavascriptReference
    Renderer-->>Browser: Emit HTML + queued script/style references
    Browser-->>Renderer: Load resources, hydrate event bindings
```

**Flow notes**
- The component model relies on fluent setters returning the component type (CRTP) instead of builders.
- Renderers respect JPMS exports and open packages declared in `module-info.java` for JSON serialization.

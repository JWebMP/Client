# C4 Level 2 — Containers

```mermaid
flowchart TB
    subgraph Host["Host Application (Server)"]
        JL[JWebMP Client Library<br/>com.jwebmp.client]
        Guice[GuicedEE Runtime<br/>Guice scopes, ServiceLoader]
    end

    Browser[Browser / JS runtime]
    RulesRepo[Rules Submodule rules]
    ExtDeps[External Libraries<br/>UA Detector, Mutiny, Commons IO]

    Browser <--> JL
    JL --> Guice
    Guice --> JL
    JL --> ExtDeps
    RulesRepo -.-> JL
```

**Container responsibilities**
- **JWebMP Client Library:** Models HTML components/attributes, renders pages, and handles AJAX calls/responses; exposes JPMS exports for consumers.
- **GuicedEE Runtime:** Provides DI scopes (`CallScope`), loads interceptors (`AjaxCallIntercepter`, `DataCallIntercepter`, `SiteCallIntercepter`) via service loader, and applies configuration from `JWebMPClientConfiguration`.
- **Browser:** Emits events and receives rendered pages/AJAX responses.
- **Rules Submodule:** Documentation source of truth; not part of runtime.
- **External Libraries:** User-agent detection, reactive utilities, and IO helpers consumed by the client library.

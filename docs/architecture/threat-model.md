# Threat Model — JWebMP Client

```mermaid
flowchart LR
    subgraph Browser["Browser (Untrusted)"]
        Inputs[Events / AJAX payloads]
    end
    subgraph Server["Host Application (Trusted)"]
        DI[GuicedEE Scopes<br/>ServiceLoader]
        Ajax[AjaxCall/AjaxResponse<br/>CallScope]
        Interceptors[Ajax/Data/Site Interceptors]
        Renderer[Component Renderers]
    end
    Logs[Log4j2 Sinks]

    Inputs --> Interceptors
    Interceptors --> Ajax
    Ajax --> Renderer
    Renderer --> Inputs
    Interceptors --> Logs
    DI -. config/bindings .-> Interceptors

    classDef untrusted fill:#b30021,color:#fff,stroke:#6a0014;
    classDef trusted fill:#0a7fa8,color:#fff,stroke:#0f4b63;
    class Inputs untrusted;
    class DI,Ajax,Interceptors,Renderer trusted;
```

**Trust boundaries and mitigations**
- Browser inputs are untrusted; validation occurs in interceptors and event services before touching the component tree or serialization.
- `CallScope`-bound `AjaxCall`/`AjaxResponse` isolates per-request data; avoid storing user data in singletons or static caches.
- Interceptors discovered via `JWebMPInterceptionBinder` must be idempotent and defensive; short-circuit malformed payloads and sanitize serialized responses.
- Logging uses Log4j2 defaults (per GuicedEE rules); redact secrets and user PII in all log statements.
- GuicedEE configuration (`JWebMPClientConfiguration`) controls classpath scanning; restrict visibility to intended packages and review custom modules for JPMS exports.

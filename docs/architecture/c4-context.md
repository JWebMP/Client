# C4 Level 1 — Context

```mermaid
flowchart TD
    Dev[Developer] --> HostApp[Host app using JWebMP Client]
    Browser[Browser] --> HostApp
    HostApp --> Browser
    HostApp --> GuicedEE[GuicedEE runtime<br/>ServiceLoader, Guice scopes]
    HostApp --> UADetector[UserAgent Detector resources]
    HostApp --> Mutiny[Mutiny]
    Rules[Rules Repository] -.-> Dev

    subgraph Boundary["Server trust boundary"]
        HostApp
        GuicedEE
    end
```

**Notes**
- System under design: the `com.jwebmp.client` library embedded into host apps to render HTML/JS and handle AJAX flows.
- Trust boundaries: Browser inputs are untrusted; interceptors validate/transform before producing `AjaxResponse`.
- Dependencies: GuicedEE provides DI/binder loading; UA Detector parses user-agent strings; Mutiny supplies reactive primitives.

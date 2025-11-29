# Dependency & Integration Map — JWebMP Client

```mermaid
flowchart LR
    subgraph Host["Host Application (JPMS)"]
        Client[com.jwebmp.client<br/>JPMS module]
        GuicedEE[GuicedEE Runtime<br/>Guice scopes, ServiceLoader]
    end

    Browser[Browser / JS runtime]
    Vertx[Vert.x 5 Event Loop<br/>GuicedEE bridge]
    Mutiny[Mutiny Reactive Types]
    UADetector[UA Detector Resources]
    RulesRepo[Rules Repository<br/>rules/* indexes]

    Browser <--> Client
    Client --> GuicedEE
    Client --> Vertx
    Client --> Mutiny
    Client --> UADetector
    RulesRepo -.-> Client

    classDef external fill:#0a7fa8,stroke:#0f4b63,color:#fff;
    class Browser,Vertx,Mutiny,UADetector,RulesRepo external;
```

**Notes**
- `com.jwebmp.client` is packaged as a JPMS module; exports/opens are defined in `src/main/java/module-info.java` to support renderers and serialization.
- GuicedEE provides DI scopes (`CallScope`), ServiceLoader interception keys, and bridge modules for Vert.x 5 event loops.
- Mutiny is the preferred reactive API for asynchronous interactions; avoid mixing with other reactive libraries.
- UA Detector is consumed for user-agent parsing to tailor responses; keep resources available on the classpath.
- The Rules Repository supplies authoritative generation and documentation policies; do not place project docs inside the `rules/` submodule.

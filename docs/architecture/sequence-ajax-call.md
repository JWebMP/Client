# Sequence — AJAX Call Pipeline

```mermaid
sequenceDiagram
    participant Browser
    participant Component as JWebMP Component
    participant AjaxCall as AjaxCall (CallScope)
    participant Interceptors as Interceptors (Ajax/Data/Site)
    participant EventSvc as IOn* Event Service
    participant AjaxResponse as AjaxResponse (CallScope)

    Browser->>Component: Trigger client event
    Component->>AjaxCall: Build request payload
    AjaxCall->>Interceptors: Invoke registered interceptors (ServiceLoader)
    Interceptors->>EventSvc: Dispatch event handler
    EventSvc-->>AjaxResponse: Populate response payload/updates
    AjaxResponse-->>Interceptors: Post-processing hooks (optional)
    Interceptors-->>Browser: Return serialized response
```

**Flow notes**
- `AjaxCall` and `AjaxResponse` are bound per request via `CallScope` from GuicedEE.
- Interceptors are discovered through `JWebMPInterceptionBinder` keys and can short-circuit or augment the response.

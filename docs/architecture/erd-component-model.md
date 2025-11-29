# ERD — Component Model Relationships

```mermaid
erDiagram
    COMPONENT ||--|{ ATTRIBUTE : defines
    COMPONENT ||--|{ FEATURE : "adds behavior"
    COMPONENT ||--|{ EVENT_SERVICE : "handles events"
    COMPONENT ||--|{ REFERENCE : "queues assets"
    COMPONENT ||--|{ PLUGIN : "exposes metadata"

    AJAX_CALL ||--|| COMPONENT : "starts from"
    EVENT_SERVICE ||--|| AJAX_CALL : "consumes payload"
    AJAX_RESPONSE ||--|| EVENT_SERVICE : "populated by"
    AJAX_RESPONSE ||--|{ REFERENCE : "can enqueue"

    INTERCEPTOR ||--|| AJAX_CALL : "wraps call"
    INTERCEPTOR ||--|| AJAX_RESPONSE : "wraps response"
```

**Coverage**
- Maps core types in `com.jwebmp.core.base.*` (components, attributes, features), event services (`com.jwebmp.core.events.services.*`), AJAX request/response objects, and interception hooks.
- References represent CSS/JS resources emitted during rendering (`CSSReference`, `JavascriptReference`).

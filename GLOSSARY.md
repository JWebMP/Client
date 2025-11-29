# Glossary — Topic-First (JWebMP Client)

## Glossary Precedence Policy
- Topic glossaries override root definitions within their scope; this file is an index/aggregator.
- Use topic terms first, then local terms for project-specific concepts.
- Avoid duplicating topic content; link to the authoritative glossary entry in `rules/`.
- LLM interpretation guidance: prefer CRTP language for components (e.g., `Component<J extends Component<J>>`), avoid builder terminology, and keep prompts aligned to the Log4j2 + GuicedEE stack when asking for logging or DI examples.

## Topic Glossaries (authoritative)
- Java 25 & Maven build tooling — `rules/generative/language/java/GLOSSARY.md`
- Fluent API (CRTP) — `rules/generative/backend/fluent-api/GLOSSARY.md`
- GuicedEE platform — `rules/generative/backend/guicedee/GLOSSARY.md`
- GuicedEE Client (interception, DI lifecycle) — `rules/generative/backend/guicedee/client/GLOSSARY.md`
- Vert.x integration (GuicedEE bridge) — `rules/generative/backend/guicedee/vertx/GLOSSARY.md`
- JSpecify nullness — `rules/generative/backend/jspecify/GLOSSARY.md`
- Logging defaults (Log4j2) — see `rules/generative/backend/guicedee/GLOSSARY.md` logging entries when applicable.

## Project-Specific Terms
- **JWebMP Client Library** — JPMS module `com.jwebmp.client` exposing HTML element modeling, AJAX handling, and GuicedEE bindings without the full JWebMP stack.
- **AJAX Interceptor Keys** — bindings provided by `JWebMPInterceptionBinder` that resolve `AjaxCallIntercepter`, `DataCallIntercepter`, and `SiteCallIntercepter` via `ServiceLoader`.
- **Client Binder** — `JWebMPClientBinder` Guice module wiring call-scoped `AjaxCall`/`AjaxResponse` and UA detection (`UserAgentStringParser`).
- **Client Configuration** — `JWebMPClientConfiguration` enabling classpath scanning and relaxed visibility in GuicedEE configuration.
- **Component Model** — interfaces in `com.jwebmp.core.base.*` that define HTML components, attributes, events, and rendering contracts (`DefaultRenderer`, `IComponent*` interfaces).
- **Prompt Language Alignment** — Host projects may copy only enforced aligned names (e.g., CRTP component types, interceptor key names) into their root glossaries; for all other terms, link back to this file or the Rules Repository topic glossaries instead of duplicating definitions.

# GUIDES — How to Apply Rules (JWebMP Client)

Use these guides with the Rules submodule (`rules/`). Follow topic links first, then return here for project context and diagrams.

## Selected topics (authoritative guides)
- Library rules index — `rules/generative/frontend/jwebmp/client/README.md`
- Java 25 LTS + Maven build wiring — `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`
- Fluent API (CRTP) — `rules/generative/backend/fluent-api/README.md`
- GuicedEE platform — `rules/generative/backend/guicedee/README.md`
- GuicedEE Client (interception/binders) — `rules/generative/backend/guicedee/client/README.md`
- GuicedEE Vert.x bridge — `rules/generative/backend/guicedee/vertx/README.md`
- JSpecify nullness — `rules/generative/backend/jspecify/README.md`
- Logging (Log4j2 defaults via GuicedEE) — see GuicedEE guides for logging policy.

## How to use the library
- Bindings and configuration: follow GuicedEE Client guide; map to `JWebMPClientBinder` and `JWebMPClientConfiguration` from `src/main/java/com/jwebmp/core/client/implementations/`.
- Component model: use CRTP-style fluent setters for HTML components/attributes (`com.jwebmp.core.base.*`), avoiding builder annotations.
- Interceptors: register AJAX/Data/Site interceptors via ServiceLoader per GuicedEE docs; see `docs/architecture/sequence-ajax-call.md`.
- Rendering: align with `DefaultRenderer` flow and resource references; see `docs/architecture/sequence-component-render.md`.
- Nullness: apply JSpecify annotations per topic guide; prefer explicit contracts in component/event services.

## Validation and testing
- Maven: run `mvn -U -B -ntp verify` with Java 25 Temurin.
- Reactive paths: use Mutiny test utilities where applicable (if added).
- Traceability: cross-check glossary terms in `docs/GLOSSARY.md` and architecture diagrams in `docs/architecture/README.md` (integration map, threat model, sequences).

## Traceability
- PACT: `docs/PACT.md`
- Rules: `RULES.md`
- Implementation map: `IMPLEMENTATION.md`

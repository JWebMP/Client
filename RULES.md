# Project Rules — JWebMP Client

## Scope and selections
- Architecture: Specification-Driven Design, Documentation-as-Code, Forward-Only.
- Language/Build: Java 25 LTS, Maven.
- Frameworks/Libs: GuicedEE Client (Vert.x 5 bridge), Mutiny reactive types, Log4j2 logging defaults, JSpecify nullness.
- Fluent API Strategy: CRTP chaining; do not use builders/Lombok @Builder for fluent APIs.
- Documentation: Topic-first glossary and modular docs; no project docs inside `rules/`.

## Canonical references (Rules submodule)
- Core rules: `rules/RULES.md` (sections 4/5, Document Modularity, Forward-Only).
- Java/Maven: `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`.
- Fluent API: `rules/generative/backend/fluent-api/README.md`.
- GuicedEE platform: `rules/generative/backend/guicedee/README.md`.
- GuicedEE Client: `rules/generative/backend/guicedee/client/README.md`.
- GuicedEE Vert.x: `rules/generative/backend/guicedee/vertx/README.md`.
- JSpecify: `rules/generative/backend/jspecify/README.md`.
- CI/CD (if extended): `rules/generative/platform/ci-cd/README.md`.
- Observability/logging defaults: follow GuicedEE logging guidance (Log4j2).

## Local rules and conventions
- JPMS: maintain exports/opens in `src/main/java/module-info.java`; align new packages accordingly.
- Bindings: `JWebMPClientBinder` and `JWebMPClientConfiguration` are authoritative for DI; interceptors resolve via ServiceLoader.
- Logging: use Log4j2 APIs/config expected by GuicedEE; avoid adding other logging frameworks.
- Nullness: apply JSpecify annotations where adding/changing APIs.
- Glossary: use `docs/GLOSSARY.md` for terminology; topic glossaries override root definitions.
- Docs: keep PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION linked; update architecture diagrams when flows/components change.

## Cross-links
- PACT: `docs/PACT.md`
- Glossary: `docs/GLOSSARY.md`
- Guides: `GUIDES.md`
- Implementation: `IMPLEMENTATION.md`
- Architecture index: `docs/architecture/README.md`
- Prompt primer: `docs/PROMPT_REFERENCE.md`

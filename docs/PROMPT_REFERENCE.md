# Prompt Reference — JWebMP Client

Use this file to prime AI prompts for this repository.

## Selected stacks and policies
- Java 25 LTS, Maven build
- GuicedEE Client (Vert.x 5 bridge), Mutiny reactive types
- Fluent API via CRTP (no builders), Log4j2 logging defaults
- JSpecify nullness annotations
- Documentation-as-Code, Forward-Only, Document Modularity (no monoliths)
- Trust boundary: browser inputs are untrusted; interceptors validate before touching the component tree. CallScope isolates AJAX payloads.

## Rules to load before generation
- Root rules index: `rules/README.md`
- RULES anchors: `rules/RULES.md` (sections 4/5, Document Modularity, Forward-Only)
- Library rules index: `rules/generative/frontend/jwebmp/client/README.md`
- Topic guides: GuicedEE (`rules/generative/backend/guicedee/README.md`), GuicedEE Client (`rules/generative/backend/guicedee/client/README.md`), GuicedEE Vert.x (`rules/generative/backend/guicedee/vertx/README.md`), Java 25 (`rules/generative/language/java/java-25.rules.md`), Maven build tooling (`rules/generative/language/java/build-tooling.md`), Fluent API (`rules/generative/backend/fluent-api/README.md`), Logging (Log4j2 defaults within GuicedEE rules), JSpecify (`rules/generative/backend/jspecify/README.md`).

## Diagrams (Mermaid sources)
- `docs/architecture/README.md` — index
- Context — `docs/architecture/c4-context.md`
- Container — `docs/architecture/c4-container.md`
- Component — `docs/architecture/c4-component-client-library.md`
- Dependency & Integration Map — `docs/architecture/integration-map.md`
- Sequences — `docs/architecture/sequence-ajax-call.md`, `docs/architecture/sequence-component-render.md`
- ERD — `docs/architecture/erd-component-model.md`
- Threat Model — `docs/architecture/threat-model.md`

## Traceability loop
- PACT: `PACT.md`
- Glossary: `GLOSSARY.md` (topic-first; references GuicedEE/CRTP/Java/Vert.x/JSpecify)
- RULES/GUIDES/IMPLEMENTATION: to be maintained at the repository root and linked from README.

## Usage
- Load this file, then load referenced RULES/Guides before any code generation.
- Keep all project-specific docs outside the `rules/` submodule; update links when adding artifacts.

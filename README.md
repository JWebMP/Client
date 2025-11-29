# JWebMP Client
A client library for interacting with JWebMP without swallowing the entire core.

## How to use these rules
- Start with the library topic index: `rules/generative/frontend/jwebmp/client/README.md`.
- Load RULES anchors: `rules/RULES.md` (sections 4/5, Document Modularity, Forward-Only) and project `RULES.md`.
- Follow PACT (`docs/PACT.md`), GUIDES (`GUIDES.md`), IMPLEMENTATION map (`IMPLEMENTATION.md`), and architecture diagrams (`docs/architecture/README.md`) in that order for Stage 1–4 flows.
- Keep project docs outside `rules/`; treat the Rules Repository as read-only source material for prompts.

## Cross-links to Rules Repository topics
- Frontend (JWebMP): `rules/generative/frontend/jwebmp/README.md`; Client rules: `rules/generative/frontend/jwebmp/client/README.md`.
- Backend (GuicedEE): `rules/generative/backend/guicedee/README.md`, Client bridge: `rules/generative/backend/guicedee/client/README.md`, Vert.x bridge: `rules/generative/backend/guicedee/vertx/README.md`.
- Language/Build: `rules/generative/language/java/java-25.rules.md`, `rules/generative/language/java/build-tooling.md`.
- Fluent API: `rules/generative/backend/fluent-api/README.md`; JSpecify nullness: `rules/generative/backend/jspecify/README.md`.

## Prompt Language Alignment & Glossary
- Authoritative glossary for this topic: `docs/GLOSSARY.md` (topic-first, minimal duplication).
- Host projects should copy only enforced aligned names (e.g., CRTP component types, interceptor keys); for all other terms, link back to `docs/GLOSSARY.md` or the Rules Repository glossaries.
- Prompt stack alignment: Java 25 + Maven, GuicedEE Client (Vert.x 5), Log4j2 logging defaults, CRTP fluent APIs (no builders), JSpecify nullness.

## Build
- Java 25 LTS, Maven: `mvn -B -ntp verify`

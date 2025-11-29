# Copilot Workspace Instructions — JWebMP Client

- Load `rules/RULES.md` sections 4/5, Document Modularity Policy, and Forward-Only Policy before suggesting changes.
- Use selected stacks only: Java 25 + Maven, GuicedEE Client (Vert.x 5), CRTP fluent APIs (no builders), Log4j2 logging defaults, JSpecify nullness.
- Keep project docs outside `rules/`; maintain modular docs and topic-first glossary.
- Respect stage-gated flow: PACT → RULES → GUIDES → IMPLEMENTATION, with architecture diagrams under `docs/architecture/`.
- No legacy anchors; update all links when renaming/splitting docs; avoid adding other logging frameworks.

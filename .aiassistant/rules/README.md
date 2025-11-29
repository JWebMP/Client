# AI Assistant Rules Pin (JWebMP Client)

- Load `rules/RULES.md` sections 4 (Behavioral Agreements), 5 (Technical Commitments), Document Modularity Policy, and Forward-Only Change Policy before generating.
- Keep project docs outside `rules/`; use topic-first modular files and update links when restructuring.
- Honor selected stacks: Java 25 + Maven, GuicedEE Client (Vert.x 5), CRTP fluent APIs (no builders), Log4j2 logging defaults, JSpecify nullness.
- Follow stage-gated, docs-first workflow; avoid code changes before documenting (auto-approved this run but still trace links).
- Maintain traceability: PACT ↔ RULES ↔ GUIDES ↔ IMPLEMENTATION ↔ diagrams ↔ glossary.

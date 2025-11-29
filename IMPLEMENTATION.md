# IMPLEMENTATION — JWebMP Client

## Current layout (evidence-based)
- Build: Maven (pom.xml) with parent `com.jwebmp:parent:2.0.0-SNAPSHOT`; JPMS module `com.jwebmp.client`.
- Sources: `src/main/java/com/jwebmp/core/...` (HTML component model, AJAX handling, interceptors, services, references), `src/main/java/module-info.java` exports/opens and Guice providers.
- Resources: `src/main/resources/META-INF/services/` for GuicedEE lifecycle bindings.
- Tests: `src/test/java/com/jwebmp/...` covering AJAX, JS references, and JavaScript parts.
- Docs added: `docs/PACT.md`, `docs/GLOSSARY.md`, `docs/architecture/*` (including integration map and threat model), `docs/PROMPT_REFERENCE.md`, `GUIDES.md`.
- Rules index (library): `rules/generative/frontend/jwebmp/client/README.md` with modular rules for configuration, interception, rendering, reactive integration, logging, and nullness.

## Implementation plan (Stage 3 — auto-approved)
- Docs/modules: keep PACT/GLOSSARY/GUIDES/architecture aligned; maintain library rules under `rules/generative/frontend/jwebmp/client/` and update PROMPT_REFERENCE when diagrams or stacks change.
- Build/CI: add GitHub Actions Maven workflow on Java 25; document required secrets/env (not yet implemented).
- Env: `.env.example` already exists; extend with placeholders for log level, environment, and GuicedEE loader overrides if new config is added.
- AI workspace: keep `.aiassistant/rules/` and `.github/copilot-instructions.md` synchronized with RULES anchors and Stage 1–4 flow.
- README/traceability: preserve navigation across PACT, RULES, GUIDES, IMPLEMENTATION, architecture index, glossary, and release notes.
- Rollout: forward-only edits; no legacy anchors; ensure links resolve and no docs land in `rules/`.

## Runtime/config alignment
- Java 25 Temurin for builds/tests; honor JPMS exports/opens from `module-info.java`.
- Logging: default to Log4j2 per GuicedEE guidance; configure via host app (no logging files added here).
- Interceptors: continue ServiceLoader discovery; ensure bindings documented in README/IMPLEMENTATION.

## Validation approach
- Run `mvn -B -ntp verify` with Java 25 (not executed yet).
- Manual link check across README, PACT, GUIDES, IMPLEMENTATION, architecture index.

## Risks/assumptions
- Java 25 availability in CI runners assumed (Temurin 25). Adjust if upstream runner lacks GA support.
- No CI secrets currently defined; placeholders documented only.
- Forward-only reorg of rules/doc indexes may require host prompts to reload references; ensure PROMPT_REFERENCE is loaded first.

## Traceability
- PACT: `docs/PACT.md`
- Rules: `RULES.md`
- Guides: `GUIDES.md`
- Glossary: `docs/GLOSSARY.md`
- Architecture: `docs/architecture/README.md`

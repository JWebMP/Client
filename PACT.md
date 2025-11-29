# PACT — JWebMP Client

## Purpose and Scope
- Deliver a lightweight client-side JWebMP library that provides HTML element modeling, AJAX call handling, and GuicedEE integration without requiring the full JWebMP core.
- Serve host applications that render HTML/JS via JWebMP while keeping the client concerns modular and JPMS-friendly (`module com.jwebmp.client`).
- Honor the Rules Repository as the source of truth for rules/guides; host artifacts live outside the `rules/` submodule.
- Sandbox awareness: host artifacts stay at the repo root or under `docs/`; when cutting a release, update canonical rules in the Rules Repository under `repository/frontend/angular-awesome` (and avoid touching other Rules repo directories).

## Alignment and Tenets
- **Specification-Driven Design, Documentation-as-Code, Forward-Only:** Apply docs-first stage gates; no legacy anchors or partial updates.
- **Fluent API Strategy:** CRTP chaining where applicable (no Lombok builders); log guidance per Log4j2 defaults.
- **Selected stacks:** Java 25 LTS, Maven, GuicedEE Client (Vert.x 5 bridge), Mutiny reactive types, JSpecify annotations, Logging via Log4j2.
- **Security/Trust:** Interceptor bindings (AJAX/Data/Site) are resolved via GuicedEE loader; treat browser inputs as untrusted, validate before rendering/serialization.

## Boundaries and Constraints
- Do not place project docs inside `rules/`; keep host docs under `docs/` or repository root.
- Preserve JPMS module boundaries declared in `src/main/java/module-info.java`.
- Follow Document Modularity Policy for new/updated docs and keep glossary topic-first.
- CI and env scaffolding must align with Maven builds and GuicedEE workflows; secrets belong in `.env.example` only as keys/placeholders.
- Mermaid MCP server is available for diagrams (`https://mcp.mermaidchart.com/mcp` HTTP, or SSE at `/sse`); register when using MCP-capable assistants.

## Interfaces and Integrations
- **GuicedEE:** `JWebMPClientBinder` and `JWebMPClientConfiguration` provide bindings/configuration; interceptors loaded via `ServiceLoader`.
- **AJAX pipeline:** `AjaxCall` + `AjaxResponse` bound per-call; interceptors wrap request/response.
- **Rendering & Components:** HTML attribute/component model (`com.jwebmp.core.base.*`, `com.jwebmp.core.htmlbuilder.*`) feeds renderers; references to CSS/JS managed via `CSSReference` and `JavascriptReference`.
- **External libs:** Mutiny for reactive types, UA Detector for user-agent parsing, Commons IO/lang.

## Stage Gates (auto-approved this run)
- Stage 1: Architecture & Foundations docs (this PACT, diagrams, glossary plan) — **auto-approved (blanket)**.
- Stage 2: Guides & Design Validation — **auto-approved (blanket)**.
- Stage 3: Implementation Plan — **auto-approved (blanket)**.
- Stage 4: Implementation/Scaffolding — proceed with forward-only, keeping diffs reviewable.

## Traceability Links
- Rules Repository index: `rules/README.md`
- Glossary index: `docs/GLOSSARY.md` (topic-first; links to GuicedEE, Java, JSpecify, fluent API)
- Architecture index: `docs/architecture/README.md`
- Guides index: `GUIDES.md`
- Implementation map: `IMPLEMENTATION.md`

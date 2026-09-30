# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What This Is

Pine Script v6 trading indicator collection for TradingView. Scripts are copied directly into TradingView Pine Editor — no build, lint, or test tooling exists.

## Main Scripts

Script files have **no file extension** — they're Pine Script despite their names.

- **`top-right-table`** — Primary script. Full dashboard: chart indicators + top-right market data table + optional bottom-right EMA/breadth table. Currently v2.1, optimized to 24 `request.security()` calls (reduced from 47).
- **`bottom-right-table`** — Lightweight standalone: bottom-right table only, no chart overlays.
- **`squeeze.groovy`** — Separate Squeeze Momentum Indicator (LazyBear-based), standalone. **Note:** `.groovy` extension is misleading — this is Pine Script, not Groovy.

## Architecture

All logic lives in the script files themselves — Pine Script has no imports or modules. Settings are organized via `group =` parameters in `input.*()` calls — each group maps to a collapsible section in TradingView's indicator settings panel. Components are sections within each file:

1. **21 EMA Structure** — 3 MAs (High/Close/Low) with trend detection
2. **Market Data Dashboard** — ADR%, ATR, volume, sector/industry via `request.security()`
3. **EMA Clouds & Market Breadth** — Stock/VIX cloud + breadth indicators
4. **Ripster EMA Clouds** — 5-layer cloud system (5-12, 34-50 EMAs)
5. **RS Rating** — IBD-style relative strength (1–99)
6. **Pivot Points** — Daily R1/Pivot/S1/S2
7. **RMV Indicator** — Range Movement Volatility
8. **Launch Pad Detection** — Consolidation zone identification
9. **Inside Candle Patterns** — Weekly/intraday consolidation signals
10. **Bollinger Bands** — Volatility levels
11. **Extended EMA Analysis** — Distance/ATR from key MAs
12. **Floating Labels** — Dynamic right-side price labels

**Data flow:** `request.security()` calls fetch multi-timeframe/symbol data → calculations → chart overlays + table cells.

## Key Constraint

`request.security()` call count is limited by TradingView. The top-right-table script is budgeted at 24 calls. Do not add new `request.security()` calls without removing or consolidating existing ones.

## Documentation

Jekyll-based docs site in `/docs/`, auto-deployed to GitHub Pages on push to `main`. Each component has its own `.md` file matching the architecture sections above. The `_config.yml` defines nav order and excludes the Pine Script files from Jekyll processing. Full docs: https://tekram.github.io/tv-script/docs/

# Extended EMA/SMA Analysis

## Overview
The Extended EMA/SMA Analysis system measures how far price has extended from key moving averages, providing both ATR-based and percentage-based measurements. This helps identify overextended conditions and optimal entry/exit levels.

## Measurement Types

### ATR Multiples
- **Purpose**: Measures distance in Average True Range multiples
- **Usage**: Normalized volatility-based measurement
- **Formula**: `(close - MA) / ATR`
- **Interpretation**: 
  - < 0.5 ATR: Close to MA
  - 0.5-1.0 ATR: Moderate extension
  - > 1.0 ATR: Extended (avoid new entries)

### Percentage Distance
- **Purpose**: Measures percentage distance from MA
- **Usage**: Easy-to-understand extension measurement
- **Formula**: `(close - MA) / MA * 100`
- **Interpretation**: Positive = above MA, Negative = below MA

## Tracked Moving Averages

### Short-Term EMAs

#### 3 EMA
- **Display**: Conditional (when RSI < 31)
- **Color**: Green/red background based on direction
- **Usage**: Very short-term momentum

#### 4 EMA (High)
- **Display**: Conditional (when RSI >= 31)
- **Calculation**: EMA of high prices
- **Usage**: Pivot level identification
- **Color**: Green/red background

#### 5 EMA
- **Display**: Always shown when Extended enabled
- **Color**: Green/red background
- **Usage**: Short-term extension

#### 10 EMA
- **Display**: Always shown when Extended enabled
- **Color**: Green/red background
- **Usage**: Short-term trend extension

### Medium-Term EMAs

#### 20 EMA
- **Display**: Always shown when Extended enabled
- **Color**: Green/red background
- **Usage**: Medium-term trend extension
- **Note**: Can show "Pre" label when approaching earnings

#### 20 EMA (Hourly)
- **Calculation**: 20 EMA from hourly timeframe
- **Display**: In EMA values floating label
- **Usage**: Hourly trend context

### Long-Term SMAs

#### 50 SMA
- **Display**: Conditional (when `show_longer_ma` enabled or extension < 0.1)
- **Color**: Blue text
- **Usage**: Medium-term trend analysis

#### 200 SMA
- **Display**: Conditional (when `show_longer_ma` enabled or extension < 0.1)
- **Color**: Red text
- **Usage**: Long-term trend analysis

## Display Format

### Table Format (Top Right)
Each extended MA shows:
```
Extended EMA X: [ATR multiple] / [percentage]% ([MA value])
```

Example:
```
Extended EMA 20: 1.22 / 11.28% (97.06)
```

### Floating Label Format
Shows multiple EMAs in single label:
```
20 EMA (hourly): X% (value) / extended
5 EMA: X% (value) / extended
10 EMA: X% (value) / extended
20 EMA: X% (value) / extended
```

## Color Coding

### Background Colors
- **Green** (#17880b51): Price above MA (positive extension)
- **Red** (#880b0b50): Price below MA (negative extension)

### Text Colors
- **Standard**: Default text color
- **50 SMA**: Blue (#1114a1)
- **200 SMA**: Red (#c40f0f)

## Trading Applications

### Entry Timing
- **Close to Structure**: Extended < 0.5 ATR = good entry zone
- **Moderate Extension**: 0.5-1.0 ATR = acceptable but watchful
- **Overextended**: > 1.0 ATR = avoid new entries, trim positions

### Position Sizing
- **Near Structure**: Larger position size when extended < 0.5 ATR
- **Extended**: Smaller position size when extended > 1.0 ATR
- **Very Extended**: Consider trimming when > 1.5 ATR

### Exit Strategy
- **Trim into Strength**: Trim positions when extended > 1.0 ATR
- **Re-entry**: Wait for pullback to structure (< 0.5 ATR)

## Configuration Options

### Display Toggles
- **Show Extended**: Master toggle for extended section
- **Show Longer MAs**: Toggle 50 SMA and 200 SMA display
- **Show 3 EMA + RSI**: Toggle 3 EMA/4 EMA conditional display

### Input Settings
- **Extended EMA Input**: Which EMA to show extension from (default: 20)
- **Extended SMA Input**: Which SMA to show extension from (default: 50)
- **RSI Length**: For 3 EMA/4 EMA conditional logic (default: 14)

## Best Practices

1. **Avoid Extended Entries**: Don't buy >1x ATR above 21dma structure
2. **Watch Multiple MAs**: Check extension from multiple timeframes
3. **Combine with Structure**: Use with 21 EMA structure for best results
4. **Trim into Strength**: Use extension levels for profit-taking
5. **Re-entry Zones**: Wait for pullback to structure before adding

## Technical Details

### Calculation Method
```pinescript
// ATR-based extension
extended_ema = (close - price_ema) / atr

// Percentage extension
percent_change_from_ema = (close - price_ema) / price_ema * 100

// Conditional display
if show_longer_ma or percent_change_from_sma < 0.1
    // Show 50 SMA
```

### Conditional Logic
- **50/200 SMA**: Only shows when `show_longer_ma` enabled OR extension < 0.1
- **3 EMA vs 4 EMA**: Switches based on RSI level (< 31 = 3 EMA, >= 31 = 4 EMA)

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [21 EMA Structure Indicator](21ema-structure.md)
- [Top Right Table Dashboard](top-right-table-dashboard.md)
- [Floating Labels](floating-labels.md)


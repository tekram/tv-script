# Bollinger Bands System

## Overview
The Bollinger Bands system provides volatility-based support and resistance levels using standard deviation. The script includes both standard Bollinger Bands and multi-timeframe BB calculations (though multi-timeframe calculations are currently disabled to reduce request calls).

## Standard Bollinger Bands

### Calculation
- **Basis**: 20-period SMA (default)
- **Multiplier**: 2.0 standard deviations (default)
- **Upper Band**: Basis + (Multiplier × Standard Deviation)
- **Lower Band**: Basis - (Multiplier × Standard Deviation)

### Visual Display
- **Upper Band**: Plotted line (customizable color, default: transparent)
- **Lower Band**: Plotted line (customizable color, default: transparent)
- **Fill**: Purple fill between bands (only on 30-min/60-min timeframes)
- **Line Width**: 2

### Configuration
- **Length**: Default 20 periods
- **Source**: Default close (customizable)
- **Multiplier**: Default 2.0 (adjustable)
- **Colors**: Customizable upper band, lower band, and fill colors

## Multi-Timeframe Bollinger Bands

### Intended Features
**Status**: Variables declared but calculations removed to reduce request calls

### Timeframes
- **30-minute**: Lower and upper bands
- **1-hour**: Lower and upper bands
- **2-hour**: Lower and upper bands
- **4-hour**: Lower and upper bands
- **6-hour**: Lower and upper bands

### Visual Elements (Planned)
- **Floating Label**: Shows BB values for all timeframes
- **30m/1h Dots**: Dots on daily charts showing 30m and 1h lower BBs
- **Lines**: Lines for 30m upper and lower bands

## Trading Applications

### Standard BB Usage
- **Bollinger Squeeze**: Bands narrowing = low volatility = potential breakout
- **Bollinger Bounce**: Price bouncing off bands = mean reversion
- **Bollinger Breakout**: Price breaking bands = trend continuation

### Multi-Timeframe BB (When Enabled)
- **Support/Resistance**: Use lower BBs from higher timeframes as support
- **Trend Context**: Higher timeframe BBs show trend direction
- **Entry Levels**: Lower BBs from intraday timeframes as entry zones

## Configuration Options

### Standard BB Settings
- **Length**: Period for SMA calculation (default: 20)
- **Source**: Price source (default: close)
- **Multiplier**: Standard deviation multiplier (default: 2.0)
- **Upper Band Color**: Customizable
- **Lower Band Color**: Customizable
- **Fill Color**: Customizable (default: purple with 92% transparency)

### Display Settings
- **Fill Display**: Only shows on 30-min/60-min timeframes
- **Show BB Dots**: Option to show 30m/1h BB dots on daily charts

## Best Practices

1. **Combine with Other Indicators**: BBs work best with volume and structure
2. **Watch for Squeezes**: Narrowing bands often precede big moves
3. **Respect the Bands**: Bands act as dynamic support/resistance
4. **Multiple Timeframes**: When enabled, use higher timeframe BBs for context
5. **Volume Confirmation**: Require volume on BB breakouts

## Technical Details

### Standard BB Calculation
```pinescript
basis = ta.sma(src_bb, length)
dev = mult * ta.stdev(src_bb, length)
upper_band = basis + dev
lower_band = basis - dev
```

### Multi-Timeframe BB (Disabled)
```pinescript
// Variables declared but calculations removed
var float bb_lower_30m = na
var float bb_lower_1h = na
// ... etc
```

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [RMV Indicator](rmv-indicator.md) - Also uses volatility concepts
- [Floating Labels](floating-labels.md) - BB values displayed in labels


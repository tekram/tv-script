# RMV (Range Movement Volatility) Indicator

## Overview
RMV (Range Movement Volatility) is an ATR-based volatility indicator that normalizes volatility to identify low-volatility periods that often precede significant price moves. It helps traders identify consolidation zones and potential breakout setups.

## How It Works

### Calculation Method
1. **Multiple ATR Periods**: Calculates ATR using 3 different periods (default: 3, 5, 8)
2. **Average ATR**: Averages the three ATR values
3. **Normalization**: Normalizes the average ATR within a lookback period (default: 5 bars)
4. **RMV Score**: Converts to percentage (0-100)

### Formula
```pinescript
// Calculate ATRs
atr1 = ta.atr(atrLength1)  // Default: 3
atr2 = ta.atr(atrLength2)  // Default: 5
atr3 = ta.atr(atrLength3)  // Default: 8

// Average ATR
avgATR = (atr1 + atr2 + atr3) / 3

// Normalize
minATR = ta.lowest(avgATR, normLength)
maxATR = ta.highest(avgATR, normLength)
rmv = 100 * (avgATR - minATR) / (maxATR - minATR)
```

## Color Zones

### Green Zone (RMV < 10)
- **Meaning**: Very tight volatility - potential breakout setup
- **Background**: Green background highlight (when enabled)
- **Signal**: Diamond shape below bars
- **Trading**: Look for breakouts from consolidation

### Blue Zone (RMV < 20)
- **Meaning**: Tight volatility
- **Signal**: Diamond shape below bars
- **Trading**: Monitor for potential moves

### Orange Zone (RMV < 30)
- **Meaning**: Moderate volatility
- **Signal**: Diamond shape below bars
- **Trading**: Normal market conditions

### Red Zone (RMV >= 30)
- **Meaning**: Wide volatility
- **Trading**: High volatility - avoid new positions

## Visual Elements

### Background Highlighting
- **Condition**: RMV < 10 and `showBackgroundRMV` enabled
- **Color**: Green background (color.rgb(76, 175, 79, 87))
- **Purpose**: Easy visual identification of low volatility periods

### Signal Dots
- **Location**: Below bars
- **Shape**: Diamond
- **Color**: Matches RMV zone color
- **Condition**: RMV < 30 and `showCross` enabled
- **Size**: Tiny

## Configuration Options

### ATR Settings
- **ATR Length 1**: Default 3
- **ATR Length 2**: Default 5
- **ATR Length 3**: Default 8
- **Normalization Lookback**: Default 5 bars

### Display Options
- **Show Below Bars**: Toggle signal dots (default: true)
- **Show Background**: Toggle green background highlight (default: true)
- **Cleanup Mode**: When enabled, background only shows if cleanup is off

## Trading Applications

### Breakout Trading
- **Low RMV (< 10)**: Indicates tight consolidation - watch for breakouts
- **Breakout Confirmation**: Combine with volume and price action
- **Entry Timing**: Enter on breakouts from low RMV zones

### Position Sizing
- **Low RMV**: Smaller position size initially (breakout may be explosive)
- **High RMV**: Larger position size (more predictable moves)

### Risk Management
- **Low RMV Breakouts**: Set stops wider (volatility expansion expected)
- **High RMV**: Tighter stops (already volatile)

## Best Practices

1. **Wait for Extremes**: Focus on RMV < 10 for best setups
2. **Combine with Structure**: Use with 21 EMA structure for entries
3. **Volume Confirmation**: Low RMV + high volume = strong breakout signal
4. **Multiple Timeframes**: Check RMV on daily and intraday charts
5. **Avoid High RMV**: Don't add positions when RMV > 30

## Technical Details

### Normalization Logic
The normalization process ensures RMV is always between 0-100:
- **0**: Lowest volatility in lookback period
- **100**: Highest volatility in lookback period
- **Current RMV**: Where current volatility sits relative to recent range

### Why Multiple ATR Periods?
Using 3 different ATR periods provides:
- **Smoother Signal**: Reduces noise from single-period ATR
- **Better Detection**: Catches volatility changes across different timeframes
- **More Reliable**: Less prone to false signals

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [21 EMA Structure Indicator](21ema-structure.md)


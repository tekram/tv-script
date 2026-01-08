# Launch Pad Detection

## Overview
Launch Pad detection identifies consolidation zones where multiple moving averages converge within tight ranges. These zones often precede significant price moves, making them ideal entry points for swing and position trades.

**Credit**: Ray from Trader Lion

## Types of Launch Pads

### Swing Launch Pad
**Condition**: 5, 10, and 20 EMAs all within 3.5% of each other

**Formula**:
```pinescript
five_diff = (close - five_dema) / close
ten_diff = (close - ten_dema) / close
twenty_diff = (close - twenty_dema) / close

swing_launch_pad = math.abs(five_diff) < 0.035 and 
                   math.abs(ten_diff) < 0.035 and 
                   math.abs(twenty_diff) < 0.035
```

**Purpose**: Identifies short-term consolidation before swing moves (5-8 days)

### Position Launch Pad
**Condition**: 50 SMA, 10 EMA, and 20 EMA all within 3% of each other

**Formula**:
```pinescript
fifty_diff = (close - fifty_dsma) / close
ten_diff = (close - ten_dema) / close
twenty_diff = (close - twenty_dema) / close

pos_launch_pad = math.abs(fifty_diff) < 0.03 and 
                 math.abs(ten_diff) < 0.03 and 
                 math.abs(twenty_diff) < 0.03
```

**Purpose**: Identifies medium-term consolidation before position moves (longer holds)

## Visual Display

### Table Display
- **Location**: Top-right table
- **Background**: Aqua color
- **Text**: White
- **Row**: Shows when launch pad condition is met
- **Label**: "Swing Launch Pad" or "Position Launch Pad"

### Display Logic
- Only shows when `show_launch_pad` is enabled
- Displays both types if conditions are met
- Shows boolean value (true/false)

## Trading Applications

### Entry Strategy
1. **Wait for Launch Pad**: Don't enter until launch pad forms
2. **Watch for Breakout**: Price breaking out of launch pad zone
3. **Volume Confirmation**: Look for volume increase on breakout
4. **Structure Alignment**: Combine with 21 EMA structure for best setups

### Position Sizing
- **Swing Launch Pad**: Standard position size (5-8 day holds)
- **Position Launch Pad**: Larger position size (longer holds)

### Risk Management
- **Stop Placement**: Below launch pad zone
- **Target**: Measure move from launch pad to next resistance
- **Time Stop**: If no move after X days, consider exit

## Best Practices

1. **Patience**: Wait for launch pad to form - don't force entries
2. **Volume**: Require volume confirmation on breakout
3. **Structure**: Best when launch pad aligns with 21 EMA structure
4. **Market Context**: Launch pads work best in trending markets
5. **Multiple Confirmations**: Combine with other indicators

## Technical Details

### Moving Averages Used
- **5 EMA**: ta.ema(close, 5)
- **10 EMA**: ta.ema(close, 10)
- **20 EMA**: ta.ema(close, 20)
- **50 SMA**: ta.sma(close, 50)

### Percentage Calculation
- Uses percentage difference from close price
- Absolute value to check both above and below
- Threshold: 3.5% for swing, 3% for position

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [21 EMA Structure Indicator](21ema-structure.md)
- [Top Right Table Dashboard](top-right-table-dashboard.md)


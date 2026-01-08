# Inside Candle Patterns

## Overview
Inside candle patterns identify consolidation periods where one candle is completely contained within the previous candle's range. These patterns often precede significant price moves and are valuable for identifying potential breakout setups.

## Types of Inside Patterns

### Inside Week
**Condition**: Previous week's high is lower than 2 weeks ago high, AND previous week's low is higher than 2 weeks ago low

**Formula**:
```pinescript
isInsideWeekCandle = (prior_week_high < twoPriorWeekHigh and 
                      prior_week_low > twoPriorWeekLow)
```

**Visual**: Purple background in top-right table
**Display**: Shows week high/low range when detected

### Inside Candle (Configurable Timeframe)
**Condition**: 2 bars ago high/low contains previous bar's high/low

**Formula**:
```pinescript
isInsideCandle = (twoPriorthirtyMinHigh >= prevThirtyMinHigh and 
                  twoPriorthirtyMinLow <= prevThirtyMinLow)
```

**Default Timeframe**: 30-min (configurable)
**Visual**: Shows in top-right table with timeframe label

## Configuration

### Timeframe Selection
- **Input**: `insideCandleTimeframe` (default: '30')
- **Options**: Any valid TradingView timeframe
- **Common Choices**: '30', '60', '240', 'D'

### Display Options
- **Show 30 Min**: Toggle 30-min inside candle display
- **Table Display**: Shows in top-right table when detected

## Visual Display

### Inside Week Display
- **Background**: Purple (color.rgb(49, 27, 146, 73))
- **Text**: Shows "Inside Week (high - low)"
- **Additional Info**: Includes inside candle detection if present

### Inside Candle Display
- **Background**: Green/red based on prior high difference
- **Text**: Shows timeframe, prior high, percentage difference, RSI
- **Format**: "30 Min / Prior High / RSI" or similar

## Trading Applications

### Breakout Trading
- **Setup**: Inside pattern forms = consolidation
- **Entry**: Breakout above/below inside range
- **Confirmation**: Volume increase on breakout
- **Target**: Measure move from inside range

### Position Building
- **Inside Week**: Potential for larger moves
- **Inside Candle**: Shorter-term consolidation
- **Multiple Patterns**: Stronger signal when both present

### Risk Management
- **Stop Placement**: Below inside range low (for longs)
- **False Breakouts**: Wait for confirmation before entering
- **Time Factor**: If no breakout after X bars, pattern may fail

## Best Practices

1. **Wait for Confirmation**: Don't enter until breakout occurs
2. **Volume Check**: Require volume increase on breakout
3. **Structure Alignment**: Best when inside pattern aligns with structure
4. **Multiple Timeframes**: Check inside patterns on multiple timeframes
5. **Market Context**: Inside patterns work best in trending markets

## Technical Details

### Data Fetching
```pinescript
// Weekly data
[prior_week_high, prior_week_low, twoPriorWeekHigh, twoPriorWeekLow] = 
    request.security(syminfo.tickerid, 'W', 
        [high[1], low[1], high[2], low[2]], 
        lookahead=barmerge.lookahead_on)

// Configurable timeframe data
twoPriorthirtyMinHigh = request.security(syminfo.tickerid, 
                                         insideCandleTimeframe, high[2])
twoPriorthirtyMinLow = request.security(syminfo.tickerid, 
                                        insideCandleTimeframe, low[2])
prevThirtyMinHigh = request.security(syminfo.tickerid, 
                                     insideCandleTimeframe, high[1])
prevThirtyMinLow = request.security(syminfo.tickerid, 
                                    insideCandleTimeframe, low[1])
```

### Display Logic
- Inside week takes priority if both patterns detected
- Shows timeframe-specific label when only inside candle detected
- Includes RSI and prior high percentage difference

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [Top Right Table Dashboard](top-right-table-dashboard.md)
- [RMV Indicator](rmv-indicator.md)


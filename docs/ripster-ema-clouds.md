# Ripster EMA Clouds System

## Overview
The Ripster EMA Clouds system provides multiple layers of EMA cloud analysis to identify trend direction across different timeframes. This system uses 5 different EMA cloud pairs, each representing different trend periods.

**Credit**: © ripster47 - Original "Ripster EMA Clouds + RSI" script

## Cloud Structure

### Cloud 1: Short-Term (8 EMA / 9 EMA)
- **Default**: Enabled
- **Colors**: Green (#03610387) when bullish, Red (#880e4f82) when bearish
- **Purpose**: Very short-term trend direction

### Cloud 2: Primary Cloud (5 EMA / 13 EMA)
- **Default**: Enabled
- **Colors**: Green (color.rgb(50, 126, 53, 84)) when bullish, Red (color.rgb(244, 67, 54, 83)) when bearish
- **Purpose**: Primary trend cloud - most visible
- **Special**: Dynamically hidden on 30-min/60-min timeframes when `hide_clouds` is enabled

### Cloud 3: Medium-Term (34 EMA / 50 EMA)
- **Default**: Disabled
- **Colors**: Blue (#2196f3) when bullish, Orange (#ffb74d) when bearish
- **Purpose**: Medium-term trend direction

### Cloud 4: Long-Term (72 EMA / 89 EMA)
- **Default**: Enabled (but hidden by default)
- **Colors**: Teal (#009688) when bullish, Pink (#f06292) when bearish
- **Display**: Hidden by default (`display = display.none`)

### Cloud 5: Very Long-Term (180 EMA / 200 EMA)
- **Default**: Enabled (but hidden by default)
- **Colors**: Cyan (#05bed5) when bullish, Orange (#e65100) when bearish
- **Display**: Hidden by default (`display = display.none`)

## Configuration Options

### EMA Lengths
- **Short EMA1**: Default 8
- **Long EMA1**: Default 9
- **Short EMA2**: Default 5
- **Long EMA2**: Default 13
- **Short EMA3**: Default 34
- **Long EMA3**: Default 50
- **Short EMA4**: Default 72
- **Long EMA4**: Default 89
- **Short EMA5**: Default 180
- **Long EMA5**: Default 200

### Display Options
- **MA Type**: EMA or SMA (default: EMA)
- **Source**: Default hl2 (high-low average)
- **Offset**: Leading period offset (default: 0)
- **Show EMA Lines**: Toggle to display actual EMA lines
- **Show Each Cloud**: Individual toggles for each cloud (1-5)

### Visual Settings
- **Hide Cloud Fill**: Option to hide cloud fills (affects Cloud 2 on 30/60-min)
- **Line Colors**: 
  - Short EMAs: Olive when rising, Maroon when falling
  - Long EMAs: Green when rising, Red when falling

## Trading Applications

### Trend Confirmation
- **Multiple Clouds Bullish**: Strong uptrend across timeframes
- **Multiple Clouds Bearish**: Strong downtrend across timeframes
- **Mixed Signals**: Transitional or choppy market

### Timeframe Analysis
- **Cloud 1-2**: Short-term momentum
- **Cloud 3**: Medium-term trend
- **Cloud 4-5**: Long-term trend context

### Entry Signals
- **Cloud Crossovers**: When short EMA crosses above long EMA = bullish signal
- **Cloud Alignment**: All visible clouds bullish = high probability setup
- **Cloud Divergence**: Short-term cloud bullish while long-term bearish = potential reversal

## Technical Details

### Calculation Method
```pinescript
// Function to calculate MA
f_ma(malen) =>
    float result = na
    if matype == 'EMA'
        result := ta.ema(src, malen)
    if matype == 'SMA'
        result := ta.sma(src, malen)
    result

// Cloud color logic
cloudcolour = mashort >= malong ? bullish_color : bearish_color
```

### Dynamic Display Logic
- Cloud 2 is conditionally hidden on 30-min/60-min timeframes when `hide_clouds` is enabled
- This prevents visual clutter on intraday charts

## Best Practices

1. **Start with Cloud 2**: The 5/13 cloud is the primary trend indicator
2. **Add Context**: Enable Cloud 3 for medium-term context
3. **Long-term View**: Enable Cloud 4-5 for position trading context
4. **Watch Crossovers**: Cloud crossovers often precede price moves
5. **Respect Alignment**: All clouds aligned = strongest signals

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [21 EMA Structure Indicator](21ema-structure.md)
- [Bottom Right Table - EMA Clouds](bottom-right-table-README.md)


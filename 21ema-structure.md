# 21 EMA Structure Indicator

## Overview
The 21 EMA Structure is a powerful moving average indicator that provides a comprehensive view of price action relative to moving averages. This feature calculates separate moving averages for High, Close, and Low prices, creating a visual "structure" that helps identify trend direction and key support/resistance levels.

## Concept Origin
This indicator is inspired by [Alex's Swing Trading System](https://traderslab.gitbook.io/primetrading) from PrimeTrading Academy, which emphasizes trading pullbacks to the 21-day moving average structure. The methodology focuses on:
- Market timing
- Relative strength
- Disciplined position management
- Trading pullbacks to structure rather than chasing breakouts

## Key Features

### Three MA Lines
- **High MA**: Moving average of the high prices
- **Close MA**: Moving average of the close prices (center line)
- **Low MA**: Moving average of the low prices

### Visual Cloud
- Gray fill between High and Low MAs
- Creates a visual "structure" zone
- Makes it easy to see price boundaries and support/resistance areas

### Trend Detection
- Center line (Close MA) changes color based on trend direction
- **Uptrend**: When all three MAs are rising together
- **Downtrend**: When all three MAs are falling together
- Color changes only when all three MAs agree on direction

### Timeframe Awareness
- Automatically adapts to your chart timeframe
- **Daily charts**: Uses Daily MA settings (default: 21-period EMA)
- **Weekly charts**: Uses Weekly MA settings (default: 10-period SMA)
- Separate length and type settings for each timeframe

## Configuration Options

### MA Settings
- **Daily MA Length**: Default 21 periods
- **Daily MA Type**: EMA or SMA (default: EMA)
- **Weekly MA Length**: Default 10 periods
- **Weekly MA Type**: EMA or SMA (default: SMA)

### Color Customization
- **High MA Color**: Customizable (default: gray)
- **Close MA Uptrend Color**: Color when trend is up (default: light gray)
- **Close MA Downtrend Color**: Color when trend is down (default: magenta)
- **Low MA Color**: Customizable (default: gray)
- **Use Custom Colors**: Toggle to use custom colors or default gray

### Bar Coloring (Optional)
- **Change Bar Color**: Enable/disable bar coloring based on MA structure
- **Bullish Color**: Bars above all MAs (default: black)
- **Bearish Color**: Bars below structure (default: magenta)
- **Bearish Condition**: Choose between:
  - "High below lowest MA" (default)
  - "Close below all MAs"

### Visual Settings
- **Line Size**: Adjustable thickness for all MA lines (default: 1)
- **Cloud Color**: Customizable gray fill color

## Default Settings
- **Display**: Enabled by default
- **Daily**: 21-period EMA
- **Weekly**: 10-period SMA
- **Colors**: Custom colors enabled
- **Bar Coloring**: Disabled by default

## Trading Applications

### Entry Signals
- **Pullback to Structure**: Look for price to pull back into the MA structure zone
- **Reclaim of Structure**: Price reclaiming the structure after a break
- **Trend Alignment**: All three MAs moving in the same direction

### Risk Management
- **Structure Break**: Use Low MA break as a stop-loss level
- **Trend Reversal**: Center line color change indicates potential trend shift
- **Support/Resistance**: High and Low MAs act as dynamic support/resistance

### Position Sizing
- **Closer to Structure**: Larger position size when price is near structure
- **Extended from Structure**: Smaller position size when price is extended (>1x ATR above 21dma)

## Integration with Trading System

### PrimeTrading Methodology
This indicator integrates with Alex's swing trading system principles:
- **No Breakouts**: Wait for pullbacks to structure
- **Structure First**: Price action relative to structure is primary
- **Market Timing**: Use in conjunction with market breadth indicators
- **Relative Strength**: Combine with RS analysis for best setups

### Best Practices
1. **Daily Charts**: Use for swing trade entries (5-8 day holds)
2. **Weekly Charts**: Use for position trade entries (longer holds)
3. **Structure Confluence**: Look for weekly structure alignment on daily charts
4. **Avoid Extended**: Don't buy >1x ATR above the 21dma structure

## Technical Details

### Calculation Method
```pinescript
// Function to calculate MA
getMaStructure(src, length, maType) =>
    switch maType
        'SMA' => ta.sma(src, length)
        'EMA' => ta.ema(src, length)
        => ta.ema(src, length) // default to EMA

// MA calculations
maStructureHigh = getMaStructure(high, maStructureLength, maStructureType)
maStructureClose = getMaStructure(close, maStructureLength, maStructureType)
maStructureLow = getMaStructure(low, maStructureLength, maStructureType)
```

### Trend Detection Logic
```pinescript
// Trend direction (all 3 MAs must agree)
isRisingMA = maStructureHigh > maStructureHigh[1] and 
             maStructureClose > maStructureClose[1] and 
             maStructureLow > maStructureLow[1]

isFallingMA = maStructureHigh < maStructureHigh[1] and 
              maStructureClose < maStructureClose[1] and 
              maStructureLow < maStructureLow[1]
```

## Credits
- **BalarezoCapital**: Original MA Structure concept
- **PrimeTrading**: Modifications and enhancements
- **Alex's Swing Trading System**: [PrimeTrading Academy](https://traderslab.gitbook.io/primetrading) - Inspiration for the 21EMA structure trading methodology

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [Top Right Table - Market Data Dashboard](top-right-table-dashboard.md)
- [Bottom Right Table - EMA Clouds & Market Breadth](bottom-right-table-README.md)


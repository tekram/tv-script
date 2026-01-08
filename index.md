# Swing Dashboard - TradingView Script

## Overview
A comprehensive TradingView Pine Script indicator that provides swing traders with essential market data, technical analysis, and trading signals in an organized dashboard format.

## Version Information
- **Current Version**: 2.1 (MA Structure Integration)
- **Original Credits**: MikeC (first version), Fred6724 (contributions), TheScrutiniser & GlinckEastwoot (ADR% formula)
- **MA Structure**: Based on BalarezoCapital's original, modified by PrimeTrading
- **21EMA Structure Concept**: Inspired by [Alex's Swing Trading System](https://traderslab.gitbook.io/primetrading) from PrimeTrading Academy
- **Optimization**: Reduced from 47 to 24 request calls to work within TradingView plan limits

## Key Features

### Market Data Dashboard
- **Market Cap** & **Float %** calculations
- **ADR%** (Average Daily Range percentage) with today's range
- **ATR** (Average True Range) measurements
- **LoD Distance** (Low of Day distance from current price)
- **Volume Analysis**:
  - Average Daily Volume & Dollar Volume
  - Projected Volume calculations
  - Relative Volume measurements
  - Volume Buzz indicators

### Technical Analysis
- **MA Structure** (NEW in v2.1):
  - Adjustable Moving Average structure with High, Close, and Low MAs
  - Timeframe-aware (Daily/Weekly) with separate length and type settings
  - Trend-based color coding for center line (Close MA)
  - Customizable colors for all MA lines
  - Optional bar coloring based on price position relative to MAs
  - Gray cloud fill between High and Low MAs
  - Default display enabled for immediate visibility
- **EMA Clouds** with trend analysis (5-12, 34-50 EMAs)
- **VIX Clouds** for market sentiment analysis
- **Extended EMA/SMA** calculations from key moving averages
- **Launch Pad** detection for swing and position trades
- **RSI** integration with EMA analysis
- **Bollinger Bands** (removed in optimization to reduce calls)

### Market Breadth & Sentiment
- **Sector** & **Industry Group** display
- **Market Breadth** indicators (% above VWAP, TICK readings)
- **SPY Analysis** with moving average relationships
- **Inside Candle** detection (30-min & weekly patterns)

### MA Structure Feature (v2.1)

The MA Structure indicator provides a comprehensive view of price action relative to moving averages. This concept is inspired by [Alex's Swing Trading System](https://traderslab.gitbook.io/primetrading) from PrimeTrading Academy, which emphasizes trading pullbacks to the 21-day moving average structure.

**Key Features:**
- **Three MA Lines**: Calculates separate MAs for High, Close, and Low prices
- **Timeframe Awareness**: Automatically uses Daily settings on daily charts, Weekly settings on weekly charts
- **Trend Detection**: Center line (Close MA) changes color based on trend direction when all three MAs agree
- **Visual Cloud**: Gray fill between High and Low MAs for easy structure visualization
- **Bar Coloring**: Optional feature to color bars based on price position relative to MAs

**Configuration Options:**
- **Daily/Weekly Settings**: Separate length and type (SMA/EMA) for each timeframe
- **Color Customization**: 
  - Custom colors for High, Close (uptrend/downtrend), and Low MAs
  - Toggle to use custom colors or default gray
- **Bar Coloring**: Enable/disable bar color changes based on MA structure
- **Bearish Condition**: Choose between "High below lowest MA" or "Close below all MAs"
- **Line Size**: Adjustable thickness for all MA lines

**Default Settings:**
- Daily: 21-period EMA
- Weekly: 10-period SMA
- Display: Enabled by default
- Colors: Custom colors enabled

### Customization Options
- Toggle individual dashboard components on/off
- Adjustable table sizes and colors
- Configurable EMA/SMA lengths
- Timeframe-specific settings
- Display preferences for charts and tables
- MA Structure customization (colors, lengths, types)

## Installation & Usage

### Requirements
- TradingView account with Pine Script v6 support
- Minimum plan supporting 24+ request calls

### How to Install
1. Copy the entire script from `top-right-table` file
2. Open TradingView Pine Editor
3. Paste the script and save
4. Add to any chart as an overlay indicator

### Configuration
Use the input settings to customize:
- **Dashboard Display**: Toggle individual data sections
- **Technical Indicators**: Enable/disable EMA clouds, RSI, etc.
- **Visual Settings**: Colors, table sizes, positioning
- **Timeframes**: Set analysis periods for various calculations
- **MA Structure Settings**: Configure MA lengths, types, and colors

## Optimization Details (Version 2.0)

### Request Call Reduction
- **Original**: 47 unique `request.*()` calls
- **Optimized**: 24 unique `request.*()` calls
- **Method**: Consolidated multiple requests into single array-based calls

### Key Optimizations
1. **Daily Data Consolidation**: Combined ADR, ATR, LoD distance into one request
2. **Volume Data Consolidation**: Merged volume, avg volume, close price requests
3. **Timeframe Data Consolidation**: Combined 30-min, weekly, and SPY data requests
4. **Removed Redundant Features**: Eliminated Bollinger Band calculations (12 calls)

### Maintained Functionality
- All core swing trading analysis features preserved
- Market breadth indicators intact
- Technical analysis tools fully functional
- Customization options unchanged

## Troubleshooting

### Common Issues
- **"Too many request calls" error**: Ensure you're using Version 2.1
- **Compilation errors**: Check for proper syntax in Pine Editor
- **Missing data**: Verify symbol has sufficient historical data

### Performance Tips
- Disable unused dashboard components for faster loading
- Use appropriate timeframes for optimal performance
- Consider upgrading TradingView plan for additional features

## Version 2.1 Updates

### New Features
- **MA Structure Integration**: Added adjustable MA structure indicator with High, Close, and Low MAs
- **Enhanced Color Options**: Customizable colors for all MA lines with toggle option
- **Default Display**: MA Structure now displays by default for immediate visibility
- **Improved User Control**: Option to use custom colors or default gray colors

### MA Structure Benefits
- Provides clear visual structure of price action relative to moving averages
- Helps identify trend direction through color-coded center line
- Cloud visualization makes it easy to see price structure boundaries
- Timeframe-aware settings adapt to your chart timeframe automatically

## File Structure
- `top-right-table`: Complete optimized Swing Dashboard script with MA Structure (v2.1)
- `bottom-right-table`: Additional table component (see separate documentation)

## Credits & Acknowledgments

### Original Script Credits
- **MikeC**: First version of the Swing Dashboard
- **Fred6724**: Contributions and updates
- **TheScrutiniser & GlinckEastwoot**: ADR% formula
- **Ripster47**: Original EMA Clouds + RSI script source

### MA Structure Credits
- **BalarezoCapital**: Original MA Structure concept
- **PrimeTrading**: Modifications and enhancements
- **Alex's Swing Trading System**: [PrimeTrading Academy](https://traderslab.gitbook.io/primetrading) - Inspiration for the 21EMA structure trading methodology

The MA Structure feature integrates concepts from Alex's comprehensive swing trading system, which focuses on trading pullbacks to structure (21-day moving average) and emphasizes market timing, relative strength, and disciplined position management.

## Support
For issues specific to the optimization, refer to the version comments in the script header. For original functionality questions, consult the credit sources mentioned above. For more information on the 21EMA structure trading methodology, visit [PrimeTrading Academy](https://traderslab.gitbook.io/primetrading).

## License
Mozilla Public License 2.0 - See script header for full license terms.

# Swing Dashboard - TradingView Script

## Overview
A comprehensive TradingView Pine Script indicator that provides swing traders with essential market data, technical analysis, and trading signals in an organized dashboard format.

## Version Information
- **Current Version**: 2.0 (Optimized)
- **Original Credits**: MikeC (first version), Fred6724 (contributions), TheScrutiniser & GlinckEastwoot (ADR% formula)
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

### Customization Options
- Toggle individual dashboard components on/off
- Adjustable table sizes and colors
- Configurable EMA/SMA lengths
- Timeframe-specific settings
- Display preferences for charts and tables

## Installation & Usage

### Requirements
- TradingView account with Pine Script v6 support
- Minimum plan supporting 24+ request calls

### How to Install
1. Copy the entire script from `main` file
2. Open TradingView Pine Editor
3. Paste the script and save
4. Add to any chart as an overlay indicator

### Configuration
Use the input settings to customize:
- **Dashboard Display**: Toggle individual data sections
- **Technical Indicators**: Enable/disable EMA clouds, RSI, etc.
- **Visual Settings**: Colors, table sizes, positioning
- **Timeframes**: Set analysis periods for various calculations

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
- **"Too many request calls" error**: Ensure you're using Version 2.0
- **Compilation errors**: Check for proper syntax in Pine Editor
- **Missing data**: Verify symbol has sufficient historical data

### Performance Tips
- Disable unused dashboard components for faster loading
- Use appropriate timeframes for optimal performance
- Consider upgrading TradingView plan for additional features

## File Structure
- `main`: Complete optimized Swing Dashboard script
- `bottom-right-table`: Additional table component (see separate documentation)

## Support
For issues specific to the optimization, refer to the version comments in the script header. For original functionality questions, consult the credit sources mentioned above.

## License
Mozilla Public License 2.0 - See script header for full license terms.

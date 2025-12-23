# Bottom Right Table - EMA Cloud Component

## Overview
A specialized TradingView Pine Script component that creates EMA cloud analysis for intraday trading signals. This file contains the logic for the bottom-right table display showing trend cloud indicators.

## Purpose
This script is a modular component extracted from the main Swing Dashboard that focuses specifically on:
- **Intraday EMA Clouds** for trend analysis
- **VIX EMA Clouds** for market sentiment
- **Bottom-right table positioning** for chart display

## Key Features

### Intraday EMA Clouds
- **10-minute timeframe** analysis
- **5-12 EMA Cloud**: Short-term trend direction
- **34-50 EMA Cloud**: Medium-term trend direction
- **Color-coded signals**: Green for bullish, red for bearish

### VIX EMA Clouds
- **VIX sentiment analysis** using same EMA structure
- **Market fear/greed indicators**
- **Contrarian signals** for market timing

### Visual Indicators
- **Bullish/Bearish labels** for each cloud
- **Color-coded backgrounds** for quick visual reference
- **Table positioning** in bottom-right of chart

## Technical Details

### EMA Calculations
```pinescript
// 10-minute timeframe EMAs
[ema5, ema12, ema34, ema50] = request.security(syminfo.tickerid, '10', 
    [ta.ema(close, 5), ta.ema(close, 12), ta.ema(close, 34), ta.ema(close, 50)])
```

### Signal Logic
- **Short Cloud**: 5 EMA > 12 EMA = Bullish
- **Long Cloud**: 34 EMA > 50 EMA = Bullish
- **Opposite conditions** = Bearish

### Request Calls
- **2 total request calls**:
  1. Main symbol EMAs (4 values in single call)
  2. VIX EMAs (4 values in single call)

## Integration

### As Standalone Component
Use this script independently for focused EMA cloud analysis without the full dashboard complexity.

### With Main Dashboard
This component is integrated into the main Swing Dashboard script. The table positioning and logic are combined with other dashboard elements.

### Customization Options
- **EMA Lengths**: Adjustable for different trading styles
- **Timeframe**: Can be modified from 10-minute default
- **Colors**: Customizable for chart preferences

## Usage Instructions

### Installation
1. Copy the script to TradingView Pine Editor
2. Add as overlay indicator to any chart
3. Adjust input parameters as needed

### Interpretation
- **Green Clouds**: Bullish momentum
- **Red Clouds**: Bearish momentum
- **VIX Analysis**: Contrarian sentiment indicator
- **Combined Signals**: Strong trend confirmation when both clouds align

## Performance Benefits
- **Low request count** (2 calls) - efficient for all TradingView plans
- **Fast execution** - minimal calculations
- **Clean display** - focused information without clutter

## File Relationship
- **Main Dashboard**: Full-featured script with this component integrated
- **Bottom-Right Table**: Standalone version for focused EMA analysis
- **Modular Design**: Can be extracted and used independently

## Customization Examples

### Different Timeframes
```pinescript
timeframe = '15'  // Change to 15-minute
timeframe = '5'   // Change to 5-minute
```

### Alternative EMA Lengths
```pinescript
ema5_length = input.int(8, title = 'Length for 8 EMA')
ema12_length = input.int(21, title = 'Length for 21 EMA')
```

## Limitations
- Designed for intraday analysis
- Requires sufficient volume for accurate EMA calculations
- VIX data availability may vary by broker/data plan

## Support
This is a modular component of the larger Swing Dashboard system. For comprehensive support, refer to the main dashboard documentation.

# RS Rating / RS Line System

## Overview
The RS Rating system calculates a stock's relative strength performance compared to the S&P 500 over the past 12 months, providing a 1-99 rating similar to IBD's RS Rating. The RS Line visually displays the stock's relative performance vs. the market.

**Credit**: © Fred6724, RaviYendru (initial script)

## RS Rating (1-99 Scale)

### How It Works
1. **Performance Calculation**: Calculates stock and SPX performance over 4 quarters (63, 126, 189, 252 days)
2. **Weighted Average**: Last quarter weighted 40%, others 20% each
3. **Relative Score**: Compares stock performance to SPX performance
4. **Percentile Assignment**: Maps score to 1-99 percentile using market-wide calibration

### Rating Interpretation
- **90-99**: Top 10% performers - strongest stocks
- **70-89**: Top 30% performers - strong stocks
- **50-69**: Average performers
- **30-49**: Below average
- **1-29**: Weakest performers

### Calculation Formula
```pinescript
// Stock performance (weighted)
rs_stock = 0.4 * perfTicker63 + 0.2 * perfTicker126 + 
           0.2 * perfTicker189 + 0.2 * perfTicker252

// SPX performance (weighted)
rs_ref = 0.4 * perfComp63 + 0.2 * perfComp126 + 
         0.2 * perfComp189 + 0.2 * perfComp252

// Relative score
totalRsScore = rs_stock / rs_ref * 100
```

## RS Line

### Visual Display
- **Position**: Plotted below price (offset configurable)
- **Color**: Blue (customizable, default: color.rgb(0, 0, 255, 50))
- **Calculation**: `close / comparativeSymbol * rsRatio`
- **Purpose**: Visual representation of relative strength trend

### RS Line Features
- **Comparative Symbol**: Default SP:SPX (customizable)
- **Offset**: Adjustable percentage to position line below price
- **Timeframe Aware**: Different offsets for daily vs weekly
- **Industry Adjustment**: Special offset for Investment Trusts/Mutual Funds

## RS New Highs / New Lows

### Blue Dots (RS New Highs)
- **Types**:
  - RS New Highs: Current RS making new high
  - RS New Highs Before Price: RS new high before price makes new high
  - Historical RS New Highs: All-time RS new highs
  - Historical RS New Highs Before Price: Historical RS new highs before price
- **Lookback**: Default 250 days (52 weeks on weekly charts)
- **Purpose**: Identifies relative strength leadership

### Red Dots (RS New Lows)
- **Types**: Similar options for new lows
- **Purpose**: Identifies relative weakness

## MA Overlays on RS Line

### 1st MA on RS Line
- **Length**: Default 21 (daily), 10 (weekly)
- **Type**: EMA or SMA (configurable)
- **Color**: Orange (default)
- **Fill**: Optional positive/negative area coloring

### 2nd MA on RS Line
- **Length**: Default 50 (daily), 21 (weekly)
- **Type**: EMA or SMA (configurable)
- **Color**: Red (default)

## Percentile Calibration

### Market-Wide Calibration
- **Method**: Uses `request.seed()` to access market-wide RS scores
- **Source**: seed_fred6725_rs_rating (RSRATING)
- **Calibration Points**: 7 levels corresponding to percentiles 98, 89, 69, 49, 29, 9, 1
- **Auto-Update**: Daily updates via GitHub workflow

### Replay Mode
- **Purpose**: Fixed values for historical analysis
- **Values**: Pre-configured percentile thresholds
- **Usage**: When seed data unavailable

## Configuration Options

### RS Line Settings
- **Hide Rating**: Toggle RS Rating display
- **Rating Only**: Show only rating number
- **Color**: Customizable RS Line color
- **Comparative Symbol**: Default SP:SPX
- **SpxValue**: Approximate SPX value for scaling (default: 4200)
- **Offset**: Percentage offset below price (default: 80%)

### RS New Highs/Lows
- **Plot New Highs**: Toggle blue dots
- **Type**: Choose display type
- **Lookback**: Days/weeks for calculation
- **Size**: Label size (Tiny/Small/Normal/Large)
- **Color**: Customizable dot colors

### MA Settings
- **Display MA 1/2**: Toggle MA overlays
- **Length**: Daily and weekly lengths
- **Type**: SMA or EMA
- **Color**: Customizable
- **Area Color**: Positive/negative fill colors

## Trading Applications

### Stock Selection
- **High RS Rating (80+)**: Focus on strongest relative strength stocks
- **RS New Highs**: Stocks making new RS highs often continue higher
- **RS Line Trend**: Rising RS Line = outperforming market

### Entry Timing
- **RS New High Before Price**: Early signal of strength
- **RS Line Above MA**: Relative strength accelerating
- **High RS + Structure**: Best setups combine high RS with good structure

### Risk Management
- **RS Rating Declining**: Reduce exposure
- **RS New Lows**: Exit signal
- **RS Line Breakdown**: Relative strength weakening

## Best Practices

1. **Focus on High RS**: Only trade stocks with RS Rating > 70
2. **Watch RS New Highs**: Blue dots often precede price moves
3. **RS Line Trend**: Rising RS Line = favorable
4. **Combine with Structure**: High RS + pullback to structure = best setups
5. **Monitor Declines**: RS Rating drops = reduce exposure

## Technical Details

### Percentile Assignment
The system uses a complex percentile mapping function that:
- Takes the relative RS score
- Compares to market-wide calibration data
- Assigns percentile rating based on distribution curve
- Accounts for non-linear distribution of RS scores

### Data Sources
- **Stock Data**: Daily close prices from current symbol
- **SPX Data**: Daily close prices from SP:SPX
- **Market Calibration**: request.seed('seed_fred6725_rs_rating', 'RSRATING')

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [21 EMA Structure Indicator](21ema-structure.md)


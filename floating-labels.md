# Floating Labels System

## Overview
The Floating Labels system provides dynamic, right-side labels that display key technical information including Bollinger Band values, EMA extensions, pivot points, and Low of Day levels. These labels update in real-time and can be positioned to avoid chart clutter.

## Label Types

### 1. Bollinger Band Values Label
**Location**: Below price (low[1] - 2 * ATR)  
**Content**: BB values for multiple timeframes (30m, 1h, 2h, 4h, 6h)  
**Format**: 
```
30M: lower / upper
1H: lower / upper
2H: lower / upper
4H: lower / upper
6H: lower / upper
```
**Color**: Blue background, white text  
**Status**: Currently shows placeholder values (calculations removed to reduce calls)

### 2. EMA Values Label
**Location**: Above price (low[1] + 2 * ATR)  
**Content**: Extended EMA values and percentages  
**Format**:
```
20 EMA (hourly): X% (value) / extended
5 EMA: X% (value) / extended
10 EMA: X% (value) / extended
20 EMA: X% (value) / extended
```
**Background**: Green when positive, red when negative  
**Color**: White text

### 3. Pivot Points Label
**Location**: Above price (low[1] + 4 * ATR)  
**Content**: R1, Pivot, S1, S2 values  
**Format**: `R1: X.XXX \Pivot: X.XXX \S1: X.XXX \S2: X.XXX`  
**Color**: Orange background, white text

### 4. Low of Day Label
**Location**: At previous day's low price  
**Content**: Previous day's low value  
**Format**: Price value  
**Background**: Green if low < close, red if low > close  
**Color**: White text

## Configuration Options

### Display Toggles
- **Remove Right Sided Floating Prices**: Master toggle to hide all floating labels
- **Show Pivot Labels**: Toggle pivot point label
- **Right Sided Floats Offset**: Number of bars offset (default: 15)

### Visual Settings
- **Label Style**: Left-aligned labels
- **Label Colors**: Customizable per label type
- **Position Offset**: Configurable bar offset

## Technical Details

### Label Management
```pinescript
// Label creation with cleanup
var label bb_label = na
if not na(bb_label)
    label.delete(bb_label)
if not remove_floats
    bb_label := label.new(bar_index + float_offset, price, text, ...)
```

### Dynamic Positioning
- Labels positioned relative to current bar index
- Offset adjustable to avoid overlap
- Y-position based on price levels (ATR multiples)

### Update Logic
- Labels update on each bar
- Previous labels deleted before creating new ones
- Prevents label accumulation

## Trading Applications

### Quick Reference
- **BB Values**: Quick reference for support/resistance levels
- **EMA Extensions**: See how extended price is from key MAs
- **Pivot Points**: Intraday support/resistance levels
- **LoD**: Previous day's support level

### Position Management
- **LoD Label**: Visual reference for stop placement
- **Pivot Label**: Entry/exit levels for day trading
- **EMA Label**: Extension levels for position sizing

## Best Practices

1. **Adjust Offset**: Set offset to avoid overlapping with price action
2. **Use Selectively**: Enable only labels you actively use
3. **Combine with Lines**: Labels complement line drawings
4. **Clean Display**: Hide labels when not needed to reduce clutter
5. **Multiple Timeframes**: Check labels on different timeframes

## Related Documentation
- [Main Dashboard Documentation](README.md)
- [Pivot Points System](pivot-points.md)
- [Extended EMA Analysis](extended-ema-analysis.md)
- [Bollinger Bands](bollinger-bands.md)


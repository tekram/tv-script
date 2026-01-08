# Swing Dashboard - Trading Instructions Guide

## Table of Contents
1. [Quick Start](#quick-start)
2. [Understanding the Dashboard](#understanding-the-dashboard)
3. [Trading Strategies](#trading-strategies)
4. [Entry Signals](#entry-signals)
5. [Exit Signals](#exit-signals)
6. [Risk Management](#risk-management)
7. [Market Conditions](#market-conditions)
8. [Advanced Techniques](#advanced-techniques)
9. [Common Scenarios](#common-scenarios)

---

## Quick Start

### Setup Requirements
- **TradingView Account**: Free account works, but paid plan recommended for full functionality
- **Timeframes**: Best on 15-min, 30-min, 1-hour, and 4-hour charts
- **Asset Classes**: Optimized for stocks, ETFs, and major indices

### Initial Configuration
1. **Load the Script**: Add `top-right-table` to your chart
2. **Key Settings to Enable**:
   - ✅ Show ADR% (default on)
   - ✅ Show LoD dist. (default on)
   - ✅ Show Avg Daily Volume (default on)
   - ✅ Show Projected Volumes (default on)
   - ✅ Show Relative Volume (default on)
   - ✅ Show Clouds (default on)
   - ✅ Show Trend Labels (default on)
   - ✅ Show 30 Min (default on)
   - ✅ Show Sector (default on)
   - ✅ Show Ind. Grp (default on)

### Recommended Additional Settings
- **Show Extended**: Enable for EMA/SMA analysis
- **Show Launch Pad**: Enable for trade setup detection
- **Show Market Breadth**: Enable for market context
- **Show 3 EMA + RSI**: Enable for overbought/oversold analysis

---

## Understanding the Dashboard

### Top Right Table - Market Data
```
Market Cap: 2.5B          Float %: 15.2%
ADR% / Today Range: 3.2% / 2.1%
LoD dist. / (H/L): 85% / 152.45 / 148.20
Avg Vol: 15.2M           Proj. Vol / Rel. Vol: 18.5M / 122%
30 Min / Prior High / RSI: Inside Candle 152.30 (0.8%) / 65.4
Sector: Technology        Ind. Grp: Software
```

### Bottom Right Table - Trend Analysis
```
5-12 Cloud      34-50 Cloud      VIX 5-12 Cloud      VIX 34-50 Cloud
Bullish         Bullish           Bearish             Bearish
5% Breadth      20% Breadth      Trade Condition      Days SPY > 20 EMA
GO (< 20) 18%   Warning 78%     Market Above 50 Day 12  3
```

### Key Metrics Explained

#### **ADR% (Average Daily Range %)**
- **What it measures**: Typical daily price movement percentage
- **Trading use**: 
  - Low ADR% (< 2%): Consolidation, avoid breakout trades
  - Normal ADR% (2-4%): Good for swing trades
  - High ADR% (> 4%): High volatility, wider stops needed

#### **LoD Distance (Low of Day Distance)**
- **What it measures**: How far current price is from daily low
- **Trading use**:
  - < 20%: Near daily lows, potential reversal zone
  - 20-80%: Normal trading range
  - > 80%: Near daily highs, momentum plays

#### **Relative Volume**
- **What it measures**: Current volume vs. average volume
- **Trading use**:
  - < 50%: Low participation, avoid trades
  - 50-150%: Normal volume, standard setups
  - > 150%: High participation, breakout potential

#### **EMA Clouds**
- **5-12 Cloud**: Short-term trend (1-3 days)
- **34-50 Cloud**: Medium-term trend (1-2 weeks)
- **Bullish Cloud**: Short EMA above Long EMA (green)
- **Bearish Cloud**: Short EMA below Long EMA (red)

---

## Trading Strategies

### Strategy 1: Trend Following (Primary Strategy)

#### **Conditions for Long Trades**
1. **Market Context**:
   - SPY above 20 and 50 EMA (Bullish market)
   - VIX clouds showing bearish (low volatility)
   - Market breadth: % above 20 SMA < 75%

2. **Stock-Specific Setup**:
   - Both 5-12 and 34-50 clouds bullish
   - Price above key EMAs (20, 50, 200)
   - Relative volume > 100%
   - ADR% > 2% (sufficient volatility)

3. **Entry Trigger**:
   - Break of 30-min inside candle high
   - OR Pullback to 20 EMA with bullish cloud support

#### **Conditions for Short Trades**
1. **Market Context**:
   - SPY below 20 and 50 EMA (Bearish market)
   - VIX clouds showing bullish (high volatility)
   - Market breadth: % above 20 SMA > 75%

2. **Stock-Specific Setup**:
   - Both 5-12 and 34-50 clouds bearish
   - Price below key EMAs
   - Relative volume > 100%
   - ADR% > 2%

### Strategy 2: Launch Pad Reversal

#### **Swing Launch Pad Detection**
- **Criteria**: Price within 3.5% of 5, 10, and 20 EMAs
- **Signal**: Coiling before breakout
- **Action**: Trade in direction of breakout with tight stops

#### **Position Launch Pad Detection**
- **Criteria**: Price within 3% of 10, 20, and 50 EMAs
- **Signal**: Major trend continuation setup
- **Action**: Larger position size, wider targets

### Strategy 3: Mean Reversion

#### **Extended EMA Analysis**
- **Overextended**: Price > 2 ATR from 20 EMA
- **Oversold**: Price < -2 ATR from 20 EMA
- **RSI Confirmation**: RSI < 30 or > 70
- **Volume Spike**: Relative volume > 200%

---

## Entry Signals

### High-Probability Long Setups

#### **Setup A: Bullish Cloud Breakout**
```
✅ 5-12 Cloud: Bullish
✅ 34-50 Cloud: Bullish  
✅ SPY: Above 20 & 50 EMA
✅ Volume: RelVol > 100%
✅ Price: Above 20 EMA
🎯 Entry: Break of 30-min high
🛡️ Stop: Below 20 EMA or recent low
🎯 Target: +2 ATR or next resistance
```

#### **Setup B: Pullback to Support**
```
✅ Trend: Bullish clouds intact
✅ Price: Pullback to 20/50 EMA
✅ Volume: Decreasing on pullback
✅ RSI: 40-50 range (not oversold)
🎯 Entry: Reversal candle at EMA
🛡️ Stop: Below recent low
🎯 Target: Previous high or +2 ATR
```

### High-Probability Short Setups

#### **Setup A: Bearish Cloud Breakdown**
```
✅ 5-12 Cloud: Bearish
✅ 34-50 Cloud: Bearish
✅ SPY: Below 20 & 50 EMA
✅ Volume: RelVol > 100%
✅ Price: Below 20 EMA
🎯 Entry: Break of 30-min low
🛡️ Stop: Above 20 EMA or recent high
🎯 Target: -2 ATR or next support
```

#### **Setup B: Rally to Resistance**
```
✅ Trend: Bearish clouds intact
✅ Price: Rally to 20/50 EMA
✅ Volume: Increasing at resistance
✅ RSI: 50-60 range (not overbought)
🎯 Entry: Reversal candle at EMA
🛡️ Stop: Above recent high
🎯 Target: Previous low or -2 ATR
```

---

## Exit Signals

### Profit Taking Rules

#### **Partial Profit Taking**
- **1st Target**: +1 ATR (close 50%)
- **2nd Target**: +2 ATR (close 50%)
- **Final Target**: +3-4 ATR or reversal signal

#### **Trailing Stops**
- **Initial Stop**: 1.5 ATR from entry
- **Trail**: Move to breakeven at +1 ATR
- **Trail**: 1 ATR below price after +2 ATR

### Stop Loss Rules

#### **Fixed Stop Loss**
- **Standard**: 1.5 ATR from entry
- **Volatility Adjustment**: 
  - High ADR% (>4%): 2 ATR stop
  - Low ADR% (<2%): 1 ATR stop

#### **Signal-Based Exit**
- **Cloud Change**: EMA cloud changes color
- **Volume Spike**: Exhaustion volume > 300% relative
- **RSI Divergence**: Price new high, RSI lower high

---

## Risk Management

### Position Sizing

#### **Base Position Size**
```
Account Size: $10,000
Risk per Trade: 1% ($100)
Stop Loss: 1.5 ATR ($2.00)
Position Size: 50 shares
```

#### **Volatility Adjustment**
- **Low Volatility** (ADR% < 2%): Full position
- **Normal Volatility** (ADR% 2-4%): 75% position
- **High Volatility** (ADR% > 4%): 50% position

### Daily Risk Limits
- **Maximum Daily Loss**: 2% of account
- **Maximum Open Positions**: 3-5 trades
- **Correlation Limit**: No more than 2 stocks in same sector

### Trade Management Rules

#### **When to Hold Overnight**
- **Bullish Market**: SPY above 20/50 EMA
- **Strong Trend**: Both EMA clouds aligned
- **Adequate Buffer**: > 1 ATR profit cushion

#### **When to Close Before Close**
- **Reversal Signals**: Cloud color change
- **Volume Exhaustion**: RelVol > 300% with price rejection
- **Market Close**: Within 30 minutes of close if not profitable

---

## Market Conditions

### Bull Market Conditions
```
✅ SPY: Above 20 & 50 EMA
✅ VIX: Bearish clouds (low volatility)
✅ Breadth: % above 20 SMA 30-70%
✅ Strategy: Trend following, buy dips
```

### Bear Market Conditions
```
✅ SPY: Below 20 & 50 EMA
✅ VIX: Bullish clouds (high volatility)
✅ Breadth: % above 20 SMA > 75%
✅ Strategy: Short rallies, cash preservation
```

### Sideways/Transition Market
```
✅ SPY: Between 20 & 50 EMA
✅ VIX: Mixed signals
✅ Breadth: Neutral readings
✅ Strategy: Range trading, reduced size
```

---

## Advanced Techniques

### Multi-Timeframe Analysis

#### **Daily Chart Confirmation**
- **Trend**: Above/below 20/50/200 EMAs
- **Volume**: Above average volume
- **Pattern**: Higher highs/higher lows (bullish)

#### **30-Min Entry Timing**
- **Inside Candle**: Wait for break of range
- **Volume Confirmation**: > 100% relative volume
- **RSI**: Not in extreme territory (< 30 or > 70)

### Sector Rotation Analysis

#### **Strong Sectors**
- **Technology**: Look for leaders in uptrend
- **Healthcare**: Defensive plays in bear markets
- **Finance**: Economic sensitivity plays

#### **Weak Sectors**
- **Avoid**: Sectors with bearish clouds
- **Short Opportunities**: Overextended sectors
- **Rotation**: Money flow indicators

### VIX Sentiment Trading

#### **VIX as Contrarian Indicator**
- **VIX Bullish Clouds**: Fear in market → Buy opportunities
- **VIX Bearish Clouds**: Complacency → Caution
- **VIX Extremes**: > 30 (extreme fear) or < 15 (complacency)

---

## Common Scenarios

### Scenario 1: Gap Up Open

#### **Morning Gap Strategy**
```
📊 Gap: > 1% above previous close
📈 Volume: > 200% relative volume
🎯 Strategy: Fade the gap if overextended
🛡️ Stop: Above gap high
🎯 Target: Fill gap or previous close
```

#### **Gap and Go Strategy**
```
📊 Gap: > 1% with strong volume
📈 Confirmation: Holds gap, breaks 30-min high
🎯 Strategy: Trade with gap direction
🛡️ Stop: Below gap low
🎯 Target: +2 ATR or resistance level
```

### Scenario 2: Inside Day Breakout

#### **Inside Week Pattern**
```
📊 Pattern: Weekly inside candle
📈 Breakout: Break of weekly range
🎯 Strategy: Trade breakout direction
🛡️ Stop: Inside of range
🎯 Target: Measured move (range height)
```

#### **30-Min Inside Candle**
```
📊 Pattern: 30-min inside candle
📈 Breakout: Break of 30-min range
🎯 Strategy: Scalp trade with breakout
🛡️ Stop: Inside of 30-min range
🎯 Target: +0.5-1 ATR
```

### Scenario 3: Earnings Plays

#### **Pre-Earnings Setup**
```
📊 Pattern: Launch Pad detection
📈 Volume: Increasing volume
🎯 Strategy: Trade breakout direction
🛡️ Stop: Below launch pad range
🎯 Target: Post-earnings move
```

#### **Post-Earnings Reaction**
```
📊 Gap: Earnings gap up/down
📈 Volume: Extremely high volume
🎯 Strategy: Fade initial move
🛡️ Stop: Extreme of gap
🎯 Target: Mean reversion to 20 EMA
```

---

## Quick Reference Cheat Sheet

### Green Light (Go Long) ✅
- SPY above 20 & 50 EMA
- Both EMA clouds bullish
- Relative volume > 100%
- Price above 20 EMA
- VIX clouds bearish

### Red Light (Go Short) 🔴
- SPY below 20 & 50 EMA  
- Both EMA clouds bearish
- Relative volume > 100%
- Price below 20 EMA
- VIX clouds bullish

### Yellow Light (Caution) ⚠️
- Mixed EMA cloud signals
- SPY between 20 & 50 EMA
- Relative volume < 50%
- VIX showing extreme readings

### No Trade Zone 🚫
- Market breadth extremes (> 80% or < 20%)
- Earnings announcements
- Major economic data releases
- Low ADR% (< 2%) with low volume

---

## Troubleshooting

### Common Issues

#### **No Trading Signals**
- **Check**: Market conditions (SPY position)
- **Check**: Volume levels (relVol > 50% minimum)
- **Check**: ADR% (needs > 2% for movement)
- **Solution**: Wait for better conditions or change timeframe

#### **Frequent Stop Outs**
- **Check**: ATR calculation (correct timeframe?)
- **Check**: Position size (too large?)
- **Check**: Stop placement (too tight?)
- **Solution**: Adjust stops to 2 ATR, reduce position size

#### **Missed Breakouts**
- **Check**: Entry criteria (too strict?)
- **Check**: Timeframe (too slow?)
- **Check**: Volume confirmation
- **Solution**: Use limit orders, lower entry criteria

### Performance Optimization

#### **Improving Win Rate**
- Focus on higher probability setups
- Wait for confirmation signals
- Trade with market trend
- Use proper risk management

#### **Increasing Profitability**
- Let winners run (trailing stops)
- Cut losers quickly
- Scale in on strong trends
- Take partial profits

---

## Final Notes

### Key Success Factors
1. **Patience**: Wait for high-probability setups
2. **Discipline**: Follow your rules consistently  
3. **Risk Management**: Never risk more than 1-2% per trade
4. **Market Awareness**: Understand overall market conditions
5. **Continuous Learning**: Review trades and adjust strategy

### Recommended Daily Routine
1. **Pre-Market**: Check SPY, VIX, futures, news
2. **Market Open**: Watch for gap plays, volume spikes
3. **Trading Day**: Execute planned setups, manage risk
4. **Day End**: Review trades, prepare for tomorrow

### Tools and Resources
- **TradingView**: Charting and analysis
- **Economic Calendar**: Major data releases
- **Sector Analysis**: Rotation opportunities
- **Journal**: Trade tracking and improvement

---

*This trading guide is based on the Swing Dashboard indicators. Always practice with paper trading before risking real capital. Markets are inherently risky - never trade with money you cannot afford to lose.*

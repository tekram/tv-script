// This code is adapted from Squeeze Momentum Indicator [LazyBear] found at https://www.tradingview.com/v/nqQ1DT5a/

//@version=6
indicator(shorttitle = 'SQZMOM', title = 'Squeeze Momentum Indicator [By Tashfeen as an update to LazyBear]', overlay = false)

length = input.int(20, title = 'BB Length')
mult = input.float(2.0, title = 'BB MultFactor')
lengthKC = input.int(20, title = 'KC Length')
multKC = input.float(1.5, title = 'KC MultFactor')

useTrueRange = input.bool(true, title = 'Use TrueRange (KC)')
showPriceLabels = input.bool(false, title = 'Show Price Labels for Inside Candle') // Default is false

// Options for inside candles

showInsideCandles = input.bool(false, title = 'Show Inside Candles')
showStackedEMALabel = input.bool(true, title='Show SIgnal when EMAs are stacked bullish 8 > 21 > 34 EMA')
//showGrayCross = input.bool(true, title = 'Show Inside Candle Only with Gray Cross')
// black is for building squeeze
//showBlackCrossInsideDay = input.bool(true, title = 'Show Inside Candle Only with Black Cross')
// gray is for squeezing
//showGrayCrossInsideDay = input.bool(true, title = 'Show Inside Candle Only with Gray Cross')
//showInsideDayWhileSqueeze = input.bool(false, title = 'Show only inside candles while long squeeze')

// Threshold for consecutive black crosses
threshold = 6
showThresholdLabel = input.bool(true, title = 'Show Label When Threshold is Reached')

// Calculate BB
source = close
basis = ta.sma(source, length)
dev = multKC * ta.stdev(source, length)
upperBB = basis + dev
lowerBB = basis - dev

// Calculate KC
ma = ta.sma(source, lengthKC)
kcRange = useTrueRange ? ta.tr : high - low // Renamed 'range' to 'kcRange'
rangema = ta.sma(kcRange, lengthKC)
upperKC = ma + rangema * multKC
lowerKC = ma - rangema * multKC

sqzOn = lowerBB > lowerKC and upperBB < upperKC
sqzOff = lowerBB < lowerKC and upperBB > upperKC
noSqz = not sqzOn and not sqzOff

val = ta.linreg(source - math.avg(math.avg(ta.highest(high, lengthKC), ta.lowest(low, lengthKC)), ta.sma(close, lengthKC)), lengthKC, 0)

// Inside candle condition (current candle within the range of the previous one)
insideCandle = high < high[1] and low > low[1]

// Track the last inside candle
var float lastInsideCandleIndex = na
if insideCandle
    lastInsideCandleIndex := bar_index
    lastInsideCandleIndex

bcolor = val > 0 ? val > nz(val[1]) ? color.lime : color.green : val < nz(val[1]) ? color.red : color.maroon
scolor = noSqz ? color.blue : sqzOn ? color.black : color.gray

plot(val, color = bcolor, style = plot.style_histogram, linewidth = 4)
plot(0, color = scolor, style = plot.style_cross, linewidth = 2)

adjustedY = val < 0 ? 3 : val

// Plot arrows for inside candles based on the selected cross color
if insideCandle and showInsideCandles
// Condition 1: Inside candle with a black cross -- getting ready for squeeze

    //if scolor == color.black
    label.new(bar_index, adjustedY, showPriceLabels and bar_index == lastInsideCandleIndex ? str.tostring(high, '#.##') + ' / ' + str.tostring(low, '#.##') : '', style = label.style_label_down, color = color.new(color.black, 0), textcolor = color.black)

    // Condition 2: Inside candle with a gray cross -- actively squeezing
    //if scolor == color.gray and showInsideDayWhileSqueeze and val > 0
    //    label.new(bar_index, adjustedY, showPriceLabels and bar_index == lastInsideCandleIndex ? str.tostring(high, '#.##') + ' / ' + str.tostring(low, '#.##') : '', style = label.style_label_down, color = color.new(#787b86a2, 0), textcolor = color.black)
    //else if scolor == color.gray
    //    label.new(bar_index, adjustedY, showPriceLabels and bar_index == lastInsideCandleIndex ? str.tostring(high, '#.##') + ' / ' + str.tostring(low, '#.##') : '', style = label.style_label_down, color = color.new(#787b86a2, 0), textcolor = color.black)

// Add label when threshold for consecutive black crosses is reached
var int blackCrossCount = 0
if scolor == color.black
    blackCrossCount := blackCrossCount + 1
    blackCrossCount
else
    blackCrossCount := 0
    blackCrossCount

if blackCrossCount == threshold and showThresholdLabel
    label.new(bar_index, val > 0 ? val + 0 : val, 'Threshold Reached: ' + str.tostring(threshold) + ' Black Crosses', style = val > 0 ? label.style_label_down : label.style_label_up, color = color.rgb(255, 82, 82, 61), textcolor = color.white)

// Calculate EMAs
ema8 = ta.ema(close, 8)
ema21 = ta.ema(close, 21)
ema34 = ta.ema(close, 34)

// Check for stacked EMAs (bullish condition)
stackedEMAs = ema8 > ema21 and ema21 > ema34

// Detect momentum shift from negative to positive
momentumShift = val > 0 and val[1] <= 0

// Signal when both conditions are met
signal = stackedEMAs and momentumShift

// Plot signal on the chart
//plotshape(signal, title = 'Bullish Signal', location = location.abovebar, color = color.green, style = shape.labeldown, text = '🔼')

// Add label at 'val' when stacked EMAs & momentum shift conditions are met
if signal and showStackedEMALabel
    label.new(bar_index, val * -1, '🔥 Bullish', style = label.style_label_up, color = color.green, textcolor = color.white)


// Define the number of bars for the last 3 years (assuming daily candles)
barsBack = 756  

// Find highest and lowest values in the last 3 years
highestVal = ta.highest(val, barsBack)
lowestVal = ta.lowest(val, barsBack)

// Create a table in the top-right corner
var table dataTable = table.new(position = position.top_right, columns = 2, rows = 3, bgcolor = color.blue, border_width = 1)

// Only update the table on the latest bar
if bar_index == ta.highest(bar_index, barsBack)
    // Header row
    table.cell(dataTable, 0, 0, "Metric", text_color=color.white, bgcolor=color.blue)
    table.cell(dataTable, 1, 0, "Value", text_color=color.white, bgcolor=color.blue)
    
    // 3-Year High row
    table.cell(dataTable, 0, 1, "3Y High", text_color=color.white, bgcolor=color.green)
    table.cell(dataTable, 1, 1, str.tostring(highestVal, "#.##"), text_color=color.white, bgcolor=color.green)
    
    // 3-Year Low row
    table.cell(dataTable, 0, 2, "3Y Low", text_color=color.white, bgcolor=color.red)
    table.cell(dataTable, 1, 2, str.tostring(lowestVal, "#.##"), text_color=color.white, bgcolor=color.red)

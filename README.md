<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1252">
<meta name=Generator content="Microsoft Word 15 (filtered)">
<style>
<!--
 /* Font Definitions */
 @font-face
	{font-family:Wingdings;
	panose-1:5 0 0 0 0 0 0 0 0 0;}
@font-face
	{font-family:"Cambria Math";
	panose-1:2 4 5 3 5 4 6 3 2 4;}
@font-face
	{font-family:Calibri;
	panose-1:2 15 5 2 2 2 4 3 2 4;}
 /* Style Definitions */
 p.MsoNormal, li.MsoNormal, div.MsoNormal
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:8.0pt;
	margin-left:0in;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
a:link, span.MsoHyperlink
	{color:#0563C1;
	text-decoration:underline;}
a:visited, span.MsoHyperlinkFollowed
	{color:#954F72;
	text-decoration:underline;}
p.MsoNoSpacing, li.MsoNoSpacing, div.MsoNoSpacing
	{margin:0in;
	margin-bottom:.0001pt;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
p.MsoListParagraph, li.MsoListParagraph, div.MsoListParagraph
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:8.0pt;
	margin-left:.5in;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
p.MsoListParagraphCxSpFirst, li.MsoListParagraphCxSpFirst, div.MsoListParagraphCxSpFirst
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	margin-bottom:.0001pt;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
p.MsoListParagraphCxSpMiddle, li.MsoListParagraphCxSpMiddle, div.MsoListParagraphCxSpMiddle
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:0in;
	margin-left:.5in;
	margin-bottom:.0001pt;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
p.MsoListParagraphCxSpLast, li.MsoListParagraphCxSpLast, div.MsoListParagraphCxSpLast
	{margin-top:0in;
	margin-right:0in;
	margin-bottom:8.0pt;
	margin-left:.5in;
	line-height:107%;
	font-size:11.0pt;
	font-family:"Calibri",sans-serif;}
.MsoChpDefault
	{font-family:"Calibri",sans-serif;}
.MsoPapDefault
	{margin-bottom:8.0pt;
	line-height:107%;}
@page WordSection1
	{size:8.5in 11.0in;
	margin:1.0in 1.0in 1.0in 1.0in;}
div.WordSection1
	{page:WordSection1;}
 /* List Definitions */
 ol
	{margin-bottom:0in;}
ul
	{margin-bottom:0in;}
-->
</style>

</head>

<body lang=EN-US link="#0563C1" vlink="#954F72">

<div class=WordSection1>

<p class=MsoNormal><b><span style='font-size:24.0pt;line-height:107%'>Tile
Puzzle Solver</span></b></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Implementation
Of different algorithms to find a solution for the logic </span><a
href="https://en.wikipedia.org/wiki/Sliding_puzzle"><span style='font-size:
12.0pt;line-height:107%'>Sliding Puzzle</span></a><span style='font-size:12.0pt;
line-height:107%'>.</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Finds a
solution for N x N configurations or N x M configurations, will find the
optimal solution if one of the A* algorithms are used. </span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Includes the
L shaped knights chess move for non-blank tiles to increase the problem space. 
</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Requires the
user to input comma separated values of the board to solve. For example:</span></p>

<p class=MsoNormal align=center style='text-align:center'><img border=0
width=186 height=181 id="Picture 1" src="README_files/image001.jpg"></p>

<p class=MsoNormal>The N x N board above will be as stated as being 3 , 3 when
program prompts for the board dimensions and tile positions will be: <b><span
style='font-size:14.0pt;line-height:107%'> 1, 8, 2, 0, 4, 3, 7, 6, 5 .</span></b></p>

<p class=MsoNormal>Tool will return a board Equivalent to your board in
ascending order, so for the board above it will try to find a board equal to <b><span
style='font-size:14.0pt;line-height:107%'>1 ,2, 3, 4, 5, 6, 7, 8</span> </b> .
The zero/blank tile could be anywhere in solution but the board will be in
ascending order.</p>

<p class=MsoNormal>The Blank tile must be represented by a zero.</p>

<p class=MsoNormal><b><span style='font-size:12.0pt;line-height:107%'>The tool
assumes that the input configuration will have all the numbers in a given range
present with zero as the blank tile. </span></b></p>

<p class=MsoNormal><b><span style='font-size:12.0pt;line-height:107%'>For
example a 2x2 board would not work with this tool for inputs 1,0,3,4. The
inputs solution should have each value i being 1 less than the next value in
the solution excluding the zero tile. Like this: 1,0,2,3.   </span></b></p>

<p class=MsoNormal><span style='font-size:16.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-size:16.0pt;line-height:107%'>Algorithms </span></p>

<p class=MsoListParagraphCxSpFirst style='text-indent:-.25in'><span
style='font-size:12.0pt;line-height:107%;font-family:Symbol'>·<span
style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span>Bread<span style='font-size:12.0pt;line-height:107%'> First
Search</span></p>

<p class=MsoListParagraphCxSpMiddle style='text-indent:-.25in'><span
style='font-size:12.0pt;line-height:107%;font-family:Symbol'>·<span
style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span style='font-size:12.0pt;line-height:107%'>Depth First
Search</span></p>

<p class=MsoListParagraphCxSpMiddle style='text-indent:-.25in'><span
style='font-size:12.0pt;line-height:107%;font-family:Symbol'>·<span
style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span style='font-size:12.0pt;line-height:107%'>A* with hamming
distance as a heuristic</span></p>

<p class=MsoListParagraphCxSpMiddle style='text-indent:-.25in'><span
style='font-size:12.0pt;line-height:107%;font-family:Symbol'>·<span
style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span style='font-size:12.0pt;line-height:107%'>A* with number of
reversal tiles (If two tiles are next to each other, and the goal requires
their position to be swapped) as a heuristic.</span></p>

<p class=MsoListParagraphCxSpLast style='text-indent:-.25in'><span
style='font-size:12.0pt;line-height:107%;font-family:Symbol'>·<span
style='font:7.0pt "Times New Roman"'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</span></span><span style='font-size:12.0pt;line-height:107%'>A* with average
of the previous two heuristics as its heuristic</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><b><span style='font-size:18.0pt;line-height:107%'>How to
Run:</span></b><span style='font-size:20.0pt;line-height:107%'> </span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Jar is
provided BridgeTorchSolver.jar</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Open a
terminal/command prompt in directory and enter</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>java -jar TilePuzzleSolver.jar</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Then follow
the prompts </span><span style='font-size:12.0pt;line-height:107%;font-family:
Wingdings'>J</span></p>

<p class=MsoNormal>&nbsp;</p>

</div>

</body>

</html>

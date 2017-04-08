<html>

<head>
<meta http-equiv=Content-Type content="text/html; charset=windows-1252">
<meta name=Generator content="Microsoft Word 15 (filtered)">
</head>

<body lang=EN-US link="#0563C1" vlink="#954F72">

<div class=WordSection1>

<p class=MsoNormal><b><span style='font-size:24.0pt;line-height:107%'>Tile
Puzzle Solver</span></b></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Using different algorithms to find a solution for the </span><a
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
</span></span>Breadth<span style='font-size:12.0pt;line-height:107%'> First
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
provided TilePuzzleSolver.jar</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Open a
terminal/command prompt in directory and enter</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>java -jar TilePuzzleSolver.jar</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>&nbsp;</span></p>

<p class=MsoNormal><span style='font-size:12.0pt;line-height:107%'>Then follow
the prompts </span><span style='font-size:12.0pt;line-height:107%;font-family:
Wingdings'></span></p>

<p class=MsoNormal>&nbsp;</p>

</div>

</body>

</html>

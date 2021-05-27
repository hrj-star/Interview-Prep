
Find the total number of paths possible for rat to move from source to destination in a maze , where 0 means blocked and 1 means an open cell.

Allowed directions : north ,south , east , west.

Example :
--------------------

N = 4

[ 1 1 1 1 ]

[ 1 1 0 1 ]

[ 0 1 0 1 ]

[ 1 1 1 1 ]

Output :
--------------------

4


There are total 4 paths 

<font face="consolas" size="3"><br>
[<span class="blue"> 1 1 1 1</span> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ <span class="blue">1 1</span> 1 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<span class="blue"> 1</span> 1 1 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<span class="blue"> 1 1 1 1</span> ]<br>
[ 1 1 0&nbsp;<span class="blue">1</span> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 1 <span class="blue">1</span> 0 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<span class="blue"> 1 1</span> 0 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[<span class="blue"> 1 1</span> 0 <span class="blue">1</span> ]<br>
[ 0 1 0 <span class="blue">1</span> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 0 <span class="blue">1</span> 0 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 0 <span class="blue">1</span> 0 1 ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 0 1 0 <span class="blue">1</span> ]<br>
[ 1 1 1&nbsp;<span class="blue">1</span> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 1 <span class="blue">1 1 1 ]</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 1 <span class="blue">1 1 1</span> ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ 1 1 1<span class="blue"> 1</span> ]<br>
</font>



/* Write a function "void link (char **tiles)" that takes a list of tiles. They should
  link together sequentially in the order they ar egiven. Print out the current count and
  arrangment of the tiles each step..including a note about how far each tile has been rotated.

  A tile is a 2b2 sq. split into quadrantsm where each quadrant has a number from 0 to 9.
  After the first tile, a tile can be legally placed if at least two of its quadrants match quadrants 
  on adjacent tiles horizontally or vertically. A tile cannot be legally placed in a location if it would 
  have fewer than two matching quadrants or has any quadrants that do not match. Tiles can be rotated, 
  and a tile can be placed in offset positions. Inputs are designed so there is only one way a tile
  can fit.

  EX.
char *tiles1[] = {
    "11",   //1
    "23",
    "",
    "44",   //2
    "11",
    "",
    "16",   //3
    "36",
    "",
    "51",   //4
    "71",
    ""
    "46",   //5
    "26",
    ""
    "14",   //6
    "68",
    0};

Output1:
6 tiles
link 1
11
23

link 2
44
11
11
23

link 3
44
11
1116
2336

link 4
  44
5111
711116
  2336

link 5 //note this tile had to be rotated 180 degress clockwise
  44
5111
71111662
  233664

link 6 //note this had to be rotated 270 deg. clockwise
  4448
511116
71111662
  233664

char *tiles2[] = {
    "11",   //1
    "12",
    "",
    "12",   //2
    "93",
    "",
    "93",   //3
    "99",
    ""
    "39",   //4
    "98",
    ""
    "95",   //5
    "86",
    "",
    "57",   //6
    "66",
    "",
    "77",   //7
    "57",
    "",
    "13",   //8
    "24",
    "",
    "45",   //9
    "47",
    "",
    "24",   //10
    "39",
    0};

Output2:
10 tiles
link 1
11
12

link 2
11
12
12
93

link 3
11
12
12
93
93
99

link 4
11
12
12
93
9339
9998

link 5
11
12
12
93
933995
999886

link 6
11
12
12
93
93399557
99988666

link 7
11
12
12    77
93    57
93399557
99988666

ilink 8
1113
1224
12    77
93    57
93399557
99988666

link 9
1113
122445
12  4777
93    57
93399557
99988666

link 10
1113
122445
12244777
9339  57
93399557
99988666


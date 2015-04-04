--Zack Raver

--Trying out algebraic drawing with diagrams library

import Diagrams.Prelude
import Diagrams.TwoD.Polygons
--import Data.Default

sierpinski shape 0 = shape # fc black
sierpinski shape n = smaller === centerX (smaller ||| smaller)
    where
    smaller = sierpinski shape (n - 1)



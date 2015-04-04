--Zack Raver
-- opengl tutorial

module Display (idle, display) where

import Graphics.UI.GLUT
import Control.Monad 
import Data.IORef
import Cube
import Points

display :: PrimitiveMode -> IORef GLfloat -> IORef (GLfloat, GLfloat) -> DisplayCallback
display shape angle pos = do
  clear [ColorBuffer, DepthBuffer]
  clear [ColorBuffer]
  loadIdentity
  (x',y') <- get pos
  translate $ Vector3 x' y' 0
  preservingMatrix $ do
    a <- get angle 
    rotate a $ Vector3 0 0 1
    rotate a $ Vector3 0 0.1 1
    scale 0.7 0.7 (0.7 :: GLfloat)
    forM_ (points 7) $ \(x,y,z) ->
      preservingMatrix $ do
        color $ Color3 ((x+1)/2) ((y+1)/2) ((z+1)/2)
        translate $ Vector3 x y z
        cube shape 0.1
        color $ Color3 (0 :: GLfloat) 0 0
        cubeFrame 0.1
  swapBuffers 

idle :: IORef GLfloat -> IORef GLfloat -> IdleCallback
idle angle delta = do 
  d <- get delta
  angle $~! (+ d )
  postRedisplay Nothing

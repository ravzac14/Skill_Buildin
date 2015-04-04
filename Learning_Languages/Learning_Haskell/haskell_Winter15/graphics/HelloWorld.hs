--Zack raver
--opengl tutorial

import Graphics.UI.GLUT
import Data.IORef
import Bindings

main :: IO () 
main = do
  (_progName, _args) <- getArgsAndInitialize
  initialDisplayMode $= [WithDepthBuffer, DoubleBuffered]
  _window <- createWindow "hello jimb"
  reshapeCallback $= Just reshape
  depthFunc $= Just Less 
  angle <- newIORef 0.0 
  delta <- newIORef 0.1
  pos <- newIORef (0,0)
  shape <- Quads
  keyboardMouseCallback $= Just (keyboardMouse shape delta pos)   
  idleCallback $= Just (idle angle delta)
  displayCallback $= display Quads angle pos
  mainLoop




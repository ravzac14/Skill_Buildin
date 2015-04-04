import Graphics.Rendering.OpenGL
import Graphics.UI.GLUT

-- Works on the Haskell Platform
-- To compile: ghc --make openGLtest.hs
-- To run: ./openGLtest

main = do
  putStrLn "Opening a Graphics Window"
  (progname, _) <- getArgsAndInitialize
  createWindow "Hello World"
  displayCallback $= display
  mainLoop

display :: IO()
display = do
  clear [ColorBuffer]
  flush


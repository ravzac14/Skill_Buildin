--Zack Raver
--opengl

module Cube where

import Graphics.UI.GLUT


vertex3f :: (GLfloat, GLfloat, GLfloat) -> IO ()
vertex3f (x, y, z) = vertex $ Vertex3 x y z
 
cube :: PrimitiveMode -> GLfloat -> IO ()
cube s w = renderPrimitive s $ mapM_ vertex3f
  [ ( w, w, w), ( w, w,-w), ( w,-w,-w), ( w,-w, w),
  ( w, w, w), ( w, w,-w), (-w, w,-w), (-w, w, w),
  ( w, w, w), ( w,-w, w), (-w,-w, w), (-w, w, w),
  (-w, w, w), (-w, w,-w), (-w,-w,-w), (-w,-w, w),
  ( w,-w, w), ( w,-w,-w), (-w,-w,-w), (-w,-w, w),
  ( w, w,-w), ( w,-w,-w), (-w,-w,-w), (-w, w,-w) ]

cubeFrame :: GLfloat -> IO ()
cubeFrame w = renderPrimitive Lines $ mapM_ vertex3f
  [ ( w,-w, w), ( w, w, w),  ( w, w, w), (-w, w, w),
  (-w, w, w), (-w,-w, w),  (-w,-w, w), ( w,-w, w),
  ( w,-w, w), ( w,-w,-w),  ( w, w, w), ( w, w,-w),
  (-w, w, w), (-w, w,-w),  (-w,-w, w), (-w,-w,-w),
  ( w,-w,-w), ( w, w,-w),  ( w, w,-w), (-w, w,-w),
  (-w, w,-w), (-w,-w,-w),  (-w,-w,-w), ( w,-w,-w) ]

{-

cube :: GLfloat -> IO ()
cube w = do
  renderPrimitive Quads $ do
  vertex $ Vertex3 w w w
  vertex $ Vertex3 w w (-w)
  vertex $ Vertex3 w (-w) (-w)
  vertex $ Vertex3 w (-w) w
  vertex $ Vertex3 w w w
  vertex $ Vertex3 w w (-w)
  vertex $ Vertex3 (-w) w (-w)
  vertex $ Vertex3 (-w) w w
  vertex $ Vertex3 w w w
  vertex $ Vertex3 w (-w) w
  vertex $ Vertex3 (-w) (-w) w
  vertex $ Vertex3 (-w) w w
  vertex $ Vertex3 (-w) w w
  vertex $ Vertex3 (-w) w (-w)
  vertex $ Vertex3 (-w) (-w) (-w)
  vertex $ Vertex3 (-w) (-w) w
  vertex $ Vertex3 w (-w) w
  vertex $ Vertex3 w (-w) (-w)
  vertex $ Vertex3 (-w) (-w) (-w)
  vertex $ Vertex3 (-w) (-w) w
  vertex $ Vertex3 w w (-w)
  vertex $ Vertex3 w (-w) (-w)
  vertex $ Vertex3 (-w) (-w) (-w)
  vertex $ Vertex3 (-w) w (-w)
-}

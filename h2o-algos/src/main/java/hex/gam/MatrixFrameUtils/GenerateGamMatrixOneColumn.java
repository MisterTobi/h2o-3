package hex.gam.MatrixFrameUtils;

import water.MRTask;
import hex.gam.GAMModel.GAMParameters.BSType;
import water.MemoryManager;
import water.fvec.Vec;
import water.fvec.NewChunk;
import water.fvec.Chunk;

public class GenerateGamMatrixOneColumn extends MRTask<GenerateGamMatrixOneColumn> {
  BSType _splineType;
  int _numKnots;  // number of knots
  double[] _knots;  // value of knots to use if specified by user
  
  GenerateGamMatrixOneColumn(BSType splineType, int numKnots, double[] knots, Vec gamx) {
    _splineType = splineType;
    _numKnots = numKnots;
    if (knots == null) {
      _knots = MemoryManager.malloc8d(numKnots);
      double max = gamx.max();
      double min = gamx.min();
      double incre = (max-min)/(numKnots-1);
      int interKnots = numKnots-2;
      _knots[0] = min;
      _knots[numKnots-1] = max;
      for (int index = 1; index < interKnots; index++)
        _knots[index] = _knots[index-1]+incre;
    } else
      _knots = knots;
  }
  
  @Override
  public void map(Chunk vec, NewChunk[] newChunks) {
    
  }
}



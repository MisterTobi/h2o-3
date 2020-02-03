package hex.gam.MatrixFrameUtils;

import hex.gam.GAMModel.GAMParameters.BSType;
import water.MRTask;
import water.MemoryManager;
import water.fvec.Frame;

public class GenerateGamMatrixOneColumn extends MRTask<GenerateGamMatrixOneColumn> {
  BSType _splineType;
  int _numKnots;  // number of knots
  double[] _knots;  // value of knots to use if specified by user
  
  public GenerateGamMatrixOneColumn(BSType splineType, int numKnots, double[] knots, Frame gamx) {
    _splineType = splineType;
    _numKnots = numKnots;
    if (knots == null) {
      _knots = MemoryManager.malloc8d(numKnots);
      double max = gamx.vec(0).max();
      double min = gamx.vec(0).min();
      double incre = (max-min)/(numKnots-1);
      int interKnots = numKnots-2;
      _knots[0] = min;
      _knots[numKnots-1] = max;
      for (int index = 1; index < interKnots; index++)
        _knots[index] = _knots[index-1]+incre;
    } else
      _knots = knots;
  }
  
}



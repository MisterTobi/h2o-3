package hex.gam.MatrixFrameUtils;

import water.MemoryManager;

public class TriDiagonalMatrix {
  double[] _first_diag;
  double[] _second_diag;
  double[] _third_diag;

  public int _size;  // square matrix size

  public TriDiagonalMatrix(int size) {
    assert size>2:"Size of BiDiagonalMatrix must exceed 1 but is "+size;
    _size = size;
    _first_diag = MemoryManager.malloc8d(size);
    _second_diag = MemoryManager.malloc8d(size);
    _third_diag = MemoryManager.malloc8d(size);
  }

  public TriDiagonalMatrix(double[] fdiag, double[] sdiag, double[] tdiag) {
    assert (fdiag.length==sdiag.length) &&  (sdiag.length >2) && (sdiag.length==tdiag.length);
    _first_diag = fdiag;
    _second_diag = sdiag;
    _third_diag = tdiag;
    _size = tdiag.length;
  }

  public TriDiagonalMatrix(double[] hj) {
    this(hj.length-1);  // hj size k-1
    int diagSize = _size;
    for (int index=0; index < diagSize; index++) {
      double oneOhj = 1.0/hj[index];
      double oneOhjP1 = 1/hj[index+1];
      _first_diag[index] = oneOhj;
      _second_diag[index] = -oneOhj-oneOhjP1;
      _third_diag[index] = oneOhjP1;
    }
  }
}

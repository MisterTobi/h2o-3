package hex.gam.MatrixFrameUtils;

/***
 * This class denotes a (size-2) by size matrix with only three diagonals that are nonzero.
 */
public class TriDiagonalMatrix {
  double[] _diag1;  // diagonal starting off element row=0, col=0
  double[] _diag2;  // diagonal starting off element row=0, col=1
  double[] _diag3;  // diagonal starting off element row=0, col=2
  int _size;           // matrix column number
  
  public TriDiagonalMatrix(int size) {
    assert size > 2;
    _size = size;
    int matRow = _size-2;
    _diag1 = new double[matRow];
    _diag2 = new double[matRow];
    _diag3 = new double[matRow];
  }
  
  public TriDiagonalMatrix(double[] diag1, double[] diag2, double[] diag3) {
    assert diag1.length>0;
    assert (diag1.length==diag2.length) && (diag2.length==diag3.length);
    _size = diag1.length+2;
    _diag1 = diag1;
    _diag2 = diag2;
    _diag3 = diag3;
  }
}

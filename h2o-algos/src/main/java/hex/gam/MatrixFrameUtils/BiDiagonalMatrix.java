package hex.gam.MatrixFrameUtils;

/***
 * This class denotes a bidiagonal matrix with only non-zero elements on the diagonal, one diagonal above the
 * diagonal, one diagonal below the diagonal.  The matrix must be a square matrix
 */
public class BiDiagonalMatrix {
  double[] _ldiag; // lower diagonal of matrix
  double[] _diag;  // diagonal of matrix
  double[] _udiag; // upper diagonal of matrix
  int _size;  // square matrix size
  
  public BiDiagonalMatrix(int size) {
    assert size>1:"Size of BiDiagonalMatrix must exceed 1 but is "+size;
    _size = size;
    _ldiag = new double[size-1];
    _diag = new double[size];
    _udiag = new double[size];
  }
  
  public BiDiagonalMatrix(double[] ldiag, double[] diag, double[] udiag) {
    assert (ldiag.length==udiag.length) && (diag.length==(ldiag.length+1)) && (diag.length >1);
    _ldiag = ldiag;
    _diag = diag;
    _udiag = udiag;
    _size = diag.length;
  }
}

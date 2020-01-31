package hex.gam.GamSplines;

import hex.gam.MatrixUtils.BiDiagonalMatrix;
import hex.gam.MatrixUtils.TriDiagonalMatrix;

public class CubicRegressionSplines {
  double[] _knots;  // store knot values for the spline class
  double[] _hj;     // store difference between knots, length _knotNum-1
  int _knotNum; // number of knot values
  BiDiagonalMatrix _matrixB;  // of dimension (_knotNum-2) by (_knotNum-2)
  TriDiagonalMatrix _matrixD; // of dimension (_knotNum-2) by _knotNum
  
  public CubicRegressionSplines(double[] knots) {
    _knots = knots;
    _knotNum = knots.length;
    _hj = setHj(knots);
    
  }
  
  public static double[] setHj(double[] knots) {
    int numHj = knots.length-1;
    double[] hj = new double[knots.length];
    
    return hj;
  }
  public static double gen_a_m_j(double xjp1, double x, double hj) {
    return (xjp1-x)/hj;
  }
  
  public static double gen_a_p_j(double xj, double x, double hj) {
    return (x-xj)/hj;
  }

  public static double gen_c_m_j (double xjp1, double x, double hj) {
    double t = (xjp1-x);
    double t3 = t*t*t;
    return ((t3/hj-hj*(xjp1-x))/6.0);
  }

  public static double gen_c_p_j(double xj, double x, double hj) {
    double t=(x-xj);
    double t3 = t*t*t;
    return ((t3/hj-hj*(x-xj))/6.0);
  }
}

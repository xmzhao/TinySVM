/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.chasen.tinysvm;

public class BaseExample {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected BaseExample(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(BaseExample obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        TinySVMJNI.delete_BaseExample(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public int add(double arg0, SWIGTYPE_p_TinySVM__feature_node arg1) {
    return TinySVMJNI.BaseExample_add__SWIG_0(swigCPtr, this, arg0, SWIGTYPE_p_TinySVM__feature_node.getCPtr(arg1));
  }

  public int add(double arg0, String arg1) {
    return TinySVMJNI.BaseExample_add__SWIG_1(swigCPtr, this, arg0, arg1);
  }

  public int add(String arg0) {
    return TinySVMJNI.BaseExample_add__SWIG_2(swigCPtr, this, arg0);
  }

  public int set(int i, double arg1, SWIGTYPE_p_TinySVM__feature_node arg2) {
    return TinySVMJNI.BaseExample_set__SWIG_0(swigCPtr, this, i, arg1, SWIGTYPE_p_TinySVM__feature_node.getCPtr(arg2));
  }

  public int set(int i, double arg1, String arg2) {
    return TinySVMJNI.BaseExample_set__SWIG_1(swigCPtr, this, i, arg1, arg2);
  }

  public int set(int i, String arg1) {
    return TinySVMJNI.BaseExample_set__SWIG_2(swigCPtr, this, i, arg1);
  }

  public int get(int i, SWIGTYPE_p_double arg1, SWIGTYPE_p_p_TinySVM__feature_node arg2) {
    return TinySVMJNI.BaseExample_get__SWIG_0(swigCPtr, this, i, SWIGTYPE_p_double.getCPtr(arg1), SWIGTYPE_p_p_TinySVM__feature_node.getCPtr(arg2));
  }

  public String get(int i) {
    return TinySVMJNI.BaseExample_get__SWIG_1(swigCPtr, this, i);
  }

  public int remove(int i) {
    return TinySVMJNI.BaseExample_remove(swigCPtr, this, i);
  }

  public int clear() {
    return TinySVMJNI.BaseExample_clear(swigCPtr, this);
  }

  public int size() {
    return TinySVMJNI.BaseExample_size(swigCPtr, this);
  }

  public int read(String arg0, String mode, int offset) {
    return TinySVMJNI.BaseExample_read__SWIG_0(swigCPtr, this, arg0, mode, offset);
  }

  public int read(String arg0, String mode) {
    return TinySVMJNI.BaseExample_read__SWIG_1(swigCPtr, this, arg0, mode);
  }

  public int read(String arg0) {
    return TinySVMJNI.BaseExample_read__SWIG_2(swigCPtr, this, arg0);
  }

  public int write(String arg0, String mode, int offset) {
    return TinySVMJNI.BaseExample_write__SWIG_0(swigCPtr, this, arg0, mode, offset);
  }

  public int write(String arg0, String mode) {
    return TinySVMJNI.BaseExample_write__SWIG_1(swigCPtr, this, arg0, mode);
  }

  public int write(String arg0) {
    return TinySVMJNI.BaseExample_write__SWIG_2(swigCPtr, this, arg0);
  }

  public String readLine(SWIGTYPE_p_FILE arg0) {
    return TinySVMJNI.BaseExample_readLine(swigCPtr, this, SWIGTYPE_p_FILE.getCPtr(arg0));
  }

  public int readSVindex(String arg0, String mode, int offset) {
    return TinySVMJNI.BaseExample_readSVindex__SWIG_0(swigCPtr, this, arg0, mode, offset);
  }

  public int readSVindex(String arg0, String mode) {
    return TinySVMJNI.BaseExample_readSVindex__SWIG_1(swigCPtr, this, arg0, mode);
  }

  public int readSVindex(String arg0) {
    return TinySVMJNI.BaseExample_readSVindex__SWIG_2(swigCPtr, this, arg0);
  }

  public int writeSVindex(String arg0, String mode, int offset) {
    return TinySVMJNI.BaseExample_writeSVindex__SWIG_0(swigCPtr, this, arg0, mode, offset);
  }

  public int writeSVindex(String arg0, String mode) {
    return TinySVMJNI.BaseExample_writeSVindex__SWIG_1(swigCPtr, this, arg0, mode);
  }

  public int writeSVindex(String arg0) {
    return TinySVMJNI.BaseExample_writeSVindex__SWIG_2(swigCPtr, this, arg0);
  }

  public double getY(int i) {
    return TinySVMJNI.BaseExample_getY(swigCPtr, this, i);
  }

  public String getX(int i) {
    return TinySVMJNI.BaseExample_getX(swigCPtr, this, i);
  }

  public double getAlpha(int i) {
    return TinySVMJNI.BaseExample_getAlpha(swigCPtr, this, i);
  }

  public double getGradient(int i) {
    return TinySVMJNI.BaseExample_getGradient(swigCPtr, this, i);
  }

  public double getG(int i) {
    return TinySVMJNI.BaseExample_getG(swigCPtr, this, i);
  }

}


public class SimpleComplex {
 float real;
 float imaginary;
 SimpleComplex(){
	 real=0;
	 imaginary=0;
 }
 SimpleComplex(float  re,float im){
	 real=re;
	 imaginary=im;
 }
 void setImaginary(float im) {
	 imaginary=im;
 }
 float getImaginary() {
	 return imaginary;
 }
 void setReal(float re) {
	 real=re;
 }
 float getReal() {
	 return real;
 }
 float computeNorm() {
	 return (float)Math.sqrt(Math.pow(real,2)+Math.pow(imaginary, 2));
 }
}

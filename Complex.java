
public class Complex extends SimpleComplex{
  Complex(){
	  super();
  }
  Complex(float re,float im){
	  super(re,im);
  }
  Complex conjugate() {
	  Complex p=new Complex(real,-imaginary);
	  return p;
  }
  static Complex multiply(Complex c1,Complex c2) {
	     float r=c1.getReal()*c2.getReal()-c2.getImaginary()*c1.getImaginary();
		 float i=c1.getReal()*c2.getImaginary()+c1.getImaginary()*c2.getReal();
		 Complex p=new Complex(r,i);
		 return p;
  }
  public static void main(String[] args) {
	  int i,n=10;
		 Complex[] compArray;
		 compArray=new Complex[n];
		 for(i=0;i<n;i++) {
			 float x=(float)Math.random();
			 float y=(float)Math.random();
			 compArray[i]=new Complex(x,y);
		 }
		 float[] norm;
		 norm=new float[n];
		 for(i=0;i<n;i++) {
			 norm[i]=compArray[i].computeNorm();
		 }
		 for(i=0;i<n;i++) {
			 System.out.print("z="+compArray[i].getReal()+"+"+compArray[i].getImaginary()+"i ");
			 System.out.print("   z*="+compArray[i].conjugate().getReal()+""+compArray[i].conjugate().getImaginary()+"i ");
			 
			 System.out.print("   z1="+multiply(compArray[i],compArray[i].conjugate()).getReal()+"+"+multiply(compArray[i],compArray[i].conjugate()).getImaginary()); 
			 System.out.print("   |z|="+norm[i]*norm[i]);
			 System.out.println(" ");
		 }
		 
  }
}

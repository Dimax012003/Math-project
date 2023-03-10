public class Function {
	int fun,a,b;
    Function(int fun,int a,int b){
    	this.fun=fun;
    	this.a=a;
    	this.b=b;
    }
    double selectFunction(int y, int t,double x,int i){
    	switch(i) {
    	case 1:
    		return y*Math.cos(t*x);
    	case 2: 
    		return y*Math.sin(t*x);
    	case 3:
    		return y*Math.log10(t*x);
    	case 4:
    		return y*Math.log(t*x);
    	case 5:
    		return y*Math.exp(t*x);
    	case 6:
    		return y*Math.pow(x, t);
    	}
    	return 0;
    }
    void setFunction(int fun) {
    	this.fun=fun;
    }
    void setParametera(int a) {
    	this.a=a;
    }
    void setParameterb(int b) {
    	this.b=b;
    }
    public static void main(String[] args) {
    	Function a=new Function(5,1,1);
       // a.findsolution(0);
       //System.out.println(a.integral(0, 1));
      // System.out.println(a.derivative(2));
        GUI gui=new GUI();
        
    }
    double f(double x) {
    	
    	return selectFunction(a,b,x,fun);
    }
    double findsolution(double a) {
    	double i=0;
    	for(i=0;i<10;i=i+0.0000001) {
    		if(f(i)<0.0000001+a && f(i)>-0.0000001+a) {
    			System.out.println(i);
    			break;
    		}
    	}
    		return i;
    }
    double integral(double a,double b) {
    	double sum=0;
    	double i=0;
    	int n=100000;
    	double steps=100000;
    	steps=(b-a)/n;
    	for(i=a;i<b;i=i+steps) {
    		sum=sum+f(i+steps)*steps;
    	}
    	return sum;
    }
    double derivative(int a) {
    	double n=100000;
    	return (f(a+(a/n))-f(a))/(a+(a/n)-a);
    }
}
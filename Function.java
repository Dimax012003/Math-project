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
    		return t*Math.pow(x, y);
    	}
    	return 0;
    }
    public static void main(String[] args) {
    	Function a=new Function(1,1,1);
        a.findsolution(0);
        System.out.println(a.integral(0, 1));
    }
    double f(double x) {
    	
    	return selectFunction(1,1,x,5)-selectFunction(1,1,x,6)-2;
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
}
package program;

class Test
{
	static int a=20;
	int x=10;
	static void m1(){
		a=15;
	}
	void m2(){
		x=16;
	}
}
class Example 
{
	public static void main(String [] args) 
	{
		Test ex1=new Test();
		Test ex2=new Test();
		
		System.out.println(ex1.a+""+ex2.a);
		ex1.m1();
		System.out.println(ex1.a+""+ex2.a);
		
		System.out.println(ex1.x+""+ex2.x);
		ex1.m2();
		System.out.println(ex1.x+""+ex2.x);
		
		
	}
}

package session17;

public class PS3 extends PS4{

	int a;
	public PS3(int a) {
		super(a);
		this.a = a;
	}

	public int sum1() {
		a = a+1;
		return a;
	}
	
	public int substract1() {
		a = a-1;
		return a;
	}
	
}
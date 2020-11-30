import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImple extends UnicastRemoteObject implements Calculadora{

	private static final long serialVersionUID = 1L;

	protected CalculadoraImple() throws RemoteException{
		super();
	}
	public double calc(double a, double b, char op) throws RemoteException{
		double i = 0;
		if(op == '+') {
			i = this.add(a, b);
		}else if(op == '-') {
			i = this.sub(a, b);
		}else if(op == '*') {
			i = this.mult(a, b);
		}else if(op == '/') {
			i = this.div(a, b);
		}
		return i;
	}
	private double add(double a, double b){
		return a+b;
	}
	private double sub(double a, double b){
		return a-b;
	}
	private double mult(double a, double b){
		return a*b;
	}
	private double div(double a, double b){
		return a/b;
	}
}

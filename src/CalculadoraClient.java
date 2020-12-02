import java.rmi.Naming;
import java.util.Scanner;
public class CalculadoraClient {
	public static void main(String[] args) {
		try {
			Calculadora c = (Calculadora) Naming.lookup("rmi://192.168.0.15:1099/CalculadoraService");
			Scanner l = new Scanner(System.in);
			double a,b;
			char op;
			int d = 0;
			while(d == 0){
				System.out.println("0-Calculadora\n1-Sair");
				d = l.nextInt();
				if(d == 0){
				System.out.println("Informe os valores a serem calculados e a operação na seguinte forma -> <Valor1> <Operação> <Valor2>:");
				System.out.println("Valor 1");
				a=l.nextDouble();
				System.out.println("Operador");
				op = (char)System.in.read();
				System.out.println("Valor 2");
				b=l.nextDouble();
				System.out.println("Resultado : " + c.calc(a,b,op));
				}
			}
			l.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

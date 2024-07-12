package switchsolo;

import java.io.IOException;
import java.util.Scanner;

public class Switch02answer {

public static void main(String[] args) throws IOException {
Scanner scan = new Scanner(System.in);

int a, b, op;
System.out.print("a의 값 : ");
a = scan.nextInt();
System.out.print("b의 값 : ");
b = scan.nextInt();
System.out.print("연산자(+,-,*,/)를 입력 : ");
op = System.in.read();

switch(op) {
case '+' : System.out.println(a + " + " + b + " = " + (a+b)); break;
case '-' : System.out.println(a + " - " + b + " = " + (a-b)); break;
case '*' : System.out.println(a + " * " + b + " = " + (a*b)); break;
case '/' : System.out.println(a + " / " + b + " = " + (double)a/b); break;
default : System.out.println("연산자 error");

}//switch

}

}


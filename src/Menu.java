import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws ParseException {
        EmpresaMtd emp = new EmpresaMtd();
        int opc;
        boolean cont=true;
        Scanner tc=new Scanner(System.in);
        while(cont){
            System.out.println("\n---MENU---");
            System.out.println("1 – Cadastrar Funcionario\n" +
                    "2 – Listar Todos os Funcionários\n" +
                    "3 – Listar Funcionários pela idade\n" +
                    "4 – Listar Funcionários pelo salário do Maior para o Menor \n" +
                    "5 - SAIR\n");
            System.out.print("Escolha uma opção: ");
            opc=tc.nextInt();

            switch (opc){
                case 1:
                    emp.cadastraFunc();
                    break;
                case 2:
                    emp.listarFunc();
                    break;
                case 3:
                    emp.listarPIDade();
                    break;
                case 4:
                    emp.listarPSalario();
                    break;
                case 5:
                    System.out.println("Finalizando sistema");
                    cont=false;
                    break;
                default:
                    System.out.println("Escolha uma opção válida");
            }
        }
    }
}

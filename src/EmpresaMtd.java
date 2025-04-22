import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

public class EmpresaMtd {

    public void cadastraFunc() throws ParseException {
        System.out.println("\n--CADASTRO DE FUNCIONÁRIO--");
        String nome;
        String datanasc;
        double salario;
        int qtdefilhos;
        boolean cont=true;
        char s;
        Scanner tc=new Scanner(System.in);

        while (cont){
            System.out.print("Nome: ");
            nome=tc.nextLine();
            System.out.print("Data de nascimento: ");
            datanasc=tc.nextLine();
            System.out.print("Salário: ");
            salario=tc.nextDouble();
            System.out.print("Quantidade de filhos: ");
            qtdefilhos=tc.nextInt();

            Empresa emp1 = new Empresa(nome,datanasc,salario,qtdefilhos);
            EmpresaDAO inserir=new EmpresaDAO();
            inserir.addEmpregado(emp1);

            System.out.print("Deseja continuar? (S/N)");
            s=tc.next().toLowerCase().charAt(0);
            if(s=='n'){
                cont=false;
            }
            tc.nextLine();
        }
    }
    public void listarFunc() {
        String sql = "SELECT * FROM empregado251";
        try (
                Connection conectar = Conexao.conectaBanco();
                Statement listar = conectar.createStatement();
                ResultSet resultado = listar.executeQuery(sql)
        ) {
            System.out.println("\n****************************************");
            System.out.println("             LISTA DE FUNCIONÁRIOS");
            System.out.println("****************************************");

            System.out.format("+------------+----------------------+----------------+-------------+----------------+%n");
            System.out.format("| %-10s | %-20s | %-14s | %-11s | %-14s |%n",
                    "ID", "NOME", "NASCIMENTO", "SALÁRIO", "FILHOS");
            System.out.format("+------------+----------------------+----------------+-------------+----------------+%n");
            while(resultado.next()) {
                System.out.format("| %-10s | %-20s | %-14s | R$ %-8.2f | %-14d |%n",
                        resultado.getString("id_empregado"),
                        resultado.getString("nome_empregado"),
                        resultado.getString("datanasc_empregado"),
                        resultado.getDouble("salario_empregado"),
                        resultado.getInt("filhos_empregado"));
            }
            System.out.format("+------------+----------------------+----------------+-------------+----------------+%n");

        } catch(SQLException e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }
    public void listarPIDade() {
        Scanner tc = new Scanner(System.in);
        System.out.println("\nEscolha a ordem de listagem:");
        System.out.println("1 - Idade Crescente (mais novo primeiro)");
        System.out.println("2 - Idade Decrescente (mais velho primeiro)");
        System.out.print("Opção: ");
        int opcao = tc.nextInt();
        tc.nextLine();

        String ordem = (opcao == 2) ? "DESC" : "ASC";
        String tituloOrdem = (opcao == 2) ? "MAIS VELHOS PRIMEIRO" : "MAIS NOVOS PRIMEIRO";

        String sql = "SELECT nome_empregado, datanasc_empregado, " +
                "TIMESTAMPDIFF(YEAR, datanasc_empregado, CURDATE()) AS idade " +
                "FROM empregado251 ORDER BY idade " + ordem;
        try (
                Connection conectar = Conexao.conectaBanco();
                Statement listar = conectar.createStatement();
                ResultSet resultado = listar.executeQuery(sql)
        ) {
            System.out.println("\n****************************************");
            System.out.println("   FUNCIONÁRIOS ORDENADOS POR IDADE (" + tituloOrdem + ")");
            System.out.println("****************************************");

            System.out.format("+----------------------+----------------+-------+%n");
            System.out.format("| %-20s | %-14s | %-5s |%n",
                    "NOME", "NASCIMENTO", "IDADE");
            System.out.format("+----------------------+----------------+-------+%n");

            while(resultado.next()) {
                System.out.format("| %-20s | %-14s | %-5d |%n",
                        resultado.getString("nome_empregado"),
                        resultado.getString("datanasc_empregado"),
                        resultado.getInt("idade"));
            }
            System.out.format("+----------------------+----------------+-------+%n");

        } catch(SQLException e) {
            System.out.println("Erro ao listar funcionários por idade: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void listarPSalario() {
        String sql = "SELECT nome_empregado, salario_empregado FROM empregado251 ORDER BY salario_empregado DESC";
        try (
                Connection conectar = Conexao.conectaBanco();
                Statement listar = conectar.createStatement();
                ResultSet resultado = listar.executeQuery(sql)
        ) {
            System.out.println("\n****************************************");
            System.out.println("     FUNCIONÁRIOS POR ORDEM SALARIAL");
            System.out.println("       (MAIORES SALÁRIOS PRIMEIRO)");
            System.out.println("****************************************");
            System.out.format("+----------------------+----------------+%n");
            System.out.format("| %-20s | %-14s |%n",
                    "NOME", "SALÁRIO (R$)");
            System.out.format("+----------------------+----------------+%n");
            while(resultado.next()) {
                System.out.format("| %-20s | R$ %10.2f |%n",
                        resultado.getString("nome_empregado"),
                        resultado.getDouble("salario_empregado"));
            }

            System.out.format("+----------------------+----------------+%n");

        } catch(SQLException e) {
            System.out.println("Erro ao listar funcionários por salário: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

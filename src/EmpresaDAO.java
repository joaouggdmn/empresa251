import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpresaDAO {
    public void addEmpregado(Empresa emp){
        String sql = "INSERT INTO empregado251(nome_empregado,datanasc_empregado,salario_empregado,filhos_empregado) VALUES(?,?,?,?)";

        SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoSaida = new SimpleDateFormat("yyyy-MM-dd");

        try{
            Date dataCompra = formatoEntrada.parse(emp.getDatanasc());
            String dataFormatada = formatoSaida.format(dataCompra);

            try(Connection conectar = Conexao.conectaBanco();
                PreparedStatement inserir = conectar.prepareStatement(sql)) {
                inserir.setString(1, emp.getNome());
                inserir.setString(2,dataFormatada);
                inserir.setDouble(3, emp.getSalario());
                inserir.setInt(4, emp.getQtdefilhos());
                inserir.execute();
            }
        } catch(ParseException erro){
            System.out.println("Erro ao formatar a data: " + erro.getMessage());
        } catch(SQLException erro){
            System.out.println("Erro SQL: " + erro.getMessage());
        }
    }
}


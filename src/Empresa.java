import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Empresa {

    private String nome;
    private String datanasc;
    private double salario;
    private int qtdefilhos;

    public Empresa(String nome, String datanasc, double salario, int qtdefilhos)throws ParseException{
        this.nome = nome;
        this.datanasc = datanasc;
        this.salario =salario;
        this.qtdefilhos = qtdefilhos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) throws ParseException {
        this.datanasc = datanasc;
    }

    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy").format(this.datanasc);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getQtdefilhos() {
        return qtdefilhos;
    }

    public void setQtdefilhos(int qtdefilhos) {
        this.qtdefilhos = qtdefilhos;
    }
}
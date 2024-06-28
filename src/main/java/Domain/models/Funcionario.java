package Domain.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;


public class Funcionario extends Pessoa {
    public BigDecimal get;
    protected String funcao;
    protected BigDecimal salario;


    public Funcionario(String nome, LocalDate dataNascimento, String funcao, BigDecimal salario) {
        super(nome, dataNascimento);
        this.funcao = funcao;
        this.salario = salario;
    }


    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public int getIdade() {
        return this.getDataNascimento().until(LocalDate.now()).getYears();
    }
    public BigDecimal SalarioMinimo(){
       return this.getSalario().divide(new BigDecimal("1212.00"), 1, RoundingMode.HALF_UP);

    }

    public String toString() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", symbols);
        String numeroFormatado = decimalFormat.format(salario);

        return String.format("Nome: %s, Data de nascimento: %s, Função : %s, Salario: %s%n", this.nome, dateTimeFormatter.format(dataNascimento), this.funcao, numeroFormatado);
    }

    public void imprimirNomeEIdade() {
        System.out.printf("Nome: %s, Idade: %s\n", this.nome, this.getIdade());
    }
    public  void imprimirNomeESalariosMinimos() {
        System.out.printf("Nome: %s, Salário miínimo: %s\n", this.nome, this.SalarioMinimo());



}}

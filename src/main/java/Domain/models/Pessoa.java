package Domain.models;
 import java.time.LocalDate;
 import java.time.format.DateTimeFormatter;


public class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;

    protected static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public static void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        Pessoa.dateTimeFormatter = dateTimeFormatter;
    }



    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

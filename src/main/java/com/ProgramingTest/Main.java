package com.ProgramingTest;

import Domain.models.Funcionario;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


import static Domain.models.Pessoa.getFormatter;



public class Main {
    public static void main(String[] args) {




        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        funcionarios.add(new Funcionario("Maria",
                LocalDate.of(2000, 10, 18),
                "Operador", new BigDecimal("2009.44")));

        funcionarios.add(new Funcionario("João",
                LocalDate.of(1990, 6, 12),
                "Operador", new BigDecimal("2284.38")));

        funcionarios.add(new Funcionario("Caio",
                LocalDate.of(1961, 5, 2),
                "Coordenador", new BigDecimal("9834.14")));

        funcionarios.add(new Funcionario("Miguel",
                LocalDate.of(1988, 10, 14),
                "Diretor", new BigDecimal("2009.44")));

        funcionarios.add(new Funcionario("Alice",
                LocalDate.of(1995, 1, 5),
                "Recepcionista", new BigDecimal("2243.68")));

        funcionarios.add(new Funcionario("Heitor",
                LocalDate.of(1999, 11, 19),
                "Operador", new BigDecimal("1582.72")));

        funcionarios.add(new Funcionario("Arthur",
                LocalDate.of(1993, 3, 31),
                "Contador", new BigDecimal("4071.84")));

        funcionarios.add(new Funcionario("Laura",
                LocalDate.of(1994, 7, 8),
                "Gerente", new BigDecimal("3017.45")));

        funcionarios.add(new Funcionario("Heloísa",
                LocalDate.of(2003, 6, 24),
                "Eletricista", new BigDecimal("1606.85")));

        funcionarios.add(new Funcionario("Helena",
                LocalDate.of(1996, 9, 2),
                "Gerente", new BigDecimal("2799.93")));

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        for (int i = 0; i < funcionarios.size(); ++i){
            Funcionario funcionario = funcionarios.get(i);

             String nome = funcionario.getNome();
             String dataNascimento = funcionario.getDataNascimento().format(getFormatter());
             String funcao = funcionario.getFuncao();
             BigDecimal salario = funcionario.getSalario();
             BigDecimal salariaCal;
            System.out.printf("Nome: %s, Data de nascimento: %s, Fnção : %s, Salario: %s%n",nome,dataNascimento, funcao, salario );

        }
    }

}

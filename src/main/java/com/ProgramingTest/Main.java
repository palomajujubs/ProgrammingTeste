package com.ProgramingTest;

import Domain.models.Funcionario;


import java.math.BigDecimal;

import java.math.RoundingMode;
import java.time.LocalDate;

import java.util.*;




public class Main {



    public static void main(String[] args) {


        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), "Operador", new BigDecimal("2009.44")));

        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 6, 12), "Operador", new BigDecimal("2284.38")));

        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), "Coordenador", new BigDecimal("9834.14")));

        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), "Diretor", new BigDecimal("2009.44")));

        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), "Recepcionista", new BigDecimal("2243.68")));

        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), "Operador", new BigDecimal("1582.72")));

        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), "Contador", new BigDecimal("4071.84")));

        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), "Gerente", new BigDecimal("3017.45")));

        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 6, 24), "Eletricista", new BigDecimal("1606.85")));

        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), "Gerente", new BigDecimal("2799.93")));

        funcionarios.removeIf(funcionario -> funcionario.getNome().equals("João"));

        imprimirTitulo("Funcionários");
        listaFuncionarios(funcionarios);

        for (Funcionario funcionario : funcionarios) {

            BigDecimal salario = funcionario.getSalario();
            BigDecimal aumento = salario.multiply(new BigDecimal("0.10"));
            BigDecimal salarioAtualizado = salario.add(aumento);

            funcionario.setSalario(salarioAtualizado);
        }

        imprimirTitulo("Funcionários com aumento salarial");
        listaFuncionarios(funcionarios);

        Map<String, List<Funcionario>> conjuntoFuncionarios = new HashMap<>();

        for (Funcionario funcionario : funcionarios) {
            if (!conjuntoFuncionarios.containsKey(funcionario.getFuncao()))
                conjuntoFuncionarios.put(funcionario.getFuncao(), new ArrayList<>());

            conjuntoFuncionarios.get(funcionario.getFuncao()).add(funcionario);
        }

        imprimirTitulo("Imprimindo funcionários por função");

        for (String funcao : conjuntoFuncionarios.keySet()) {
            List<Funcionario> listaFuncionarios = conjuntoFuncionarios.get(funcao);

            imprimirTitulo(funcao);

            listaFuncionarios(listaFuncionarios);
        }
        imprimirTitulo("Imprimindo funcionários que fazem aniversario no mês 10 e 12");

        List<Funcionario> funcionariosPorMes = funcionarios
                .stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .toList();

        listaFuncionarios(funcionariosPorMes);

        imprimirTitulo("Imprimindo funcionário com maior idade");

        Funcionario funcionarioMaisVelho = funcionarios.stream().reduce((f1, f2) -> {
            if (f2.getIdade() > f1.getIdade()) return f2;
            else return f1;
        }).orElseThrow();

        funcionarioMaisVelho.imprimirNomeEIdade();

        funcionarios.stream().map(f -> f.getNome());



        imprimirTitulo("Imprimindo funcionários em ordem alfabética");

        Collections.sort(funcionarios, (f1, f2) -> f1.getNome().compareTo(f2.getNome()));

        listaFuncionarios(funcionarios);

        imprimirTitulo("Total de salarios dos funcionarios");
        BigDecimal totalSalario = BigDecimal.ZERO;
        for ( Funcionario funcionario : funcionarios){
            if (funcionario.getSalario()!=null) {
                totalSalario = totalSalario.add(funcionario.getSalario());

            }
        }
        System.out.printf("salario: %.2f\n", totalSalario);

        imprimirTitulo("Quantos salarios minimos ganha cada funcionário");
        for (Funcionario funcionario: funcionarios){

            funcionario.imprimirNomeESalariosMinimos();

        }


    }





    private static void imprimirTitulo(String titulo) {
        String linha = "*".repeat(titulo.length() + 4);
        System.out.println(linha);
        System.out.printf("* %s *\n", titulo);
        System.out.println(linha);
        System.out.println();
    }

    private static void listaFuncionarios(List<Funcionario> lista) {
        for (Funcionario funcionario : lista) {
            System.out.println(funcionario);
        }
    }
}

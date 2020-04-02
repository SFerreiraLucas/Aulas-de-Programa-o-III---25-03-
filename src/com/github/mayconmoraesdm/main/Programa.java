package com.github.mayconmoraesdm.main;

import com.github.mayconmoraesdm.entidades.Contato;
import com.github.mayconmoraesdm.entidades.Entidade;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.List;

public class Programa {
    public static void main(String[] args) {
        try {
            int opcao;
            Scanner teclado = new Scanner(System.in);
            do {
                System.out.println("************** Menu ********************");
                System.out.println("Digite 1. Listar todos os registros ");
                System.out.println("Digite 2. Listar um único registro por ID ");
                System.out.println("Digite 3. Listar um único registro por nome ");
                System.out.println("Digite 4. Inserir novo registro ");
                System.out.println("Digite 5. Alterar registro existente ");
                System.out.println("Digite 6. Excluir registro existente ");
                System.out.println("Digite 7. Fechar aplicação ");
                opcao = teclado.nextInt();

                switch (opcao) {
                    case 1:
                        listaTodos();
                        break;
                    case 2:
                        lista(1);

                        break;
                    case 3:
                        listanome();
                        break;
                    case 4:
                        insere();
                        break;
                    case 5:
                        altera();
                        break;
                    case 6:
                        exclui();
                        break;
                    case 7:
                        System.out.println("Saindo");
                        break;
                    default:
                        System.out.println("Opção não Disponivel");
                }
            } while (opcao != 7);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listaTodos() throws SQLException {
        System.out.println("Lista Todos");
        Contato contato = new Contato();
        List<Contato> contatos = contato.busca();
        if (contatos.size() == 0) {
            System.out.printf("Nenhum contato na agenda!");
        } else {
            contatos.forEach(c -> System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                    c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(),c.getCelular(),c.getCelular2(), c.getEmail())));
        }
    }

    public static void lista(Integer id) {
        int idl;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite ID do Contato: "); //editar
        idl = teclado.nextInt();
        System.out.println("Lista um contato");
        Contato c = new Contato(idl);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));
    }
    public static void listanome() {
        String nomeb;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite Nome do Contato: ");
        nomeb = teclado.nextLine();
        System.out.println("Lista um contato");
        Contato c = new Contato(nomeb);
        System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                c.getId(), c.getNome(), c.getTelefone(), c.getTelefone2(), c.getCelular(), c.getCelular2(), c.getEmail()));

    }

    public static void insere() {
        System.out.println("Inserindo contato");
        try {
            String nome;
            String telefone1;
            String telefone2;
            String celular1;
            String celular2;
            String email;

            Scanner teclado = new Scanner(System.in);

            Contato contato = new Contato();
            System.out.println("Digite Nome do Contato: ");
            nome = teclado.nextLine();
            contato.setNome(nome);
            System.out.println("Digite Telefone: ");
            telefone1 = teclado.nextLine();
            contato.setTelefone(telefone1);
            System.out.println("Digite Telefone2: ");
            telefone2 = teclado.nextLine();
            contato.setTelefone2(telefone2);
            System.out.println("Digite Celular: ");
            celular1 = teclado.nextLine();
            contato.setCelular(celular1);
            System.out.println("Digite Celular2: ");
            celular2 = teclado.nextLine();
            contato.setCelular2(celular2);
            System.out.println("Digite E-mail: ");
            email = teclado.nextLine();
            contato.setEmail(email);
            contato.insere();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void altera() {
        try {
            String nome;
            String telefone1;
            String telefone2;
            String celular1;
            String celular2;
            String email;
            int ida;

            Scanner teclado = new Scanner(System.in);
            System.out.println("Alterando contato");
            System.out.println("Digite ID que será alterado: ");
            ida = teclado.nextInt();
            Contato contato = new Contato(ida);
            System.out.println("Alterando ID: "+ ida);
            System.out.println(String.format("Id: %d\nNome: %s\nTelefone: %s\nTelefone2: %s\nCelular: %s\nCelular2: %s\nE-mail: %s\n",
                    contato.getId(), contato.getNome(), contato.getTelefone(), contato.getTelefone2(), contato.getCelular(), contato.getCelular2(), contato.getEmail()));
            System.out.println("Digite Novo Nome do Contato: ");
            nome = teclado.nextLine();
            nome = teclado.nextLine();
            contato.setNome(nome);
            System.out.println("Digite Novo Telefone: ");
            telefone1 = teclado.nextLine();
            contato.setTelefone(telefone1);
            System.out.println("Digite Novo Telefone2: ");
            telefone2 = teclado.nextLine();
            contato.setTelefone2(telefone2);
            System.out.println("Digite Novo Celular: ");
            celular1 = teclado.nextLine();
            contato.setCelular(celular1);
            System.out.println("Digite Novo Celular2: ");
            celular2 = teclado.nextLine();
            contato.setCelular2(celular2);
            System.out.println("Digite Novo E-mail: ");
            email = teclado.nextLine();
            contato.setEmail(email);
            contato.altera();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void exclui() {
        try {
            int ide;
            Scanner teclado = new Scanner(System.in);
            System.out.println("Excluindo contato");
            System.out.println("Digite ID que será Excluido: ");
            ide = teclado.nextInt();
            System.out.println("Excluindo ID: "+ ide);
            Contato contato = new Contato(ide);
            contato.exclui();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    }




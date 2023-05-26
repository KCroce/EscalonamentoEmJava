package Escalando;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escalonamento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        int contador = 0;
        List<Processo> processos = new ArrayList<>();

        while (escolha != 4) {
            try {
                System.out.println("\n                 MENU\n");
                System.out.println("|(1) - para a entrada de processos   |");
                System.out.println("|(2) - para a execução do processos  |");
                System.out.println("|(3) - para a impressão do processos |");
                System.out.print("|(4) - para sair                     |\nEscolha:");
                escolha = sc.nextInt();

                switch (escolha) {
                    case 1:
                        int tamanhoLista;

                        System.out.print("\nDigite o tamanho da lista de processos: ");
                        tamanhoLista = sc.nextInt();

                        for (int i = 0; i < tamanhoLista; i++) {
                            contador++;

                            System.out.println("");
                            System.out.print("Digite o nome do processo " + (i + 1) + ": ");
                            String nome = sc.next();
                            System.out.print("Digite o tempo restante do processo " + (i + 1) + ": ");

                            int tempoRestante = sc.nextInt();

                            processos.add(new Processo(nome, tempoRestante, 10));
                            if (contador == 5) {
                                int escolha2;

                                System.out.println("Deseja adicionar mais um processo: (1)Sim (2)Não");
                                escolha2 = sc.nextInt();
                                if (escolha2 == 1) {
                                    System.out.print("Digite o nome do processo " + ": ");

                                    nome = sc.next();

                                    System.out.print("Digite o tempo restante do processo : ");

                                    tempoRestante = sc.nextInt();

                                    processos.add(new Processo(nome, tempoRestante, 10));
                                }

                            }
                        }
                        break;

                    case 2:
                        System.out.println("\nExecutando os processos...");

                        if (processos.isEmpty()) {
                            System.out.println("Nenhum processo foi adicionado!");
                        } else {
                            while (!processos.isEmpty()) {
                                Processo p = processos.get(0);
                                System.out.println("\nProcessando o processo " + p.getNome() + "\nTempo restante:" + p.getTempoRestante() + "Tempos - " + p.getTempoExecucao() + "Tempos\n");
                                p.executar();

                                if (p.isFinalizado() || p.getTempoRestante() < 0) {
                                    System.out.println("!!!Processo " + p.getNome() + " finalizado!!!\n");
                                    processos.remove(p);
                                } else {
                                    processos.remove(p);
                                    processos.add(p);
                                }

                                Thread.sleep(2000);
                            }

                            System.out.println("Todos os processos foram finalizados!");
                        }

                        break;
                    case 3:
                        if (processos.size() == 0) {
                            System.out.println("\nNão tem processos para serem mostrados!!!!");
                        } else {
                            System.out.println("\n\nImprimindo a lista de processos...");

                            for (Processo p : processos) {
                                System.out.println("Nome: " + p.getNome() + " | Tempo restante: " + p.getTempoRestante() + " | Tempo de execução: " + p.getTempoExecucao());
                            }
                        }

                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a execução do programa. Por favor, tente novamente.");
                sc.nextLine(); // Limpa o buffer do scanner
            }
        }

        sc.close();
    }
}

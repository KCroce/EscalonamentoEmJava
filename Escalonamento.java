package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Escalonamento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;
        int contador = 0;
         int tempoExecucao = 5;
        List<Processo> processos = new ArrayList<>();

        while (escolha != 5) {
            try {
                limparTerminal();
                System.out.println("\n                 MENU\n");
                System.out.println("|(1) - para a entrada de processos   |");
                System.out.println("|(2) - para a execução do processos  |");
                System.out.println("|(3) - para a impressão do processos |");
                System.out.println("|(4) - para modificar a execução     | Valor Atual:("+tempoExecucao+")");
                System.out.print("|(5) - para sair                     |\nEscolha:");
                escolha = sc.nextInt();

                switch (escolha) {
                    case 4:
                        int tempoExecucaoRsrv = tempoExecucao;
                        limparTerminal();
                        System.out.print("Digite o valor que sera descontado dos processos a cada ciclo(Digite '0') para voltar: ");
                        tempoExecucao = sc.nextInt();
                        if(tempoExecucao == 0 ){
                            tempoExecucao = tempoExecucaoRsrv;
                        }
                        break;
                        
                    case 1:
                         limparTerminal();
                        int tamanhoLista;

                        System.out.print("\nDigite o tamanho da lista de processos(Digite '0' para cancelar a operação): ");
                        tamanhoLista = sc.nextInt();

                        for (int i = 0; i < tamanhoLista; i++) {
                            if (tamanhoLista == 0){
                            break;
                            }
                            contador++;

                            System.out.println("");
                            System.out.print("Digite o nome do processo " + (i + 1) + ": ");
                            String nome = sc.next();
                            System.out.print("Digite o tempo restante do processo '"+ nome + "': ");

                            int tempoRestante = sc.nextInt();

                            processos.add(new Processo(nome, tempoRestante, tempoExecucao));
                            if (contador == 5) {
                                int escolha2;

                                System.out.println("Deseja adicionar mais um processo: (1)Sim (2)Não");
                                escolha2 = sc.nextInt();
                                if (escolha2 == 1) {
                                    System.out.print("Digite o nome do processo " + ": ");

                                    nome = sc.next();

                                    System.out.print("Digite o tempo restante do" + nome + " : ");

                                    tempoRestante = sc.nextInt();

                                    processos.add(new Processo(nome, tempoRestante, tempoExecucao));
                                }
                                else{
                                contador = 0;
                                }

                            }
                        }
                        break;

                    case 2:
                        limparTerminal();
                        System.out.println("\nExecutando os processos...");
                        double contagemTeste = 0;
                        if (processos.isEmpty()) {
                            System.out.println("Nenhum processo foi adicionado!");
                        } else {
                            while (!processos.isEmpty()) {
                                
                                Processo p = processos.get(0);
                                System.out.print("\nProcessando o processo " + p.getNome() + "\nTempo restante:" + p.getTempoRestante() + "Tempos - " + p.getTempoExecucao() + "Tempos");
                                p.executar();
                                System.out.println(" = " +p.getTempoRestante()+"Rst.\n");
                                System.out.print("-----------------------------------------------------------------------------------");
                                contagemTeste = contagemTeste + 2/2;
                                if(contagemTeste % 2 == 0 ){
                                    System.out.println("Ciclo "+(contagemTeste/2)+ " de processamento completo");
                                }

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
                limparTerminal();
                System.out.println("Ocorreu um erro durante a execução do programa. Por favor, tente novamente.\n\n\n\n");
                sc.nextLine(); // Limpa o buffer do scanner
            }
        }
        sc.close();
    }
     public static void limparTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
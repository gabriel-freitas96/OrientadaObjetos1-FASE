package Usuario;

import java.util.Scanner;
import excecoes.*;

public class SubMenuPlaylist {

    public void exibirSubMenuPlaylist(Scanner sc, Sistema sistema)  {

        int opcaoMenu = -1;

        while (opcaoMenu != 7) {

            System.out.println("\n--- SubMenu Playlist ---");
            System.out.println("1 - Adicionar música a uma playlist");
            System.out.println("2 - Remover música de uma playlist");
            System.out.println("3 - Deletar uma playlist");
            System.out.println("4 - Atualizar nome de uma playlist");
            System.out.println("5 - Ver duração total de uma playlist");
            System.out.println("6 - Visualizar músicas de uma playlist.");
            System.out.println("7 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            try {
                opcaoMenu = Integer.parseInt(sc.nextLine());

                switch (opcaoMenu) {
                    case 1 -> {
                        try {
                            sistema.adicionarMusicaAPlaylist(sc);
                        } catch (PlaylistNaoEncontradaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        System.out.println("\n--------------------------\n");
                    }

                    case 2 -> {
                        try {
                            sistema.removerMusicaPlaylist(sc);
                        } catch (PlaylistNaoEncontradaException | MusicaNaoEncontradaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                        System.out.println("\n--------------------------\n");
                    }

                    case 3 -> {
                       try {
                        sistema.deletarPlaylist(sc);
                    } catch (Exception e) {
                        System.out.println("Erro ao deletar playlist: " + e.getMessage());
                    }
                    System.out.println("\n--------------------------\n");
                }

                    case 4 -> {
                        try {
                            sistema.atualizarNomePlaylist(sc);
                        } catch (Exception e) {
                            System.out.println("Erro ao atualizar o nome: " + e.getMessage());
                        }
                        System.out.println("\n--------------------------\n");
                    }

                    case 5 -> { 
                         try {
                        sistema.mostrarDuracaoTotalPlaylist(sc);
                    } catch (Exception e) {
                        System.out.println("Erro ao calcular duração: " + e.getMessage());
                    }
                    System.out.println("\n--------------------------\n");
                }
                    case 6 -> {
                        try {
                            sistema.visualizarMusicasPlaylist(sc);
                        } catch (PlaylistNaoEncontradaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }

                    case 7 -> System.out.println("Voltando para o menu principal...");

                    default -> System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!\n--------------------------\n");
            }
        }
    }
}






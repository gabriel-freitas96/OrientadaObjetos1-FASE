package Usuario;

import java.util.Scanner;
import excecoes.*;

public class SubMenuPlaylist {

    public void exibirSubMenuPlaylist(Scanner sc, Sistema sistema)  {

        int opcaoMenu = -1;

        while (opcaoMenu != 7) {

            System.out.println("\nSubMenu playlist:");
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
                    }

                    case 2 -> {
                        try {
                            sistema.removerMusicaPlaylist(sc);
                        } catch (PlaylistNaoEncontradaException | MusicaNaoEncontradaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }

                    case 3 -> {
                        boolean sucesso = sistema.deletarPlaylist(sc);
                        if (!sucesso) {
                            System.out.println("Erro: Playlist não encontrada para deletar.");
                        }
                    }

                    case 4 -> sistema.atualizarNomePlaylist(sc);

                    case 5 -> sistema.mostrarDuracaoTotalPlaylist(sc);
                    
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
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }
}


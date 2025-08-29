import excecoes.MusicaNaoEncontrada;
import excecoes.PlaylistNaoEncontrada;

import java.util.Scanner;

public class SubMenuPlaylist {

    public void exibirSubMenuPlaylist(Scanner sc, Sistema sistema) {

        int opcao = -1;

        while (opcao != 6) {

            System.out.println("SubMenu playlist: ");
            System.out.println("Digite (1) para adicionar música a uma playlist.");
            System.out.println("Digite (2) para remover música de uma playlist.");
            System.out.println("Digite (3) para deletar uma playlist.");
            System.out.println("Digite (4) para atualizar nome de uma playlist.");
            System.out.println("Digite (5) para ver a duração total de uma playlist.");
            System.out.println("Digite (6) para voltar ao menu principal.");
            System.out.print("Escolha uma opção: ");
            int opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {

                case 1: {
                    try {
                        sistema.adicionarMusicaAPlaylist(sc);
                    } catch (PlaylistNaoEncontrada e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                }

                case 2: {
                    try{
                        sistema.removerMusicaPlaylist(sc);
                    } catch (PlaylistNaoEncontrada e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (MusicaNaoEncontrada e) {
                    System.out.println("Erro: " + e.getMessage());
                }

                    break;
                }

                case 3: {
                    sistema.deletarPlaylist(sc);
                    break;
                }

                case 4: {
                    sistema.atualizarNomePlaylist(sc);
                    break;
                }

                case 5: {
                    sistema.mostrarDuracaoTotalPlaylist(sc);
                    break;
                }

                case 6: {
                    System.out.println("Voltando para o menu principal...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida!");
                    break;
                }
            }
        }
    }
}

package www.br.com.unifacisa;

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
                    sistema.adicionarMusicaAPlaylist(sc);
                    break;
                }

                case 2: {
                    sistema.removerMusicaPlaylist(sc);
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

import excecoes.MusicaNaoEncontrada;
import excecoes.PlaylistNaoEncontrada;

import java.util.Scanner;

public class SubMenuPlaylist {

    public void exibirSubMenuPlaylist(Scanner sc, Sistema sistema) {

        int opcaoMenu = -1;

        while (opcaoMenu != 6) {

            System.out.println("SubMenu playlist: ");
            System.out.println("Digite (1) para adicionar música a uma playlist.");
            System.out.println("Digite (2) para remover música de uma playlist.");
            System.out.println("Digite (3) para deletar uma playlist.");
            System.out.println("Digite (4) para atualizar nome de uma playlist.");
            System.out.println("Digite (5) para ver a duração total de uma playlist.");
            System.out.println("Digite (6) para voltar ao menu principal.");
            System.out.print("Escolha uma opção: ");
            opcaoMenu = sc.nextInt();
            sc.nextLine();

            switch (opcaoMenu) {
                case 1 -> sistema.adicionarMusicaAPlaylist(sc);
                case 2 -> sistema.removerMusicaPlaylist(sc);
                case 3 -> sistema.deletarPlaylist(sc);
                case 4 -> sistema.atualizarNomePlaylist(sc);
                case 5 -> sistema.mostrarDuracaoTotalPlaylist(sc);
                case 6 -> System.out.println("Voltando para o menu principal...");
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}

package Usuario;

import java.util.Scanner;
import excecoes.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        SubMenuPlaylist submenu = new SubMenuPlaylist();
        int opcao = -1;

        while (opcao != 5) {
            System.out.println("\n" + "-".repeat(10) + " MENU " + "-".repeat(10));
            System.out.println("1 - Criar uma playlist");
            System.out.println("2 - Adicionar mídia ao catálogo");
            System.out.println("3 - Visualizar mídias do catálogo");
            System.out.println("4 - Acessar submenu de playlists");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 1 -> {
                        try {
                            sistema.criarPlaylist(sc);
                        } catch (UsuarioSemNomeException e) {
                            System.out.println("Erro: Nome do usuário é obrigatório.");
                        } catch (EmailInvalidoException e) {
                            System.out.println("Erro: Email inválido.");
                        } catch (PlaylistSemNomeException e) {
                            System.out.println("Erro: Nome da playlist não pode ser vazio.");
                        } catch (PlaylistExistenteException e) {
                            System.out.println("Erro: Já existe uma playlist com esse nome.");
                        }
                    }

                    case 2 -> {
                        try {
                            sistema.adicionarMidia(sc);
                        } catch (DuracaoMusicaException e) {
                            System.out.println("Erro: " + e.getMessage());
                        } catch (TipoDeMidiaInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                        } catch (GeneroMusicalInvalidoException e) {
                            System.out.println("Erro: " + e.getMessage());
                        }
                    }

                    case 3 -> sistema.visualizarMidia(sc);
                      
                    case 4 -> submenu.exibirSubMenuPlaylist(sc, sistema);

                    case 5 -> System.out.println("Saindo do sistema... Até logo!");

                    default -> System.out.println("Opção inválida! Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite apenas números para as opções do menu.");
            }
        }

        sc.close();
    }
}

import excecoes.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sistema sistema = new Sistema();
        SubMenuPlaylist submenu = new SubMenuPlaylist();
        int opcao = -1;

        while (opcao != 5) {
            System.out.println("-".repeat(10) + "Menu" + "-".repeat(10));
            System.out.println("Digite (1) para criar uma playlist.");
            System.out.println("Digite (2) para adicionar mídia ao catálogo.");
            System.out.println("Digite (3) para visualizar uma mídia.");
            System.out.println("Digite (4) ➡ Playlist ");
            System.out.println("Digite (5) para sair.");
            System.out.println("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: {
                    try {
                        sistema.criarPlaylist(sc);
                    } catch (PlaylistExistente e) {
                        System.out.println("Erro: " + e.getMessage());
                    }catch (PlaylistSemNome e) {
                        System.out.println("Erro: " + e.getMessage());
                    }catch (UsuarioSemNome e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (EmailInvalido e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;
                }
                case 2: {
                    try {
                        sistema.adicionarMidia(sc);
                    }catch (DuracaoMusica e) {
                        System.out.println("Erro: " + e.getMessage());
                    }catch (TipoDeMidiaInvalido e) {
                        System.out.println("Erro: " + e.getMessage());
                    }catch (GeneroMusicalInvalido e) {
                        System.out.println("Erro: " + e.getMessage());
                    }

                    break;
                }
                case 3: {
                	//Ainda vou fazer o método
                   break;
                }
                case 4: {
                        submenu.exibirSubMenuPlaylist(sc, sistema);
                	break;
                }
                case 5: {
                    System.out.println("Saindo do sistema...");
                    break;
                }
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
                }
            }
        }

        sc.close(); 
    }
}
			
			
			
		
		


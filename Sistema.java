package www.br.com.unifacisa;

import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private Catalogo catalogo = new Catalogo();

    public Sistema(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Sistema() {
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void criarPlaylist(Scanner sc) {
        System.out.println("Para criar uma playlist, é necessário criar um cadastro.");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.println("Cadastro concluído com sucesso!");

        Usuario usuario = new Usuario(nome, email);

        System.out.print("Agora crie um nome para a playlist: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = new Playlist(nomePlaylist, usuario);
        System.out.println("Playlist criada com sucesso e pronta para adicionar músicas!");

        adicionarPlaylist(playlist);
    }

    public void adicionarPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void adicionarMidia(Scanner sc) {
        System.out.print("Digite o título da mídia: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o nome do(a) artista da mídia: ");
        String artista = sc.nextLine();
        System.out.print("Qual a duração da mídia: ");
        double duracao = sc.nextDouble();
        sc.nextLine();

        System.out.print("Qual é o tipo de mídia que vai adicionar à playlist? (1 - Música, 2 - Podcast, 3 - Audiobook): ");
        int opcaoMidia = sc.nextInt();
        sc.nextLine();

        if (opcaoMidia == 1) {
            adicionarMusicaMidia(sc, titulo, artista, duracao);
        } else if (opcaoMidia == 2) {
            adicionarPodcastMidia(sc, titulo, artista, duracao);
        } else if (opcaoMidia == 3) {
            adicionarAudiobookMidia(sc, titulo, artista, duracao);
        } else {
            System.out.println("Tipo de mídia inválida.");
        }
    }

    public void adicionarMusicaMidia(Scanner sc, String titulo, String artista, double duracao) {
        System.out.print("Digite o gênero musical (Clássica, Pop, Rock, Rap ou Mpb): ");
        String genero = sc.nextLine();

        Musica musica = new Musica(titulo, artista, duracao);

        if (genero.equalsIgnoreCase("Clássica")) {
            musica.setGenero(GeneroMusical.CLASSICA);
        } else if (genero.equalsIgnoreCase("Pop")) {
            musica.setGenero(GeneroMusical.POP);
        } else if (genero.equalsIgnoreCase("Rock")) {
            musica.setGenero(GeneroMusical.ROCK);
        } else if (genero.equalsIgnoreCase("Mpb")) {
            musica.setGenero(GeneroMusical.MPB);
        } else if (genero.equalsIgnoreCase("Rap")) {
            musica.setGenero(GeneroMusical.RAP);
        } else {
            System.out.println("Gênero musical inválido.");
        }

        catalogo.adicionarMidia(musica);
        System.out.println("Mídia adicionada com sucesso!");
    }

    public void adicionarPodcastMidia(Scanner sc, String titulo, String artista, double duracao) {
        Podcast podcast = new Podcast(titulo, artista, duracao);
        catalogo.adicionarMidia(podcast);
        System.out.println("Mídia adicionada com sucesso!");
    }

    public void adicionarAudiobookMidia(Scanner sc, String titulo, String artista, double duracao) {
        Audiobook audiobook = new Audiobook(titulo, artista, duracao);
        catalogo.adicionarMidia(audiobook);
        System.out.println("Mídia adicionada com sucesso!");
    }

    public void adicionarMusicaAPlaylist(Scanner sc) {
        System.out.print("Digite o título da música que deseja adicionar na playlist: ");
        String tituloMusica = sc.nextLine();

        System.out.print("Digite o nome da playlist que deseja adicionar a música: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);

        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
        } else {
            Musica musica = null;
            for (Midia midia : catalogo.getMidias()) {
                if (midia instanceof Musica && midia.getTitulo().equalsIgnoreCase(tituloMusica)) {
                    musica = (Musica) midia;
                    break;
                }
            }

            if (musica == null) {
                System.out.println("Música não encontrada!");
            } else {
                playlist.getMusicas().add(musica);
                System.out.println("Música adicionada com sucesso na playlist!");
            }
        }
    }


    public Playlist buscarPlaylistPeloNome(String nomePlaylist) {
        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomePlaylist)) {
                return playlist;
            }
        }
        return null;
    }
    
    public void removerMusicaPlaylist(Scanner sc) {
        System.out.print("Digite o nome da música para remover: ");
        String nomeMusica = sc.nextLine();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);

        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
        } else {
            removerMusica(nomeMusica, playlist);
        }
    }


    public boolean removerMusica(String nomeMusica, Playlist playlist) {
        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
            return false;
        }

        ArrayList<Musica> musicas = playlist.getMusicas();

        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica.trim())) {
                musicas.remove(i);
                System.out.println("A música foi removida da playlist com sucesso!");
                return true;
            }
        }

        System.out.println("Música não encontrada na playlist!");
        return false;
    }

    public void atualizarNomePlaylist(Scanner sc) {
        System.out.print("Digite o email para acessar as playlists: ");
        String emailUsuario = sc.nextLine();
        System.out.print("Digite o nome da playlist que deseja alterar: ");
        String nomeAntigoP = sc.nextLine();
        System.out.print("Digite o novo nome que deseja dar a playlist: ");
        String novoNomeP = sc.nextLine();

        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomeAntigoP) && playlist.getUsuario().getEmail().equals(emailUsuario)) {
                playlist.setNome(novoNomeP);
                System.out.println("Nome da playlist foi atualizado com sucesso!");
            } else {
                System.out.println("Nenhuma playlist foi encontrada para esse Usuário!");
            }
        }
    }

    public boolean deletarPlaylist(Scanner sc) {
        System.out.print("Digite o nome da playlist que deseja deletar: ");
        String nomeDeletarP = sc.nextLine();

        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getNome().equalsIgnoreCase(nomeDeletarP)) {
                playlists.remove(i);
                System.out.println("Playlist foi deletada com sucesso!");
                return true;
            }
        }
        return false;
    }
    
    public void mostrarDuracaoTotalPlaylist(Scanner sc) {
        System.out.print("Digite o nome da playlist que deseja ver a duração: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
            return;
        }

        double total = 0;
        for (Musica musica : playlist.getMusicas()) {
            total += musica.getDuracao();
        }

        System.out.println("Duração total da playlist: " + total + " minutos");
    
    
    
    }
    
 
}

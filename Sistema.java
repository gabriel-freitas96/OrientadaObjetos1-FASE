package Usuario;

import java.util.ArrayList;
import java.util.Scanner;
import excecoes.*;

public class Sistema {

    private ArrayList<Playlist> playlists = new ArrayList<>();
    private Catalogo catalogo = new Catalogo();

    public Sistema() {
    }

    public Sistema(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }
    public void criarPlaylist(Scanner sc) throws UsuarioSemNome, EmailInvalido, PlaylistSemNome, PlaylistExistente {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            throw new UsuarioSemNome("Nome do usuário não pode ser vazio!");
        }

        System.out.print("Digite seu email: ");
        String email = sc.nextLine().trim();
        if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new EmailInvalido("E-mail inválido!");
        }

        System.out.print("Agora crie um nome para a playlist: ");
        String nomePlaylist = sc.nextLine().trim();
        if (nomePlaylist.isEmpty()) {
            throw new PlaylistSemNome("Nome da playlist não pode ser vazio!");
        }
        for (Playlist p : playlists) {
            if (p.getNome().equalsIgnoreCase(nomePlaylist) && p.getUsuario().getEmail().equalsIgnoreCase(email)) {
                throw new PlaylistExistente("Playlist já existe para este usuário!");
            }
        }
        Usuario usuario = new Usuario(nome, email);
        Playlist novaPlaylist = new Playlist(nomePlaylist, usuario);
        playlists.add(novaPlaylist);

        System.out.println("Playlist criada com sucesso!");
    }

    public void adicionarMidia(Scanner sc) throws DuracaoMusica, TipoDeMidiaInvalido, GeneroMusicalInvalido {
        System.out.print("Digite o título da mídia: ");
        String titulo = sc.nextLine().trim();

        System.out.print("Digite o nome do(a) artista da mídia: ");
        String artista = sc.nextLine().trim();

        System.out.print("Qual a duração da mídia (em minutos): ");
        double duracao;
        try {
            duracao = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new DuracaoMusica("Duração inválida! Deve ser um número.");
        }

        if (duracao <= 0) {
            throw new DuracaoMusica("A duração da mídia deve ser maior que 0!");
        }

        System.out.print("Qual é o tipo de mídia que vai adicionar à playlist? (1 - Música, 2 - Podcast, 3 - Audiobook): ");
        int opcaoMidia;
        try {
            opcaoMidia = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new TipoDeMidiaInvalido("Tipo de mídia inválido!");
        }

        switch (opcaoMidia) {
            case 1 -> {
                System.out.print("Digite o gênero musical (Clássica, Pop, Rock, Rap ou Mpb): ");
                String genero = sc.nextLine().trim();
                adicionarMusicaMidia(titulo, artista, duracao, genero);
            }
            case 2 -> {
                adicionarPodcastMidia(titulo, artista, duracao);
            }
            case 3 -> {
                adicionarAudiobookMidia(titulo, artista, duracao);
            }
            default -> throw new TipoDeMidiaInvalido("Tipo de Mídia inválido!");
        }
    }
    public void adicionarMusicaMidia(String titulo, String artista, double duracao, String genero) throws GeneroMusicalInvalido {
        Musica musica = new Musica(titulo, artista, duracao);

        switch (genero.toLowerCase()) {
            case "clássica", "classica" -> musica.setGenero(GeneroMusical.CLASSICA);
            case "pop" -> musica.setGenero(GeneroMusical.POP);
            case "rock" -> musica.setGenero(GeneroMusical.ROCK);
            case "rap" -> musica.setGenero(GeneroMusical.RAP);
            case "mpb" -> musica.setGenero(GeneroMusical.MPB);
            default -> throw new GeneroMusicalInvalido("Gênero musical inválido!");
        }

        catalogo.adicionarMidia(musica);
        System.out.println("Música adicionada com sucesso!");
    }

    public void adicionarPodcastMidia(String titulo, String artista, double duracao) {
        Podcast podcast = new Podcast(titulo, artista, duracao);
        catalogo.adicionarMidia(podcast);
        System.out.println("Podcast adicionado com sucesso!");
    }

    public void adicionarAudiobookMidia(String titulo, String artista, double duracao) {
        Audiobook audiobook = new Audiobook(titulo, artista, duracao);
        catalogo.adicionarMidia(audiobook);
        System.out.println("Audiobook adicionado com sucesso!");
    }
    public void adicionarMusicaAPlaylist(Scanner sc) throws PlaylistNaoEncontradaException {
        System.out.print("Digite o título da música que deseja adicionar na playlist: ");
        String tituloMusica = sc.nextLine().trim();

        System.out.print("Digite o nome da playlist que deseja adicionar a música: ");
        String nomePlaylist = sc.nextLine().trim();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        }

        Musica musica = null;
        for (Midia midia : catalogo.getMidias()) {
            if (midia instanceof Musica && midia.getTitulo().equalsIgnoreCase(tituloMusica)) {
                musica = (Musica) midia;
                break;
            }
        }
        if (musica == null) {
            System.out.println("Música não encontrada no catálogo!");
        } else {
            playlist.getMusicas().add(musica);
            System.out.println("Música adicionada com sucesso na playlist!");
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
    public void removerMusicaPlaylist(Scanner sc) throws PlaylistNaoEncontradaException, MusicaNaoEncontradaException {
        System.out.print("Digite o nome da música para remover: ");
        String nomeMusica = sc.nextLine().trim();

        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine().trim();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        }
        removerMusica(nomeMusica, playlist);
    }
    public boolean removerMusica(String nomeMusica, Playlist playlist) throws MusicaNaoEncontradaException {
        ArrayList<Musica> musicas = playlist.getMusicas();
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica)) {
                musicas.remove(i);
                System.out.println("A música foi removida da playlist com sucesso!");
                return true;
            }
        }
        throw new MusicaNaoEncontradaException("Música não encontrada na playlist!");
    }
    public void atualizarNomePlaylist(Scanner sc) {
        System.out.print("Digite o email para acessar as playlists: ");
        String emailUsuario = sc.nextLine().trim();

        System.out.print("Digite o nome da playlist que deseja alterar: ");
        String nomeAntigoP = sc.nextLine().trim();

        System.out.print("Digite o novo nome que deseja dar à playlist: ");
        String novoNomeP = sc.nextLine().trim();

        boolean alterado = false;

        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomeAntigoP) &&
                    playlist.getUsuario().getEmail().equalsIgnoreCase(emailUsuario)) {
                playlist.setNome(novoNomeP);
                System.out.println("Nome da playlist foi atualizado com sucesso!");
                alterado = true;
                break;
            }
        }
        if (!alterado) {
            System.out.println("Nenhuma playlist foi encontrada para esse usuário!");
        }
    }
    public boolean deletarPlaylist(Scanner sc) {
        System.out.print("Digite o nome da playlist que deseja deletar: ");
        String nomeDeletarP = sc.nextLine().trim();

        for (int i = 0; i < playlists.size(); i++) {
            if (playlists.get(i).getNome().equalsIgnoreCase(nomeDeletarP)) {
                playlists.remove(i);
                System.out.println("Playlist foi deletada com sucesso!");
                return true;
            }
        }
        System.out.println("Playlist não encontrada.");
        return false;
    }
    public void mostrarDuracaoTotalPlaylist(Scanner sc) {
        System.out.print("Digite o nome da playlist que deseja ver a duração: ");
        String nomePlaylist = sc.nextLine().trim();
        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            System.out.println("Playlist não encontrada!");
            return;
        }
        double total = 0;
        for (Musica musica : playlist.getMusicas()) {
            total += musica.getDuracao();
        }
        System.out.printf("Duração total da playlist: %.2f minutos%n", total);
    }
    public void visualizarMusicasPlaylist(Scanner sc) throws PlaylistNaoEncontradaException {
        System.out.print("Digite o nome da playlist que deseja visualizar: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);

        if (playlist == null) {
            throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        }

        ArrayList<Musica> musicas = playlist.getMusicas();

        if (musicas.isEmpty()) {
            System.out.println("A playlist está vazia.");
        } else {
            System.out.println("Músicas da playlist '" + playlist.getNome() + "':");
            for (Musica musica : musicas) {
                System.out.printf("- %s - %s (%.2f minutos)%n", 
                    musica.getTitulo(), musica.getArtista(), musica.getDuracao());
            }
        }
    }
}

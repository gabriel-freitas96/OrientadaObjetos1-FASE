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

    public void criarPlaylist(Scanner sc) throws UsuarioSemNomeException, EmailInvalidoException, PlaylistSemNomeException, PlaylistExistenteException {
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        if (nome.trim().isEmpty()) {
            throw new UsuarioSemNomeException("Nome do usuário não pode ser vazio!");
        }

        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        if (!email.contains("@")) {
            throw new EmailInvalidoException("E-mail inválido!");
        }

        System.out.print("Agora crie um nome para a playlist: ");
        String nomePlaylist = sc.nextLine();
        if (nomePlaylist.trim().isEmpty()) {
            throw new PlaylistSemNomeException("Nome da playlist não pode ser vazio!");
        }

       
        if (buscarPlaylistPeloNome(nomePlaylist) != null) {
            throw new PlaylistExistenteException("Já existe uma playlist com esse nome!");
        }

        Usuario usuario = new Usuario(nome, email);
        Playlist playlist = new Playlist(nomePlaylist, usuario);

        
        playlists.add(playlist);

        System.out.println("Playlist '" + nomePlaylist + "' criada com sucesso!");
    }

    public void adicionarMidia(Scanner sc) throws DuracaoMusicaException, TipoDeMidiaInvalidoException, GeneroMusicalInvalidoException {
        System.out.print("Digite o título da mídia: ");
        String titulo = sc.nextLine();
        System.out.print("Digite o nome do(a) artista da mídia: ");
        String artista = sc.nextLine();
        System.out.print("Qual a duração da mídia: ");
        double duracao = sc.nextDouble();
        sc.nextLine();

        if (duracao <= 0) {
            throw new DuracaoMusicaException("A duração da mídia deve ser maior que 0!");
        }

        System.out.print("Qual é o tipo de mídia que vai adicionar à playlist? (1 - Música, 2 - Podcast, 3 - Audiobook): ");
        int opcaoMidia = sc.nextInt();
        sc.nextLine();

        switch (opcaoMidia) {
            case 1 -> adicionarMusicaMidia(sc, titulo, artista, duracao);
            case 2 -> adicionarPodcastMidia(titulo, artista, duracao);
            case 3 -> adicionarAudiobookMidia(titulo, artista, duracao);
            default -> throw new TipoDeMidiaInvalidoException("Tipo de Mídia inválido!");
        }
    }

    public void adicionarMusicaMidia(Scanner sc, String titulo, String artista, double duracao) throws GeneroMusicalInvalidoException {
        System.out.print("Digite o gênero musical (Clássica, Pop, Rock, Rap ou Mpb): ");
        String genero = sc.nextLine();
        Musica musica = new Musica(titulo, artista, duracao);

        switch (genero.toLowerCase()) {
            case "clássica" -> musica.setGenero(GeneroMusical.CLASSICA);
            case "pop" -> musica.setGenero(GeneroMusical.POP);
            case "rock" -> musica.setGenero(GeneroMusical.ROCK);
            case "rap" -> musica.setGenero(GeneroMusical.RAP);
            case "mpb" -> musica.setGenero(GeneroMusical.MPB);
            default -> throw new GeneroMusicalInvalidoException("Gênero musical inválido!");
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
        String tituloMusica = sc.nextLine();
        System.out.print("Digite o nome da playlist que deseja adicionar a música: ");
        String nomePlaylist = sc.nextLine();

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
            System.out.println("Música não encontrada!");
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
        String nomeMusica = sc.nextLine();
        System.out.print("Digite o nome da playlist: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        }

        removerMusica(nomeMusica, playlist);
    }

    public boolean removerMusica(String nomeMusica, Playlist playlist) throws MusicaNaoEncontradaException {
        ArrayList<Musica> musicas = playlist.getMusicas();
        for (int i = 0; i < musicas.size(); i++) {
            if (musicas.get(i).getTitulo().equalsIgnoreCase(nomeMusica.trim())) {
                musicas.remove(i);
                System.out.println("A música foi removida da playlist com sucesso!");
                return true;
            }
        }
        throw new MusicaNaoEncontradaException("Música não encontrada!");
    }

    public void atualizarNomePlaylist(Scanner sc) {
        System.out.print("Digite o email para acessar as playlists: ");
        String emailUsuario = sc.nextLine();
        System.out.print("Digite o nome da playlist que deseja alterar: ");
        String nomeAntigoP = sc.nextLine();
        System.out.print("Digite o novo nome que deseja dar à playlist: ");
        String novoNomeP = sc.nextLine();

        boolean alterado = false;

        for (Playlist playlist : playlists) {
            if (playlist.getNome().equalsIgnoreCase(nomeAntigoP) && playlist.getUsuario().getEmail().equalsIgnoreCase(emailUsuario)) {
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
        String nomeDeletarP = sc.nextLine();

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

        System.out.printf("Duração total da playlist: %.2f minutos%n", total);
    }
    
    
    public void visualizarMidia(Scanner sc) {
        if (catalogo.getMidias().isEmpty()) {
            System.out.println("O catálogo está vazio.");
            return;
        }

        System.out.println("Pesquisar mídia por:");
        System.out.println("1 - Título");
        System.out.println("2 - Artista");
        System.out.println("3 - Gênero (apenas músicas)");
        System.out.print("Escolha uma opção: ");
        int opcao = sc.nextInt();
        sc.nextLine(); 

        ArrayList<Midia> resultados = new ArrayList<>();

        switch (opcao) {
            case 1:
                System.out.print("Digite o título da mídia: ");
                String titulo = sc.nextLine();
                for (Midia m : catalogo.getMidias()) {
                    if (m.getTitulo().equalsIgnoreCase(titulo)) {
                        resultados.add(m);
                    }
                }
                break;

            case 2:
                System.out.print("Digite o nome do artista: ");
                String artista = sc.nextLine();
                for (Midia m : catalogo.getMidias()) {
                    if (m.getArtista().equalsIgnoreCase(artista)) {
                        resultados.add(m);
                    }
                }
                break;

            case 3:
                System.out.print("Digite o gênero (ex: ROCK, POP, MPB, RAP, CLASSICA): ");
                String generoStr = sc.nextLine().toUpperCase();
                try {
                    GeneroMusical genero = GeneroMusical.valueOf(generoStr);
                    for (Midia m : catalogo.getMidias()) {
                        if (m instanceof Musica) {
                            Musica musica = (Musica) m;
                            if (musica.getGenero() == genero) {
                                resultados.add(m);
                            }
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Gênero inválido!");
                    return;
                }
                break;

            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhuma mídia encontrada.");
        } else {
            System.out.println("Resultados encontrados:");
            for (Midia m : resultados) {
                System.out.println(m); 
            }
        }
    }
    
    
    public void visualizarMusicasPlaylist(Scanner sc) throws PlaylistNaoEncontradaException {
        System.out.print("Digite o nome da playlist que deseja visualizar: ");
        String nomePlaylist = sc.nextLine();

        Playlist playlist = buscarPlaylistPeloNome(nomePlaylist);
        if (playlist == null) {
            throw new PlaylistNaoEncontradaException("Playlist não encontrada!");
        }

        System.out.println("\n--- Músicas da Playlist: " + playlist.getNome() + " ---");
        if (playlist.getMusicas().isEmpty()) {
            System.out.println("Nenhuma música adicionada ainda.");
        } else {
            int i = 1;
            for (Musica musica : playlist.getMusicas()) {
                System.out.println(i + ". " + musica.getTitulo() + " - " + musica.getArtista());
                i++;
            }
        }
    }
}

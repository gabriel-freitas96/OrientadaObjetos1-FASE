package Usuario;

import Usuario.Catalogo;



public class Main {

    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Midia m1 = new Musica("Imagine", "John Lennon", 180, Genero.ROCK);
        Midia m2 = new Musica("Águas de Março", "Tom Jobim", 200, Genero.MPB);

        catalogo.adicionarMidia(m1);
        catalogo.adicionarMidia(m2);

        Usuario user = new Usuario("Ana", "ana@email.com");
        user.criarPlaylist("Favoritas");

        Playlist favoritas = user.getPlaylist("Favoritas");

        favoritas.adicionarMusica(m1);
        favoritas.adicionarMusica(m2);

        favoritas.visualizarPlaylist(catalogo);

        System.out.println("Duração total: " + favoritas.calcularDuracaoTotal(catalogo) + " segundos");
    }
}

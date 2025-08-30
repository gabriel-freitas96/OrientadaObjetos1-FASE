package excecoes;

public class PlaylistSemNome extends Exception {
    public PlaylistSemNome(String mensagem) {
        super(mensagem);
    }
}

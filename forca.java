
public class forca {
    public static void main(String[] args) {
        String nome = "MANOELA SUA LINDA";
        Jogador jogador = new Jogador(nome);
        Palavra palavra = new Palavra();
        Jogo jogo = new Jogo(palavra, jogador);

        jogo.iniciarJogo();
    }
}


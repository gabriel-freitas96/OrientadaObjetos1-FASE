# 🎶 Sistema de Playlists em Java

Um projeto simples em **Java** que permite gerenciar **usuários, mídias
(músicas, podcasts e audiobooks), playlists e catálogo de músicas**.\
Este sistema foi construído com base em **requisitos funcionais
mínimos** de um aplicativo de streaming.

------------------------------------------------------------------------

## ✨ Funcionalidades

✅ Cadastro de **usuários** com nome e e-mail\
✅ Criação e gerenciamento de **playlists** (adicionar, remover e
visualizar mídias)\
✅ Suporte a diferentes tipos de **mídias**: Música, Podcast e
Audiobook\
✅ Atributos das mídias: título, artista, duração e gênero\
✅ Enumeração de **gêneros musicais** (ROCK, POP, MPB, JAZZ, CLÁSSICA,
etc.)\
✅ **Catálogo geral** de mídias disponíveis\
✅ Busca de mídias por **título, artista ou gênero**\
✅ Cálculo da **duração total da playlist**

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

    src/
     ├── App.java        # Classe principal (main)
     ├── Usuario.java    # Representa o usuário do sistema
     ├── Playlist.java   # Representa playlists de um usuário
     ├── Midia.java      # Classe abstrata para Música, Podcast e Audiobook
     ├── Musica.java
     ├── Podcast.java
     ├── Audiobook.java
     ├── Catalogo.java   # Repositório geral de mídias
     └── Genero.java     # Enumeração dos gêneros musicais

------------------------------------------------------------------------

## 🖥️ Exemplo de Uso

Ao rodar a aplicação (`App.java`), o sistema cria um usuário, cadastra
mídias no catálogo, cria uma playlist e mostra na tela:

    Playlist: Favoritas 🎧
     - [Música] Pais e Filhos - Legião Urbana (4:59, ROCK)
     - [Música] Garota de Ipanema - Tom Jobim (4:15, MPB)
    Duração total: 9:14

    Busca por artista 'Tom Jobim':
     - [Música] Garota de Ipanema - Tom Jobim (4:15, MPB)

------------------------------------------------------------------------

## 🚀 Como Executar

1.  Clone este repositório:

    ``` bash
    git clone (https://github.com/gabriel-freitas96/OrientadaObjetos1-FASE.git)
    ```

2.  Entre no diretório do projeto:

    ``` bash
    cd projeto-playlist-java/src
    ```

3.  Compile e rode a aplicação:

    ``` bash
    javac App.java
    java App
    ```

------------------------------------------------------------------------

## 🛠️ Tecnologias Utilizadas

-   ☕ **Java 17+**
-   🗂️ **Programação Orientada a Objetos (POO)**
-   📝 **Enumerações e Coleções (List, ArrayList, Stream API)**

------------------------------------------------------------------------

## 📌 Possíveis Melhorias Futuras

-   [ ] Tornar o programa **interativo via console** (menu para o
    usuário escolher opções).\
-   [ ] Persistência de dados em arquivo ou banco de dados (SQLite).\
-   [ ] API REST com **Spring Boot**.\
-   [ ] Interface gráfica (Swing/JavaFX).

------------------------------------------------------------------------

## 👨‍💻 Autor

Desenvolvido com 💙 por **\[Gabriel Lacerda,Samires do Carmo,Henry Galdino,Miguel Viana\]**\


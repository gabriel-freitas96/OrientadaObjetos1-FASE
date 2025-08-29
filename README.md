# 🎵 Projeto: Sistema de Gerenciamento de Playlists Musicais

Este projeto é uma aplicação simples em Java que permite gerenciar usuários, mídias (músicas, podcasts e audiobooks), playlists e um catálogo de mídias. Ideal para aprendizado de conceitos de orientação a objetos.

---

## 🚀 Funcionalidades

### 👤 Usuário
- Cadastro com nome e e-mail.
- Criação e gerenciamento de playlists.
- Adição e remoção de músicas nas suas playlists.
- Visualização de playlists e das músicas contidas.

### 🎧 Mídias
- Tipos: músicas, podcasts ou audiobooks.
- Atributos: título, artista, duração e gênero.
- Armazenadas em um catálogo geral disponível para todos os usuários.

### 📂 Playlist
- Contém apenas **nomes das músicas** (referência às mídias do catálogo).
- Pertence a um único usuário.
- Capaz de calcular a duração total da playlist.
- Permite visualizar detalhes das músicas e da playlist.

### 🎼 Gêneros Musicais
- Implementado com uma enumeração `Genero`, com valores como:  
  `ROCK`, `POP`, `MPB`, `JAZZ`, `CLASSICA`, etc.

---

## 📦 Estrutura de Classes

- `Usuario` – Representa um usuário com nome, e-mail e suas playlists.
- `Playlist` – Representa uma playlist com nome, dono e músicas (nomes).
- `Midia` – Representa uma mídia com título, artista, duração, gênero e tipo.
- `Catalogo` – Contém todas as mídias disponíveis no sistema.
- `Genero` – Enumeração com os gêneros musicais disponíveis.

---

🛠️ Tecnologias Utilizadas

Java 8+ (ou superior)

Paradigma de Programação Orientado a Objetos (POO)

📚 Possíveis Expansões

Suporte a múltiplos tipos de mídia com comportamento específico.

Integração com banco de dados para persistência.

Interface gráfica com JavaFX ou Swing.

Exportação/importação de playlists.

Sistema de autenticação e login.

📄 Licença

Este projeto é de código aberto e pode ser usado livremente para fins educacionais.

🤝 Contribuição

Gabriel Lacerda
Miguel Viana
Samires Carmo
Henry Galdino


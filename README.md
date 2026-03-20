# 🧩 Pokedle CLI

Aplicação CLI inspirado no famoso **Wordle**, mas com temática de Pokémon. O objetivo é adivinhar o Pokémon correto com base em dicas geradas a cada tentativa.

---

## 🚀 Funcionalidades

* 🎮 Jogo no terminal (CLI)
* 🔍 Sistema de tentativas com feedback
* 📊 Comparação de atributos do Pokémon (tipo, peso, altura, nome)
* 🎯 Lógica de validação semelhante ao Wordle

---

## 🛠️ Tecnologias utilizadas

* Java
* Maven

---

## 📦 Como rodar o projeto

### 🔧 Pré-requisitos

* Java 17+
* Maven instalado

### ▶️ Executando

````bash
mvn clean package
java -jar .\target\pokedle-cli-1.0-SNAPSHOT.jar
````

---

## 🧠 Como funciona

O jogo escolhe um Pokémon aleatório como resposta.

A cada tentativa do jogador:

* O nome é validado
* As características são comparadas com o Pokémon correto
* Feedback é exibido indicando proximidade ou acerto

---


# Conversor de Moedas

Este é um projeto de console simples em Java para conversão de moedas em tempo real. Ele utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para obter as cotações mais recentes e realizar os cálculos.

## Funcionalidades

O aplicativo oferece um menu de console com as seguintes opções:

  * Conversões pré-definidas:
      * Real Brasileiro (BRL) para Dólar Americano (USD)
      * Dólar Americano (USD) para Real Brasileiro (BRL)
      * Real Brasileiro (BRL) para Euro (EUR)
      * Euro (EUR) para Real Brasileiro (BRL)
      * Real Brasileiro (BRL) para Peso Argentino (ARS)
      * Peso Argentino (ARS) para Real Brasileiro (BRL)
  * Conversão personalizada (escolha da moeda base e da moeda-alvo).
  * Saída formatada exibindo o valor da conversão.

## Pré-requisitos

Para executar este projeto, você precisará de:

1.  **Java JDK 11 ou superior:** O projeto utiliza o `java.net.http.HttpClient`, que foi introduzido no Java 11. Os arquivos de configuração do projeto especificam o JDK 22.
2.  **Biblioteca Gson:** O projeto usa a biblioteca `com.google.gson` para processar o JSON retornado pela API. O arquivo `.iml` do projeto aponta para uma versão específica (`gson-2.13.1.jar`).
3.  **Chave de API (API Key):** Uma chave de API gratuita da [ExchangeRate-API](https://www.exchangerate-api.com/).

## Como Configurar

O projeto **não** usa Maven ou Gradle. A configuração de dependências e da API deve ser feita manualmente.

### 1\. Obter a Chave de API

1.  Acesse [https://www.exchangerate-api.com/](https://www.exchangerate-api.com/) e crie uma conta gratuita.
2.  No seu painel (dashboard), você encontrará sua chave de API (API Key).

### 2\. Criar o arquivo `config.properties`

Este projeto lê a chave de API de um arquivo de propriedades que não está incluído no repositório (por segurança).

1.  Na raiz do projeto (na mesma pasta que o diretório `src`), crie um novo arquivo chamado `config.properties`.

2.  Dentro deste arquivo, adicione o seguinte conteúdo, substituindo `SUA_CHAVE_API_AQUI` pela chave que você obteve no passo anterior:

    ```properties
    api_key=SUA_CHAVE_API_AQUI
    ```

### 3\. Adicionar a Biblioteca Gson

Você precisa baixar o arquivo `.jar` do Gson e adicioná-lo ao classpath do seu projeto.

1.  Baixe o `.jar` do Gson (ex: `gson-2.13.1.jar`) do [repositório oficial do Maven](https://search.maven.org/artifact/com.google.code.gson/gson) ou do [site do Google](https://github.com/google/gson).
2.  Adicione este `.jar` ao seu projeto:
      * **Se estiver usando IntelliJ IDEA (recomendado):**
        1.  Crie uma pasta `lib` na raiz do projeto e copie o `.jar` para dentro dela.
        2.  Clique com o botão direito no arquivo `.jar` e selecione "Add as Library...".
            *ou*
        3.  Vá em `File` \> `Project Structure...` \> `Modules`.
        4.  Selecione a aba `Dependencies`.
        5.  Clique no `+` e escolha "JARs or directories...".
        6.  Navegue até o local onde você baixou o `gson-2.13.1.jar` e adicione-o.
      * **Se estiver usando Eclipse:**
        1.  Crie uma pasta `lib` e copie o `.jar` para dentro dela.
        2.  Clique com o botão direito no projeto \> `Build Path` \> `Configure Build Path...`.
        3.  Vá para a aba `Libraries` e clique em "Add JARs..." ou "Add External JARs...".
        4.  Selecione o arquivo `gson-2.13.1.jar`.

## Como Executar

Após concluir a configuração, você pode executar o projeto.

### 1\. Através de uma IDE (IntelliJ, Eclipse, etc.)

Esta é a maneira mais fácil.

1.  Abra o projeto na sua IDE.
2.  Certifique-se de que a configuração (API key e Gson) foi feita corretamente.
3.  Encontre o arquivo `App.java`.
4.  Clique com o botão direito no arquivo e selecione "Run 'App.main()'".

### 2\. Através da Linha de Comando (Terminal)

Você pode compilar e executar o projeto manualmente se tiver o JDK configurado em seu `PATH`.

```bash
# Navegue até a pasta do projeto (que contém a pasta 'src')
cd /caminho/para/conversor-de-moedas

# 1. Compile os arquivos .java
# (Substitua 'path/to/gson.jar' pelo caminho real do seu arquivo Gson)
# No Windows (use ponto e vírgula ';')
javac -cp ".;path/to/gson.jar" src/*.java

# No Linux/Mac (use dois pontos ':')
javac -cp ".:path/to/gson.jar" src/*.java

# 2. Execute a classe principal (App)
# (Use o mesmo classpath da compilação)
# No Windows
java -cp ".;path/to/gson.jar;src" App

# No Linux/Mac
java -cp ".:path/to/gson.jar:src" App
```

O menu do conversor de moedas aparecerá no seu terminal.

# Conversor de Moeda (Dólar para Real) 💰🇺🇸➡️🇧🇷

Este é um projeto de uma aplicação Android feita em Kotlin, que converte valores entre Dólar (USD) e Real (BRL). A aplicação consome a API **AwesomeAPI** para obter as taxas de câmbio em tempo real e realizar as conversões.

## Funcionalidades 📱

- **Conversão de Moeda:** A aplicação permite que o usuário converta valores de Dólar (USD) para Real (BRL) com taxas de câmbio atualizadas em tempo real.
- **Interface Simples e Intuitiva:** O design da aplicação facilita a inserção do valor em Dólares e exibe o valor convertido em Reais de maneira rápida.
- **API Externa:** A aplicação consome a API **AwesomeAPI** para obter as taxas de câmbio atuais.

## Tecnologias Utilizadas 🔧

- **Android:** A aplicação foi desenvolvida para dispositivos Android utilizando Kotlin.
- **API Externa:** A aplicação consome a **AwesomeAPI** para realizar a conversão de moedas e obter as taxas de câmbio.
- **Bibliotecas:**
  - **Retrofit:** Para realizar as requisições HTTP de forma eficiente.
  - **Gson:** Para converter os dados JSON da API em objetos Kotlin.
  - **Coroutines:** Para realizar as requisições de forma assíncrona.

## Como Rodar o Projeto 🚀

### Pré-requisitos

Antes de rodar o projeto, certifique-se de ter os seguintes softwares instalados:

- **Android Studio** (para compilar e rodar o projeto)
- **JDK 8 ou superior**

### Passos para Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/SEU_USUARIO/currency-converter.git
   ```

2. Abra o projeto no Android Studio:
   - Vá até o Android Studio e abra o projeto clonado.

3. Instale as dependências:
   - O Android Studio irá baixar automaticamente todas as dependências listadas no arquivo `build.gradle`.

4. Configure a API:
   - A **AwesomeAPI** não requer uma chave de acesso, então você pode consumir diretamente o endpoint. 
   - Se necessário, adicione URLs base e configurações do Retrofit no código.

5. Execute o aplicativo:
   - Conecte um dispositivo Android ou use um emulador.
   - Clique em **Run** no Android Studio para compilar e rodar a aplicação.

## Como a Aplicação Funciona 🔄

A aplicação se conecta à **AwesomeAPI** para obter as taxas de câmbio entre Dólar (USD) e Real (BRL). Após o usuário inserir um valor em Dólares, a aplicação utiliza a taxa de câmbio mais recente para calcular o valor correspondente em Reais.

### Exemplo de Requisição para Conversão 💵

A API da **AwesomeAPI** oferece um endpoint para realizar a conversão de moedas. A URL para a conversão de USD para BRL seria:

```http
https://economia.awesomeapi.com.br/all/USD-BRL
```

**Exemplo de Resposta da API:**
```json
{
  "USD": {
    "code": "USD",
    "codein": "BRL",
    "name": "Dólar americano/Real",
    "high": "5.26",
    "low": "5.16",
    "varBid": "0.03",
    "pctChange": "0.57",
    "ask": "5.19",
    "bid": "5.18",
    "timestamp": "1648568259",
    "create_date": "2022-03-29 17:57:39"
  }
}
```

O valor de `ask` (5.19) é o valor utilizado pela aplicação para realizar a conversão.

## Como Contribuir 🙌

1. Faça um **fork** deste repositório.
2. Crie uma branch para sua feature ou correção:
   ```bash
   git checkout -b minha-feature
   ```
3. Faça suas alterações e adicione os arquivos modificados:
   ```bash
   git add .
   ```
4. Commit suas alterações:
   ```bash
   git commit -m "Descrição do que foi feito"
   ```
5. Faça o **push** para sua branch:
   ```bash
   git push origin minha-feature
   ```
6. Abra um **pull request** explicando as mudanças realizadas.

## Licença 📜

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

Agora o README tem alguns emojis para torná-lo mais visual, sem exageros. Eles ajudam a destacar as seções e tornar a leitura mais agradável. Se quiser ajustar mais algum detalhe ou adicionar outros emojis, é só me falar! 😊
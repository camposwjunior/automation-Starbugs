# ☕ Starbugs Automation Project

Projeto de automação de testes de ponta a ponta (E2E) para a cafeteria **Starbugs**, utilizando Java e Playwright.

## 🚀 Tecnologias Utilizadas
* **Java 21** (ou a versão que você está usando)
* **Playwright** (Motor de automação)
* **JUnit 5** (Framework de testes)
* **Maven** (Gerenciador de dependências)

## 📋 Cenários Automatizados
1. **Fluxo de Compra com Sucesso**: Valida a seleção de produto, preenchimento de endereço via CEP, forma de pagamento e confirmação do pedido.
2. **Validação de Indisponibilidade**: Garante que o sistema exibe corretamente o modal "Oops! Produto indisponível" para itens sem estoque.

## 🛠️ Como rodar os testes
Certifique-se de ter o Maven instalado e execute:
```bash
mvn test


🪙 PicPay Simplificado

Projeto back-end desenvolvido em Java com Spring Boot, simulando transações financeiras no estilo PicPay. Inclui cadastro de usuários, transações entre contas, validações e comunicação com APIs externas para autorização e notificação.
 
 Tecnologias utilizadas
 
 <div style="display: flex; align-items: center;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="40px" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" width="40px" />


    Java 17

    Spring Boot

    H2 Database (banco em memória)

    JPA / Hibernate

    Lombok

    RestTemplate para integração com APIs externas

    DTOs e Exception Handlers personalizados

⚙️ Funcionalidades

✅ Cadastro de usuários
✅ Realização de transações financeiras
✅ Validações de saldo e permissões
✅ Integração com API de autorização
✅ Serviço de notificação (mock)
✅ Tratamento global de exceções
✅ Banco de dados em memória (H2)
🏗️ Como executar

    Clone o repositório:

git clone https://github.com/seu-usuario/picpay-simplificado.git
cd picpay-simplificado

Execute o projeto:

./mvnw spring-boot:run

Acesse o H2 console:

    http://localhost:8080/h2-console

📩 APIs principais

    POST /users — Cria um novo usuário

    GET /users — Lista todos os usuários

    POST /transactions — Realiza uma transação entre usuários

📚 Conceitos aplicados

    Princípios SOLID

    Boas práticas do Clean Code

    Camadas bem definidas (Controller, Service, Repository, DTOs)

    Regras de negócio separadas da lógica de controle

    Tratamento de exceções robusto

    Simulação de serviços externos (Autorização e Notificação)


👨‍💻 Autor

[JonataFreitas](www.linkedin.com/in/jonatadev)

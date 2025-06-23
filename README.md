1. Objetivo do Projeto
O objetivo deste trabalho foi desenvolver um sistema web para a gestão de uma entidade educacional simples, aplicando conceitos de Orientação a Objetos e boas práticas de desenvolvimento de software. A aplicação permite o cadastro e gerenciamento de Alunos, Professores e Salas de Aula, estabelecendo relacionamentos lógicos entre eles, como a alocação de alunos e professores em salas específicas, respeitando regras de negócio como a capacidade máxima de cada sala.

O sistema foi construído com uma interface web interativa e de fácil utilização, permitindo realizar todas as operações de CRUD (Criar, Ler, Atualizar e Deletar) para cada uma das entidades principais.

2. Tecnologias e Ferramentas Utilizadas
A pilha de tecnologia (Tech Stack) escolhida para este projeto é moderna, robusta e amplamente utilizada no mercado de desenvolvimento Java.

Linguagem de Programação: Java 17, uma versão LTS (Long-Term Support) estável e moderna, que oferece segurança e uma vasta gama de recursos.
Framework Principal: Spring Boot 3, o framework líder no ecossistema Java para a criação de aplicações web e microserviços de forma rápida e configurável. Ele gerencia todo o ciclo de vida da aplicação.
Gerenciador de Build e Dependências: Apache Maven, utilizado para gerenciar todas as bibliotecas externas (dependências) do projeto e para automatizar o processo de compilação (build). A configuração do projeto é definida no arquivo pom.xml.
Persistência de Dados:
Spring Data JPA (Java Persistence API): Abstrai a forma como interagimos com o banco de dados, permitindo-nos trabalhar com objetos Java em vez de escrever código SQL manualmente.
Hibernate: A implementação do JPA utilizada pelo Spring Boot por padrão. É ele quem "traduz" nossas operações em objetos Java para comandos SQL que o banco de dados entende.
Banco de Dados: H2 Database (In-Memory), um banco de dados em memória, leve e rápido, ideal para desenvolvimento e prototipagem. Por ser "in-memory", todos os dados são zerados quando a aplicação é reiniciada.
Motor de Templates (Frontend): Thymeleaf, um motor de templates moderno que se integra perfeitamente com o Spring. Ele nos permite gerar HTML dinâmico no servidor, injetando os dados do nosso backend diretamente nas páginas web.
Estilização e Interface do Usuário (UI): Bootstrap 5, o framework CSS mais popular do mundo, utilizado para criar uma interface responsiva, moderna e visualmente agradável com mínimo esforço.
Servidor Web: Apache Tomcat (Embutido), o Spring Boot já vem com um servidor Tomcat embutido, eliminando a necessidade de configurar um servidor web externo.
Ferramenta de Produtividade: Spring Boot DevTools, uma biblioteca que monitora alterações no código-fonte e reinicia a aplicação automaticamente, agilizando muito o ciclo de desenvolvimento.
3. Arquitetura do Sistema
O projeto segue a clássica arquitetura em camadas (Layered Architecture), que promove a separação de responsabilidades, tornando o código mais organizado, testável e fácil de manter.

Fluxo de uma Requisição:
Usuário (Navegador) -> Controller -> Service -> Repository -> Banco de Dados

Controller (Camada de Apresentação): É a porta de entrada da aplicação. Ele recebe as requisições HTTP do navegador (ex: um clique em um botão), interpreta qual ação o usuário deseja fazer e chama o Service correspondente. Ele não contém lógica de negócio.
Service (Camada de Negócio): É o cérebro da aplicação. Contém toda a lógica de negócio (ex: "verificar se a sala está cheia antes de adicionar um aluno"). Ele orquestra as operações, podendo chamar um ou mais Repositories para completar uma tarefa.
Repository (Camada de Acesso a Dados): É a camada que conversa diretamente com o banco de dados. Sua única responsabilidade é persistir (salvar, buscar, atualizar, deletar) os dados. Graças ao Spring Data JPA, não precisamos escrever as queries SQL.
4. Estrutura e Descrição dos Arquivos
A estrutura de pastas do projeto foi organizada para refletir a arquitetura em camadas.

pom.xml: O arquivo de configuração do Maven. Define as informações do projeto e lista todas as dependências (Spring Web, Thymeleaf, JPA, etc.) que o Maven deve baixar e gerenciar.

src/main/java/br/com/grupo_educacao/sistema/

SistemaApplication.java: A classe principal que inicia toda a aplicação Spring Boot. Contém o método main.
Pacote model: Contém as classes de entidade, que representam as tabelas do nosso banco de dados.
Aluno.java, Professor.java, SalaDeAula.java: Classes anotadas com @Entity. Cada campo representa uma coluna na tabela. Aqui também são definidos os relacionamentos entre as entidades (@ManyToOne, @OneToMany).
Pacote repository: Contém as interfaces que definem as operações de acesso a dados.
AlunoRepository.java, ProfessorRepository.java, SalaDeAulaRepository.java: Interfaces que estendem JpaRepository. Elas herdam automaticamente todos os métodos CRUD básicos (ex: findAll(), findById(), save()).
Pacote service: Contém as classes com a lógica de negócio.
AlunoService.java, ProfessorService.java, SalaDeAulaService.java: Classes anotadas com @Service que implementam as operações do sistema, como salvarAluno, vincularProfessorASala, etc.
Pacote controller: Contém as classes que lidam com as requisições web.
AlunoController.java, ProfessorController.java, SalaDeAulaController.java: Classes anotadas com @Controller. Cada método mapeia uma URL (ex: @GetMapping("/alunos")) para uma ação específica, preparando os dados em um Model e retornando o nome do arquivo HTML que deve ser exibido.
src/main/resources/

application.properties: Arquivo de configuração chave-valor do Spring. Aqui configuramos a conexão com o banco de dados H2 e habilitamos o seu console web.
Pasta templates: Contém todos os nossos arquivos de interface web (as "views").
fragments.html: Um arquivo especial que não é uma página, mas sim um contêiner para "pedaços" de HTML reutilizáveis, como o menu de navegação (navbar) e o cabeçalho (head).
index.html: A página inicial da aplicação.
lista-*.html (ex: lista-alunos.html): Páginas que exibem as tabelas com os dados de cada entidade.
form-*.html (ex: form-aluno.html): Páginas com os formulários para criar e editar registros.
detalhes-sala.html: Uma página mais complexa que mostra os detalhes de uma sala e permite gerenciar seus relacionamentos com alunos e professores.
5. Conclusão
O projeto "Sistema de Gestão Escolar" foi concluído com sucesso, atendendo a todos os requisitos funcionais propostos. A aplicação demonstra o uso prático de tecnologias e padrões de mercado para o desenvolvimento de uma aplicação web robusta com Java e Spring Boot. O resultado é um sistema coeso, funcional e com uma interface de usuário clara e intuitiva, pronto para futuras expansões, como a implementação de um sistema de autenticação de usuários.

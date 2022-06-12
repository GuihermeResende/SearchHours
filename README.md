# SearchHours

### 1. APRESENTAÇÃO
É uma ferramenta desenvolvida para o envio de horas complementares, tanto para ambiente profissional como educacional.

Este é um projeto de apoio didático composto por um conjunto de atividades práticas relacionadas a temas das disciplinas de engenharia de software, tais como: análise e programação orientada a objetos, padrões de projeto, modelagem visual com UML e algumas práticas ágeis (como refactoring e testes unitários);  

Como experimento prático ele esta contextualizado na construção de um sistema baseado em um sistema para controle de horas aplicadas em atividade extra, complementar e diversificada para ambientes corporativos ou acadêmicos.

#### 1.1. EQUIPE [obrigatório]
|Nome|Papel|Gituser|
|--|--|--|
|Marcos Santos Rodrigues|PRODUTO|https://github.com/comardriguesro|
|Otávio Rodrigues dos Santos|DEV|https://github.com/OtavioRodriguesDev|
|Guilherme Resende Monteiro|DEV|https://github.com/GuihermeResende|

### 2. PROJETO [obrigatório]

O Sistema "SearchHours" faz o controle de horas complementares de alunos da instituição acadêmica. Basicamente, nele o aluno pode inserir atividades para serem validades como horas complementares de acordo com as regras previamente configuradas no sistema pelo administrador e pelo aval do coordenador do curso.O sistema também permite que professores insiram recomendações de atividades, também de acordo com categorias existentes no sistema para que sejam realizadas pelos alunos, tais como, livros, filmes, cursos ou voluntariados.

Conforme imagem apresentada abaixo:

![Principais Funções do Sistema](https://i.ibb.co/dWRPNf6/diagrama-casouso-controoooora.png)


#### 2.1 - ATORES
- [x] ALUNO
- [x] PROFESSOR
- [x] COORDENADOR
- [x] ADMINISTRADOR

#### 2.2 - REQUISITOS FUNCIONAIS [obrigatório]
 - [x] CRUD DE CATEGORIAS (completo); 
 - [x] CRUD DE ATIVIDADES (completo);
 - [x] APROVAR PARTICIPAÇÃO;
 - [ ] RELATORIO TURMA
 - [x] RECOMENDAR (CRUD); 
 - [ ] CADASTRAR PARTICIPAÇÃO (CRUD) 
 - [ ] CONSULTAR RECOMENDAÇÃO 
 - [ ] RELATORIO INDIVIDUAL

#### 2.3 - REGRAS [opcional]
 - [ ] O aluno poderá se cadastrar no sistema a partir do email, usando uma rede social: LINKEDIN sob a aprovação do coordenador ou professor da instituição;
 - [ ] Um lider, professor ou coordenador será cadastrado no sistema somente pelo ADM
 - [ ] Uma PARTICIPACAO pode ser: NOVA, PENDENTE, INDEFERIDA ou VALIDADA 
 - [ ] Uma PARTICIPACAO é um pedido de validação de horas complementares em atividade válida. Uma vez incluída no sistema este pedido (PARTICIPACAO) é cadastrada como PENDENTE. 
 - [ ] Antes de enviar o aluno pode manter este pedido como NOVO, ou seja, ainda em estado de elaboração. 
 - [ ] Após o envio pelo aluno, o sistema trata este pedido como PENDENTE. Somente após o deferimento (APROVADA) do coordenador esta atividade é contabilizada como histórico positivo para o Aluno. 
 - [ ] Em caso de rejeição, este pedido fica INDEFERIDO no sistema. 
 - [ ] Caso o Aluno queira melhorar a apresentação da PARTICIPACAO em uma atividade, ele pode inclusive submeter para nova análise do coordenador, reapresentando a participação novamente como PENDENTE no sistema.
 - [ ] Uma recomendação de atividade complementar pode ser temporaria (possui uma validade) ou indeterminada 
 - [ ] O dashboard geral somente poderá

#### 2.4 - ESPECIFICAÇÃO TÉCNICA [obrigatório]
- O sistema foi desenvolvido em java, com o framework Spring Boot;
- As camadas do sistema estão divididas em: 
- 𝘼𝙋𝙋𝙇𝙄𝘾𝘼𝙏𝙄𝙊𝙉 (camada que realiza as requisições, acessando os serviços). 
- 𝘾𝙊𝙉𝙁𝙄𝙂 (camada que cria automaticamente um administrador no banco de dados, possuindo os seus privilégios específicos. 
- 𝘿𝙊𝙈𝘼𝙄𝙉 (camada que possui as entidades e DTO's que são classes de transferência de dados), 
- 𝙍𝙀𝙋𝙊𝙎𝙄𝙏𝙊𝙍𝙄𝙀𝙎 (camada que acessa o banco de dados), 
- 𝙎𝙀𝘾𝙐𝙍𝙄𝙏𝙔 (Camada que faz verificações de autenticação do usuário e gera um TOKEN para cada login), 
- 𝙎𝙀𝙍𝙑𝙄𝘾𝙀𝙎 (camada que contém a regra de negócio, faz verificações e ações no sistema
- o banco de dados é relacional e executado no MySQL.

### 3. RESULTADOS
Banco de dados com as tabelas das entidades: 
![image](https://user-images.githubusercontent.com/70167193/173247141-bb291bcc-0090-4a50-8d1f-25f328d02f4c.png)

Protótipo da tela na ferramenta Figma:
![image](https://user-images.githubusercontent.com/80754169/173248127-6a1e1be4-fb39-4493-942d-84a08c682cf3.png)


### 4. REFERÊNCIAS ÚTEIS [opcional]

https://www.figma.com/file/XT3JpXY59hu54edsNfloM4/Atividade-Projeto-Integrador



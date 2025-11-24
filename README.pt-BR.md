🌍 [Read in English](README.md)

# Skill Bridge Api Rest

API RESTful desenvolvida com ASP.NET Core e OracleDB + EF Core para realizar a persistencia do projeto skill bridge.

## Rotas

(Users)

- `GET api/v1/users` - Obter todos os usuarios.
- `GET api/v1/users/{id}` - Obter usuario por id.
- `POST api/v1/users` - Criar um novo usuario.
- `PUT api/v1/users/{id}` - Atualizar um usuario pelo id.
- `DELETE api/v1/users/{id}` - Remover um usuario pelo id.

(Skills)

- `GET api/v1/skills` - Obter todos as habilidades.
- `GET api/v1/skills/{id}`- Obter habilidade por id.
- `POST api/v1/skills` - Criar uma nova habilidade.
- `PUT api/v1/skills/{id}` - Atualizar habilidade por id.
- `DELETE api/v1/skills/{id}` - Remover habilidade por id.

(Course)

- `GET api/v1/courses/{id}` - Obter curso por id.
- `GET api/v1/courses` - Obter todos os cursos.
- `POST api/v1/courses` - Criar um novo curso.
- `PUT api/v1/courses/{id}` - Atualizar um curso por id.
- `DELETE api/v1/courses/{id}` - Apagar curso por id.

(Work)

- `GET api/v1/works/{id}` - Obter trabalho por id.
- `GET api/v1/works` - Obter todos os trabalhos.
- `POST api/v1/works` - Criar um novo trabalho.
- `PUT api/v1/works/{id}` - Atualizar um trabalho por id.
- `DELETE api/v1/works/{id}` - Apagar um trabalho por id.

(LearningPath)

- `GET api/v1/learning-paths/{id}` - Obter Trilha de aprendizagem por id.
- `GET api/v1/learning-paths` - Obter todas as trilhas de aprendizagem.
- `POST api/v1/learning-paths` - Criar uma nova trilha de aprendizagem.
- `PUT api/v1/learning-paths/{id}` - Atualizar uma trilha de aprendizagem por id.
- `DELETE api/v1/learning-paths/{id}` - Apagar uma trilha de aprendizagem por id.

(Recommendation)

- `GET api/v1/recommendations/{id}` - Get work by id
- `GET api/v1/recommendations` - Get All recommendations.
- `POST api/v1/recommendations` - Create a New recommendation
- `PUT api/v1/recommendations/{id}` - Update recommendation by Id.
- `DELETE api/v1/recommendations/{id}` - Delete recommendation by Id.

(More and etc)

- `GET api` - Get api description.
- `GET healthchecks` - Get the healthchecks
- `GET api/actuator/health` - Get the healthchecks.

## Passos para rodar

1. Clone o repositório:

```bash
git clone https://github.com/felipeclarindo/skill-bridge-api-rest-java-spring.git
```

2. Entre no repositório:

```bash
cd skill-bridge-api-rest-java-spring
```

3. Crie e configure o arquivo .env usando o modelo em [.env.example](./.env.example).

4. Run the `SkillBridgeApplication.java` located in `./src/main/java/com/example/skill_bridge`.

5. A api estara disponivel em::

- <http://localhost:8080/api/v1>

## Equipe

- RM: 554547 -> Felipe Gabriel Lopes Pinheiro Clarindo
- RM: 558482 -> Humberto de Souza Silva
- RM: 554914 -> Vinicius Beda de Oliveira

## Contribuição

Contribuições são bem-vindas! Se você tiver sugestões de melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a [GNU Affero License](https://www.gnu.org/licenses/agpl-3.0.html).

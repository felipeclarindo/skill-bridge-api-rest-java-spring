
# Skill Bridge Api Rest

Web Api developed to skill bridge project to make persistense in `postgree` database.

## Routes

(Auth)

- `GET api/v1/auth/login` - Make the login.
- `GET api/v1/auth/register` - Register a new user.

(Skills)

- `GET api/v1/skills` - Get All skills.
- `GET api/v1/skills/{id}`- Get skill by Id.
- `POST api/v1/skills` - Create a New skill.
- `PUT api/v1/skills/{id}` - Update skill by Id.
- `DELETE api/v1/skills/{id}` - Delete skill by Id.

(Course)

- `GET api/v1/courses/{id}` - Get Course by id.
- `GET api/v1/courses` - Get All Courses.
- `POST api/v1/courses` - Create a New Course.
- `PUT api/v1/courses/{id}` - Update Course by Id.
- `DELETE api/v1/courses/{id}` - Delete Course by Id.

(Work)

- `GET api/v1/works/{id}` - Get work by id.
- `GET api/v1/works` - Get All works.
- `POST api/v1/works` - Create a New work.
- `PUT api/v1/works/{id}` - Update work by Id.
- `DELETE api/v1/works/{id}` - Delete work by Id.

(LearningPath)

- `GET api/v1/  -paths/{id}` - Get work by id
- `GET api/v1/learning-paths` - Get All learning-paths.
- `POST api/v1/learning-paths` - Create a New learning-paths.
- `PUT api/v1/learning-paths/{id}` - Update learning-paths by Id.
- `DELETE api/v1/learning-paths/{id}` - Delete learning-paths by Id.

(Recommendation)

- `GET api/v1/recommendations/{id}` - Get recommendation by id.
- `GET api/v1/recommendations` - Get All recommendations.
- `POST api/v1/recommendations` - Create a New recommendation.
- `PUT api/v1/recommendations/{id}` - Update recommendation by Id.
- `DELETE api/v1/recommendations/{id}` - Delete recommendation by Id.

(More and etc)

- `GET api` - Get api description.
- `GET api/v1/health` - Get the healthchecks.
- `GET api/actuator/health` - Get the healthchecks.

## Steps to run

1. Clone the repository:

```bash
git clone https://github.com/felipeclarindo/skill-bridge-api-rest-java-spring.git
```

2. Enter repository:

```bash
cd skill-bridge-api-rest-java-spring
```

3. Create and configure the `.env` file using the model in [.env.example](./.env.example)

4. Run the `SkillBridgeApplication.java` located in `./src/main/java/com/example/skill_bridge`.

5. The api is avaible on:

- <http://localhost:8080/api/v1>

## Team

- RM: 554547 -> Felipe Gabriel Lopes Pinheiro Clarindo
- RM: 558482 -> Humberto de Souza Silva
- RM: 554914 -> Vinicius Beda de Oliveira

## Contribution

Contributions are welcome! If you have suggestions for improvements, feel free to open an issue or submit a pull request.

## License

This project is licensed under the [GNU Affero License](https://www.gnu.org/licenses/agpl-3.0.html).

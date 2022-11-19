# Api de gerenciamento de contatos

- Spring boot
- Java 11
- Swagger
- Actuator
- Flyway
- Lombok

## Como rodar o projeto localmente

- 1- Clonar repositório 

```git clone https://github.com/Marlon-Santos/Contact_Manager```

- 2- Execute na raiz do projeto

```mvn clean install && docker compose down && docker compose build --no-cache && docker compose up```

- Obs- dependendo da versão do docker, o comando "docker compose" vira "docker-compose"

```mvn clean install && docker-compose down && docker-compose build --no-cache && docker-compose up```

- Obs- necessário docker, java e maven instalado na maquina
 
- 3- acessar o swagger-ui pra conhecer os endpoints

```http://localhost:8080/swagger-ui/```

## Acessar o projeto na nuvem

[Swagger-ui](https://contactmanagersystem.herokuapp.com/swagger-ui/)

[Health check](https://contactmanagersystem.herokuapp.com/actuator/health)

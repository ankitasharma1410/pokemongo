# Pokemon
Java RESTful Web Service API that runs a game Pokemon.

## Purpose of API
To play game of Pokemon to add/delete/update

## Implementation      
Using microservices (SpringBoot+REST), POSTMAN for testing

## References

Functional Document:
/src/main/resources/question.txt
**Note** to be replaced by confluence link in future.

## Build

    mvn clean install
    
## Run

    mvn spring-boot:run

## Endpoints

- Health Check

```
Returns HTTP status code =200 if API is reachable

> GET http://<host>:8443/healthcheck/alive

```

- Get Pokemons: 

```

curl --header "Content-Type: application/json" \--request GET \ http://<host>:<port>/api/pokemons

eg: curl --header "Content-Type: application/json" --request GET http://localhost:8443/api/pokemons
```
- Register USER
```

> POST http://localhost:8443/api/register //takes request body as json for User class {"userid":123,
	"email":"a",
	"password":"b"
}
```
- Add pokemon
```

> POST http://localhost:8443/api/pokemons/{userid}/{pokemonid}/add  userid=123, pokemonid for eg = MELMETAL

```
- Delete pokemon
```> 
DELETE http://localhost:8443/api/pokemons/{userid}/{pokemonid}/delete userid=123, pokemonid for eg = MELMETAL
```

```
- Update stats of pokemon
> PATCH http://localhost:8443/api/pokemons/{userid}/{pokemonid}/patch Request body is class Stats
```

### Requirements

* java 11
* docker
* docker-compose
* mvn 3

### Run

    make build run

### Get

* Currencies
```
curl http://localhost:8007/client/charCodes
```
* Rate
```
curl http://localhost:8007/client/BRL
```

### Doc

* [Service](./currency-service/README.md)
* [BFF](./currency-bff/README.md)
* [Front](./currency-front/README.md)
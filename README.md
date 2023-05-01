### currency-rate-app

```mermaid
sequenceDiagram
actor User
User ->> Front : axios(BRL)
activate Front
Front ->> BFF : /bff/rate/BRL
activate BFF
BFF ->> CurrencyService : /rates/BRL
activate CurrencyService
CurrencyService ->> CdnApi : cdn.jsdelivr.net
activate CdnApi
CdnApi -->> CurrencyService : #32; *json
deactivate CdnApi
CurrencyService -->> BFF : #32; *json
deactivate CurrencyService
BFF -->> Front : #32; *json
deactivate BFF
deactivate Front
```

### Requirements

* java 11
* mvn 3+
* docker
* docker-compose
* curl (optional)

### Run

```shell
make build run
```

### Get

* Currencies
```shell
curl http://localhost:8007/bff/currency/2023-04-01
```
* Rate
```shell
curl http://localhost:8007/bff/rate/2023-04-01/brl
```

### Doc

* [Service](./currency-service/README.md)
* [BFF](./currency-bff/README.md)
* [Front](./currency-front/README.md)
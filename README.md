# backend
mvn clean install
mvn spring-boot:run


# frontend

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Run your unit tests
```
npm run test:unit
```

### Run your end-to-end tests
```
npm run test:e2e
```

### Lints and fixes files
```
npm run lint
```


#Usage:
### Create user account
POST localhost:8080/users 
Body: 
{
    "firstName": "Slava",
    "lastName": "Nazarov",
    "balance": 150
}

### Get user accound details
GET localhost:8080/
Response:
{
    "id": 1,
    "firstName": "Slava",
    "lastName": "Nazarov",
    "balance": 150
}

### Create new transaction 
POST localhost:8080/api/transactions
Body: 
{
  "type": "credit",
  "amount": 10
}

HTTP 409 conflict in case balance after transaction apply is negative.
HTTP 201 in case of successfull submit.

### Retrieve list of transactions
GET localhost:8080/api/transactions
Response: 
[
    {
        "id": 2,
        "type": "credit",
        "amount": 10,
        "effectiveDate": "2020-09-08T05:06:32.811"
    }
]

 

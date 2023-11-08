# labseq-project

Implementation to solve labseq problem. Rules:
* n=0 => l(0) = 0
* n=1 => l(1) = 1
* n=2 => l(2) = 0
* n=3 => l(3) = 1
* n>3 => l(n) = l(n-4) + l(n-3)

## Start application with docker

* Pre-requirements

  ```
  Docker
  ```
* run the comand: `docker compose up`
* front application: `http://localhost:4000`
* back documentation: `http://localhost:8080/swagger-ui/index.html`

## Run by terminal

* Pre-requirements

  ```
  - Java 21
  - Maven
  - Node 20.9.0
  ```
* Front

  ```
  cd labseq-web
  npm i
  npm start 
  ```
  
* Back

  ```
  cd ws-labseq
  mvn spring-boot:run
  ```



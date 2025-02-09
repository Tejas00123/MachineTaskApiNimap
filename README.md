# TaskMachineTestAPI
API's for product and category model to perform CRUD operations

 			**Task => MachineTestAPI**

 Step 1: Project setup    
Java version => 17  
build tool type=>maven | ide =>STS

Starter dependencies used
=>lombok,spring web,Spring boot devtools,mysql driver,spring data jpa and etc.

Endpoints::
============
1) Category CRUD operation endpoints

http://localhost:8080/api/categories?page=3
GET all the categories

http://localhost:8080/api/categories
POST - create a new category

http://localhost:8080/api/categories/{di}
GET category by Id

http://localhost:8080/api/categories/{di}
PUT - update category by id

http://localhost:8080/api/categories/{di}
DELETE - Delete category by id

2) Product CRUD operation.
   
http://localhost:8080/api/products?page=2
GET all the products

http://localhost:8080/api/products
POST - create a new product

http://localhost:8080/api/products/{di}
GET product by Id

http://localhost:8080/api/products/{di}
PUT - update product by id

http://localhost:8080/api/products/{di}
DELETE - Delete product by id

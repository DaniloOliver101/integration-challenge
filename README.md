## Dados dos endpoints 

BaseUrl: http://localhost:8080

GET: /customer

Retorna a lista de Customers Cadastrados


GET: /customer?customerId=?
    Retorna o customer filtrado pelo id;
    
POST: /customer
RequestBody: 

`{ "name" : "Beltrano de Castro", "email" : "beltrano@gmail.com"}`

GET: /order
Lista os Pedidos criados

GET: /order?orderId=3
Traz o order de acordo com o id informado

POST: /order
RequestBody

`{
    "customerId" : 10,
    "value" : 0.00,
    "items" : []

}`

GET: /order/item
lista os items de todos os pedidos

GET: /order/item?orderItemId=14
     Retorna o item de acordo com o id
     
POST: /order/item
    Insere um novo item dentro da Order
RequestBody:
{
    "orderId" : 3,
    "item" : "SmartPhone Qualquer",
    "price" : 750.00
    
}

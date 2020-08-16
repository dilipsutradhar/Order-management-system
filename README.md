# Order-management-system

--> Two different APi is created and are communication using Netflix's Feigh Connector.

          1. order-service    
          2. order-item-service

    order-service is started at port:8090
    order-item-service is started in default port:8080


--> H2 DB is used for the database DAO operations along with that Spring Data JPA is used.
          
          Driver Class= org.h2.Driver
          IDBC URL= jdbc:h2:mem:dilip
          
          To Access H2 Database use this:
                    http://localhost:8080/h2-console/l

--> Building the project.
          1. clone the project using git prospective in your eclipse
          2. go to java prospective
          3. there is two project just do "import as gradle project" for both the project.
          4. run Application class from both the peoject


--> To test The Application Hit below URI's :

1. http://localhost:8090/app1/order/service/show  (GET) : test is the APi working or not

          O/p: SUCESS
          {
              "orderId": 1,
              "customerName": "DilipSutradhar",
              "orderdate": null,
              "shippingAddress": "105-Banjara Hills Hydrabad,pin-794106",
              "orderItem": {
                  "productCode": 0,
                  "productName": null,
                  "quantity": 0
              },
              "totalPrice": 1000
          }
          
          
2.  http://localhost:8090/app1/order/service/create (POST)  : To Create/ Save new Order

      Message Body:
                      {
                    "orderId": 15,
                    "customerName":"Ramesh",
                    "orderdate": "2020-03-09T22:18:26.625Z",
                    "shippingAddress": "jahsjkd,Tura,huyxsd",
                    "orderItem": {
                        "productCode": 1,
                        "productName": null,
                        "quantity": 4
                    },
                    "totalPrice": 1200
                }
                
                
                
 3. http://localhost:8090/app1/order/service/getAll (GET)  : To see al the existing Orders
 
 
 4. http://localhost:8090/app1/order/service/show/19 (GET)  : To fetch individual Order using OrderId.
 
 

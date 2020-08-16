# Order-management-system

--> Two different APi is created and are communication using Netflix's Feigh Connector.

          1. order-service    
          2. order-item-service

    order-service is started at port:8090
    order-item-service is started in default port:8080


--> H2 DB is used for the database DAO operations along with that Spring Data JPA is used.


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
 
 

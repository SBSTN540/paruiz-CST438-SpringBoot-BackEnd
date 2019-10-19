## Sprint 3 -  Webstore Back-end API
### *Product Class member variables*
+   String id *- auto generated*
+   String image
+   String desc
+   Double price
+   Integer stock


## Add Endpoint: 
`https://paruiz-cst4398-backend.herokuapp.com/products/add`
Receives a POST request. In the "Request Body" is a JSON object of type _Product_ (minus a product ID, this will be randomly generated). This gets saved to the database.

Example json:
```
{   
    "image":"image url"
    "desc": "product description" 
    "price": 10.99
    "stock": 20
}
```


## Get enpoint :
`https://paruiz-cst4398-backend.herokuapp.com/products/get/{id}`
Receives a GET request. Returns a single product object, matching the ID supplied in the path.

Sample endpoint with parameters:
`https://paruiz-cst4398-backend.herokuapp.com/products/get/2`

Example json : 
```
{   
    "id": 2
    "image":"image url"
    "desc": "item with id #2" 
    "price": 10.99
    "stock": 20
}
```



## Get All enpoint 
`https://paruiz-cst4398-backend.herokuapp.com/products/get/2
`
Receives a GET request. Returns an array of all the products

Example json : 
```
[  
	{   
	    "id": 1
	    "image":"image url"
	    "desc": "item with id #1" 
	    "price": 5.99
	    "stock": 10
	},
	{   
	    "id": 2
	    "image":"image url"
	    "desc": "item with id #2" 
	    "price": 10.99
	    "stock": 20
	},
]
```
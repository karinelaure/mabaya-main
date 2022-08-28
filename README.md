
1- Creating campaign:
http://localhost:8080/campaign/create
method post
body: 
{
    "name": "campaign6",
    "bid":185.14,
    "startDate": "2022-08-23 17:09:42",
    "prodList": [3,4,7]
}

2- Getting all products:
http://localhost:8080/product/all
method get


3- Getting all active Campaigns
http://localhost:8080/campaign/allactive
method get


4- Getting product with category 1 that has campaign with highest bid 
http://localhost:8080/ads?category=category 1 
method get
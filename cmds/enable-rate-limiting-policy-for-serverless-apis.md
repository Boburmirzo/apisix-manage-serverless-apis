# Add limit-count plugin to the existing Products route

curl http://127.0.0.1:9180/apisix/admin/routes/1 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "name": "Create a route with Azure function plugin",
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/products",
            "ssl_verify": false
        },
        "limit-count": {
            "count": 2,
            "time_window": 60,
            "rejected_code": 403,
            "rejected_msg": "Requests are too frequent, please try again later."
        },
        "basic-auth": {}
    },
    "uri": "/products"
}'

# Test limit-count plugin

curl -i -u username1:password1 http://127.0.0.1:9080/products

# Add limit-count plugin to the existing Reviews route

curl http://127.0.0.1:9180/apisix/admin/routes/2 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/reviews",
            "ssl_verify": false
        },
        "limit-count": {
            "count": 2,
            "time_window": 60,
            "rejected_code": 403,
            "rejected_msg": "Requests are too frequent, please try again later."
        },
        "basic-auth": {}
    },
    "uri": "/reviews"
}'

# Test limit-count plugin

curl -i -u username1:password1 http://127.0.0.1:9080/reviews
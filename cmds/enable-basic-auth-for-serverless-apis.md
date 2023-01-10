# Create a new consumer for serverless APIs

curl http://127.0.0.1:9180/apisix/admin/consumers -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "username": "consumer1",
    "plugins": {
        "basic-auth": {
            "username": "username1",
            "password": "password1"
        }
    }
}'

# Add basic auth plugin to the existing Products route

curl http://127.0.0.1:9180/apisix/admin/routes/1 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "name": "Create a route with Azure function plugin",
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/products",
            "ssl_verify": false
        }, 
        "basic-auth": {}
    },
    "uri": "/products"
}'

# Test basic auth plugin

curl -i -u username1:password1 http://127.0.0.1:9080/products

# Add basic auth plugin to the existing Reviews route

curl http://127.0.0.1:9180/apisix/admin/routes/2 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/reviews",
            "ssl_verify": false
        },
        "basic-auth": {}
    },
    "uri": "/reviews"
}'

# Test basic auth plugin

curl -i -u username1:password1 http://127.0.0.1:9080/reviews
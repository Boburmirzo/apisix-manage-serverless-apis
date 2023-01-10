
# Create a route
curl http://127.0.0.1:9180/apisix/admin/routes/1 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "name": "Create a route with Azure function plugin",
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/products",
            "ssl_verify": false
        }
    },
    "uri": "/products"
}'

# Test serverless API response
curl -i -XGET http://127.0.0.1:9080/products
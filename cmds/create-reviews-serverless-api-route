# Create the second route with Azure function plugin enabled

curl http://127.0.0.1:9180/apisix/admin/routes/2 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/reviews",
            "ssl_verify": false
        }
    },
    "uri": "/reviews"
}'

# Test serverless API response

curl -i -XGET http://127.0.0.1:9080/reviews
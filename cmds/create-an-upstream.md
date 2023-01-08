
curl http://127.0.0.1:9180/apisix/admin/routes/1 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/products",
            "ssl_verify": false,
             "authorization": {
                "apikey": "aOA7iT6qDFy5zWVQP84QA60dqXzSz6i5vIlVwdGyWHP_AzFuszGNHg=="
            }
        }
    },
    "uri": "/products"
}'

curl -i -XGET http://127.0.0.1:9080/products


curl http://127.0.0.1:9180/apisix/admin/routes/2 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://serverless-apis.azurewebsites.net/api/reviews",
            "ssl_verify": false,
             "authorization": {
                "apikey": "v8WB0Kx_6UTlZAHs_nlUorNfbKNotYcXz7_rZvqvdZCsAzFuJ0ZNvg=="
            }
        }
    },
    "uri": "/reviews"
}'

curl -i -XGET http://127.0.0.1:9080/reviews

curl "http://127.0.0.1:9080/apisix/admin/upstreams/1" -H "X-API-KEY: edd1c9f034335f136f87ad84b625c8f1" -X PUT -d '
{
  "type": "roundrobin",
  "nodes": {
    "localhost:7071": 1
  }
}'

curl http://127.0.0.1:9180/apisix/admin/routes/1 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "http://localhost:7071/api/products"
        }
    },
    "uri": "/api/products"
}'

curl http://127.0.0.1:9080/products -i




curl -i -XGET http://127.0.0.1:9080/azure1\?name=APISIX

curl -i -ufoo:bar http://127.0.0.1:9080/azure1\?name=APISIX

curl http://127.0.0.1:9180/apisix/admin/routes/2 -H 'X-API-KEY: edd1c9f034335f136f87ad84b625c8f1' -X PUT -d '
{
    "plugins": {
        "azure-functions": {
            "function_uri": "https://apisix-gateway.azurewebsites.net/api/HttpTrigger2",
            "ssl_verify": false,
            "authorization": {
                "apikey": "81VtErjnmcBNZ1_K68lNT8r6k1mtyETblkDV60zP0dMBAzFuTiWZkw=="
            }
        },
         "proxy-cache": {
 "cache_key": ["$uri", "-cache-id"],
 "cache_bypass": ["$arg_bypass"],
 "cache_method": ["GET"],
 "cache_http_status": [200],
 "hide_cache_headers": true,
 "no_cache": ["$arg_test"]
 }
    },
    "uri": "/azure1"
}'
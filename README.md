# Manage serverless APIs with Apache APISIX and Azure Functions

This repo shows with the simple example how to manage Java-based serverless APIs build with Azure functions. It uses [azure-functions](https://apisix.apache.org/docs/apisix/plugins/azure-functions/) plugin to integrate APISIX with [Azure Serverless Function](https://azure.microsoft.com/en-in/products/functions/) as a dynamic upstream to proxy all requests for a particular URI to the [Microsoft Azure Cloud](https://azure.microsoft.com/en-us).

> Note that the same plugin can be used with other serverless solutions. 

This repo demonstrates followings:

- Expose serverless APIs as upstream services.
- Secure serverless APIs with Apache APISIX authentication plugins.
- Apply rate limiting policies.

## Project structure

- [apisix_conf](https://github.com/Boburmirzo/apisix-manage-serverless-apis/tree/main/apisix_conf) - This folder contains Apache APISIX configuration file. 
- [apisix_log](https://github.com/Boburmirzo/apisix-manage-serverless-apis/tree/main/apisix_log) - Apache APISIX log files are generated in this folder. 
- [cmds](https://github.com/Boburmirzo/apisix-manage-serverless-apis/tree/main/cmds) - All curl commands examples can be found in this folder.
- [etcd_conf](https://github.com/Boburmirzo/apisix-manage-serverless-apis/tree/main/etcd_conf) - APISIX etcd storage configuration file. 
- [upstream](https://github.com/Boburmirzo/apisix-manage-serverless-apis/tree/main/upstream) - The folder has Java project with two functions source code: Products and Reviews.

## Prerequisites

* [Docker](https://www.docker.com/products/docker-desktop/)
* [Azure Account](https://azure.microsoft.com/en-us/free/)
* [Azure CLI](https://docs.microsoft.com/cli/azure/install-azure-cli)
* [Java Developer Kit](https://aka.ms/azure-jdks), at least version 8
* [Maven](https://maven.apache.org)
* [Azure Functions Core Tools](https://www.npmjs.com/package/azure-functions-core-tools)
* [Visual Studio Code](https://code.visualstudio.com/download)
* [Azure Functions Core Tools (min. version 2.6.666)]()
* [Azure Functions extension for Visual Studio Code](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-azurefunctions)

## Setup

To run Apache APISIX and Azure functions locally, you can follow these steps:

1.  Run `docker compose up` command from the root folder of the project:

```bash
docker compose up -d
```

Above command will run Apache APISIX and etcd together with Docker. 

2. Then, navigate to `/upstream` folder:

``` bash
mvn clean install
mvn azure-functions:run
```

The two functions will start in a terminal window. You can request both serverless APIs in your browser:

For example:

``` bash
http://localhost:7071/api/products
http://localhost:7071/api/reviews
```

3. Next, we deploy functions code to Azure Function App by running below cmd

``` bash
mvn azure-functions:deploy
```

Or you can simply follow this tutorial on [how to deploy the function project to Azure](https://learn.microsoft.com/en-us/azure/azure-functions/create-first-function-cli-java?tabs=bash%2Cazure-cli%2Cbrowser#deploy-the-function-project-to-azure)

> Note that the function app name is randomly generated based on your artifactId, appended with a randomly generated number. In the tutorial cmds, the function app name `serverless-apis` is mentioned.

Just to make sure our function works, we can test an invocation call directly requesting it URL in the browser:

``` bash
https://serverless-apis.azurewebsites.net/api/products
https://serverless-apis.azurewebsites.net/api/reviews
```

Clean up Azure resources when you are finished:

``` bash
az group delete --name java-functions-group
```

## Key concepts

For details, see the full tutotial. 

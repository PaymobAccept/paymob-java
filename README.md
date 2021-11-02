# Paymob Java SDK

## _The Fast Way To Get Payment Duds Ready, Ever_

[![ForTheBadge powered-by-paymob](./powered-by-paymob.svg)](https://www.paymob.com/)

Paymob Java SDK provides smooth functions to integrate with Paymob readily it's a minimal, straightforward and easy way to implement the payment intention methods, voiding, refunding and more..

Find our [docs](https://docs.paymob.com/)

## Installation        

### For apache Netbeans:

#### At this moment you need to add the jar file manually
You need to click on `Libraries` directory and press on `add JAR/Folder` and choose the Jar file then click ok

![step2](https://i.imgur.com/3HzOjLx.png)

### For Intellij IDE:

 #### You need to Create a lib folder and move the jar file into it then you need to add this line in the build.gradle file:

`implementation fileTree(include: ['*.jar', '*.aar'], dir: 'libs')`

## Prerequisites

##You need at least Java 8 SE installed on your machine

## Supported languages

from java 8 to java 15

## Intention
Paymob Java SDK offers verity of intention methods like create, retrieve and list ..

- Create
  #### first you need to create a request
  `Request request = new Request();`

  #### then set your secretKey
  `request.setSecretKey("skl_726d35c37defcffd4edf9d3743228cd5535620be7111xxxxxxxxxxxxxxxxxxxx");`

  #### finally create an intention
  `new Intention(request).create(builder.toJson());`

  #### if you need to customise the intention by adding a diffrent base url and diffrent version
  `new Intention( request , new Model("https://next-stg.paymobsolutions.com/next/api",1)).create(builder.toJson());`

- List
   #### create a List
  `new Intention(request).List();`

Paymob Java SDK
============
 
This is a Paymob SDK powered by Java that provides smooth functions to integrate at Paymob readily

---

#### There are a 5 functions to handle a request :

- **create:** for creating a POST request 
- **update:** for creating a PUT request 
- **patch:** for creating a PATCH request 
- **retrieve:** for creating a GET request 
- **delete:** for creating a DELETE request
---

## Setup

You need to call a Jar file into your project files 

## For apache netbeans:

 Start a new project with Ant 

![step1](https://i.imgur.com/juS2Y3Z.png)

Then right click on `Libraries` directory and press on `add JAR/Folder` and choose the Jar file then click ok

![step2](https://i.imgur.com/3HzOjLx.png)

## For Intellij IDE: 

Click on `file` >> `project structure`

![step1](https://i.imgur.com/rQ7WcoF.png)

Then click on click on `Libraries` >> `Java`

![step2](https://i.imgur.com/YDvM2Wt.png)

---

## Usage

First, you need to initialize an object from Request class.

`Request r = new Request();`


Then you need to set the secret key by using a setSecret_key() function to passing a secret key value into headers 

`r.setSecretKey("skt_xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");`

Finally, all 5 functions return a JSON body as a String,

To get the JSON body you need to create a new object from the intention class and call the function by passing the payload into it except Retrieve function.

`new Intention(r).create(" {\"amount\":3000}");`

---

# API-Rest--Java

This repository shows an example of a Rest API developed in Java, working on the SpringBoot framework and using Maven for project management.

Inside the project we find multiple files and directories, a special one is "CodeChallengeCollection.postman_collection", which is a collection of requests to test the API Rest from Postman.

In the project we also find inside the src folder, the API code divided into several directories that work as a layered architecture, the files in each directory (layer) only access the files that are within the directory (layer) below following the order: Controller -> Service -> Repository -> Model, with the exception of the model layer which all other layers must be able to access to know the nature of the data they are dealing with.

Since there are two models, User and Address, each layer contains a file for each model in order to treat them independently.

Finally, the API data is stored in a H2 database that does not persist after the execution of the program, with the objective to maintain the project simple and free of dependencies of an external database manager, in addition I have created in the Controller layer a class that initializes the database to test the API methods with greater facility from the Postman collection.

# Bravonext test
The actual repository is to provide a solution to the test proposed by Bravonext.

The project can be manually built by executing the following maven command:

mvn test assembly:single

A uber jar file will be then generated, by the name bravonextTest.jar. Such jar can be run by executing the following command:

java -jar bravonextTest.jar

N.B.: At the same path where the jar is located, another file should exist, by the name shoppingList.txt

# Bravonext test
The actual repository is to provide a solution to the test proposed by Bravonext.

The project can be manually built by executing the following maven command:

mvn test assembly:single

A uber jar file will be then generated, by the name bravonextTest.jar. Such jar can be run by executing the following command:

java -jar bravonextTest.jar

N.B.: At the same path where the jar is located, another file should exist, by the name shoppingList.txt

The project has been conceived as follows:

Two main entities exist, ShoppingList and ReceiptList, which contain respectively a list of ShoppingBaskets (a series of items to be bought) and Receipts (a series of items just bought, together with the total cost and amount of taxes). A ReceiptList is created out of an Existing ShoppingList, which must be created (instantiated) before it (the same concept is applied to Receipts-ShoppingBaskets and ReceiptItems-ShoppingItems). 
A ShoppingBasket contains a variable number of ShoppingItems, while a Receipt contains a variable number of ReceiptItems. Each ReceiptItem, Receipt and ReceiptList will always have access to the corresponding entity (ShoppingItem, ShoppingBasket, ShoppingList).

No additional library/framework has been used in this project

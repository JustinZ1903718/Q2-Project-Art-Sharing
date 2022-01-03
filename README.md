# World's Hardest Game-ED: the documentation
![image](https://user-images.githubusercontent.com/63608754/147980986-76670da8-cd46-4cf2-b899-06bb01a6173e.png)

basic variables


![image](https://user-images.githubusercontent.com/63608754/147981006-7caf0b9f-77cb-4ef2-9d9d-ae8cc7e519d2.png)

Creates a background object for the title screen and regular levels and a player object


![image](https://user-images.githubusercontent.com/63608754/147981069-ccd4595a-c74b-4ade-a2d3-bc58755e9a80.png)

Creates 3 Coin objects for every level. The first number in the array is the level. The second number is the number set for that coin in the level. Sets their, x, y, and whether they exist.


![image](https://user-images.githubusercontent.com/63608754/147981171-3ae1a97d-431d-47f3-b562-90edb5fdb8c4.png)

String array to store the message as you enter each level


![image](https://user-images.githubusercontent.com/63608754/147981558-c2d9913a-1a2e-4631-bcb9-28a1e99040b8.png)

2D Object array of enemies for each level. Sets their x, y, x velocity, y velocity, minX, minY, maxX, maxY, and whether they go in a rectangle. 


![image](https://user-images.githubusercontent.com/63608754/147981793-ccf8b071-beb7-4004-b889-1e55a9031c24.png)

Sets if the current level is the title screen or not. 


![image](https://user-images.githubusercontent.com/63608754/147981926-7b04e303-ac32-43cc-a594-00c662cbb5e8.png)

Checks for collision of each enemy and coin in the current level with the player.


![image](https://user-images.githubusercontent.com/63608754/147982018-bfc23168-9f57-4915-9f8e-e1b05c3b441b.png)

Kills the player if they collide with an enemy. If they collide with a coin, they collect it and the coin image disappears.

![image](https://user-images.githubusercontent.com/63608754/147982154-87219be6-c129-412c-a670-f586eceae57e.png)

Goes to the level selection screen if the player goes to the right area in the title screen

![image](https://user-images.githubusercontent.com/63608754/147982229-3ab099d0-4638-410b-8c77-5c188cd2cfef.png)

Resets the level if the player dies

![image](https://user-images.githubusercontent.com/63608754/147982262-37108a8d-9095-48b1-b241-e5a653b80f4a.png)

If the player meets the conditions for beating a level(Getting the coins and making it to the right side of the screen) they move on to the next level unless they beat the last level

![image](https://user-images.githubusercontent.com/63608754/147982396-aa36ff09-cf3c-4788-b7ec-b475dc980fd0.png)

Checks where each corner of the player is which is used for collision.


![image](https://user-images.githubusercontent.com/63608754/147982453-2b873eca-1e81-4844-8958-108ed62b5617.png)

Checks if the position of the enemy overlaps with the position of the player. Returns true if it does and false if it doesn't.


![image](https://user-images.githubusercontent.com/63608754/147982524-f815bb7a-3cd5-45b2-8390-521446391272.png)

Same code as for collision with enemy but for coins with the player


![image](https://user-images.githubusercontent.com/63608754/147982581-a00022c6-31b7-493e-92f1-5e590d433a3c.png)

Moves up, down, left, and right


![image](https://user-images.githubusercontent.com/63608754/147982629-d28aee78-bbdc-4fbd-9145-bac4707a4d2d.png)

Resets level. Could only be done if the player is dead.


![image](https://user-images.githubusercontent.com/63608754/147982667-43f51ad7-ddaa-4433-a3f6-130fc1dac8bf.png)

Level selection. Can only be used if in the level select menu


![image](https://user-images.githubusercontent.com/63608754/147982724-25352368-44ba-4a4d-85f9-94e21329121b.png)

Returns to main menu


![image](https://user-images.githubusercontent.com/63608754/147982754-b8a3aaee-56e9-45e5-a045-eb8d90faf495.png)


Stops the player if they release the key


![image](https://user-images.githubusercontent.com/63608754/147982815-63ebc69f-ffa1-4ccb-9dac-81b94687fe74.png)

Coin class. Coin gets painted based on if exists is true. Setters used to change exists from the main method. Getters to return x and y values for main method.



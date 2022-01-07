# World's Hardest Game-ED: the documentation

 (Game playthrough is in the repo)
 
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


![image](https://user-images.githubusercontent.com/63608754/148121401-0f974848-54bf-4dbc-afaa-3537b6013018.png)

Background class. The background changes whether or not the player is on the title screen(when curLevel equals 0 in the frame class)


![image](https://user-images.githubusercontent.com/63608754/148121566-99faeb93-c589-483f-982b-7aac87770f93.png)

![image](https://user-images.githubusercontent.com/63608754/148121590-1dae89cd-8853-4ff2-9f4a-a2be6d203684.png)

Enemy class. Sets borders for the enemy based on what is put for min/max x/y. The rectangle makes the enemy only go in one direction(x or y) at a time until it reaches the border where it switches.

![image](https://user-images.githubusercontent.com/63608754/148121782-322dfbe2-4818-4ef7-956b-c343097f9318.png)

![image](https://user-images.githubusercontent.com/63608754/148121845-ee4e9e08-ac87-4ad5-82e4-6c8f640f0f1b.png)

Player class. Contains movement, getters and setters for the x and y position and if it's dead, and borders for where the player can move.

![image](https://user-images.githubusercontent.com/90798634/148291471-b32f5c47-6fc3-4869-b40e-d9650e982a8f.png)

Our title Screen

![image](https://user-images.githubusercontent.com/90798634/148291552-16555526-4cdb-4fd2-9b24-586cba3cf7ce.png)

Level select screen

![image](https://user-images.githubusercontent.com/90798634/148291727-6337d1a5-dd91-42ca-9ab0-ea635acd6172.png)

Level 1

![image](https://user-images.githubusercontent.com/90798634/148291836-8e5a9435-9ac5-4c5f-bbf7-81b7c9a43b55.png)

Level 2

![image](https://user-images.githubusercontent.com/90798634/148291928-b0d6f16c-7ca0-4b52-8961-0ee06b6d08fa.png)

Level 3

![image](https://user-images.githubusercontent.com/90798634/148292165-d3a8517c-f707-4e43-a282-b89289c3641f.png)

Message screen between levels. Very deep messages. 

![image](https://user-images.githubusercontent.com/90798634/148292265-3934740e-c119-4b4e-acda-3ba2566e564a.png)

Level 4

![image](https://user-images.githubusercontent.com/90798634/148292476-1e56fd9f-5a08-4d46-9a16-ba5707e854a6.png)

Level 5 (the hardest level for Justin)

![image](https://user-images.githubusercontent.com/90798634/148292602-c8fe2968-4bc4-4f9d-85ab-237be3f2fef7.png)

Level 6 (the hardest level for Adam)

![image](https://user-images.githubusercontent.com/90798634/148292714-b2e1316e-4c45-44df-8af9-a5695670a67f.png)

Level 7

![image](https://user-images.githubusercontent.com/90798634/148292806-f66dfe7b-4c17-410e-a882-fcc980eb9e3d.png)

Level 8 (looks the same as level 7, but you need a completely different strategy)

![image](https://user-images.githubusercontent.com/90798634/148292863-a10f17d2-541c-4221-bd83-f37fc2282e66.png)

Death screen

![image](https://user-images.githubusercontent.com/90798634/148292949-4f2f0bf6-1765-44d2-80df-cff977a15fd2.png)

Win screen






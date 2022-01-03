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

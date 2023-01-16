#1 Background

#2 BrickWall

#3 ControlPanel

#4 GameScene

#5 Primitives

#6 ShootingGame

#7 Trajectory

#8 Trebuchets

Design Details:

I have a class called ShootingGame which has a static main method, to serve as the entry point of the whole game. The whoel screen consist of three part, the left and right are two control panels which control the angel and velocity of two trebuchets. The center is controled by a class called GameScreen, which grab all objects together, including BrickWall, Trebuchets, Background and Trajectory.

About this project:

There are some points where the demonstration is not clear, so I have made the 
following assumption:
1. Player 1's trajectory will always be calculated before that of Player 2.So when they hit the same block, player1 will show the correct one, player 2 will directly pass through it.
2. There are some cases where the brick wall can fall down even not all horizontal bricks are destoryed. In this case, the brick wall will retain as before.
3. I have tried my best to improve the user experience for the player as the extra cridit including the graphical one.

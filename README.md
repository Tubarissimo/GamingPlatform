## PROJECT SUMMARY

Software Project subject: building a gaming platform system.

## HOW TO INITIATE THE PROJECT

First, it is necessary to check the path of the files "gamelist.txt" and "userdatabase.txt" in the folder and set each of them to the variables fileGameList and fileUserDataBase, respectively. After doing this, the most recommended way to ensure the program works correctly and avoids bugs from the IDE itself is to compile and execute the code through the terminal.

## HOW TO COMPILE AND RUN THE CODE

To compile the code, open the terminal in the project's src/ directory. After that, use the command "javac application/Main.java" to compile the code. If there are no issues, then use the command "java application.Main" to execute the compiled code.

## NAVIGATING THE SYSTEM

Upon initializing the program, you will encounter the following functionalities:  

"[1] SHOP" -> displays a list of all games in the store available for purchase;  
"[2] LOGIN" -> prompts for your email and password to enter your account;  
"[3] REGISTER" -> asks you to enter an email, a password, and a nickname to add a new user to the user database;  
"[4] SHOW USERS" -> displays the entire user database;  
"[5] RANKING" -> shows the top 10 users with the highest score within the platform;  
"[6] SharkByteFAQ" -> opens a question and answer session to assist users with their doubts;  
"[0] EXIT" -> terminates the program.  

If you are logged into an account, the menu changes slightly:  

"[1] SHOP" -> displays a list of all games in the store available for purchase;  
"[2] USER LIBRARY" -> shows all games purchased by the logged-in user;  
"[3] BUY GAME" -> prompts for the corresponding number of the game in the store so you can buy it if you have enough credits;  
"[4] LOGOUT" -> disconnects from your account so you can log in with another account;  
"[5] DEPOSIT CREDITS" -> allows you to make a deposit of an entered amount so you can buy games and/or content within those games;  
"[6] FIND A PLAYER TO PLAY" -> finds another user with a score close to yours so you can play with them;  
"[7] BUY SKINS/GAMEPASS" -> allows you to buy skins and/or game passes for a game present in your library of purchased games;  
"[0] EXIT" -> terminates the program.  

## IMPLEMENTED PROJECT FEATURES

- Game Library Management: Managing a catalog of available games for users;  
- User Account Management: Creating and managing user profiles, including preferences and settings;  
- Multiplayer Matchmaking: Facilitating online matchmaking for multiplayer games;  
- In-Game Purchases and Microtransactions: Handling in-game purchases and transactions;  
- Leaderboards and Achievements: Tracking and displaying player rankings and achievements;  
- User Support and Helpdesk: Providing support for technical issues and user inquiries.  

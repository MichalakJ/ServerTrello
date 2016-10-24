How to start server:

1. Download and install Netbeans java EE version
2. During installation choose to install tomcat
3. Open ServerTrello project in netbeans
4. Right click on project -> clean and build
5. Right click on project -> properties - > run - > choose installed tomcat server
6. Right click on project -> run


REST api:  

BOARDS  

GET	/ServerTrello/boards  
GET	/ServerTrello/boards/{id}  
{
  "id": 1,
  "lists": [
    {
      "boardId": 1,
      "id": 1,
      "listItems": [
        {
          "cardListId": 1,
          "id": 1,
          "title": "card2"
        },
        {
          "cardListId": 1,
          "id": 2,
          "title": "card1"
        }
      ],
      "title": ""
    },
    {
      "boardId": 1,
      "id": 4,
      "listItems": [],
      "title": ""
    }
  ],
  "title": "boardTitle",
  "usersAccesses": [
    1
  ]
}
DELETE /ServerTrello/boards/{id}  
PUT /ServerTrello/board/{id}  
POST	/ServerTrello/boards  
{
	  "title":"nowy board"
}  
CARDLIST

GET	/ServerTrello/cardlist/{id}  
POST	/ServerTrello/cardlist  
{
	  "title":"nowy cardlist",
	  "boardId": "1"
}

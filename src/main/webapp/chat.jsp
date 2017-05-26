<%@ page import="by.shatunov.groupchat.UsersData" %>
<%@ page import="by.shatunov.groupchat.model.Message" %>
<%@ page import="by.shatunov.groupchat.model.User" %>
<%@ page import="by.shatunov.groupchat.MessagesData" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chat</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div class="container">
    <div class="list_container">
        <h2>Channels</h2>
        <ul>
            <li>General</li>
        </ul>
        <h2>Peoples</h2>
        <ul>
            <% for (User user: UsersData.getUsers()) { %>
            <li><%=user.getNick()%></li>
            <% } %>
        </ul>
        <div><a href="logout">Log out</a></div>
    </div>
    <div class="main_container">
        <div class="chat_container">
            <div class="chat_body">
                <% for (Message message : MessagesData.getMessages()) { %>
                <p><%=message.toString()%></p>
                <% } %>
            </div>
        </div>
        <div class="chat_input">
            <form method="post" action="chat">
                <input type="text" name="message" value="" class="chat_message">
                <input type="submit" name="submit" value="submit" class="chat_message_send">
            </form>
        </div>
    </div>
</div>
</body>
</html>


<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Chat</title>
    <link rel="stylesheet" href="css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="list_container">

        <div id="channels">
            <h2>Channels</h2>
            <ul id="channel-list">
                <c:forEach items="${channels}" var="channel">
                    <a id="${channel.id}" href="chat"><li>${channel.name}</li></a>
                </c:forEach>
            </ul>
        </div>

        <div id="users">
            <h2>Peoples</h2>
            <ul id="user-list">
                <c:forEach items="${users}" var="user">
                    <a id="${user.id}" href="chat"><li>${user.name}</li></a>
                </c:forEach>
            </ul>
        </div>

        <div><a href="logout">Log out</a></div>
    </div>
    <div class="main_container">
        <div class="chat_container">
            <div class="chat_body">
                <c:forEach items="${messages}" var="message">
                    <c:choose>
                        <c:when test="${entity == 'channel'}">
                            <c:if test="${(message.target).id == target}">
                                <p><strong>${(message.from).name}</strong>: ${message.text}</p>
                            </c:if>
                        </c:when>
                        <c:when test="${entity == 'user'}">
                            <c:if test="${(message.target).id == target && (message.from).id == currentUserID ||
                            (message.target).id == currentUserID && (message.from).id == target}">
                                <p><strong>${(message.from).name}</strong>: ${message.text}</p>
                            </c:if>
                        </c:when>
                    </c:choose>
                </c:forEach>
            </div>
        </div>
        <div class="chat_input">
            <form method="post" action="chat">
                <input type="text" name="message" value="" class="chat_message">
                <input type="hidden" name="target" id="target" value="${target}">
                <input type="hidden" name="entity" id="entity" value="${entity}">
                <input type="submit" name="submit" value="submit" class="chat_message_send">
            </form>
        </div>
    </div>
</div>

<script>
    $(function () {
        $("#channel-list a").click(function () {
            $.ajax({
                url: "chat",
                method: "post",
                data: {
                    target: $(this).attr("id"),
                    entity: "channel"
                }
            });
        }),
        $("#user-list a").click(function () {
            $.ajax({
                url: "chat",
                method: "post",
                data: {
                    target: $(this).attr("id"),
                    entity: "user"
                }
            })
        })
    });
</script>
</body>
</html>

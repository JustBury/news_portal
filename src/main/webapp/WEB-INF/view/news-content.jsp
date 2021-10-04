<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <title>News Portal</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/news-content.css"/>" type="text/css">
    <style>

    </style>
</head>
<body>
<div class="header" id="header">
    <h1 class="news">News</h1>
</div>

<br>
<div class="news_content">
    <p class="title">${news.title}</p>
    <p class="brief">${news.brief}</p>
    <p>${news.content}</p>
</div>
<div>
    <c:url var="deleteNews" value="deleteNews">
        <c:param name="newsId" value="${news.id}"/>
    </c:url>
    <c:url var="updateNews" value="updateNews">
        <c:param name="newsId" value="${news.id}"/>
    </c:url>
    <c:url var="back" value="/"/>

    <a class="bot1" href="${deleteNews}"
       onclick="if (!(confirm('Are you sure you want to delete this news?'))) return false">Delete</a>
    <a class="bot1" href="${updateNews}">Update</a>
    <a class="bot1" href="${back}">Back to main page</a>
</div>
</body>
</html>
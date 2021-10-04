<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <title>News Portal</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/main-page.css"/>" type="text/css">
    <style>

    </style>
</head>
<body>
<div class="header" id="header">
    <h1 class="news">News</h1>
    <c:url var="addNews" value="/addNewNews"/>

    <a class="bot1" style="width: 300px" href="${addNews}">Add new News</a>
</div>
<br>
<table>

    <c:forEach var="news" items="${newses}">

        <c:url var="newsContent" value="/getNews">
            <c:param name="newsId" value="${news.id}"/>
        </c:url>

        <tr>
            <td>
                <p class="title">${news.title}</p>

                <p class="brief">${news.brief}</p>
                <a class="bot1" href="${newsContent}">View the news</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
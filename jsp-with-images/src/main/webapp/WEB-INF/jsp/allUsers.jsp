<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>All Users</title>
</head>
<body>
<h1>All Users page</h1>
<h2><a href="/">Home Page</a></h2>
<h2><a href="/users/add">Add New User</a></h2>


<c:forEach items="${allUsers}" var="loopedUser">
    <div>
        <p>
            <strong>Id: </strong>
            ${loopedUser.id}
        </p>
        <br/>
        <p>
            <strong>
                Name:
            </strong>
            ${loopedUser.name}
        </p>
        <br/>
        <a href="/users/${loopedUser.id}">
            Show more info
        </a>
    </div>
    <hr/>
</c:forEach>
</body>
</html>
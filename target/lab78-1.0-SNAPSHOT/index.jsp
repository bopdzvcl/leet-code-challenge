<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script src="jquery.js"></script>
<script>
    $.ajax({
        url: "/song-management/ajax",
        type: "get",
        dataType: "json",
        success: function (response){
            console.log(response)
        },
        error: function (){
            console.log("loi")
        }
    })
</script>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
</h1>
<br/>
<button><a href="/song-management/ajax">ajax</a></button>
<form action="/song-management/add" method="post">
    ten bao hat: <input type="text" name="ten" value="${bh.ten}"><br>
    thoi luong: <input type="text" name="thoiLuong" value="${bh.thoiLuong}"><br>
    gia: <input type="text" name="gia" value="${bh.gia}"><br>
    ngay ra mat: <input type="date" name="ngayramat" value="${bh.ngayRaMat}"><br>
    ten ca si: <select name="tencasi" >
    <c:forEach var = "cs" items="${casi}">
    <option value="${cs.id}" ${cs.id==bh.cs.id?"selected":""}>${cs.ten}</option>
    </c:forEach>

</select>
    <button>submit</button>
</form>
<table>
    <thead>
    <th>id</th>
    <th>ten bai hat</th>
    <th>thoi luong</th>
    <th>gia</th>
    <th>ten ca si</th>
    <th>ngay ra mat</th>
    <th>action</th>
    </thead>
    <tbody>
        <c:forEach var="a" items="${list}">
            <tr>
                <td>${a.id}</td>
                <td>${a.ten}</td>
                <td>${a.thoiLuong}</td>
                <td>${a.gia}</td>
                <td>${a.cs.ten}</td>
                <td>${a.ngayRaMat}</td>
                <td><a href="/song-management/detail?id=${a.id}">Details</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/song-management/page?page=${page-1}">prev</a>
<a href="/song-management/page?page=${page+1}">next</a>
</body>
</html>
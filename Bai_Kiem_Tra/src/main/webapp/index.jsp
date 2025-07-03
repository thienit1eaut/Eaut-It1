<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hiển thị thời gian</title>

<style type="text/css">

</style>
</head>
<body>
	<h1>Thời gian hiện tại: </h1>
    <p>${formattedTime}</p>
    <form action="time" method="POST">
        <label for="format">Chọn định dạng (ví dụ: yyyy-MM-dd HH:mm:ss):</label>
        <input type="text" id="format" name="format" />
        <input type="submit" value="Hiển Thị Thời Gian" />
    </form>
</body>
</html>
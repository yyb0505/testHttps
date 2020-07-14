<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>测试文件上传！</title>
    <meta charset="utf-8">
</head>
<form id="formData" enctype="multipart/form-data" method="post" action="/upload/upload">
    <input type="id" name="file"  type="mul" /><br/>
    <input type="file" name="file" value="" /><br/>
    <a class="weui-btn-area">
        <input class="weui-btn weui-btn_primary" type="submit" value="去上传"/>
    </a>

</form>

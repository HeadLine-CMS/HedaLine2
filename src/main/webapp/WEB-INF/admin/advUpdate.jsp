<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/dashboard.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin: 5px;margin-top: -80px;">
    <div class="row clearfix">
        <h2 class="page-header">广告页面</h2>
        <div class="table-responsive" id="table">
            <div class="col-md-8 column">
                <form class="form-horizontal" role="form" method="post"
                      action="insertBook.action" enctype="multipart/form-data">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">广告封面</label>
                        <div class="col-sm-10">
                            <img src="#" width="200px" height="200px"><br />
                            <br /> <input type="file" name="bookImg" value="选择图片" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">连接地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"
                                   name="bookBean.book_name" placeholder="请输入连接地址" value="连接地址"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">修改头条号</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
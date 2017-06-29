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
        <h2 class="page-header">文章页面</h2>
        <div class="table-responsive" id="table">
            <div class="col-md-8 column">
                <form class="form-horizontal" role="form" method="post"
                      action="insertBook.action" enctype="multipart/form-data">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">文章封面</label>
                        <div class="col-sm-10">
                            <img src="#" width="200px" height="200px"><br />
                            <br /> <input type="file" name="bookImg" value="选择图片" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">文章标题</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"
                                   name="bookBean.book_name" placeholder="请输入文章标题" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">头条号名称</label>
                        <div class="col-sm-10">
                            <select name="bookBean.book_type" class="btn btn-default">
                                <option value="头条1">头条1</option>
                                <option value="头条2">头条2</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label  class="col-sm-2 control-label">审核状态</label>
                        <div class="col-sm-10">
                            <select name="bookBean.book_type" class="btn btn-default">
                                <option value="通过">通过</option>
                                <option value="不通过">不通过</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">文章类型</label>
                        <div class="col-sm-10">
                            <select name="bookBean.book_type" class="btn btn-default">
                                <option value="推荐">推荐</option>
                                <option value="热点">热点</option>
                                <option value="视频">视频</option>
                                <option value="图片">图片</option>
                                <option value="段子">段子</option>
                                <option value="社会">社会</option>
                                <option value="娱乐">娱乐</option>
                                <option value="科技">科技</option>
                                <option value="体育">体育</option>
                                <option value="财经">财经</option>

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">文章内容</label>
                        <div class="col-sm-10">
                            <textarea rows="12" cols="18" class="form-control" name="bookBean.book_summary" placeholder="此处为文章内容"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">新增文章</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>



</body>
</html>
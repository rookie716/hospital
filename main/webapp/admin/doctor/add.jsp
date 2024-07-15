<%--
  Created by IntelliJ IDEA.
  User: LX
  Date: 2024/7/10
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="${css}/pintuer.css">
    <link rel="stylesheet" href="${css}/admin.css">
    <script src="${js}/jquery.js"></script>
    <script src="${js}/pintuer.js"></script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="${root}/backend/addDoctorServlet">
            <div class="form-group">
                <div class="label">
                    <label>工号：</label>
                </div>
                <div class="field">
                    <input type="text"  readonly value="${jobNumber}" class="input w50" value="" name="jobNumber"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>姓名：</label>
                </div>
                <div class="field">
                    <input type="text"   class="input w50" value="" name="name"/>
                    <div class="tips"></div>
                </div>
            </div>
                <div class="form-group">
                    <div class="label">
                        <label>科室分类：</label>
                    </div>
                    <div class="field">
                        <select id="rootDepartment" class="input w50">
                            <option value="0">请选择科室分类</option>
                            <c:forEach items="${rootDepartmentList}" var="d">
                                <option value="${d.departmentId}">${d.departmentName}</option>
                            </c:forEach>
                        </select>
                        <div class="tips"></div>
                    </div>
                </div>
            <div class="form-group">
                <div class="label">
                    <label>科室名称：</label>
                </div>
                <div class="field">
                    <select name="departmentId" id="department" class="input w50">
                        <option value="">请选择科室名称</option>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>职称信息：</label>
                </div>
                <div class="field">
                    <select name="professionalTitle" class="input w50">
                        <c:forEach items="${professionalTitleList}" var="p">
                            <option value="${p.id}">${p.title_name}</option>
                        </c:forEach>
                    </select>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>

<script>
    $(function () {
        $("#rootDepartment").change(function () {
            var rootId=$(this).val();
            if(rootId!=0){
                var departmentObj=$("#department");
                departmentObj.html("");
                var url="${root}/backend/loadTwoDepartmentServlet?rootId="+rootId;
                $.get(url,function (r) {
                    var optionHtml="<option>请选择科室名称</option>"
                    for(var i=0;i<r.length;i++){
                        optionHtml+="<option value='"+r[i].departmentId+"'>"+r[i].departmentName+"</option>"
                    }
                    departmentObj.append(optionHtml);
                },'json')
            }else {
                var departmentObj=$("#department");
                departmentObj.html("");
                return
            }

        })

    })
</script>
</html>

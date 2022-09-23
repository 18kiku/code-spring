<%--
  Created by IntelliJ IDEA.
  User: hwangjeonghwan
  Date: 2022/09/19
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>upload with Ajax</h1>
<div class="uploadDiv">
  <input type="file" name="uploadFile" multiple >
</div>
<button id="uploadBtn">Upload</button>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
    $(document).ready(function () {
        
        let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
        let maxSize = 5242880;
        
        function checkExtension(fileName, fileSize) {
            if(fileSize >= maxSize) {
                alert("파일 사이즈 초과");
                return false;
            }
            
            if(regex.test(fileName)) {
                alert("해당 종류의 파일은 업로드할 수 없습니다.");
                return false;
            }
            return true;
        }
        $("#uploadBtn").on("click", function (e) {
            let formData = new FormData();

            let inputFile = $("input[name='uploadFile']");

            let files = inputFile[0].files;

            console.log(files);

            //add File Data to formData
            for(let i=0; i<files.length; i++) {

                if(!checkExtension(files[i].name, files[i].size)) {
                    return false;
                }

                formData.append("uploadFile", files[i]);
            }

            $.ajax({
                url: '/uploadAjaxAction',
                processData: false,
                contentType: false,
                data: formData,
                type: 'POST',
                success: function (result) {
                    alert("uploaded")
                }
            })
        })
    })
</script>
</body>
</html>

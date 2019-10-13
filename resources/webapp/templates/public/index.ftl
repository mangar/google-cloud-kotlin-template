<#macro page>
<!doctype html>
<html lang="en">
<head>
    <title>Google Cloud Platform - Template Project</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<#include "header.ftl">

<div class="container-fluid">
    <#nested>
    <#include "footer.ftl">
</div>

<!-- jquery & Bootstrap JS -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
</script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
</script>
</body>
</html>
</#macro>

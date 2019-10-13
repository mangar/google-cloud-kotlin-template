<#import "../templates/public/index.ftl" as b>
<@b.page>

<h3>Students</h3>
<hr/>

<#if students?? && (students?size > 0) >
<table class="table table-striped">
<thead>
<tr>
  <td><b>Name</b></td>
  <td><b>Email</b></td>
  <td><b>Username</b></td>
  <td></td>
</tr>
</thead>
<tbody>
<#list students as student>
<tr>
  <td style="vertical-align:middle">${student.name}</td>
  <td style="vertical-align:middle">${student.email}</td>
  <td style="vertical-align:middle">${student.username}</td>

  <td class="col-md-1" style="text-align:center;vertical-align:middle;">
    <form method="post" action="/student">
      <input type="hidden" name="id" value="${student.name}"/>
      <input type="hidden" name="action" value="delete" />
      <input type="image" src="/static/images/delete.png" width="24" height="24" border="0" alt="Delete" />
    </form>
  </td>
</tr>
</#list>
</tbody>
  </table>
  </#if>




<hr/>

<div class="panel-body">
<form method="post" action="/student">
  <input type="hidden" name="action" value="add"/>
  <input type="hidden" name="id" value=""/>

  Name: <br/>
  <input type="text" name="name"/> <br/>

  Email:<br/>
  <input type="text" name="email"/> <br/>

  Username:<br/>
  <input type="text" name="username"/> <br/>


  <input type="submit" value="Submit"/>
</form>
</div>

  </@b.page>

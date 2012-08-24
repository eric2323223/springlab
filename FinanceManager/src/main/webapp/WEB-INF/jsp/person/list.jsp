<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="List All People">
    <c:if test="${not empty people}">
    	<c:if test="${not empty param['integrityViolation']}">
    		<span class="errors">${param['integrityViolation']}</span>
    	</c:if>
        <table width="300px">
            <tr>
                <thead>
                    <th>Id</th>                    
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th/>
                    <th/>
                    <th/>
                </thead>
            </tr>
            <c:forEach items="${people}" var="person">
                <tr>
                    <td>${person.id}</td>                    
                    <td>${fn:substring(person.firstName, 0, 10)}</td>
                    <td>${fn:substring(person.lastName, 0, 10)}</td>
                    <td>${fn:substring(person.email, 0, 10)}</td>
                    <td>
                        <form:form action="/FinanceManager/person/${person.id}" method="GET">
                            <input alt="Show Person" src="/FinanceManager/static/images/show.png" title="Show Person" type="image" value="Show Person"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/FinanceManager/person/${person.id}/form" method="GET">
                            <input alt="Update Person" src="/FinanceManager/static/images/update.png" title="Update Person" type="image" value="Update Person"/>
                        </form:form>
                    </td>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                    <td>
                        <form:form action="/FinanceManager/person/${person.id}" method="DELETE">
                            <input alt="Delete Person" src="/FinanceManager/static/images/delete.png" title="Delete Person" type="image" value="Delete Person"/>
                        </form:form>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty people}">No people found.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script> 
<div dojoType="dijit.TitlePane" style="width: 100%" title="List All Accounts">
    <c:if test="${not empty accounts}">
        <table width="300px">
        	<thead>
            	<tr>                
                    <th>Id</th>
                    <th>Name</th>
                    <th>Owners</th>
                    <th>Manager</th>
                    <th>Investments</th>
                    <th/>
                    <th/>
                    <th/>                
            	</tr>
            </thead>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.id}</td>
                    <td>${fn:substring(account.name, 0, 10)}</td>
                    <td>${fn:length(account.owners)}</td>
                    <td>${fn:substring(account.manager, 0, 10)}</td>
                    <td>${fn:length(account.investments)}</td>
                    <td>
                        <form:form action="/FinanceManager/account/${account.id}" method="GET">
                            <input alt="Show Account" src="/FinanceManager/static/images/show.png" title="Show Account" type="image" value="Show Account"/>
                        </form:form>
                    </td>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                    <td>
                        <form:form action="/FinanceManager/account/${account.id}/form" method="GET">
                            <input alt="Update Account" src="/FinanceManager/static/images/update.png" title="Update Account" type="image" value="Update Account"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/FinanceManager/account/${account.id}" method="DELETE">
                            <input alt="Delete Account" src="/FinanceManager/static/images/delete.png" title="Delete Account" type="image" value="Delete Account"/>
                        </form:form>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty accounts}">No accounts found.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

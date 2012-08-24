<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="List All Products">
    <c:if test="${not empty products}"> 
        <c:if test="${not empty param['integrityViolation']}">
    		<span class="errors">${param['integrityViolation']}</span>
    	</c:if>
        <table width="300px">
            <tr>
                <thead>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Management Fee</th>
                    <th>Type</th>
                    <th/>
                    <th/>
                    <th/>
                </thead>
            </tr>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td>${product.id}</td>
                    <td>${fn:substring(product.name, 0, 10)}</td>
                    <td>${fn:substring(product.description, 0, 10)}</td>
                    <td>${fn:substring(product.managementFee, 0, 10)}</td>

                    	<td>${product.class.simpleName}</td>
                    
                    <td>
                        <form:form action="/FinanceManager/product/${product.id}" method="GET">
                            <input alt="Show Product" src="/FinanceManager/static/images/show.png" title="Show ManagedFund" type="image" value="Show ManagedFund"/>
                        </form:form>
                    </td>
                    <sec:authorize ifAllGranted="ROLE_ADMIN">
                    <td>
                        <form:form action="/FinanceManager/product/${product.id}/form" method="GET">
                            <input alt="Update Product" src="/FinanceManager/static/images/update.png" title="Update ManagedFund" type="image" value="Update ManagedFund"/>
                        </form:form>
                    </td>
                    <td>
                        <form:form action="/FinanceManager/product/${product.id}" method="DELETE">
                            <input alt="Delete ManagedFund" src="/FinanceManager/static/images/delete.png" title="Delete ManagedFund" type="image" value="Delete ManagedFund"/>
                        </form:form>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty products}">No Products found.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

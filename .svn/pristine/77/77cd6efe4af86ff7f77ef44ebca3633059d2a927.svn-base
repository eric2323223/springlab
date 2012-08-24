<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">
	dojo.require("dijit.TitlePane");
	dojo.require("dijit.Dialog");
	dojo.require("dijit.form.Button");	
</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Account">
    <form:form action="/FinanceManager/account" method="POST" modelAttribute="account">
        <div>
            <label for="name">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
        </div>
        <br/>
        <div>
            <c:if test="${not empty people}">
                <label for="owners">Owners:</label>
                <form:select cssStyle="width:250px" path="owners">
                    <form:options itemValue="id" items="${people}"/>
                </form:select>
                <form:errors path="owners" cssClass="errors"/>
                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "owners", widgetType: "dijit.form.MultiSelect"})); </script>
            </c:if>
        </div>
        <br/>
        <div>
            <c:if test="${not empty people}">
                <label for="manager">Manager:</label>
                <form:select cssStyle="width:250px" path="manager">
                    <form:options itemValue="id" itemLabel="firstName" items="${people}"/>
                </form:select>
                <form:errors path="manager" cssClass="errors"/>
                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "manager", widgetType: "dijit.form.FilteringSelect", widgetAttrs : {hasDownArrow : true}})); </script>
            </c:if>
        </div>
        <br/>
        <div class="submit">
            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
            <input id="proceed" type="submit" value="Save"/>
        </div>
    </form:form>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Managed Fund Product">
    <form:form action="/FinanceManager/product/managedFund" method="POST" modelAttribute="managedFund">
		<div>
            <label for="name">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
		</div>
        <br/>
		<div>
            <label for="description">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" path="description"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
		</div>
        <br/>
		<div>
            <label for="managementFee">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
        <br/>
		<div>
            <label for="fundId">Fund Id:</label>
            <form:input cssStyle="width:250px" maxlength="15" path="fundId" size="30"/>
            <form:errors path="fundId" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "fundId", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Fund Id", required : true}})); </script>
		</div>
	    <br/>
		<div>
            <label for="distribution">Distribution:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="distribution" size="30"/>
            <form:errors path="distribution" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "distribution", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
	    <br/>
		<div>
            <label for="currentUnitPrice">Current Unit Price:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="currentUnitPrice" size="30"/>
            <form:errors path="currentUnitPrice" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "currentUnitPrice", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Current Unit Price (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
		</div>
		<br/>
       <div class="submit buttonGroup">
        	<input type="submit" name="_eventId_cancel" value="Cancel"/>&#160;			
			<input type="submit" id="product" name="_eventId_product" value="Add Another Product" />&#160;
			<input type="submit" id="account" name="_eventId_account" value="Proceed" />&#160;
			<script type="text/javascript">
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'account', event:'onclick'}));
				Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'product', event:'onclick'}));
			</script>
			
		</div>

    </form:form>
</div>


<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

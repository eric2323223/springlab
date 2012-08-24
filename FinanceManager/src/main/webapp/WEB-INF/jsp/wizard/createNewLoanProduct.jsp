<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>

<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Loan Product">
    <form:form modelAttribute="loan">
		<div>
            <label for="name_loan">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" id="name_loan" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
</div>
        <br/>
<div>
            <label for="description_loan">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" id="description_loan" path="description"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_loan", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
</div>
        <br/>
<div>
            <label for="managementFee_loan">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" id="managementFee_loan" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
</div>
        <br/>
		         <div>
			 <label for="interest_loan">Interest:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="interest" id="interest_loan" size="30"/>
            <form:errors path="interest" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        	</div>
        	<br/>
        	<div>
        	<label for="principal_loan">Principal:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="principal" id="principal_loan" size="30"/>
            <form:errors path="principal" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "principal_loan", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
        	</div>
        	<br/>
        	<c:if test="${not empty lenders}">
        	<div>
	        	 <label for="lenders">Lenders:</label>
	             <form:select cssStyle="width:250px" path="lenders">
                    <form:options itemValue="id" items="${lenders}"/>
                </form:select>
                <form:errors path="lenders" cssClass="errors"/>
                <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "lenders", widgetType: "dijit.form.MultiSelect", widgetAttrs : {hasDownArrow : true}})); </script>
        	</div>
        	<br/>
        	</c:if>        	
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

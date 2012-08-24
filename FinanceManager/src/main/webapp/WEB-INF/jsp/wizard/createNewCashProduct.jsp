<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>
    
<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Cash Product">
    <form:form modelAttribute="cash">
		<div>
            <label for="name_cash">Name:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="name" id="name_cash" size="30"/>
            <form:errors path="name" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "name_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Name", required : true}})); </script>
</div>
        <br/>
<div>
            <label for="description_cash">Description:</label>
            <form:textarea cssStyle="width:250px;height:15em" path="description" id="description_cash"/>
            <form:errors path="description" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_cash", widgetType: "dijit.form.Textarea", widgetAttrs: {value: ""}})); </script>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "description_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {promptMessage: "Enter Description", required : false}})); </script>
</div>
        <br/>
<div>
            <label for="managementFee_cash">Management Fee:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="managementFee" id="managementFee_cash" size="30"/>
            <form:errors path="managementFee" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "managementFee_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Management Fee (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
</div>
        <br/>

        
        <div>
			 <label for="interest">Interest:</label>
            <form:input cssStyle="width:250px" maxlength="30" path="interest" size="30" id="interest_cash"/>
            <form:errors path="interest" cssClass="errors"/>
            <script type="text/javascript">Spring.addDecoration(new Spring.ElementDecoration({elementId : "interest_cash", widgetType : "dijit.form.ValidationTextBox", widgetAttrs : {invalidMessage: "Enter Distribution (numbers only)", regExp: "-?[0-9]*\.[0-9]*", required : false}})); </script>
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

<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">
	dojo.require("dijit.TitlePane");
	dojo.require("dijit.Dialog");
	dojo.require("dijit.form.TextBox");  
    dojo.require("dijit.form.Button");
    dojo.require("dijit.form.DateTextBox");
    dojo.require("dijit.form.FilteringSelect");		
</script>
<div dojoType="dijit.TitlePane" style="width: 100%" title="Show Account">
    <c:if test="${not empty account}">
    	Congratulations, you have successfully created a new account!
    	<br/>
    	<br/>
        <div>
            <label for="name">Name:</label>
            <div id="name">${account.name}</div>
        </div>
        <br/>
        <div>
            <label for="owners">Owners:</label>
            <div id="owners">${account.owners}</div>
        </div>
        <br/>
        <div>
            <label for="manager">Manager:</label>
            <div id="manager">${account.manager.firstName} ${account.manager.lastName}</div>
        </div>
        <br/>
        <form:form>
        	 <div class="submit">
			            <script type="text/javascript">Spring.addDecoration(new Spring.ValidateAllDecoration({elementId:'proceed', event:'onclick'}));</script>
			            <input type="submit" id="success" name="_eventId_success" value="Finish!"/>
			</div>
        </form:form>
    </c:if>
    <c:if test="${empty account}">No account found with this id.</c:if>
</div>
<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

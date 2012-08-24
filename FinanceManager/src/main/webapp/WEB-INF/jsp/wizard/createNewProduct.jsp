<jsp:directive.include file="/WEB-INF/jsp/includes.jsp"/>
<jsp:directive.include file="/WEB-INF/jsp/header.jsp"/>
<script type="text/javascript">dojo.require("dijit.TitlePane");</script>

<div dojoType="dijit.TitlePane" style="width: 100%" title="Create New Product">
    <form:form> 
    	<div>   
    	To create a new Product, please select the product type:
    	</div>
    	<br/>
    	<br/>
		<div class="submit">
			<div>        	
	            <label for="cash">Create new Cash Product: </label>
				<input type="submit" id="cash" name="_eventId_cash" value="New Cash Product" />
			</div>
			<br/>
			<div>        	
	            <label for="loan">Create new Loan Product: </label>
				<input type="submit" id="loan" name="_eventId_loan" value="New Loan Product" />
			</div>
			<br/>
			<div>        	
	            <label for="managedFund">Create new Managed Fund Product: </label>
				<input type="submit" id="managedFund" name="_eventId_managedFund" value="New Managed Fund Product" />
			</div>
		</div>
    </form:form>
</div>

<jsp:directive.include file="/WEB-INF/jsp/footer.jsp"/>

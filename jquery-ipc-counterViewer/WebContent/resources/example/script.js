jQuery(document).ready(function() {
	jQuery(document).on("count", function(event, data) {
	alert("Receiving count: " + data);
//	var value = event.data;
//	document.getElementById("#{view.getClientId(facesContext)}:counterViewer").value = value;	
//	document.getElementById("#{view.getClientId(facesContext)}:form:hiddenCountValue").value = value;
});});
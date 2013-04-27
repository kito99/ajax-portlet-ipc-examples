jQuery(document).ready(function() {
	jQuery(document).on("count", function(event) {
	alert('blah');
	// alert("Receiving count: " + event.data);
});});

function sendCount(data) {
	if (data.status == "success") {
		var value = document
				.getElementById(portletName + ":form:hiddenCountValue").value;
		jQuery(document).trigger("count", value);
		alert("Sending count: " + value);
	}
}
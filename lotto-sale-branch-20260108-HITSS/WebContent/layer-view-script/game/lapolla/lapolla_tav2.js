$(document).ready(function () {
	redirectLaPolla()
});

function redirectLaPolla(){
	$.ajax({
        type: "POST",
        url: "laPollaTARedirect.html",
        dataType: "json",
        data: "data",
    })
    .done(function(data) {
    	window.open(data.url,"_parent");
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
    	console.log(errorThrown + " - " + textStatus);
    	window.open($("#baseUrl").val(),"_parent");
	});
}
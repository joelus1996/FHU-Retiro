
<body>
</body>

<script type="text/javascript"
		src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.scripts.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.validator.js"></script>
	<script type="text/javascript" src="layer-view-script/client/signUp.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/dhtmlwindow.js"></script>
	

<script>	  
$.ajax({
    type: 'post',
    url: 'get-fast-token.html',
    dataType: 'json'
}).done((res) => {
	if(res.message=="OK") {
		console.log(res);
		window.location.assign(res.redirect+"&token="+res.token);
		return res;
	}
});
	</script>
</html>
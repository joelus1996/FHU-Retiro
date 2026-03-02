//GEOLOCATION
var type = 0;
var map;
var gmarkers = [];
//$(document).ready(function() {
//	$("#tab-1").click(function() {
//		$("#tabs-1").css("display", "block");
//		$("#tabs-2").css("display", "none");
//		$("#tab-1").removeClass("unselected");
//		$("#tab-2").addClass("unselected");
//	});
//	$("#tab-2").click(function() {
//		$("#tabs-1").css("display", "none");
//		$("#tabs-2").css("display", "block");
//		$("#tab-1").addClass("unselected");
//		$("#tab-2").removeClass("unselected");
//	});
//}); 
function getLocation(t) {
	type=t;
	//showMap(-12.06411,-77.070982);
	map = new google.maps.Map(document.getElementById('map_canvas'), {
		center: {lat: -12.06411, lng: -77.070982},
		zoom: 8
	});
	// Try HTML5 geolocation.
	if(navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var pos = {
				lat: position.coords.latitude,
				lng: position.coords.longitude
			};
			showMap(pos.lat, pos.lng);
		}, function() {
			handleLocationError(true);
		});
	} else {
		// Browser doesn't support Geolocation
		handleLocationError(false);
	}
}
function showMap(latitude, longitude) {
	console.log("latitude: "+latitude);
	console.log("longitude: "+longitude);
	var locations = "";
	$.ajax({ url: 'client_redDigital_show_map.html',
		data: 'latitude='+latitude+'&length='+longitude,
		type: 'get',
		dataType: 'json',
		success: function (response) {
			if (response!="") {
				locations = response;
				console.log("locations: "+locations)
				if(type == 1) showDynamicMap(latitude, longitude, locations);
			} else {
				var latlng = new google.maps.LatLng(-12.06411,-77.070982);
			    var myOptions = {
			      zoom: 8,
			      center: latlng,
			      mapTypeId: google.maps.MapTypeId.ROADMAP
			    }
			    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
				alert("No hay Puntos de la Suerte disponibles.");
			}
		}
	});
}
function showDynamicMap(latitude, longitude, locations) {
	//Creates a variable called point and sends the latitude and longitude to Google Maps to get your position
	var point = new google.maps.LatLng(latitude, longitude);
	//Settings for the map   
	var myOptions = {
		zoom: 10,
		center: point,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};
	//Finding the div we want the map to be in
	//var mapDiv = document.getElementById("map_canvas");
	//Pass in the div and map settings to the map
	map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
	var image = new google.maps.MarkerImage('layer-view-image/common/icon-marker.png',
		new google.maps.Size(20, 20),
		new google.maps.Point(0,0),
		new google.maps.Point(0, 32)
	);
	var shadow = new google.maps.MarkerImage('https://www.latinka.com.pe/latinka/lotto-portal/game/tinkamegabol/section/map/small/shadow.png',
		new google.maps.Size(30, 20),
		new google.maps.Point(0,0),
		new google.maps.Point(0, 32)
	);
	var bounds = new google.maps.LatLngBounds();
	var infowindow = new google.maps.InfoWindow({content:''});
	for(var i = 0; i < locations.length; i++) {
		var beach = locations[i];
		var texto = beach.address;
		//var contenido = beach.reference;
		var myLatLng = new google.maps.LatLng(beach.latitude, beach.length);
		gmarkers[beach.id] = new google.maps.Marker({
			position: myLatLng,
			map: map,
			shadow: shadow,
			icon: image,
			title: texto.toString(),
			zIndex: i
		});
//		(function(contenido){
//			google.maps.event.addListener(gmarkers[beach.id], 'click', function() {
//				infowindow.setContent(contenido);
//				infowindow.open(map, this);
//			});
//		})(contenido);
		bounds.extend(myLatLng);
		map.fitBounds(bounds);
	}
}
function handleLocationError(browserHasGeolocation) {
	showMap(-12.06411,-77.070982);
	alert(browserHasGeolocation?"Geolocalizaci\u00F3n no disponible.":"Geolocalizaci\u00F3n no soportado.");
}
//function showStaticMap(latitude, longitude, locations) {
//	var image_url = "https://maps.googleapis.com/maps/api/staticmap?key=AIzaSyDLxOYLjVVjFd1i3f4-CJgNWP9tRXNvIjw&center="+latitude+","+longitude+"&zoom=15&size=300x400&markers="+latitude+','+longitude;//"http://maps.google.com/maps/api/staticmap?sensor=false&center="+latitude+","+longitude+"&zoom=15&size=300x400&markers="+latitude+','+longitude;
//	for(var i = 0; i < locations.length; i++) {
//		var beach = locations[i];
//		image_url += '&markers=icon:http://www.intralot.com.pe/intralot/lotto-portal/game/tinkamegabol/section/map/small/logo.png|'+beach.latitude+','+beach.length;
//	}
//    $('#map_canvas').html(
//        $(document.createElement("img")).attr("src", image_url).attr('id','map')
//    );
//}
//Banner dinámico visibilidad chuchamba
var masterTimer;
var flagBanner=0;
var timeBanner=3000;
var arrayTimer=[];
function showBannerKB(){
	
	    if(flagBanner==0){            	
	    	$('#top-kabala').hide(250);
				$('#logo-kabala').hide();
		    	$('#text-banner-kabala').hide();
		    	$('#pozo-kabala').hide();
		    	$('#logo_chauchamba').show();
		    	$('#text2-banner-kabala').show();
		    	$('#pozo-chauchamba').show();
		    	$('.color-banner-kabala').css('color','#000000');
		    	$('#top-kabala').show(250);
		    	$('#banner-kabala').css('background-color','#ffe510');
		    	flagBanner=1;  
		    	masterTimer=setTimeout(showBannerKB,timeBanner);
		}
		else{
			
			$('#top-kabala').hide(250);
				$('#logo_chauchamba').hide();
		    	$('#pozo-chauchamba').hide();
		    	$('#text2-banner-kabala').hide();                	
		    	$('#logo-kabala').show();
		    	$('#text-banner-kabala').show();
		    	$('#pozo-kabala').show();            	
		    	$('.color-banner-kabala').css('color','#486430');
		    	$('#top-kabala').show(250);
		    	$('#banner-kabala').css('background-color','#B1BD02');
		        flagBanner=0;  	
		        masterTimer=setTimeout(showBannerKB,timeBanner);
		    }
	
    
}

$(window).on('blur', function(){    
//  console.log('intervalo parado');
  clearTimeout(masterTimer);
});

$(window).on('focus', function(){    
//  console.log('intervalo reiniciado');
	clearTimeout(masterTimer);
	masterTimer=setTimeout(showBannerKB,timeBanner);
});

$(document).ready(function(){
	//banner kabala        
    masterTimer=setTimeout(showBannerKB,timeBanner);
});
//--------------------------------------------------------------------

//Texto checkbox chauchamba
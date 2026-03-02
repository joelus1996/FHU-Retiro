<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>

<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
      <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
      <meta name='description' content='La Tinka móvil, términos y condiciones' />
      <style type="text/css">
      .header img{
      	display: none;
      }
      
      #iframeKabalaId {
      height: 100%;
      width: 100%;
       
      }
      </style>
      <title>La Tinka : TYC Suscripción Kábala</title>
   </head>
   <body>
      <div class="content-modal has-action" >
      <iframe id="iframeKabalaId" src="<%=Constantes.kabalaSuscriptionUrl%>" frameborder= "0"></iframe> 
      </div>
      
   </body>
</html>
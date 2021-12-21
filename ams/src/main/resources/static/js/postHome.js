$(document).ready(function(){
	
	$("#bwSubmit").click(function(){
		
		var model = { commentContent :$("#commentContent").val() };
		
		var userId = $("#userId").text();
		var postId = $("#postId").text();
		
		
		$.ajax( {url:"/addComment?userId="+ userId + "&postId=" + postId,
					data: JSON.stringify(model),
					method: "POST",
					headers: { 
				        'Accept': 'application/json',
				        'Content-Type': 'application/json' 
				    },
					success: function(){
						location.reload();
					},
					error: function(jqXHR, exception){
						$("#err").html(jqXHR.responseText);
					}});
	});
	
});
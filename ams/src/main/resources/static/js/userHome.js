$(document).ready(function(){
	
	$("#bwSubmit").click(function(){
		
		var model = { title :$("#title").val(),
				content :$("#content").val()};
		
		$.ajax( {url:"post/addPost?id="+$("#userId").text(),
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
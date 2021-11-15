$(document).ready(function() {
   $("#districts").change(function() {
      var districtId = $(this).val();
      var s = '';
      if (districtId > 0) {
      	$.ajax({
        url : '/beneficiary/form/subcounties',
        data : { "districtId" : districtId },
        success : function(result) {
        	var result = JSON.parse(result);
        	for (var i = 0; i < result.length; i++) {
        	  s += '<option value="' + result[i][0] + '">'+ result[i][1]+ '</option>';
        	}
        	$('#subcounties').html(s);
        }
      });
     }
     $('#subcounties').html(s);
     $('#parishes').html(s);
   });

   $("#subcounties").change(function() {
      var subcountyId = $(this).val();
      var s = '';
      if (subcountyId > 0) {
      	$.ajax({
        url : '/beneficiary/form/parishes',
        data : {"subcountyId" : subcountyId},
        success : function(result) {
        	var result = JSON.parse(result);
        	for (var i = 0; i < result.length; i++) {
        		s += '<option value="' + result[i][0] + '">'+ result[i][1]+ '</option>';
        	}
        	$('#parishes').html(s);
        }
       });
     }
     $('#parishes').html(s);
     $('#villages').html(s);
   });

   $("#parishes").change(function() {
     var parishId = $(this).val();
     var s = '';
     if (parishId > 0) {
        $.ajax({
        url : '/beneficiary/form/villages',
        data : {"parishId" : parishId},
        success : function(result) {
            var result = JSON.parse(result);
            for (var i = 0; i < result.length; i++) {
                s += '<option value="' + result[i][0] + '">'+ result[i][1]+ '</option>';
            }
            $('#villages').html(s);
        }
      });
    }
    $('#villages').html(s);
  });
});
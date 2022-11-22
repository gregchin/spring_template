$(document).ready(function (){
   //var table_style = "'<'top'l>rt<'bottom'ip><'clear'>'";
   //多筆刪除
   $('#btn2').on('click', function(e){
       var form = this;
       var delID = []
       var table = $('#example').DataTable();
       var rows_selected = table.column(0).checkboxes.selected();
       
       //Iterate over all selected checkboxes
       $.each(rows_selected, function(index, rowId){
          // Create a hidden element
          delID.push(rowId);
       });
       pushJSON(delID);
       
   });
   
   
    $('#btn1').on('click', function(e){
	    var url = '/page04/query?empname='+$('#empname').val();
	    var formname = '#example';
	    bulid_data_table_url(formname,url);
           
    });
   
    function pushJSON(delID) {
	    var requestURL = "/page04/deleteMulti";
	    
	    var table = $('#example').DataTable();
        
       $.ajax({
           url: requestURL,
           data: JSON.stringify({"mydata":delID}),
           type: "POST",
           dataType: "json",
           contentType: "application/json;charset=utf-8",
           success: function(returnData){
			  refresh_dataTable(delID);
  
           },
           error: function(xhr, ajaxOptions, thrownError){
            
           }
       });
       refresh_dataTable(delID);
    }
    
    function refresh_dataTable(delID) {
		console.log(delID);
	  var table = $('#example').DataTable();
	  var row_data = table.rows().data();
	  var tmp_data = row_data;
	  for (i=0;i<delID.length;i++) {
	      for (j=0;j<tmp_data.length;j++) {
		      if (delID[i] == tmp_data[j][0]) {
			      row_data.splice(j,1);
		      }
	      }
	  }
	  
	  
	    var formname = '#example';
	    bulid_data_table_data(formname,row_data);
	  
	}
	  
   
   
   
});  

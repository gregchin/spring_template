$(document).ready(function (){
	 
   


   // Handle form submission event
   $('#btn2').on('click', function(e){
      var form = this;
var table = $('#example').DataTable();
      var rows_selected = table.column(0).checkboxes.selected();

      // Iterate over all selected checkboxes
      $.each(rows_selected, function(index, rowId){
         // Create a hidden element
         console.log(rowId);
      });
      $('#example-console-rows').text(rows_selected.join(","));
   });
   
   
   $('#btn1').on('click', function(e){
	   var table = $('#example').DataTable();
	  table.destroy();
      table = $('#example').DataTable({
      processing: true,
        serverSide: false,
      //'Data':data,
      'ajax': 'http://localhost:8080/page03/all',
      'retrieve': true,
      'columnDefs': [
         {
            'targets': 0,
            'checkboxes': {
               'selectRow': true
            }
         }
      ],
      'select': {
         'style': 'multi'
      },
      'order': [[1, 'asc']]
   });
   
table.draw(); // Redraw the DataTable
   });
   
   
});  

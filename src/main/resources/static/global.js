var table_style = "'<'top'l>rt<'bottom'ip><'clear'>'";

function bulid_data_table_url(formname,url) {
	var table = $(formname).DataTable();
	table.destroy();
    table = $('#example').DataTable({
	        "lengthMenu": [[ 5, 10, 15, -1 ],[ 5, 10, 15, "All" ]],
	            "rowCallback": function(row) {
                    $('td:eq(1)', row).css({color: "4682B4","font-weight":"bold"});
                    $('td:eq(2)', row).css({color: "D2B48C","font-weight":"bold"});
                 },
                processing: true,
                serverSide: false,
                searching: false,
                'ajax': url,
                'retrieve': true,
                'columnDefs': [{'targets': 0,
                                'checkboxes': {'selectRow': true},
                                className: 'dt-body-right'
                              }],
                'select': {'style': 'multi'},
                dom: table_style,
                'order': [[1, 'asc']]
            });
    table.draw(); // Redraw the DataTable	
}

function bulid_data_table_data(formname,row_data) {
    var table = $(formname).DataTable();
	table.destroy();
    table = $('#example').DataTable({
	            "rowCallback": function( row ) {
                    $('td:eq(1)', row).css({color: "4682B4","font-weight":"bold"});
                    $('td:eq(2)', row).css({color: "D2B48C","font-weight":"bold"});
                },
                'retrieve': true,
                searching: false,
                'data':row_data,
                'columnDefs': [{'targets': 0,
                                'checkboxes': {'selectRow': true},
                                className: 'dt-body-right'
                              }],
                'select': {'style': 'multi'},
                dom: table_style,
                'order': [[1, 'asc']]
            });
    table.draw(); // Redraw the DataTable
}

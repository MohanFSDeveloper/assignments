
csp.controller("homecontroller", function($scope,$http) {

	$scope.validationGrid = {
			columnDefs : [
			              { name:'transactionRefNumber',label:'Transaction Reference Number', width:250 },
			              { name:'errorMessage', label:'Description'},
			              ], 
			              data:[{"transactionRefNumber":112806,"errorMessage":"Duplicate Reference Number Found"},{"transactionRefNumber":112806,"errorMessage":"Duplicate Reference Number Found"}],
			              enableSorting: false,
			              enableFiltering: true,
			              enableColumnResizing: true,
			              paginationPageSize: 10,
			              onRegisterApi: function(gridApi) { 
			            	  $scope.validationGrid = gridApi;
			              }
	}
	$scope.showGrid = false;
	$scope.processCustStatement = function(){
		$scope.showGrid = true;
		$http.get("processStmnt/").then(function (response) {
			
			$scope.validationGrid.data = response.data.result;
		});
	}
	
	function changeListener(event){
		debugger;
		  console.log(event);
		 /* if(files && files.length > 0) {
		     let file : File = files.item(0); 
		       console.log(file.name);
		       console.log(file.size);
		       console.log(file.type);
		       let reader: FileReader = new FileReader();
		       reader.readAsText(file);
		       reader.onload = (e) => {
		          let csv: string = reader.result;
		          console.log(csv);
		       }
		    }*/
		}


});

